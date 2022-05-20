package sample2

import usecase.create.CreateUserOutput.UserNameConflict
import usecase.create.{CreateUserInput, CreateUserOutput, CreateUserUseCase}

class CreateUserInteractor(
    userNameConflictValidator: UserNameConflictValidator,
    userRepository: UserRepository
) extends CreateUserUseCase {

  override def handle(input: CreateUserInput): CreateUserOutput = {
    val newUser: User[NotValid] = User.create(input.name)

    // userRepository.insert(newUser) <--- ここでinsertしようとすると Type mismatch でエラーになる

    newUser.validate(userNameConflictValidator) match {
      case Left(_) => UserNameConflict(newUser.name)
      case Right(validUser) =>
        userRepository.insert(validUser)
        CreateUserOutput.Success2(validUser)
    }
  }
}
