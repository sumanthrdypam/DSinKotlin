import kotlin.time.times

open class BankAccount(val accountNumber:String, open var balance:Double, val ownerName:String){
    companion object{
        var accountNumberGenerator:Int=0
        fun giveAccountNumber():String = ""+accountNumberGenerator
    }
    constructor(balance: Double,ownerName: String):this(BankAccount.giveAccountNumber(),balance,ownerName)
    fun deposit(amount:Double) {
        if(amount>=0){
            balance+=amount
            println("Deposite Succesful")
        }else{
            println("Invalid amount to deposite")
        }
    }
    open fun withdraw(amount: Double){
        if(amount>=0 && balance>=amount){
            balance-=amount
            println("Withdraw successful")
        }else{
            println("Insuffient balance or invalid amount")
        }
    }
}

open class SavingsAccount(acccountNumber:String, balance:Double, ownerName: String,var interestRate:Double) : BankAccount(acccountNumber,balance,ownerName){
    //assuming intreset would be with less than 1
    fun addIntrest(){
        super.balance += super.balance*interestRate
    }
}

class CurrentAccount(acccountNumber:String, balance:Double, ownerName: String, interestRate:Double, var overdraftLimit:Double):SavingsAccount(acccountNumber,balance,ownerName,interestRate){
    override fun withdraw(amount: Double) {
        if(amount<=super.balance+overdraftLimit){
            if(amount<balance){
                balance-=amount
            }else{
                overdraftLimit-=balance
                balance= 0.0
                overdraftLimit-=(amount)
            }
            println("Successful deposite from derived class $amount")
        }else{
            println("Insuffient balance")
        }
    }


}
/*fun main(){
   *//* val basicAccount=BankAccount("1",100000.0,"Sumanth")
    val savingsAccount=SavingsAccount(basicAccount.accountNumber,basicAccount.balance,basicAccount.ownerName,0.02)
    val currentAccount=CurrentAccount(savingsAccount.accountNumber, savingsAccount.balance, savingsAccount.ownerName,savingsAccount.interestRate,10000.0)
    currentAccount.withdraw(1000.0)*//*

  *//*  val list=listOf(1,2,3,4,5,6,7,8,9)
    println(list.iterator())
    println(list.subList(1,2))
    for(i in list) print(i)
    for(i in list.indices) print(list[i])
    list.forEach{print(it)}
    println(list.slice(1..5))//slice on a list will return elements not indices
    val alphabets = mutableListOf("a","b","c","d","e","f","g")
    println(alphabets)

    alphabets.add(alphabets.size,"h")
    println(alphabets)

    alphabets.add("i")
    println(alphabets)

    list.partition(i>4)
    list.take(3)
    list.drop(2)

    alphabets.removeAt(0)
    println(alphabets)

    alphabets.remove("b")
    println(alphabets)

    alphabets[0]="a"
    println(alphabets)

    alphabets.sort()
    println(alphabets)

    alphabets.sortDescending()
    println(alphabets)
*//*

    //set
 *//*   val set = mutableSetOf(1,2,3,4,5,6,7,8,9)
    println(set)
    set.add(1)
    println(set)
    set.remove(1)
    println(set)
    val s2 = mutableSetOf(19,11,23,"abc")
    println(set union s2)
    println(set intersect  s2)
    s2.add(2)
    s2.add(3)
    println(set intersect s2)
    println(set.size)
    println(set.isEmpty())
    println(1 in set)
    println(set.contains(2))
    for(i in set){
        print(i)
    }

    //underline sets in kotlin are linkedhashset
    println()
    println(set.reversed())
    println(set.sorted())
    println(set)
    println(set.reversed())
    println(set.toList())*//*

    val map= mutableMapOf(1 to "One", 2 to "Two", 3 to "Three", 4 to "Four")
    println( map.containsKey(1))
    println(map.remove(1))
    println(map)
    println(map.put(4,"Five"))
    println(map.filterValues { it> 3.toString() })
    println(map)
    val settt= mutableSetOf(1)



}*/

/*
data class Book(val isbn:String,val title:String, val authors:List<String>)

class Library(val books:MutableList<Book>){
    val borrowedHistory:MutableMap<String,String> = mutableMapOf()
    fun borrowBook(isbn:String,userName:String){
        if(borrowedHistory.containsKey(isbn)){
            println("Sorry Book is currently not available to Borrow")
        }else{
            borrowedHistory[isbn]=userName
            println("Congrats !!! You have been allocated this book")
        }
    }

    fun returnBook(isbn:String, userName: String){
        if(borrowedHistory.containsKey(isbn)){
            println("Returning book Success!!!")
            borrowedHistory.remove(isbn)
        }else{
            println("Error!!!")
        }
    }

}

fun main(){
    //books implementation
    val books= mutableListOf<Book>(Book("1","Kotlin", listOf("Sam")),Book("2","Android", listOf("Ram","Sam")))
    val library=Library(books)
    library.borrowBook("1","Sumanth")
    library.returnBook("1","Sumanth")
}*/


