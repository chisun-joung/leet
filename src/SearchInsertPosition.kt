package prob35

import org.junit.Test
import kotlin.test.assertEquals

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0*/



class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        if (nums[nums.size-1] < target) return nums.size
        for ( i in 0 until nums.size) {
            if(nums[i] >= target)
                return i
        }
        return 0
    }
}



class  Tests {
    @Test fun test1() {
        assertEquals(2, Solution().searchInsert(intArrayOf(1,3,5,6),5))
    }

    @Test fun test2() {
        assertEquals(1, Solution().searchInsert(intArrayOf(1,3,5,6),2))
    }

    @Test fun test3() {
        assertEquals(4, Solution().searchInsert(intArrayOf(1,3,5,6),7))
    }

    @Test fun test4() {
        assertEquals(0, Solution().searchInsert(intArrayOf(1,3,5,6),0))
    }
}
