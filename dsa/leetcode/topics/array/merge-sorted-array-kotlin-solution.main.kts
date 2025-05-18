#!/usr/bin/env kotlin

// Runtime 6 ms Beats 23.07%
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
        val lastIndexValidNums1 = m - 1
        val lastIndexValidNums2 = n
        var startInvalidIndexNums1 = lastIndexValidNums1 + 1

        for (index in nums2.indices) {
            if (index <= lastIndexValidNums2) {
                val indexValue = nums2[index]
                nums1.set(startInvalidIndexNums1, indexValue)
                startInvalidIndexNums1 ++
            }
        }

        for (pass in nums1.indices) {
            val missingSteps = nums1.size - pass
            for (currentIndex in 0 until missingSteps) {
                if (currentIndex + 1 < nums1.size) {
                    val currentIndexValue = nums1[currentIndex]
                    val nextIndexValue = nums1[currentIndex + 1]
                    if (currentIndexValue > nextIndexValue) {
                        nums1[currentIndex] = nextIndexValue
                        nums1[currentIndex + 1] = currentIndexValue
                    }
                }
            }
        }

        return nums1
    }
}

data class InputExample(
    val nums1: IntArray,
    val nums1ValidValues: Int,
    val nums2: IntArray,
    val nums2ValidValues: Int,
)

fun main() {

    val input1 = InputExample(
        nums1 = intArrayOf(1, 2, 3, 0, 0, 0),
        nums1ValidValues = 3,
        nums2 = intArrayOf(2, 5, 6),
        nums2ValidValues = 2
    ) // expected output = [1,2,2,3,5,6]
    val input2 = InputExample(
        nums1 = intArrayOf(1),
        nums1ValidValues = 1,
        nums2 = intArrayOf(),
        nums2ValidValues = 0,
    ) // expect output = [1]
    val input3 = InputExample(
        nums1 = intArrayOf(0),
        nums1ValidValues = 0,
        nums2 = intArrayOf(1),
        nums2ValidValues = 1,
    ) // expected output = [1]
    val input4 = InputExample(
        nums1 = intArrayOf(4,5,6,0,0,0),
        nums1ValidValues = 3,
        nums2 = intArrayOf(1,2,3),
        nums2ValidValues = 3,
    )
    val input5 = InputExample(
        nums1 = intArrayOf(-1,0,0,3,3,3,0,0,0),
        nums1ValidValues = 6,
        nums2 = intArrayOf(1,2,2),
        nums2ValidValues = 3,
    ) // expected output [-1,0,0,1,2,2,3,3,3]



    val inputs = listOf(
        input1,
        input2,
        input3,
        input4,
        input5
    )

    val solutionClass = Solution()

    inputs.forEach { inputExample ->
        val solution = solutionClass.merge(
            inputExample.nums1,
            inputExample.nums1ValidValues,
            inputExample.nums2,
            inputExample.nums2ValidValues,
        ).contentToString()

        println(solution)
    }
}

main()