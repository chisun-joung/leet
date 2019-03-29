package prob312

import org.junit.Test
import kotlin.test.assertEquals

/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class Solution {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.isEmpty()) return
        var i = nums.size - 2
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--
        }
        if(i >=0) {
            var j = nums.size - 1
            while (j >= 0 && nums[j] <= nums[i]) {
                j--
            }
            swap(nums,i,j)
        }
        reverse(nums,i+1)
    }

    fun swap(nums: IntArray,i: Int, j: Int) {
        val temp = nums[j]
        nums[j] = nums[i]
        nums[i] = temp
    }

    fun reverse(nums: IntArray, start : Int) {
        var i = start
        var j = nums.size - 1
        while (i < j){
            swap(nums, i, j)
            i++
            j--
        }
    }
}


fun main() {
    val nums = intArrayOf(1,3,2)
    Solution().nextPermutation(nums)
    nums.forEach { print("$it,") }
}