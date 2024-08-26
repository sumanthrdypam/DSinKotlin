import java.util.*

fun main(args: Array<String>) {


    Day4().main()
/*    var a =arrayOf(1,2,3)
    var b=a.filter({
        x:Int->
        x==1
    })
    println("sample ${a.joinToString()}")
    val x:Int=5
  println(x.powerOf(6))

    fun Int.powerOf(n:Int):Int{
        var p=1
        for(i in 1..n){
            p=p*this
        }
        return p
    }

    val multiply: (Int, Int) -> Int = { i, j ->
        i * j
    }

    var power:(Int,Int)->Int={
        a,b->
        var i:Int = 1
        for(x in 1..b){
            i=i*a
        }
        i
    }

    var mini:(Int,Int)->Int={
        a,b->
        if(a<b)
            a
        else
            b
    }

    var isprime : (Int)->Boolean={ a->
        var count : Boolean = true

        for(i in 1 until a){
            if (a%i==0){
                count=false
                break
            }
        }
        count
    }

   var removeduplicatesfrom1:(String,String, (String, String)->String)->String={
       str1,str2,funn->

           funn(str1, str2)
   }
   var rem:(String,String)->String={
       a,b->
       val stringBuilder:StringBuilder = StringBuilder()
       for(x in a){
           if(x !in b){
               stringBuilder.append(x)
           }
       }
       stringBuilder.toString()
   }

    println(removeduplicatesfrom1("abcd","bcd",rem))*/



}
//1.Check if a Given String is Palindrome or not without finding the reverse of the string
fun isPalindrome(s: String): Boolean {
    //O(n) is the time complexity
    //below is the submission link
    //https://leetcode.com/problems/valid-palindrome/submissions/1354950780/
    var str:StringBuffer=StringBuffer()
    var s:String=s.toLowerCase()
    for(i in s){
        if(i in 'a'..'z'){
            str.append(i)
        }else if(i in '0'..'9'){
            str.append(i)
        }
    }
    for(i in 0 until str.length/2){
        if(str[i]!=str[str.length-1-i]){
            return false
        }
    }
    return true
}

//2.Count the number of occurrences of each char in the input string
fun freqFinder(s: String) {
  val freq:MutableMap<Char,Int> = mutableMapOf<Char,Int>()
    for(x in s){
        freq[x] = freq.getOrDefault(x,0)+1
    }
    for( key in freq.keys){
        println("$key : ${freq[key]}")
    }
    //O(n),O(n)
}

//3. Find the most recurring char in the input string.
fun findMostRecurringChar(s:String):Char{
    // if two characters have same freq then it will return the char that has attained the maximum value first
    val map:MutableMap<Char,Int> = mutableMapOf()
    var letter:Char=' '
    var freq:Int=Int.MIN_VALUE
    for(x in s){
        map[x]=map.getOrDefault(x,0)+1
        if(map.getOrDefault(x,0) > freq){
            letter=x
            freq=map.getOrDefault(x,0)
        }
    }
    return letter
}

//4. Remove duplicate chars from the input string.
fun removeDuplicates(s : String) : String{
    //O(n), O(n)
    val set:MutableSet<Char> = mutableSetOf()
    var str:StringBuilder = StringBuilder()
    for(x in s){
        if(!set.contains(x)){
            str.append(x)
        }
    }
    return str.toString()
}

//5. Print all the duplicate chars in the input string.
fun printDuplicates(s:String){
    val freq:MutableMap<Char,Int> = mutableMapOf<Char,Int>()
    for(x in s){
        freq[x] = freq.getOrDefault(x,0)+1
    }
    for( key in freq.keys){
        if(freq.getOrDefault(key,0) > 1) {
            println("$key : ${freq[key]}")
        }
    }
}

//6. Find first non-repeating character in the string
fun findUniqueChar(s : String):Char{
    val freq : MutableMap<Char, Int> = mutableMapOf()
    for(x in s){
        freq[x] = freq.getOrDefault(x,0)+1
    }
    for(i in s.indices){
        if(freq.getOrDefault(s[i],0)==1){
            return s[i]
        }
    }
    //if not found returning '.'
    return '.'
}

//6. Find first non-repeating character in the string
//https://leetcode.com/problems/first-unique-character-in-a-string/description/
//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/1354990605/
fun firstUniqChar(s: String): Int {
    val freq : MutableMap<Char, Int> = mutableMapOf()
    for(x in s){
        freq[x] = freq.getOrDefault(x,0)+1
    }
    for(i in s.indices){
        if(freq.getOrDefault(s[i],0)==1){
            return i
        }
    }
    //if not found returning '.'
    return -1
}

//7. Remove characters from the first string which are present in the second string
fun removeChars(s1 : String, s2 : String) : String{
    val s:MutableSet<Char> = mutableSetOf()
    for(x in s2){
        s.add(x)
    }
    val ret: StringBuilder = StringBuilder()
    for(x in s1){
        if(!s.contains(x)){
            ret.append(x)
        }
    }
    return ret.toString()
}

//8. Check if strings are rotations of each other or not


//9. Print all permutations of a given string


