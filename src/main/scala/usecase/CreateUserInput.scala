package usecase

import ddd.{Input, Output}

final case class CreateUserInput(name: String) extends Input[CreateUserOutput]
