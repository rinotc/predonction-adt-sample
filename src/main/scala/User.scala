class User(val id: UserId, val name: UserName) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[User]

  override def equals(other: Any): Boolean = other match {
    case that: User => (that canEqual this) && id == that.id
    case _          => false
  }

  override def hashCode(): Int = 31 * id.##
}
