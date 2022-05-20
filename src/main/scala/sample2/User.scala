package sample2

import user.{UserId, UserName}

class User[Validation <: ValidationState] private (val id: UserId, val name: UserName) {

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
   * @note ここではID生成方法は主眼ではないので、固定値で返している。
   * @param name ユーザー名
   */
  def create(name: String): User[NotValid] = new User(UserId(-1L), UserName(name))
}
