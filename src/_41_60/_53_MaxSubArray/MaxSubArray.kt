package _41_60._53_MaxSubArray

import org.junit.Test
import kotlin.math.max
import kotlin.test.assertEquals

/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

*/

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var subSumMax = nums[0]
        var sumMax = nums[0]
        for (i in 1 until nums.size){
            subSumMax = nums[i] + max(subSumMax,0)
            sumMax =  max(subSumMax, sumMax)
        }
        return sumMax
    }
}

class Tests{
    @Test fun test1(){
        val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
        assertEquals(6, Solution().maxSubArray(nums))
    }
}