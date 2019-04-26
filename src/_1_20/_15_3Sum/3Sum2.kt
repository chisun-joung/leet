package _1_20._15_3Sum2

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val resultList = mutableListOf<List<Int>>()
        for(i in 0 .. nums.size-3) {
            val first = nums[i]
            if(first > 0) { break }
            for(j in i+1 .. nums.size-2) {
                val second = nums[j]
                for(k in nums.size-1 downTo j+1) {
                    val third = nums[k]
                    val sum = first + second + third
                    if(sum == 0) {
                        var oneResult: MutableList<Int> = mutableListOf(first, second, third)
                        if(!resultList.contains(oneResult)) {
                            resultList.add(oneResult)
                        }
                        break
                    }
                    else if(sum < 0) {
                        break
                    }
                }
            }
        }
        return resultList
    }

}