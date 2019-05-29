package _41_60._45_JumpGameII

import org.junit.Test
import kotlin.test.assertEquals

/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.*/

class Solution {
    fun jump(nums: IntArray): Int {

        val memoized = arrayOfNulls<Int>(nums.size)
        fun go(index : Int): Int {
            if (index > nums.size - 1)
                return nums.size
            if (memoized[index] != null) return memoized[index] as Int

            if (index == nums.size - 1)
                return 0

            var minValue = nums.size - 1
            for (i in nums[index] downTo 1) {
                val value = go(index + i) + 1
                if (minValue > value)
                    minValue = value
            }
            memoized[index] = minValue
            return minValue
        }
        return go(0)
    }

// no1 try
//            if(jump >= jumpCount) return
//            if(index == nums.size-1){
//                return 0JumpGameII.kt
//                if (jump < jumpCount) {
//                    jumpCount = jump
//                }
//                return
//            } else if ( index >= nums.size) {
//                return
//            }
//
//            for (i in nums[index] downTo 1){
//                go(index+i,jump + 1)
//            }


        //return jumpCount

}

class Tests {
    @Test fun jump1() {
        assertEquals(2,Solution().jump(intArrayOf(2,3,1,1,4)))
    }

    @Test fun jump2() {
        assertEquals(13,Solution().jump(intArrayOf(8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5)))
    }

    @Test fun jump3() {
        assertEquals(16,Solution().jump(intArrayOf(5,8,1,8,9,8,7,1,7,5,8,6,5,4,7,3,9,9,0,6,6,3,4,8,0,5,8,9,5,3,7,2,1,8,2,3,8,9,4,7,6,2,5,2,8,2,7,9,3,7,6,9,2,0,8,2,7,8,4,4,1,1,6,4,1,0,7,2,0,3,9,8,7,7,0,6,9,9,7,3,6,3,4,8,6,4,3,3,2,7,8,5,8,6,0)))
    }
}

