package usecase.create

import ddd.Output
import sample2.Valid
import user.UserName

sealed abstract class CreateUserOutput extends Output
object CreateUserOutput {
  final case class Success(newUser: sample1.User)               extends CreateUserOutput
  final case class Success2(newUser: sample2.User[Valid])       extends CreateUserOutput // 面倒なので一緒にしちゃった
  final case class UserNameConflict(conflictUserName: UserName) extends CreateUserOutput
}
