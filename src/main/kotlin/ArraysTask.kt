
//1. Find the second largest number from the array.
//using extension Function
fun Array<Int>.findSecondLargest():Int{
    var first=this[0]
    var second=this[0]
    for(i in this){
        if(i>first){
            second=first
            first=i
        }else if(i>second && i<first){
            second=i
        }
    }
    return second
}

// 2. Find the second smallest number from the array.

var secondSmallest:(Array<Int>)->Int={
    arr->
    var first=arr[0]
    var second=first
    for(i in arr){
        if(i<first){
            second=first
            first=i
        }else if(i<second){
            second=i
        }
    }
    second

}

//3. Merge two arrays to form a third array e.g. First array: 10, 50, 20,30,70,80,40 Second  array: 25,75, 5, 25 Merged array should be: 10, 25, 50, 75, 20, 5, 30, 25, 70, 80,40
//using lambda function

var merge:(Array<Int>, Array<Int>)->Array<Int> = {
    a ,b->
    var retArray=Array<Int>(a.size+b.size){0}
    var min=Math.min(a.size,b.size)
    for(i in 0 until min){
        retArray[2*i]=a[i]
        retArray[2*i+1]=b[i]
    }
    var m=min
    if(a.size==min){
        for(i in 2*min until retArray.size){
            retArray[i]=b[m++]
        }
    }else{
        for(i in 2*min until retArray.size){
            retArray[i]=a[m++]
        }
    }
    retArray
}

//4. Merge two softed array to form third sorted array: e.g. First Array: 10, 28, 50, 75, 80,95,  100 Second array: 35, 60, 70, 78 Expected Merged sorted array: 10, 28, 35, 50, 60, 70,  75, 78, 80, 95,100
//O(n+m), O(n+m)
var mergesorted:(Array<Int>, Array<Int>)->Array<Int> = {
    a,b->
    var retArray:Array<Int> = Array<Int>(a.size+b.size){0}

    var i:Int=0
    var j:Int=0
    var index:Int=0
    while(i<a.size && j<b.size){
        if(a[i]<=b[j]){
            retArray[index++]=a[i++]
        }else{
            retArray[index++]=b[j++]
        }
    }
    if(i<a.size){
        while(i<a.size){
            retArray[index++]=a[i++]
        }
    }else if(j<b.size){
        while(j<b.size){
            retArray[index++]=b[j++]
        }
    }
    retArray
}

//5. Rotate array elements from left to right by n position.
//O(2*n), O(1)
var rotateToRight:(Array<Int>, Int)->Unit={
    a,n->
    for(i in 0..<n/2){
        var t=a[i]
        a[i]=a[n-1-i]
        a[n-1-i]=t
    }
    for(i in 0 until (a.size-n)/2){
        var t=a[i+n]
        a[i+n]=a[a.size-i-1]
        a[a.size-i-1]=t
    }
    for(i in 0..<a.size/2){
        var t=a[i]
        a[i]=a[a.size-i-1]
        a[a.size-i-1]=t
    }
    a.forEach { println(it) }
}

//6. Rotate array elements from right to left by n position.
//O(2*n), O(1)
var rotateArrayElementsFromRightToLeft:(Array<Int>,Int)->Unit={
    arr,n->
    for(i in 0 until (arr.size-n)/2){
        var t=arr[i]
        arr[i]=arr[arr.size-n-1-i]
        arr[arr.size-n-1-i] = t
    }
    for(i in 0 until (n)/2){
        var t=arr[arr.size-n-i]
        arr[arr.size-n-i]=arr[arr.size-i-1]
        arr[arr.size-i-1]=t
    }
    for(i in 0..<arr.size/2){
        var t=arr[i]
        arr[i]=arr[arr.size-i-1]
        arr[arr.size-i-1]=t
    }
    arr.forEach { println(it) }
}

//7. Find the first pair of array elements having sum equal to zero.
//two sum problem solved with hashmap
//O(n), O(n)
var sumEqualTo:(Array<Int>,Int)->Array<Int>? = {
    //if you need sum pass target as zero
    arr,target->
    var map:MutableMap<Int,Int> = mutableMapOf()
    for(i in arr){
        if(map.containsKey(target-i)){
            arrayOf(i,target-i)
        }
        map[i]=map.getOrDefault(map[i],0)+1
    }
    null
}

