package first

/**
 * ユーザーのドメインに関するエラー
 *
 * @note 今回のサンプル用にあまり考えずに作っている。実プロダクトでこのように実装するとファットになる可能性があり。
 */
sealed trait UserDomainError

/**
 * ユーザー名が重複している
 */
sealed trait UserNameDuplicateError extends UserDomainError
