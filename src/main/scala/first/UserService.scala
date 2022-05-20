package first

import ddd.DomainService

/**
 * ユーザーのドメインサービス
 */
trait UserService extends DomainService {

  /**
   * DBに問い合わせをして、ユーザー名が重複してないかを確認する
   *
   * @param user ユーザー
   */
  def exists(user: User): Either[UserNameDuplicateError, Unit]
}