//8. Find all the pairs of array elements having sum equal to given number.
//Using the same previous approach
//O(n), O(n)
var targetSumPairs:(Array<Int>, Int)->MutableList<Array<Int>> = {
    arr,target->
    var listOfPairs:MutableList<Array<Int>> = mutableListOf()
    var map:MutableMap<Int,Int> = mutableMapOf()
    arr.forEach{
        var req=target-it
        if(map.containsKey(req)){
            listOfPairs.add(arrayOf(it,req))
        }

        map[it]=map.getOrDefault(it,0)+1
    }
    listOfPairs


}


//9. Find the maximum element in an array.
fun Array<Int>.findMaximum():Int{
    var max:Int=Int.MIN_VALUE
    for( i in this){
        if(i>max){
            max=i
        }
    }
    return max
}

// 10. Find the minimum element, in an array,
fun Array<Int>.findMimimum():Int{
    var min:Int=Int.MAX_VALUE
    for( i in this){
        if(i<min){
            min=i
        }
    }
    return min
}

//11. Remove duplicates from an'array.
//this is generic as I have used Any type
//O(n), O(n)
var removeDuplicate:(Array<Any>)->MutableList<Any> = {
    arr->
    var l:MutableList<Any> = mutableListOf()
    var mapis:MutableMap<Any,Int> = mutableMapOf()
    arr.forEach {
        mapis[it]=mapis.getOrDefault(it,0) + 1
    }
    for( i in arr){
        if(mapis.getOrDefault(i,0)==1){
            l.add(i)
        }
    }
    l
}

//12. Find the second largest element in an array.
// Redudent question refer to 1

//13. Find the kth smallest/largest element in' an array.
//sorting and finding the element at k-1 index
//O(NlogN), O(1)
fun findKthSmallest(a:Array<Int>,k:Int):Int{
    a.sort()
    return a[k-1]
}

//14. Merge two sorted arrays into one sorted array.
//Repeated question refer to  4

//15. Find the frequency of each element in an array.
fun findFreq(arr:Array<Int>):Unit{
    var freq:MutableMap<Int,Int> = mutableMapOf()
    arr.forEach { freq[it] = freq.getOrDefault(it,0)+1 }
    freq.forEach { (k, v) ->
        println("Element $k 's frequency is $v")
    }
}

//16. Rotate an array to the right by n positions.
//Redudent question 5

//17. Sort an array using any sorting algorithm (e.g., bubble sort, insertion sort, quicksort).
fun customSort(arr:Array<Int>){


}

//******************************//******************************//******************************//******************************
//18. Find the contiguous subarray with the largest sum (Kadane's algorithm).
//so we will maintain two variables one is max and other is sum
//max will have MIN_VALUE as initial value and sum as 0
// at every index we will add the value to the sum
//compare and update max
// if sum is less than 0 max sum as zero
//so we will nullify if sum is less than zero and carry forward positive sum, this is the main core logic here
//O(N),O(1)
fun Array<Int>.findMaxSubArray():Int{
    var sum:Int=0
    var max:Int=Int.MIN_VALUE
    for(i in this){
        sum+=i
        if(sum>max) max=sum
        if(sum<0) sum=0
    }
    return max
}

//19. Move all zeros to the end of an array while maintaining the order of non-zero elements.
//O(N),O(1)
//https://leetcode.com/problems/move-zeroes/
//https://leetcode.com/problems/move-zeroes/submissions/1357227235/
fun moveZerosToEnd(arr:Array<Int>){
    var index:Int=0
    for(i in arr.indices){
        if(arr[i]!=0){
            arr[index++]=arr[i]
        }
    }
    for(i in index until arr.size){
        arr[i]=0
    }
}

//20. Find the majority element (element that appears more than n/2 times) in an array.
//my approach was to use hashMap and maintain the freq but want to do it in constant space
//https://leetcode.com/problems/majority-element/submissions/1357246437/
//since the element will appear more than n/2 times using carryforward kind of approach here
//O(N), O(1)
fun Array<Int>.findMajortity():Int?{
    var maj:Int=this[0]
    var count:Int=0
    for(i in this){
        if(maj==i){
            count++
        }else{
            count--
        }
        if(count==0){
            maj=i
            count=1
        }
    }

    var checkcount=0
    for(i in this){
        if(i==maj){
            checkcount++
        }
    }
    if(checkcount>(this.size)/2){
        return maj
    }
    return null
}

//21. Find all pairs in an array that sum up to a specific target value.
//refer question number 8

