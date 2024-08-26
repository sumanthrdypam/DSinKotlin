class ABC(){
   var mobileNumber:String?=null
      get() {
         return field
      }
      set(value){

         if(value != null && "[1-9][0-9]{9}".toRegex().matches(value)){
            field=value
         }else{
            field=null
         }
      }

   var x = ""
      get() {
         println("get called")
         return field}
      set(value) {
         println("set called")
         field = value
      }
   fun test():Unit{
      println(x)
      x="f"
   }


}

fun main(){
   var obj = ABC()
   obj.mobileNumber="123456789"
   println("Mobile number ${obj.mobileNumber}")

}