package smr.playground.arrays

class MergeSortedArrays {

    // [1,2,3.,0,0,6*]  [2,5,6.]
    // [1,2,3.,0,5*,6]  [2,5.,6]
    // [1,2,3.,3*,5,6]  [2.,5,6]
    // [1,2.,2*,3,5,6]  [2.,5,6]

    // [2,5,6.,0,0,6*]  [1,2,3.]
    // [2,5.,6,0,5*,6]  [1,2,3.]
    // [2.,5,6,3*,5,6]  [1,2,3.]
    // [2.,5,2*,3,5,6]  [1,2.,3]
    // [2.,2*,2,3,5,6]  [1.,2,3]

    fun runTests() {
        merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)
        merge(intArrayOf(0, 0, 0), 0, intArrayOf(1, 2, 3), 3)
        merge(intArrayOf(0), 0, intArrayOf(3), 1)
        merge(intArrayOf(4), 1, intArrayOf(), 0)
    }

    private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var index1 = m - 1
        var index2 = nums2.lastIndex
        var last = nums1.lastIndex
        while (last >= 0) {
            if (index1 < 0) {
                nums1[last] = nums2[index2]
                index2--
            } else if (index2 < 0) {
                nums1[last] = nums1[index1]
                index1--
            } else if (nums1[index1] > nums2[index2]) {
                nums1[last] = nums1[index1]
                index1--
            } else {
                nums1[last] = nums2[index2]
                index2--
            }
            last--
        }
        println(nums1.asList())
    }
}

fun main() {
    MergeSortedArrays().runTests()
}