case class UserName(firstName: String, lastName: String) {
  def fullName: String = s"$firstName $lastName"
}
