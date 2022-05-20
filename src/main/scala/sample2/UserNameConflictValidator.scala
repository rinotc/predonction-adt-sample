package sample2

trait UserNameConflictValidator {

  def validate(user: User[NotValid]): Either[String, User[Valid]]
}
