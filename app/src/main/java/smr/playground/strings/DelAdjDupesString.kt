package smr.playground.strings

/*
Input: azxxzy
Output: ay
First “azxxzy” is reduced to “azzy”.
The string “azzy” contains duplicates,
so it is further reduced to “ay”.
Input: geeksforgeeg
Output: gksfor
First “geeksforgeeg” is reduced to
“gksforgg”. The string “gksforgg”
contains duplicates, so it is further
reduced to “gksfor”.
Input: caaabbbaacdddd
Output: Empty String
Input: acaaabbbacdddd
Output: acac
*/
class DelAdjDupesString {

    fun test() {
//        println(removeDupes("abc"))
//        println(removeDupes("azxxzy"))
//        println(removeDupes("geeksforgeeg"))
        println(removeDupes("acaaabbbacdddd"))
    }

    private fun removeDupes(input: String): String {
        var deleted = false
        val sb = StringBuilder()
        var i = 0

        while (i < input.length - 1) {
            if (input[i] == input[i + 1]) {
                deleted = true
                i += 2
            } else {
                sb.append(input[i++])
            }
            if (i == input.length - 1) {
                sb.append(input[i])
            }
        }
        val res = sb.toString()
        return if (deleted) {
            removeDupes(res)
        } else {
            res
        }
    }
}

fun main() {
    DelAdjDupesString().test()
}