/*
fun main(){
        println("UserName e is available : ${isUsernameAvailable(mutableSetOf("a","b","c","d"),"e")}")
        println("UserName b is available : ${isUsernameAvailable(mutableSetOf("a","b","c","d"),"b")}")
}
fun isUsernameAvailable(usernames: Set<String>, newUsername: String) = !usernames.contains(newUsername)*/

//getRecommendedProducts(userPurchases: Map<String, List<String>>): Set<String> that returns a set of product IDs
// that are recommended based on the purchase history of all users.



/*
fun getRecommendedProducts(userPurchases: Map<String, List<String>>): Set<String>{
    val recommendeProducts= mutableSetOf<String>()
    for(i in userPurchases.values){
        recommendeProducts.addAll(i)
    }
    return recommendeProducts
}

fun main(){
    val map = mutableMapOf<String,List<String>>()
    map["manam"]= listOf("product1","product2","product3","product4")
    map["zie"]= listOf("product4", "product5")
    println(getRecommendedProducts(map))
}
*/

/*
fun assignTask(employeeTasks:MutableMap<String,MutableSet<String>>, employeeName:String, task:String):Boolean{
    for(i in employeeTasks.values){
        if(task in i) return false
    }
    employeeTasks[employeeName]= mutableSetOf(task)
    return true
}

fun main(){
    val employeeTasks= mutableMapOf<String,MutableSet<String>>(
        "sumanth" to mutableSetOf<String>("bug1","bug2"),
        "sampath" to mutableSetOf<String>("bug3","bug4")
    )
    var task1="bug1"
    var task2="bug5"
    print("$task1 assignment ")
    when(assignTask(employeeTasks,"sampath",task1)){
        true->println("done")
        false-> println("fail")
    }
    print("$task2 assignment ")
    when(assignTask(employeeTasks,"sampath",task2)){
        true->println("done")
        false-> println("fail")
    }
}
*/


/*
fun enrollStudent(courseEnrollments: MutableMap<String, MutableList<String>>, courseName:String, studentName:String):Boolean{
    val enrolledCourses=courseEnrollments.getOrDefault(studentName, mutableListOf())
    for(i in enrolledCourses){
        if(i.equals(courseName)){
            return false
        }
    }
    enrolledCourses.add(courseName)
    courseEnrollments[studentName]=enrolledCourses
    return true
}
fun main(){
    val courseEnrollments= mutableMapOf<String, MutableList<String>>(
        "Sumanth" to mutableListOf<String>("Java","Android","Kotlin"),
        "Sampath" to mutableListOf<String>("Ios","Swift","CP"),
        "Ramanath" to mutableListOf<String>("OS","OOPS","Kotlin"),
        )
    val studentName:String = "Sumanth"
    val course1="Android"
    val course2="CP"
    val course1result=when(enrollStudent(courseEnrollments,course1,studentName)){
        true->"Success"
        false->"Fail"
    }
    val course2result=when(enrollStudent(courseEnrollments,course2,studentName)){
        true->"Success"
        false->"Fail"
    }
    println("$studentName enrollement in $course1 is $course1result")
    println("$studentName enrollement in $course2 is $course2result")

}
*/

/*
data class Item(val id:String, val category:String, val price:Double, var quantity:Int)

class ShoppingCart(){
    var totalItems:Int =0
    var totalPriceBeforeDiscount:Double=0.0
    var totalDiscount:Double=0.0
    var finalPriceAfterDiscount:Double=0.0
    var cart:MutableMap<String,Item> = mutableMapOf()
   //Add items to the cart (addltem(productld: String, category: String, price: Double, quantity: Int).

    fun addItems(productld: String, category: String, price: Double, quantity: Int){
        val item = cart.getOrDefault(productld, Item(productld,category,price,0))
        item.quantity+=quantity
        cart[productld] = item
    }

// Remove items from the cart (removeltem(productld: String, quantity: Int).
    fun removeltem(productld: String, quantity: Int){
        if(cart.containsKey(productld)){
            var item:Item?=cart.remove(productld)
            if (item != null) {
                if(item.quantity>quantity){
                    item.quantity-=quantity
                    cart[productld] = item
                }
            }
        }
    }

    fun applyDiscounts(discounts: Map<String, Double>){
        for(i in cart.values){
            val discountPercentage=discounts.getOrDefault(i.id,0.0)
            val q = i.quantity
            val p = i.price
            val price = q*p
            val thisDiscount = price*discountPercentage
            totalItems+=q
            totalPriceBeforeDiscount +=price
            totalDiscount += thisDiscount
        }
    }

    fun getCartSummary(){
        finalPriceAfterDiscount=totalPriceBeforeDiscount-totalDiscount
        println("Total Items                 = $totalItems")
        println("Total Price Before Discount = $totalPriceBeforeDiscount")
        println("Total Discount              = $totalDiscount" )
        println("Effective Price             = $finalPriceAfterDiscount")
    }
}
fun main(){

    val mackbook = Item("Macbook", "Clothing", 2000.0, 4)
    TODO("Complete this")
}*/

class TestPrep{
    companion object{

    }
}
fun main(){
   fun test():Unit{
       println("Hi")
   }

    fun higherorder(b:Int, x:()->Unit):Unit{
        x()
    }
    higherorder(5,::test)
}
