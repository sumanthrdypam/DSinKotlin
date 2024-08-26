class Mat(val m :Array<Array<Int>>) {
    infix fun add(b:Mat):Mat?{
        if(this.m.size == b.m.size && this.m[0].size == b.m[0].size){
            for(i in this.m.indices){
                for(j in m[0].indices){
                    b.m[i][j]=this.m[i][j]
                }
            }
            return b
        }else {
            return null
        }
    }
    infix fun mul (b:Mat):Mat?{
        if(this.m[0].size == b.m.size){
            for(i in this.m.indices){
                for(j in m[0].indices){
                    var sum=0
                    for(k in 0 until b.m.size){
                        sum+=this.m[i][k]*b.m[k][j]
                    }
                    print(sum)
                }
                println()
            }
            return this

        }else {
            return null
        }
    }
    override fun toString(): String {
        var str:StringBuilder=StringBuilder()
        for(i in m){
            for(j in i){
                str.append(j)
                str.append(' ')
            }
            str.append('\n')
        }
        return str.toString()
    }


}
fun main(){
    val a = arrayOf(
        arrayOf(1,2,3),
        arrayOf(4,5,6),
    )
    val b = arrayOf(
        arrayOf(1,1,1),
        arrayOf(1,1,1),
        arrayOf(1,1,1)
    )
    val x=Mat(a) mul Mat(b)

}