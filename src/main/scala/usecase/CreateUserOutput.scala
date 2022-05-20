package usecase

import ddd.Output
import sample1.User
import user.UserName

sealed abstract class CreateUserOutput extends Output
object CreateUserOutput {
  final case class Success(newUser: User)                       extends CreateUserOutput
  final case class UserNameConflict(conflictUserName: UserName) extends CreateUserOutput
}
