package sample1

import usecase.{CreateUserInput, CreateUserOutput, CreateUserUseCase}

final class CreateUserInteractor(userService: UserService, userRepository: UserRepository) extends CreateUserUseCase {

  override def handle(input: CreateUserInput): CreateUserOutput = {
    val newUser = User.create(input.name)

    userService.exists(newUser) match { // このバリデーションが必ず必要だが、知らないとできない。
      case Left(_) => CreateUserOutput.UserNameConflict(newUser.name)
      case Right(_) =>
        val insertedUser = userRepository.insert(newUser)
        CreateUserOutput.Success(insertedUser)
    }
  }
}
