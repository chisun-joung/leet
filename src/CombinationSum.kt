package combinationsum



/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
[7],
[2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
[2,2,2,2],
[2,3,3],
[3,5]
]*/


class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val list = mutableListOf<Int>()
        candidates.sort()
        fun dfs(remain: Int, from: Int){
            if (remain < 0 ) return
            if (remain == 0) {
                result.add(list.toList())
                return
            }
            for (i in from until candidates.size) {
                list.add(candidates[i])
                dfs(remain - candidates[i], i)
                list.removeAt(list.size-1)
            }

        }
        dfs(target,0)
        return result
    }
}