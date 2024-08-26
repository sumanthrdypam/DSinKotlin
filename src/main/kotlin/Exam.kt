//Write a program to move all zero elements of the array to the end of the array.
// E.g. If the input array is 9, 0, 1, 6, 0, 3, 0, 2, 0, 8 then output should be 9, 1, 6, 3, 2, 8, 0, 0, 0, 0.

/*
fun moveZerostoEnd(arr:Array<Int>):Array<Int>{
    //O(N),O(1)
    var index=0 //It will keep track the index where non zero element should be placed
    for(i in 0 until arr.size){
        if(arr[i]!=0){//if the element is non zero then we push it to the front
            arr[index++]=arr[i]
        }
    }
    // appending zeros till the end
    for(i in index until arr.size){
        arr[i]=0
    }
    return arr
}

fun main(){
    var arr:Array<Int> = arrayOf(9, 0, 1, 6, 0, 3, 0, 2, 0, 8)
    arr =  moveZerostoEnd(arr)
    println( arr.joinToString(separator = ","))
}*/

//Write a program for linked list operation to copy n number of nodes from position p to new position d.
// E.g. if linked list items are 10, 7, 13, 9, 25, 34, 90, 50 and if n = 4, p=3, d = 8
// then copy copy 4 nodes from position 3 i.e. 13, 9, 25, 34 to 8th position
// i.e. output would be 10, 7, 13, 9, 25, 34, 90, 13, 9, 25, 34, 50.

class LinkedList {
    private var first: Node? = null
    private var last: Node? = null

    inner class Node(val data: Int, var next: Node?=null) {
        fun append() {
            if(first == null) {
                first = this
                last = this
            } else {
                last?.next = this
                last = this
            }
        }


    }

    fun add(d: Int) {
        val n = Node(d)
        n.append()
    }

    fun print() {
        var t: Node? = first
        while(t != null) {
            println("${t.data}")
            t = t?.next
        }
    }

    fun copyNNodesTod(list:LinkedList,n:Int,p:Int,d:Int ){
        //I am assuming that input will have more than n nodes
        //first creating a copy of n nodes from position p
        var copyList = LinkedList()
        var pos=1
        var tHead=list.first
        var myHead=LinkedList()
        myHead.add(-1)
        while(pos<p){
            if (tHead != null) {
                tHead=tHead.next
                pos++
            }
        }
        // now I am at position p
        var count=0
        while(count<n){
            count++
            if (tHead != null) {
                myHead.add(tHead.data)
                tHead=tHead.next
            }

        }
        myHead.first= myHead.first?.next
        //now I have the copied the n nodes from p to myHead
        //now just need to attach this list at position
        tHead=list.first
        pos=1
        while(pos<d-1){
            if (tHead != null) {
                tHead=tHead.next
                pos++
            }
        }
        var tempnext= tHead?.next
        if (tHead != null) {
            tHead.next = myHead.first
        }
        myHead.last=tempnext


        var check=1
    }






}

fun main() {
    val list = LinkedList()
    list.add(10)
    list.add(7)
    list.add(13)
    list.add(9)
    list.add(25)
    list.add(34)
    list.add(90)
    list.add(50)
    list.print()
    list.copyNNodesTod(list,4,3,8)
    list.print()

}
//Write a program to implement Fraction class with two data members numerator and denominator.
// Implement functions to addition, multiplication of two fraction numbers, inverse of fraction number.

/*
class Fraction(){
    var numerator:Int = 0
    var denominator:Int = 1
        set(value) {
            if(value==0){
                field=1
                numerator=0
                //trying to invalidate
            }else if(value<0){
                numerator=-numerator
                field=-value
            }else{
                field=value
            }
        }
    constructor( n:Int, d:Int ):this(){
        numerator=n
        denominator=d
    }
    fun inverse(){
        var t=numerator
        numerator=denominator
        denominator=t
    }
    fun addition(b: Fraction){
        var rnum:Int=0
        var rden:Int=0

        var t=this.denominator
        this.numerator=this.numerator*b.denominator
        this.denominator=this.denominator*b.denominator

        b.numerator=b.numerator*t
        b.denominator=b.denominator*t

        this.numerator=this.numerator+b.numerator
        makeItLeast()
    }
    private fun makeItLeast(){
        val min = Math.min(Math.abs(this.numerator),Math.abs(this.denominator))
        var tn=Math.abs(this.numerator)
        var td=Math.abs(this.denominator)
        var positive:Boolean=this.numerator>0
        for(i in min downTo 2){
            if(tn%i ==0 && td%i ==0){
                tn=tn/i
                td=td/i
            }
        }
        this.numerator=tn
        this.denominator=td
        if(!positive){
            this.numerator=-this.numerator
        }
    }

    fun multiplication(b:Fraction){
        this.numerator*=b.numerator
        this.denominator*=b.denominator
        makeItLeast()
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }
}

fun main(){
    var f=Fraction(1,2)
    f.addition(Fraction(1,2))
    println("Additoion result with 1/2 = $f")
    f.multiplication(Fraction(-2,3))
    println("Mutliplication result with -2/3 = $f")
    f.inverse()
    println("inverse result is $f")
}*/

