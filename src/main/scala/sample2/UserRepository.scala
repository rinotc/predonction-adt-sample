package sample2

trait UserRepository {

  /**
   * ユーザーをDBに保存する
   *
   * @param user （バリデーション済みの）ユーザー。ここでこの
   */
  def insert(user: User[Valid]): Unit
}