// 10. Reverse each word in a given string. E.g. input: Android is best output: diordnA si tseb
fun reverseEachWord(s:String) : String{
    val arr: List<String> = s.split(" ")
    var ret : StringBuilder= StringBuilder()
    for(x in arr){
        var ar: CharArray = x.toCharArray()
        for(i in 0 until ar.size/2){
            var t=ar[i]
            ar[i]=ar[ar.size-1-i]
            ar[ar.size-1-i]=t
        }
        var temp=StringBuilder()
        for(ch in ar){
            temp.append(ch)
        }


        ret.append(temp.toString())
        ret.append(" ")

    }
    return ret.toString().substring(0,s.length-1)
    //O(3*n), O(2*n)
}

//11. Find the word with the longest length in the given sentence.
fun findLongestString(s:String):String{
    var string = s.trim()
    string= "$string "
    var start=0
    var min=Int.MIN_VALUE
    var str=""
    for(i in string.indices){
        if(string[i]==' '){
            if(i-start>min){
                min=i-start
                str = string.substring(start,i)
            }
            start=i+1
        }
    }
    return str
}

//12. Program to remove the same consecutive char from the input string. E.g. input string:  ssuuppperrr coooommpuuuuuuuutttter output should be: super computer
fun removeConsecutiveChars(s : String) : String{
    var str : StringBuilder = StringBuilder()
    if(s.isEmpty()) return str.toString()
    str.append(s[0])
    for(i in 1..<s.length){
        if(str[str.length-1]!=s[i]){
            str.append(s[i])
        }
    }
    return str.toString()

}


//Program to check if number is prime or not
fun isPrime(n:Long):Boolean{
    if(n<=1) return false
    for(i in 2 until n){
        if(n%i== 0L){
            return false
        }
    }
    return true
}

//Program to perform binary search on sorted array
//returns -1 if number not found
fun binarysearch(arr: Array<Int>, target: Int) : Int{
    //assuming array is sorted
    var start:Int=0
    var end:Int=arr.size-1
    while(start<=end){
        var middle=(start+end)/2
        if(arr[middle]==target) return middle
        else if(arr[middle]<target) start=middle+1
        else end=middle-1
    }
    return -1 //required element not found
}

//2 arrays are supposed to have same numbers irrespective of their order in array. But second array has one element missing. Write program to find missing number from 2nd array.
/*e.g.

a = { 4, 9, 0, 3, 2}
b = { 9, 2, 0, 4}

Output: missing = 3
 */

fun findMissingElement(arr1 : Array<Int>, arr2 : Array<Int>) : Int? {
    var set: MutableMap<Int,Int> = mutableMapOf()
    for(i in arr2){
        set.put(i,0)
    }
    for(i in arr1){
        if(!set.contains(i)){
            return i
        }
    }
    return null
}


//Program to remove duplicate chars from string using Extension function
fun String.removeDuplicate():String{
    val ret:StringBuilder=StringBuilder()
    val map:MutableMap<Char,Int> = mutableMapOf()
    for(x in this){
        if(!map.containsKey(x)){
            ret.append(x)
        }
        map[x]=1
    }
    return ret.toString()
}

//Extension function to check if two strings are Anagram strings or not

fun String.checkAnagram(str:String):Boolean{
    val freqOfS1 : MutableMap<Char,Int> = mutableMapOf()
    val freqOfS2 : MutableMap<Char,Int> = mutableMapOf()
    for (i in this) {
        freqOfS1[i] = freqOfS1.getOrDefault(i, 0) + 1
    }
    for(i in str){
        freqOfS2[i] = freqOfS2.getOrDefault(i,0)+1
    }
    for(i in this){
        if(freqOfS1[i]!=freqOfS2[i]){
            return false
        }
    }
    return true

}

//Program to find x raise to y using extension function.

fun Int.powerOf(n:Int):Int{
    var p=1
    for(i in 1..n){
        p=p*this
    }
    return p
}

fun day4(){

    var removeduplicatesfrom1:(String,String, (String, String)->String)->String={
            str1,str2,funn->

        funn(str1, str2)
    }
    var rem:(String,String)->String={
            a,b->
        val stringBuilder:StringBuilder = StringBuilder()
        for(x in a){
            if(x !in b){
                stringBuilder.append(x)
            }
        }
        stringBuilder.toString()
    }

    println(removeduplicatesfrom1("abcd","bcd",rem))

    //single line experesion funtion
    fun sum(a:Int, b:Int):Int{
        return a+b
    }


    //removed the return type and curly braces
    fun sum1(a:Int, b:Int )= a+b

    //default value parameters function


    fun sum(a:Int, b:Int=0, c:Int=0):Int = a+b+c
    println("${sum(1,2,3)} sum is ${sum(1,2)} sum is ${sum(3)}")

    fun sub(a:Int=0, b:Int):Int = a-b
    //so here there is no rule to have default parameters at the end like c++
    println("sub is "+sub(b=5))

    //named parameter
    println(sum(b=5,a=1,c=8)) // we are passing the named parameters
    //useful while remembering the sequence
    //java cannot use default value parameters that are here

    //if you want to use this then use @JvmOverloads when can from java program with default values as well
    //@JvmOverloads
    fun multiply(a: Int, b:Int=5):Int{
        return a*b
    }

}
@JvmOverloads
fun multiply(a: Int, b:Int=5):Int{
    return a*b
}







