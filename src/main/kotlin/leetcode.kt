var per:MutableList<MutableList<Int>> = mutableListOf()
fun permute(nums: IntArray): List<List<Int>> {
    var temp:MutableList<Int> = mutableListOf()
    for(i in nums){
        temp.add(i)
    }
    per.clear()
    solve(temp,mutableListOf())
    return per
}

fun solve(arr:MutableList<Int>, ans:MutableList<Int>){
    if(arr.size == 0  ){
        var oneper:MutableList<Int> = mutableListOf()
        for(i in ans){
            oneper.add(i)
        }
        per.add(oneper)

        return
    }
    for(i in 0 until arr.size){
        var t = arr.removeAt(i)
        ans.add(t)
        solve(arr, ans)
        arr.add(i,t)
        ans.removeAt(ans.size-1)
    }
}

fun main(){
    permute(intArrayOf(1,2,3))
}