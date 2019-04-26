package prob34

import org.junit.Test
import kotlin.test.assertEquals


/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]*/


class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var start_index = -1
        var end_index = -1
        if (nums.isEmpty()) return intArrayOf(start_index,end_index)

        for( i in 0 .. nums.size/2){
            if (nums[i] > target && start_index == -1) {
                return intArrayOf(start_index, end_index)
            }

            if (nums[i] == target && start_index == -1) {
                start_index = i
            }
            if (nums[i] == target)
                if (end_index < i)
                    end_index = i
        }

        for( i in (nums.size-1) downTo nums.size/2) {
            if (nums[i] < target && end_index == -1) {
                return intArrayOf(start_index, end_index)
            }

            if (nums[i] == target) {
                if (end_index < i)
                    end_index = i
            }
            if (nums[i] == target)
                if(start_index == -1 || start_index > i )
                    start_index = i
        }


        if (nums.size == 1 && nums[0] == target) return intArrayOf(0,0)
        if (start_index == -1 && end_index != -1) return intArrayOf(end_index , end_index)
        if (start_index != -1 && end_index == -1) return intArrayOf(start_index,start_index)

        return return intArrayOf(start_index,end_index)
    }
}



class Tests {
    @Test fun test0() {
       val result = Solution().searchRange(intArrayOf(1,2,2,3,4,4,4),4)
        for( i in 0 until result.size) {
            print("${result[i]} ,")
        }
    }
}