//22.Find the longest increasing subsequence in an array.
//https://leetcode.com/problems/longest-increasing-subsequence/description/
//******************************//******************************//******************************//******************************
//the idea is to memoize the maximum length starting at index i from ending
//O(N*N), O(N)
//can be written in O(NlogN),O(N)
fun lengthOfLIS(nums: IntArray): Int {
    var arr:Array<Int> = Array<Int>(nums.size){1}
    for(i in nums.size-2 downTo 0){
        var m=0
        for(j in i until nums.size){
            if(nums[i]<nums[j]){
                m=Math.max(m,arr[j])
            }
        }
        arr[i]=m+1
    }
    var mm=0
    for(i in arr){
        mm=Math.max(mm,i)
    }
    return mm
}

//23. Find the missing number in an array containing numbers from 1 to n.
fun findfirstMissingNumber(arr:Array<Int>):Int{
    var sum=0
    arr.forEach { sum+=it }
    return ((arr.size+1)*(arr.size+2))/2-sum
}

//24. Find the leaders in an array (an element is a leader if it is greater than all the elements to  its right).
//O(N), O(1)
var findLeaders:(Array<Int>)->MutableList<Int> = {
    var ans : MutableList<Int> = mutableListOf()
    var max:Int = Int.MIN_VALUE
    for(i in it.size-1 downTo  0){
        if(max<it[i]){
            ans.add(0,it[i])
            max=Math.max(max,it[i])
        }
    }
    ans
}

//25. Rearrange positive and negative numbers in an array such that positive and negative  elements are alternate.
//I am assuming that input will have numbers where positive and negative numbers or equal or differ by atmost one
//I am assuming input doesn't have zeros as my code will break if a element is zero, I can handle that if I know zero is positive or negative

fun mixPositiveAndNegative(arr : Array<Int>){
    var pos=0
    var neg=1
    while(pos < arr.size && neg<arr.size){
        if(arr[pos]>0){
            while(pos<arr.size){
                if(arr[pos]>0){
                    pos+=2
                }else{
                    break
                }
            }
        }
        if(pos>=arr.size) break

        if(arr[neg]<0){
            while(neg<arr.size){
                if(arr[neg]<0){
                    neg+=2
                }else{
                    break
                }
            }
        }
        if(neg>=arr.size) break
        var t=arr[pos]
        arr[pos]=arr[neg]
        arr[neg]=t
    }
}

//26. Find the equilibrium index of an array (an index such that the sum of elements at lower  indices is equal to the sum of elements at higher indices).
//O(2*N),O(1)
fun findEqulibrium(arr:Array<Int>):Int?{
    var sum=0
    for(i in arr.size-1 downTo 0){
        sum+=arr[i]
    }
    var leftSum=0
    for(i in arr.indices){
        leftSum+=arr[i]
        sum-=arr[i]
        if(leftSum==sum){
            return i
        }
    }
    return null
}

//27. Find the longest subarray with equal number of 0s and 1s.
//O(N),O(N)

fun findSubArrayWithEqualZerosandOnes(arr:Array<Int>):Array<Int>{
    var sum=0
    var map:MutableMap<Int,Int> = mutableMapOf()
    var max=Int.MIN_VALUE
    var start=-1
    var end=-1
    for(i in arr.indices){
        if(arr[i]==0){
            arr[i]=-1
        }
        sum+=arr[i]
        if(map.containsKey(sum) && i-map.getOrDefault(sum,0)>max){
            max=i-map.getOrDefault(sum,0)
            start=map.getOrDefault(sum,0)
            end=i
        }
    }
    return arrayOf(start,end)
}

//28. Find the peak element in an array (an element which is greater than or equal to its  neighbors).
// so my understanding of this question is if left and right elements of an element is less than given element then it is peak element
//and also since starting and end indexes are considered as not peak elements

fun findPeakElements(arr:Array<Int>):MutableList<Int>{
    val list = mutableListOf<Int>()
    for(i in 1..arr.size-2){
        if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
            list.add(arr[i])
        }
    }
    return list
}

//29. Find the intersection of two arrays.
//O(N),O(N)
fun findIntersection(arr1:Array<Int> , arr2:Array<Int>):MutableList<Int>{
    val list = mutableListOf<Int>()
    val hm = mutableMapOf<Int,Int>()
    for(i in arr1){
        hm.put(i,0)
    }
    for(i in arr2){
        if(hm.containsKey(i)){
            list.add(i)
        }
    }
    return list
}

//30. Find the smallest positive integer missing from an unsorted array.
//O(N),O(N)
fun firstMissingPositive(arr:Array<Int>):Int{
    for(i in arr.indices){
        if(arr[i]<=0){
            arr[i]=Int.MAX_VALUE
        }
    }
    for(i in arr){
        var temp=Math.abs(i)
        if(temp<=arr.size){
            arr[temp-1]=-arr[temp-1]
        }
    }
    for(i in arr.indices){
        if(arr[i]>0){
            return i+1
        }
    }
    return arr.size+1
}

