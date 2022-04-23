package smr.playground.arrays

// TODO: unsolved
class RotateArray {

//    [0,1,2] - 0,3,6
//    [2,0,1] - 1,4,7
//    [1,2,0] - 2,5,8

//    [0,1,2,3] - 0,4,8
//    [3,0,1,2] - 1
//    [2,3,0,1] - 2
//    [1,2,3,0] - 3

//    [0,1,2,3,4,5,6] - 0
//    [6,0,1,2,3,4,5] - 1
//    [5,6,0,1,2,3,4] - 2
//    [4,5,6,0,1,2,3] - 3

    fun test() {
        rotate(intArrayOf(0, 1, 2, 3, 4, 5, 6), 1)
        rotate(intArrayOf(0, 1, 2, 3, 4, 5, 6), 2)
        rotate(intArrayOf(0, 1, 2, 3, 4, 5, 6), 3)
    }

    private fun rotate(nums: IntArray, k: Int) {
        val list = ArrayList<Int>()
        for (i in nums.lastIndex downTo k) {
            list.add(nums[i])
            nums[i] = nums[i - k]
        }
        //println("list: " + list)
        for (i in 0 until k) {
            nums[i] = list[k - i]
        }
        println(nums.toList())
    }
}

fun main() {
    RotateArray().test()
}