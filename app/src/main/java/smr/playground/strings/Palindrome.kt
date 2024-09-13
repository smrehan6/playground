package smr.playground.strings

class Palindrome {
    fun isPalindrome(s: String): Boolean {
        val sb = StringBuilder()
        for(ch in s) {
            when {
                ch.isLetter() -> sb.append(ch.lowercase())
                ch.isDigit() -> sb.append(ch)
            }
        }
        return sb.toString() == sb.toString().reversed()
    }
}