//31. Find the largest subarray with equal number of 0s and 1
//refer 27


//******************************//******************************//******************************//******************************
//32. Sort an array of 0s, 1s, and 2s (Dutch National Flag problem).
//O(2*N),O(1)
fun sort012(arr:Array<Int>){
    var zeros=0
    var one=0
    var two=0
    for(i in arr){
        when(i) {
                0 -> zeros++
                1 -> one++
                2 -> two++
        }
    }
    for(i in 0 until one){
        arr[i] = 0
    }
    for(i in 0 until one){
        arr[zeros+i]=1
    }
    for(i in 0 until two){
        arr[zeros+one+i]=2
    }
}

//33. Find the maximum product subarray.
//******************************//******************************//******************************//******************************

    fun maxProduct(nums: IntArray): Int {
        var pre:Int=1
        var suf:Int=1
        var ans:Int=Int.MIN_VALUE
        for(i in 0 until nums.size){
            if(pre==0) pre=1
            if(suf==0) suf=1
            pre=pre*nums[i]
            suf=suf*nums[nums.size-1-i]
            ans=Math.max(ans, Math.max(pre,suf))
        }
        return ans
    }
    //https://leetcode.com/problems/maximum-product-subarray/description/


//34. Find the subarray with _given sum.
//https://leetcode.com/problems/subarray-sum-equals-k/
//https://leetcode.com/problems/subarray-sum-equals-k/submissions/1361914481/
fun subarraySum(nums: IntArray, k: Int): Int {
    var count=0
    var hm:MutableMap<Int, Int> = mutableMapOf()
    hm[0]=1
    if(nums[0] == k) count++
    hm[nums[0]]=hm.getOrDefault(nums[0],0)+1
    for(i in 1 until nums.size){
        nums[i]=nums[i]+nums[i-1]
        var req = nums[i]- k
        count+=hm.getOrDefault(req,0)
        hm[nums[i]]=hm.getOrDefault(nums[i],0)+1
    }
    return count
}

//35. Find the maximum difference between two elements in an array such that larger element  appears after the smaller number.
//O(N),O(1)
fun findMaxDiff(arr:Array<Int>):Int?{
    if(arr.size<=1) return null
    var MaxDiff:Int?=null
    var maxAs=arr[arr.size-1]
    for(i in arr.size-2 downTo 0){
        if(maxAs>arr[i]){
            MaxDiff=maxAs-arr[i]
        }else{
            maxAs=arr[i]
        }
    }
    return MaxDiff

}

//36. Find the k closest elements to a given value in an array.
//O(NlogN), O(1)




//37. Find the minimum number of swaps required to sort an array.

//38. Find the maximum length of subarray having sum equal to k

fun findSubArrayWithSum(arr :MutableList<Int>, target:Int):Int{
    var map:MutableMap<Int,Int> = mutableMapOf()
    var ans=0
    map[0]=0
    map[arr[0]] = 1
    for(i in 1 until arr.size){
        arr[i]+=arr[i-1]
        var req=arr[i]-target
        if(map.containsKey(req)){
            ans=Math.max(ans,i-map.getOrDefault(req,0))
        }
        if(!map.containsKey(arr[i])) {
            map[arr[i]] = i + 1
        }

    }
    return ans
}

//39. Find the minimum distance between two given elements in an array.
//O(NlogN),O(N)
fun minDist(a: IntArray, n: Int, x: Int, y: Int): Int {
    val al = ArrayList<Int>()
    val bl = ArrayList<Int>()

    for (i in 0 until n) {
        if (a[i] == x) {
            al.add(i)
        }
    }

    for (i in 0 until n) {
        if (a[i] == y) {
            bl.add(i)
        }
    }

    if (al.isEmpty() || bl.isEmpty()) {
        // we do not have an element; it is either x or y
        return -1
    }

    var ans = Int.MAX_VALUE
    for (xx in al) {
        val c = findCeil(bl, xx)
        val f = findFloor(bl, xx)
        if (c != -1) {
            ans = minOf(ans, c - xx)
        }
        if (f != -1) {
            ans = minOf(ans, xx - f)
        }
    }

    return ans
}

fun findFloor(arr: ArrayList<Int>, target: Int): Int {
    var found = -1
    var l = 0
    var r = arr.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (arr[mid] <= target) {
            found = arr[mid]
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return found
}

fun findCeil(arr: ArrayList<Int>, target: Int): Int {
    var found = -1
    var l = 0
    var r = arr.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        if (arr[mid] >= target) {
            found = arr[mid]
            r = mid - 1
        } else {
            l = mid + 1
        }
    }
    return found
}

