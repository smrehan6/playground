package smr.playground.strings

import kotlin.math.max
import kotlin.math.min

class AddStrings {

    fun test() {
        println(addStrings("99", "99"))
        println(addStrings("0", "1"))
        println(addStrings("10", "1"))
    }

    private fun addStrings(num1: String, num2: String): String {
        var str1 = num1
        var str2 = num2
        val len1 = num1.length
        val len2 = num2.length
        if (len1 != len2) {
            val diff = max(len1, len2) - min(len1, len2)
            if (len1 > len2) {
                str2 = addLeadingZeros(num2, diff)
            } else {
                str1 = addLeadingZeros(num1, diff)
            }
        }
        val chars = CharArray(str1.length)
        var carry = 0
        for (i in str1.lastIndex downTo 0) {
            val ch1 = Integer.valueOf(str1[i] + "")
            val ch2 = Integer.valueOf(str2[i] + "")
            val sum = ch1 + ch2 + carry
            carry = if (sum > 9) 1 else 0
            chars[i] = sum.toString().toCharArray().last()
        }
        return if (carry > 0) {
            "1${String(chars)}"
        } else
            String(chars)
    }

    private fun addLeadingZeros(str: String, count: Int): String {
        val sb = StringBuilder()
        for (i in 1..count) sb.append('0')
        return sb.append(str).toString()
    }
}

fun main() {
    AddStrings().test()
}