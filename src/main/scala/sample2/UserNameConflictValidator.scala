package sample2

import user.UserNameDuplicateError

trait UserNameConflictValidator {

  def validate(user: User[_]): Either[UserNameDuplicateError, Unit]
}
