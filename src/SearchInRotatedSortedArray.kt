package prob33

import org.junit.Test
import kotlin.test.assertEquals

/*

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/


class Solution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        if (nums[0] > target) {
            for (i in (nums.size-1) downTo 0){
                if (nums[i] == target) {
                    return i
                }
                if (nums[i] < target){
                    return -1
                }
            }
        } else {
            for (i in 0 until nums.size){
                if (nums[i] == target) return i
                if (nums[i] > target) return -1
            }
        }

        return -1
    }
}

class Tests {
    @Test fun test1() {
        assertEquals(4, Solution().search(intArrayOf(4,5,6,7,0,1,2),0))
    }
}