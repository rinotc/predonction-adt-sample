package first.usecase

import ddd.Output
import first.{User, UserName}

sealed abstract class CreateUserOutput extends Output
object CreateUserOutput {
  final case class Success(newUser: User)                       extends CreateUserOutput
  final case class UserNameConflict(conflictUserName: UserName) extends CreateUserOutput
}