//Given a list of employees, where each employee is represented by a data class containing their name, a list of projects they are working on, and a map of their project names to the hours worked on each project. Write a function to perform the following tasks:
//Filter out employees who are working on less than 2 projects.
//Create a set of all unique projects across all employees.
//Create a map where the keys are project names and the values are lists of pairs. Each pair contains an employee's name and the hours they have worked on that project.
//For each project in the map, sort the list of pairs by the hours worked in descending order.
//Return a map where the keys are project names and the values are the names of the top 3 employees who worked the most hours on that project. If there are fewer than 3 employees, include all of them.
//code//
//data class Employee(val name: String, val projects: List<String>, val hoursWorked: Map<String, Int>)
//fun analyzeEmployeeProjects(employees: List<Employee>): Map<String, List<String>>

/*
data class Employee(val name: String, val projects: List<String>, val hoursWorked: Map<String, Int>)

fun analyzeEmployeeProjects(employees: List<Employee>): Map<String, List<String>>{
    val sortedEmployeeWithLessThan2Projects= mutableListOf<Employee>()
    val allProjects:MutableSet<String> = mutableSetOf()
    for(i in employees){
        if(i.projects.size<2){
            sortedEmployeeWithLessThan2Projects.add(i)
        }
        allProjects.addAll(i.projects)
    }
    //Create a map where the keys are project names and the values are lists of pairs. Each pair contains an employee's name and the hours they have worked on that project.
    val map= mutableMapOf<String,MutableList<Pair<String,Int>>>()
    for(i in employees){
        for(p in i.projects){
            val pairs= map.getOrDefault(p, mutableListOf())
            pairs.add(Pair(i.name,i.hoursWorked.getOrDefault(p,0)))
        }
    }
    //For each project in the map, sort the list of pairs by the hours worked in descending order.
    for(i in map){
        var projectName=i.key
        val workedPairs = map.getOrDefault(projectName, mutableListOf())
        var hours = mutableListOf<Int>()
        workedPairs.sortBy { p->
            p.second
        }
    }

    val returnMap= mutableMapOf<String,List<String>>()
    for(i in map){
        var workedPairs = i.value
        val topWorkers = mutableListOf<String>()
        for(i in workedPairs){
            topWorkers.add(i.first)
        }
        for(i in topWorkers.size-4 downTo 0){
            topWorkers.removeAt(i)
        }
        returnMap[i.key] = topWorkers
    }
    return returnMap
}
*/


//You are building an inventory management system for a retail store. Each product has a unique ID, name, category, price, and stock quantity. The system should handle the following:
//Product Tracking: Add, update, and remove products.
//Stock Updates: Increase or decrease stock based on sales or restocking.
//Low Stock Alerts: Identify products below a specified stock threshold.
//Category Inventory Check: Report the total number of items and total value for a given category.
//Inventory Summary: Generate a report showing total products, total inventory value, and low-stock items.
//Task:
//Implement a class InventoryManager with appropriate methods to manage these tasks.
//Include methods to handle adding/updating products, checking for low stock, and generating summaries.

/*data class Product(val id:Int,val name:String, val category:String, var price:Int, var quantity)
class InventoryManager(val list:MutableList<Product>){
    val map:MutableMap<Int, Product> = mutableMapOf()
    init {
        for(i in list){
            map[i.id] = i
        }
    }

    fun addProduct(p:Product){
        list.add(p)
        map[p.id] = p
    }

    fun updating(p:Product){
        map[p.id] = p
        // we can even improve this like sending the product id with change in quantity but as per time constraint doing this
    }

    fun checkLowStock(q:Int):List<String>{
        val list:MutableList<String> = mutableListOf()
        for(i in map){
            if(i.value!!.quantity<q){
                list.add(i.value.name)
            }
        }
        return list
    }

    fun printQuantityAndValue(cat:String){
        var q:Int =0
        var p = 0
        for(i in map){
            if(i.value.category.equals(cat)){
                val thisq:Int = i.value.quantity
                val thisp = i.value.quantity
                q = q+thisq
                p +=(thisp*thisq)

            }
        }
        println("for Catageory $cat total Quantity = $q and total Price = $p")
    }

    fun generateReport(){
        //Inventory Summary: Generate a report showing total products, total inventory value, and low-stock items.
        var totalQuantity=0
        var totalValue:Int=0
        var lowstockitems=checkLowStock(3)//assuming less than 3 as low stock
        for(i in map){
            val thisq:Int = i.value.quantity
            val thisp = i.value.quantity
            totalQuantity += thisq
            totalValue = totalValue +(thisp*thisq)
        }

        println("Low Stock Items = ${ lowstockitems.joinToString(separator = ",") }")
        println("Total Inventory cost = $totalValue")
        println("Total Quantity cost = $totalQuantity")
    }
}*/

/*class example(val i:Int){
   lateinit var b:example
   val name:String by lazy {
       "sumath"
   }
    init {
        println("First init")
    }
    constructor():this(1){
        println("Seconday")
    }
    init {
        println("Second init")
        ::b.isInitialized

    }
    var a :()->Unit= {
        println()
    }

}

fun Int.add(b:Int){
    println(this +b)
}

open class A(){
companion object{
    var a:Int = 0
}
}
class B:A(){

}*/
