class Day4 {
    @JvmOverloads
    fun sum(a:Int, b:Int=5):Int{
        return a+b
    }
    infix fun Int.raiseTo(y:Int):Int{
        //need to implement logic
        var p=1
        for( i in 1.. y step 5){
            p=p*this
        }
        return p
    }
    fun main(){
        println("hi")

        //variable length function
      //  println(Max(1))
        //println(Max(1,2,3,4))


        //***InLine Function
        //if you have function then function call we be replaced by function body
        //as a result there is no activation record and performance enhancement is there
        //java doesn't support inline funtion expectily
        //But JIC will do things automatically as per need
        //see about theory told be sir how funtion call process
        //defining higher order function as inline is more useful
        //keyword:inline



        //**infix functions
        //code becomes more redable***
        infix fun Int.raiseTo(y:Int):Int{
            //need to implement logic
            var p=1
            for( i in 1.. y step 5){
                p=p*this
            }
            return p
        }

        val x=5
        println(x raiseTo 5)//x.raiseTo(y)
        //must have single parameter to be infix
        //is it only for extension function?***
        //example



        //classes and objects ***
        //collection of data and functions which operate on that data
        //this collection of data and functions belongs to only one entity


    }
    @JvmOverloads
    fun Max(b:Double=5.0, vararg numbers:Int ):Int{
        //internally numbers is of type Array<Int>
        //examples is arrayOf()
        var m=Int.MIN_VALUE
        for(i in numbers){
            m=Math.max(m,i)
        }
        return m
    }



    //

}


