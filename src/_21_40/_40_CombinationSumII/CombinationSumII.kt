package _21_40._40_CombinationSumII
/*

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
[1, 7],
[1, 2, 5],
[2, 6],
[1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
[1,2,2],
[5]
]*/

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val list = mutableListOf<Int>()
        candidates.sort()
        fun dfs(remain:Int,from: Int){
            if (remain < 0) return
            if (remain == 0) {
                if (!result.contains(list))
                    result.add(list.toList())
                return
            }
            for (i in from until candidates.size){
                list.add(candidates[i])
                dfs(remain - candidates[i], i + 1)
                list.removeAt(list.size - 1)
            }

        }
        dfs(target, 0)
        return result
    }
}

fun main() {
    val can = intArrayOf(10,1,2,7,6,1,5)
    val result = Solution().combinationSum2(can,8)
    for (i in result)
        println(i)
}