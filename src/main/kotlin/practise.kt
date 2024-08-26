class PersonDetails {
    private var name: String = ""
        get() {
            println("Get function of name is executed")
            return field
        }
        set(value) {
            field = value.uppercase()
            println("Set function of name is executed")
        }
     var age: Int = 0
        get() {
            println("Get function of age is executed")
            return field
        }
        set(value) {
            field = Math.abs(value)
            println("Set function of age is executed")
        }

    fun setPersonName(n: String) {
        println(age)
        name = n
    }

    fun getPersonName() = name

    fun setPersonAge(a: Int) {
        age = a
    }

    fun getPersonAge() = age

}

fun main() {
    val p = PersonDetails()
    p.setPersonName("rakesh")


}