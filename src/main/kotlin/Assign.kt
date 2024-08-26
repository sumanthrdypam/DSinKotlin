/*
 Program to input result details of n students as exam number, name, and marks of 5 subjects.
 Calculate total marks, percentage and grade obtained of each student.
 Display list of students sorted in the descending order of their percentage.
 */

data class Exam(
    var number:Int,
    val name:String,
    val marks : Double
)
class Student(val number:Int, var name:String){
    lateinit var subs:Array<Exam>
    var totalMarks:Double=0.0
    var percentage:Double=0.0
    var grade:Char=' '
    fun inputMarks() {
        val n = 5

        println("Enter Marks details of $n items: ")

        subs = Array<Exam>(n) {
            print("Enter Exam id: ")
            val enumber = readln().toInt()

            print("Enter exam name: ")
            val ename = readln()

            print("Enter marks: ")
            val emarks = readln().toDouble()



            totalMarks += emarks
            Exam(enumber, ename, emarks)
        }

    }

    fun calculateGrade(){
        if(::subs.isInitialized){
            percentage=totalMarks/5.0
            grade=when{
                percentage>=80->'A'
                percentage>=70->'B'
                percentage>=60->'C'
                percentage>=40->'D'
                else->'A'

            }
        }
    }

    override fun toString(): String {
        return "$name got $totalMarks marks, $percentage% $grade grade"
    }

}

class Report( val students:Array<Student>){
    fun computeAndprint(){
        val map:MutableMap<Double,Student> = mutableMapOf()
        val list:MutableList<Double> = mutableListOf()
        for(i in students){
            list.add(i.totalMarks)
            map[i.totalMarks]=i
        }
        list.sortWith(reverseOrder())
        println("Studnets sorted as per marks: ")
        for(i in list){
            println(map.getOrDefault(i,null)?.name )
        }
    }
}
fun main(){


    val sumanth:Student=Student(1,"Sumanth")
    sumanth.inputMarks()
    sumanth.calculateGrade()

    val santhosh:Student=Student(2,"santhosh")
    santhosh.inputMarks()
    santhosh.calculateGrade()

    val report:Array<Student> = arrayOf(sumanth,santhosh)
    val finalReport:Report = Report(report)
    finalReport.computeAndprint()
}
