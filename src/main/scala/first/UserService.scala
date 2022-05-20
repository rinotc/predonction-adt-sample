package first

/**
 * ユーザーのドメインサービス
 */
trait UserService {

  /**
   * ユーザー名が重複してないかを確認する
   *
   * @param user ユーザー
   * @return ユーザー名が重複した場合 `true`
   */
  def exists(user: User): Either[UserNameDuplicateError, Unit]
}
