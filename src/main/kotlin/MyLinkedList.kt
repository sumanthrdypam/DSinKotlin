class MyLinkedList {
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

        fun insert(position: Int) {
            if(position==1){
                this.next=first
                first=this
                return
            }
            var tempfirst=first
            var currentPosition=1
            while(currentPosition<position-1){
                first= first?.next
                currentPosition+=1
            }
            this.next=first?.next
            first?.next=this
            first=tempfirst

        }
    }

    fun add(d: Int) {
        val n = Node(d)
        n.append()
    }

    fun printList() {
        var t: Node? = first
        while(t != null) {
            println("${t.data}")
            t = t?.next
        }
    }

    fun insert(position: Int, v: Int) {
        val n= Node(v)
        n.insert(position)

    }

    fun delete(position:  Int) {
        if(position==1){
            first=first?.next
            return
        }
        val tfirst=first
        var currPosition=1
        while(currPosition<position-1){
            first=first?.next
            currPosition+=1
        }
        first?.next=first?.next?.next
        first=tfirst

    }

    fun deleteVal(value: Int) {
        //deletes the first node with the given value
        if(first?.data  == value){
            first=first?.next
            return
        }
        val tfirst=first
        var prev=first
        first=first?.next
        while(first!=null){
            if(first?.data==value){
                prev?.next=first?.next
                break
            }else{
                prev=first
                first=first?.next
            }
        }
        first=tfirst
    }
}

fun main() {
    val list = MyLinkedList()

    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)

    //Insert the node at given position
    list.insert(5,5)
    //list.printList()

    //Delete the node from the given position
   // list.delete(6)
    //list.printList()

    //Search and delete the node
    list.deleteVal(3)
    list.printList()



}