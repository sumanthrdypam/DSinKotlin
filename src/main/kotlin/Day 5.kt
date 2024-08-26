import java.text.SimpleDateFormat
import java.util.Date

//if two points or more than one objects then n-1 as arguments

//diff between primary and secondary
//there will  be only one primary constructor but as many with secondary
//in primary we can val and var as argument type but not in second
//class data property should be intitlized in constructor or init block or while declaration
//in seconday constructor we ccan perform some operations
//in data class equals and tostring and
/*
*data class should have atleast one element in primary constructor and functions is optional
*lateinit has used to be with object type data not primitive
*::customer.isInitialized tells if customer is Initialized
*late cannot have null value and is not a nullable varaible
*
* companion object{} == static
*
* //init is used to execute that will initilize other data members of our class
* //it is used as alternative or addition to primary constructor to perform operations
* example FileOperations
*
* Fractional - Addition, multiplication and division
Complex - Addition and multiplication
* data class
*/



class MySet {
    val ar: Array<Int>

    // secondary constructor
    constructor(n: Int) {
        println("Enter $n elements of set: ")
        ar = Array<Int>(n) {
            readln().toInt()
        }
    }
    // secondary constructor
    constructor(list: MutableList<Int>) {
        ar = Array<Int>(list.size) {
            list[it]
        }
    }
    // function to find intersection of two sets
    infix fun intersect(s: MySet): MySet? {
        val list = mutableListOf<Int>()
        for(a in ar) {
            if(a in s.ar) {
                list.add(a)
            }
        }
        if(list.isEmpty()) {
            return null
        }

        return MySet(list)
    }

    infix fun union(s: MySet): MySet {
        val list = ar.map { it }.toMutableList()
        for(a in s.ar) {
            if( a !in list) {
                list.add(a)
            }
        }
        return MySet(list)
    }

    override fun toString() = ar.joinToString(prefix = "{", postfix = "}", separator = ", ")
}

fun main() {
    println("Enter size of first set: ")
    val n1 = readln().toInt()

    val s1 = MySet(n1)

    println("Enter size of second set: ")
    val n2 = readln().toInt()

    val s2 = MySet(n2)

    val s3 = s1 intersect s2
    val s4 = s1 union s2

    println("Set A = $s1")
    println("Set B = $s2")
    println("A Intersection with B = $s3")
    println("A U B = $s4")
}






/*"Point-Of-Sale Application:(POS)
POS is used in shopping mall for bill printing at checkout counter.
At checkout counter operator feeds data about customer as
customer name, mobile number, address and sale details of n items
such as item id, item name, price and quantity.
At the end customer receivers a detailed bill which includes
customer details, purchase details and total bill amount.
Write a program to simulate POS application."
*/


data class Customer(
    val name: String,
    val mobileNo: String,
    val address: String
)

data class SaleItem(
    val id: Long,
    val name: String,
    val qty: Int,
    val unitPrice: Float
)

class Bill {
    val billNo: Long
    val date: String

    init {
        billNo = nextBillNo
        generateNextBillNo()
        val sdf = SimpleDateFormat("EEE dd-MM-yyyy")
        val currentDate = Date(System.currentTimeMillis())
        date = sdf.format(currentDate)
    }

    lateinit var customer: Customer
    lateinit var saleItems: Array<SaleItem>
    private var totalBillAmount: Float = 0f

    companion object {
        var nextBillNo: Long = 1000

        fun generateNextBillNo() {
            nextBillNo ++
        }

    }

    fun inputBillDetails() {
        print("Enter customer name: ")
        val name = readln()

        print("Enter customer mobile no.: ")
        val mobile = readln()

        print("Enter customer address: ")
        val address = readln()

        customer = Customer(name, mobile, address)

        print("Enter number of sale items: ")
        val n = readln().toInt()

        println("Enter sale details of $n items: ")

        saleItems = Array<SaleItem>(n) {
            print("Enter prouduct id: ")
            val pid = readln().toLong()

            print("Enter product name: ")
            val pname = readln()

            print("Enter unit price: ")
            val price = readln().toFloat()

            print("Enter sell quantity: ")
            val qty = readln().toInt()

            totalBillAmount += price * qty
            SaleItem(pid, pname, qty, price)
        }

    }

    fun printBill() {

        println("Bill number      : $billNo")
        println("Date             : $date")
        if(::customer.isInitialized) {
            println("Customer name: ${customer.name}")
            println("Mobile       : ${customer.mobileNo}")
            println("Address      : ${customer.address}")
        } else {
            println("Customer details are not available")
        }
        println("---------------------Sale Details----------------------------")
        println("Pid \t Name \t Qty \t Price \t Amount")

        for(si in saleItems) {
            println("${si.id} \t ${si.name} \t ${si.qty} \t ${si.unitPrice} \t ${si.qty * si.unitPrice}")
        }
        println("\nTotal bill amount = $totalBillAmount")
    }
}
/*

fun main() {
    var more = 1
    do {
        val b = Bill()
        b.inputBillDetails()
        b.printBill()
        print("Do you want to generate next bill: [ 1 Yes | 0 - No ] : ")
        more = readln().toInt()
    }while(more == 1)


}*/

class ABCD{
    lateinit var abs:String
    companion object{

        fun String.check(b:Int){
            println("Checked")
        }
    }

}


