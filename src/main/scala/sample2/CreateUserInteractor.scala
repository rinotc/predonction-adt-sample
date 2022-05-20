package sample2

import usecase.{CreateUserInput, CreateUserOutput, CreateUserUseCase}

class CreateUserInteractor extends CreateUserUseCase {

  override def handle(input: CreateUserInput): CreateUserOutput = ???
}
