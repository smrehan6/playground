package smr.playground.stack
// https://leetcode.com/problems/min-stack/
class MinStack {
    var head : Node? = null

    fun push(value: Int) {
        val min = head?.let {
            if (it.min <value) it.min
            else value
        } ?: value
        head = Node(value, min, head)
    }

    class Node(val value:Int, val min:Int,var next:Node? = null)

    fun pop() {
        head = head!!.next
    }

    fun top(): Int {
        return head!!.value
    }

    fun getMin(): Int {
        return head!!.min
    }
}