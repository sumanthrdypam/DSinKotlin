/*
In an organization, salary of each employee is calculated on the basis of his basic salary. Every employee gets HRA, DA allowances. HRA is 35% of basic salary, DA is 45% of basic salary. For every employee there is TAX and PF deduction. TAX is calculate on the basis of Gross salary.

Gross Salary = Basic Salary + HRA + DA.

TAX is 20% of gross salary if gross salary is greater than 95000, 10 % if gross salary is between 70000 to 95000, is 5% if gross salary is between 40000 to 70000.
PF is 12% of basic salary.
Net Salary is calculated as : Net Salary = Gross Salary - TAX - PF.

There are two types of employees in the organization - Manager and Worker

If worker works in over time hours, worker gets per hour overtime (OT) benifits of 100 per hour.
For worker, gross salary is calculate as

Gross Salary = Basic Salary + HRA + DA + OT hours * 100

And Net salary calculate as Net Salary = Gross Salary - TAX - PF

For managers, company pays bonus which depends on number of targets completed by manager. Company pays 2000 per target to Managers
For managers, gross salary is calculated as

Gross Salary = Basic Salary + HRA + DA + Number of Targets Completed * 2000

and Net salary is calculated as
Net Salary = Gross Salary - TAX - PF"

 *//*


open class Employee(
    val id: Long,
    val name: String,
    val basicSalary: Float
) {
    protected var hra: Float = 0f
    protected var da: Float = 0f
    protected var tax: Float = 0f
    protected var pf: Float = 0f
    protected var gs: Float = 0f
    protected var ns: Float = 0f

    open fun calculateGrossSalary() {
        hra = 0.35f * basicSalary
        da = 0.45f * basicSalary
        gs = basicSalary + hra + da
    }

    fun calculateNetSalary() {
        tax = when {
            gs >= 95000f -> {
                0.2f * gs
            }
            gs >= 70000f -> {
                0.1f * gs
            }
            gs >= 40000f -> {
                0.05f * gs
            } else -> {
                0f
            }
        }
        pf = 0.12f * basicSalary
        ns = gs - tax - pf
    }

    open fun printSalarySlip() {
        println("Employee Id    : $id")
        println("Name           : $name")
        println("Basic salary   : $basicSalary")
        println("HRA - 35% of Basic salary: $hra")
        println("DA - 45% of Basic salary : $da")
        println("Grass Salary = Basic Salary + HRA + DA = $basicSalary + $hra + $da = $gs")
        println("Tax            : $tax")
        println("PF - 12% of Basic Salary : $pf")
        println("Net salary = Gross Salary - tax - PF = $gs - $tax - $pf = $ns")
    }
}

class Worker(workerId: Long,
             workerName: String,
             workerBs: Float,
             val otHours: Int
) : Employee(workerId, workerName, workerBs) {

    override fun calculateGrossSalary() {
        super.calculateGrossSalary()
        gs += otHours * 100
    }

    override fun printSalarySlip() {
        println("Employee Id    : $id")
        println("Name           : $name")
        println("Basic salary   : $basicSalary")
        println("HRA - 35% of Basic salary: $hra")
        println("DA - 45% of Basic salary : $da")
        println("Number of OT Hours       : $otHours")
        println("Gross Salary = Basic Salary + HRA + DA + OT Hours  100 = $basicSalary + $hra + $da + ${otHours* 100}  = $gs")
        println("Tax            : $tax")
        println("PF - 12% of Basic Salary : $pf")
        println("Net salary = Gross Salary - tax - PF = $gs - $tax - $pf = $ns")
    }
}

class Manager( workerId: Long,
               workedName:String,
                workerBs:Float,
                val noOfTargets:Int
    ) : Employee(workerId, workedName, workerBs){
    override fun calculateGrossSalary() {
        super.calculateGrossSalary()
        gs+= noOfTargets*2000
    }
    override fun printSalarySlip() {
        println("Employee Id    : $id")
        println("Name           : $name")
        println("Basic salary   : $basicSalary")
        println("HRA - 35% of Basic salary: $hra")
        println("DA - 45% of Basic salary : $da")
        println("Number of Targets       : $noOfTargets")
        println("Gross Salary = Basic Salary + HRA + DA + NoofTargets * 2000 = $basicSalary + $hra + $da + ${noOfTargets* 2000}  = $gs")
        println("Tax            : $tax")
        println("PF - 12% of Basic Salary : $pf")
        println("Net salary = Gross Salary - tax - PF = $gs - $tax - $pf = $ns")
    }

    }



*/
/*
Write a program to find distance between two points in 2D Plane and 3D Plain.
Create appropriate classes, inheritance, constructors, functions and function overriding.
*//*




open class Point2D( val x:Float=5f, val y:Float){
    open fun calculateDistance(b:Point2D):Float = Math.sqrt((((this.x-b.x)*(this.x-b.x)) + ((this.y-b.y)*(this.y-b.y))).toDouble()).toFloat()
    override fun toString()="(x,y) = {$x, $y)"
}

class Point3D(x:Float, y:Float, val z:Float):Point2D(x,y){
    override fun calculateDistance(b:Point2D):Float {
        if(b is Point3D) {
            return Math.sqrt((((this.x - b.x) * (this.x - b.x)) + ((this.y - b.y) * (this.y - b.y)) + ((this.z - b.z) * (this.z - b.z))).toDouble())
                .toFloat()
        }else{
            return super.calculateDistance(b)
        }
    }
    override fun toString()="(x,y,z) = {$x, $y,$z)"
}

fun add(a:Int=5, b:Int=6, c:Int=7):Int = a

fun main() {
*/
/*    val A2=Point2D(0f,0f)
    val B2=Point2D(1f,1f)
    println("Distnce between point A$A2 and point B$B2 is ${A2.calculateDistance(B2)}")

    val A=Point3D(0f,0f,0f)
    val B=Point3D(1f,1f,1f)
    println("Distnce between point A$A and point B$B is ${A.calculateDistance(B)}")*//*

    var diff:Int = Int.MAX_VALUE

    add(1)
    add(1,2)
    add(3)
    add(c=9)//named arguments

}*/
