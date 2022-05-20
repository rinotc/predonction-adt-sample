package sample2

import user.{UserId, UserName, UserNameDuplicateError}

/**
 * ユーザー
 *
 * @note デフォルトコンストラクタは `private` にして生成処理を絞っている。
 *       ADTを利用した状態遷移はインスタンスの生成方法の制御が重要である。
 *       型パラメータを自由につけてインスタンスを生成できては、制約の効果がないためだ。
 *       こちらで指定したメソッドを経由してのみ型パラメータの状態を変更できるようにする。
 *       そのため、`apply` の生成が制御できない `case class` もNG.
 * @tparam ValidState バリデーション状態を示す型パラメータ
 */
class User[ValidState <: ValidationState] private (val id: UserId, val name: UserName) {

  /**
   * バリデーション
   *
   * @note このメソッドを通さないと、[[Valid]] をもった [[User]] は生成できないようにする。
   * @param validator バリデーションを行うクラス
   * @param ev generalized typed constraints
   * @return バリデーション成功時には [[Valid]] を型パラメータにもった[[User]]を返す
   */
  def validate(
      validator: UserNameConflictValidator
  )(implicit ev: ValidState =:= NotValid): Either[UserNameDuplicateError, User[Valid]] = {
    validator.validate(this) match {
      case Left(error) => Left(error) // 記事で読みやすいようにわざと冗長に書いている
      case Right(_)    => Right(new User[Valid](this.id, this.name))
    }
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[User]

  override def equals(other: Any): Boolean = other match {
    case that: User[_] => (that canEqual this) && id == that.id
    case _             => false
  }

  override def hashCode(): Int = 31 * id.##
}

object User {

  /**
   * 新規ユーザーを生成する
   *
   * @note 生成時はバリデーション前なので [[NotValid]] で生成する。
   * @param name ユーザー名
   */
  def create(name: String): User[NotValid] = new User(UserId(-1L), UserName(name))
}