//other approach O(N),O(1)
fun minDist2(a: IntArray, n: Int, x: Int, y: Int): Int {
    var x1 = -1
    var y1 = -1
    var dist = Int.MAX_VALUE
    var found = false

    for (i in a.indices) {
        when (a[i]) {
            x -> {
                if (y1 != -1) {
                    found = true
                    dist = minOf(dist, kotlin.math.abs(y1 - i))
                }
                x1 = i
            }
            y -> {
                if (x1 != -1) {
                    found = true
                    dist = minOf(dist, kotlin.math.abs(x1 - i))
                }
                y1 = i
            }
        }
    }

    return if (found) dist else -1
}



// 40. Find the maximum circular subarray sum.
fun maxSubarraySumCircular(nums: IntArray): Int {
    var allNegative=true
    var maxElement=nums[0]
    for(i in nums){
        if(i>0){
            allNegative=false
        }
        maxElement=Math.max(maxElement,i)
    }
    if(allNegative){
        return maxElement
    }
    //so till now I just verified if all the elements in the array are negative, if so I will return the maximum in them
    //now will calculate the sum using the kadanes algorithm
    var maxSumOfTheSubArray=0
    var currentSum=0
    var totalSum=0
    var negMaxSumOfTheSubArray=nums[0]
    var negCurrentSum = 0
    for(i in nums){
        //maintaning the totalSum of the array
        totalSum+=i
        //maintaining the currentSum which is positive and updating as per the kadanes algorithm
        if(currentSum<0){
            currentSum = 0
        }
        currentSum+=i
        maxSumOfTheSubArray=Math.max(maxSumOfTheSubArray, currentSum)
        //now again maintaing the maximum negative sum using the same kadanes algorithm
        if(negCurrentSum>0){
            negCurrentSum=0
        }
        negCurrentSum+=i
        negMaxSumOfTheSubArray = Math.min(negCurrentSum, negMaxSumOfTheSubArray)
    }
    var maxSumOfCircular=totalSum-negMaxSumOfTheSubArray
    return Math.max(maxSumOfTheSubArray, maxSumOfCircular)
}

// 41. Find the longest subarray with at most k distinct elements.

fun maxSubarrayLength(nums: IntArray, k: Int): Int {
    var len=0
    var start=0
    var end=0
    var n=nums.size
    val freq:MutableMap<Int,Int> = mutableMapOf()
    while(end < n){
        var ele = nums[end]
        var newFreq = freq.getOrDefault(ele,0)+1
        freq[ele] = newFreq
        end++
        if(newFreq>k){
            while(start<end){
                var sEle = nums[start]
                var sfreq = freq.getOrDefault(sEle,0)-1
                start++
                if(sfreq == 0){
                    freq.remove(sEle)
                }else{
                    freq[sEle] = sfreq
                }
                if(sEle==ele){
                    break
                }

            }
        }
        len=Math.max(len,end-start)
    }
    return len
}

// 42. Find the median of two sorted arrays of different sizes.
//O(N+M) , O(N+M)
/*fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var arr = mutableListOf<Int>()
    var i=0; var j=0; var index=0
    var n= nums1.size
    var m= nums2.size
    while(arr.size < (n+m) ){
        if(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                arr.add(nums1[i++])
            }else{
                arr.add(nums2[j++])
            }
        }else if(i<n){
            arr.add(nums1[i++])
        }else {
            arr.add(nums2[j++])
        }
    }
    if(arr.size%2==1){
        return arr[(arr.size)/2]+0.0
    }else{
        return (arr[(arr.size-1)/2]+arr[arr.size/2]+0.0)/2
    }
}*/
//O((N+M)/2), O(1)
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var i=0
    var j=0
    var index=0
    var req1 = (nums1.size + nums2.size -1)/2
    var req2 = (nums1.size + nums2.size)/2
    var a = -1
    var b = -1
    while(a == -1 || b == -1){
        var pre:Int=-1
        if(i < nums1.size && j < nums2.size){
            if(nums1[i] <= nums2[j]){
                pre=nums1[i++]
            }else{
                pre=nums2[j++]
            }
        }else if( i<nums1.size ){
            pre=nums1[i++]
        }else if(j<nums2.size){
            pre=nums2[j++]
        }
        if(index==req1){
            a=pre
        }
        if(index == req2){
            b=pre
        }
        index++

    }
    return a+b/2.0
}

fun main(){
    println(findMedianSortedArrays(intArrayOf(1,3),intArrayOf(2)))
}
