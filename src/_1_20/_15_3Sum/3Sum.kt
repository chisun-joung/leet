package _1_20._15_3Sum
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//The solution set must not contain duplicate triplets.
//
//Example:
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//[-1, 0, 1],
//[-1, -1, 2]
//]



class Solution {

    var intlistoflist_result = mutableListOf<List<Int>>()
    var tempnums : IntArray = intArrayOf()

    fun threeSum(nums: IntArray): List<List<Int>> {
        tempnums = nums.clone()
        Combinations(3,nums.size)

        return intlistoflist_result
    }

    inner class Combinations(val m: Int, val n: Int) {
        private val combination = IntArray(m)
        init {
            generate(0)
        }

        private tailrec fun generate(k: Int) {
            if (k>=m){
                 if(tempnums[combination[0]]+tempnums[combination[1]]+tempnums[combination[2]] == 0){
                     val list = listOf(tempnums[combination[0]],tempnums[combination[1]],tempnums[combination[2]]).sorted()
                     if (!intlistoflist_result.contains(list)) intlistoflist_result.add(list)
                 }

            } else {
                for (j in 0 until n)
                    if (k == 0 || j > combination[k -1]) {
                        combination[k] = j
                        generate(k + 1)
                    }
            }
        }
    }

}



fun main(args: Array<String>){
    Solution().Combinations(3,1000)
}