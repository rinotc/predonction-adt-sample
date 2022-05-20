package usecase.create

import ddd.Input

final case class CreateUserInput(name: String) extends Input[CreateUserOutput]
