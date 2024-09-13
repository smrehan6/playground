package smr.playground.problems

import java.util.Stack

class StringEncodeDecode {
    // "a3[b2[c]]"
    fun sss() {
        val arr = mutableListOf(1, 2, 3, 4)
        arr.filterIndexed { index, _ -> index == 1 }
        arr.lastIndex
        val res = StringBuilder()
        val countStack = Stack<Int>()
        val strStack = Stack<String>()
        val str = "abc12[AB4[xyz]]"
        val list = mutableListOf(1,2,3,4,4)
        list.sum()
        var num = 0
        var sb = StringBuilder()
        for (ch in str) {
            when {
                ch.isDigit() -> {
                    num = num * 10 + ch.toInt()
                }

                ch == '[' -> {
                    countStack.push(num)
                    num = 0
                    if (sb.isNotEmpty()) {
                        strStack.push(sb.toString())
                    }
                    sb.clear()
                }

                ch == ']' -> {
                    // make string
                    var count = countStack.pop()
                    var ss = sb.toString().repeat(count)

                    if (strStack.isNotEmpty()) {

                    }
                    res.append(ss)
                }

                ch.isLetter() -> {
                    if (countStack.size > 0) {
                        sb.append(ch)
                    } else {
                        res.append(ch)
                    }
                }
            }
        }
    }
}

