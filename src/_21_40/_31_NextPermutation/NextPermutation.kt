package _21_40._31_NextPermutation

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
        for (i in (nums.size-1) downTo 1) {
            for (j in (i-1) downTo 0) {
                if (nums[i] > nums[j]) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                    return
                }
            }
        }
        nums.reverse()
    }
}


fun main() {
    val nums = intArrayOf(1,3,2)
    Solution().nextPermutation(nums)
    nums.forEach { print("$it,") }
}