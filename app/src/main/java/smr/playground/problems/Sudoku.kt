package smr.playground.problems


fun main() {
    val input: Array<CharArray> = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('2', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9'),
    )
    print(isValidSudoku(input))
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val set = mutableSetOf<String>()
    for (i in 0..8) {
        for (j in 0..8) {
            val c = board[i][j]
            if (c != '.') {
                if (!set.add("$c:r:$i")
                    || !set.add("$c:c:$j")
                    || !set.add("$c:g:&${i / 3}x${j / 3}")
                ) {
                    return false
                }
            }
        }
    }
    return true
}

class ListNode(var `val`: Int) {
        var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head?.next
    while(fast?.next != null){
        if(slow?.`val`==fast.`val`) return true
        slow = slow?.next
        fast = fast.next?.next
    }
    return false
}