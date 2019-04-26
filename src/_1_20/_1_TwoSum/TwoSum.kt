package twosum

class Solution {
    fun twoSum(nums: IntArray, target: Int) : IntArray {
        for ( i in 0..(nums.size-2)) {
            for (j in (i+1)..(nums.size-1)) {
                if (nums[i]+nums[j] == target)
                    return intArrayOf(i,j)
            }
        }

        return IntArray(0)
    }

    fun twoSum2(nums: IntArray, target: Int) : IntArray {
        val map = mutableMapOf<Int, Int>()
        for( i in 0..(nums.size-1) ) {
            val num = nums[i]
            val index = map[num]
            if( index !== null) {
                return intArrayOf(index , i)
            } else {
                map.put(target-num,i)
            }
        }

        return IntArray(0)
    }

    fun twoSum3(nums: IntArray, target: Int) : IntArray {
        for( (i,v) in nums.withIndex()) {
            val m = target - v
            val index = nums.indexOf(m)
            if (index != -1 && index != i ) {
                return intArrayOf(i,index)
            }
        }
        return IntArray(0)
    }
}


fun main(args: Array<String>) {
    val nums = intArrayOf(2,5,4,5,100)
    val sol = Solution().twoSum3(nums,6)
    for(value in sol)
    {
        print("$value ")
    }
}