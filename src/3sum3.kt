package prob152

class Solution {
    var result = mutableListOf<List<Int>>()
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) { return result}
        nums.sort()
        for (i in 0..nums.size-3){
            if(i>0 && nums[i] == nums[i-1]) {
                continue
            }
            val target = nums[i]
            var left = i+1
            var right = nums.size-1
            twoSumHelper(nums, left, right, target)
        }
        return result
    }

    fun twoSumHelper(nums: IntArray, left :Int, right: Int, target : Int) {
        var tleft = left
        var tright = right

        while (tleft < tright) {
            if (target + nums[tleft] + nums[tright] == 0) {
                val triples = listOf(target , nums[tleft] , nums[tright])
                result.add(triples)
                tleft++
                tright--
                while(tleft<tright && nums[tleft] == nums[tleft - 1]) {
                    tleft++
                }
                while(tleft<tright && nums[tright] == nums[tright + 1]) {
                    tright--
                }

            }else if (target + nums[tleft] + nums[tright] < 0){
                tleft++
            }else if (target + nums[tleft] + nums[tright] > 0){
                tright++
            }
        }
    }
}