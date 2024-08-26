class Matrix(val mat : Array<Array<Int>>) {
    infix fun sum(mat2: Matrix): Matrix?{
        if(this.mat.size!= mat2.mat.size || this.mat[0].size != mat2.mat[0].size) return null
        var sum = Array<Array<Int>>(mat.size){
            Array<Int>(mat[0].size){0}
        }
        for(i in mat.indices){
            for(j in mat[i].indices){
                sum[i][j]=this.mat[i][j]+mat2.mat[i][j]
            }
        }

        return Matrix(sum)
    }

    infix fun multiply(mat2: Matrix): Matrix? {
        if (this.mat[0].size != mat2.mat.size) return null
        val result = Array(this.mat.size) { Array(mat2.mat[0].size) { 0 } }

        for (i in this.mat.indices) {
            for (j in mat2.mat[0].indices) {
                for (k in this.mat[0].indices) {
                    result[i][j] += this.mat[i][k] * mat2.mat[k][j]
                }
            }
        }

        return Matrix(result)
    }

    override fun toString(): String {
        var str:StringBuilder=StringBuilder()
        for(i in mat){
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
    var mat1=Matrix(arrayOf(
        arrayOf(1,2,3),
        arrayOf(4,5,6),
        arrayOf(7,8,9)
    ))

    var sumis = mat1 sum Matrix(arrayOf(
        arrayOf(1,1,1),
        arrayOf(1,1,1),
        arrayOf(1,1,1)
    ))

    if(sumis !=null){
        for(i in sumis.mat){
            for(j in i){
                print("$j ")
            }
            println()
        }
    }
    var mulis = mat1 multiply  Matrix(arrayOf(
        arrayOf(1,1,1),
        arrayOf(1,1,1),
        arrayOf(1,1,1)
    ))

    if(mulis !=null){
        for(i in mulis.mat){
            for(j in i){
                print("$j ")
            }
            println()
        }
    }
}