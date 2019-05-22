package _41_60._42_TrappingRainWater

import kotlin.math.max
import kotlin.math.min


/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/


class Solution {
    fun trap(height: IntArray): Int {
        var ans = 0
        val size = height.size
        for( i in 1 until size-1){
            var max_left = 0
            var max_right = 0
            for( j in i downTo 0) {
                max_left = max(max_left, height[j])
            }
            for( j in i until size) {
                max_right = max(max_right,height[j])
            }
            ans += min(max_left, max_right) - height[i]
        }
        return ans
    }
}

fun main() {
    val height = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    println(Solution().trap(height))
}