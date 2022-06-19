package smr.playground.arrays

/**
 * https://leetcode.com/problems/majority-element/
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 * */
class MajorityElement {

    // Time: O(N), Space: O(N)
    fun majorityElement(nums: IntArray): Int? {
        val majority = nums.size/2
        val map = mutableMapOf<Int,Int>()
        for(num in nums) {
            val count = map[num]?.plus(1) ?: 1
            if(count >= majority) {
                return num
            } else {
                map[num] = count
            }
        }
        return null
    }

    // Time: O(N), Space: O(1)
    fun majorityElement2(nums: IntArray): Int? {
        val majority = nums.size/2
        var count = 1
        var major : Int? = nums[0]
        for (i in 1 until nums.size) {
            val current  = nums[i]
            if(count==0) major = current
            if(current == major) {
                count++
            } else {
                count--
            }
            if(count>majority) return major
            if(count==0) major = null
        }
        return null
    }

    // TODO find all elements having > n/3 count

}