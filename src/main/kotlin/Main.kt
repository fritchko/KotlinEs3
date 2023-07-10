sealed class User {
    abstract val id: String

    data class Email(
        override val id: String,
        val email: String,
        val password: String
    ) : User()

    data class Facebook(
        override val id: String,
        val facebookId: String
    ) : User()

    data class Google(
        override val id: String,
        val googleId: String,
        val email: String
    ) : User()

    fun details(): String {
        return when (this) {
            is Email -> "Email (ID: $id, Email: $email)"
            is Facebook -> "Facebook (ID: $id, Facebook ID: $facebookId)"
            is Google -> "Google (ID: $id, Google ID: $googleId, Email: $email)"
        }
    }
}

fun main() {
    val emailUser = User.Email("123", "michele@esempio.com", "password123")
    val facebookUser = User.Facebook("456", "facebook123")
    val googleUser = User.Google("789", "google123", "giovanni@es.com")

    println(emailUser.details())
    println(facebookUser.details())
    println(googleUser.details())
}
