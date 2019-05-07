package _41_60.firstmissingpositive

/*

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1*/

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        for(i in 0 until n){
            if(nums[i] <=0 || nums[i] > n){
                nums[i] = n + 1
            }
        }

        for (i in 0 until n) {
            var num = Math.abs(nums[i])
            if(num > n){
                continue
            }
            num--
            if(nums[num] > 0){
                nums[num] = -1 * nums[num]
            }
        }

        for (i in 0 until n) {
            if (nums[i] >= 0) {
                return i + 1
            }
        }

        return n + 1
    }
}