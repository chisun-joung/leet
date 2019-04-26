package prob16

import org.junit.Test
import kotlin.math.abs
import kotlin.test.assertEquals

//Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//Example:
//
//Given array nums = [-1, 2, 1, -4], and target = 1.
//
//The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


class Solution {
    var result = 0
    var diff = Int.MAX_VALUE
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size < 3) { return result}
        nums.sort()
        for (i in 0..nums.size-3){
            val first = nums[i]
            var left = i+1
            var right = nums.size-1
            twoSumHelper(nums, left, right,first, target)
            if(diff == 0) break
        }
        return result
    }

    fun twoSumHelper(nums: IntArray, left :Int, right: Int,first: Int, target : Int)  {
        var tleft = left
        var tright = right

        while (tleft < tright) {
            val sum = first + nums[tleft] + nums[tright]
            if ( sum == target) {
                result = target
                diff = 0
                return
            }else if (sum < target){
                val temp  = abs(sum - target)
                if ( temp < diff ) {
                    diff = temp
                    result = sum
                }
                tleft++

            }else if (sum  > target){
                val temp = abs(sum - target)
                if (temp < diff) {
                    diff = temp
                    result = sum
                }
                tright--
            }
        }
    }
}


class Tests {
    @Test fun Test_1 () {
        assertEquals(2,Solution().threeSumClosest(intArrayOf(-1,2,1,-4),1))
    }

    @Test fun Test_2 () {
        assertEquals(2,Solution().threeSumClosest(intArrayOf(1,1,1,0),-100))
    }

    @Test fun Test_3 () {
        assertEquals(-1,Solution().threeSumClosest(intArrayOf(4,-1,-4,4),-1))
    }

    @Test fun Test_4 () {
        assertEquals(3,Solution().threeSumClosest(intArrayOf(1,1,-1,-1,3),3))
    }
}