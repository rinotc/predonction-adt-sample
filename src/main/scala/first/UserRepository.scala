package first

trait UserRepository {

  /**
   * ユーザーを保存する処理
   *
   * @param user 新規ユーザー
   * @return 新規ユーザー（ID採番済みで返ってくるイメージ）
   */
  def insert(user: User): User
}
