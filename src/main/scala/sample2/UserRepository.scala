package sample2

trait UserRepository {

  def insert(user: User[Valid]): Unit
}
