package _41_60._47_PermutationsII
/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]*/


class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        fun go(input: List<Int>): List<List<Int>>{
            if (input.size == 1) return listOf(input)
            val perms = mutableListOf<List<Int>>()
            val toInsert = input[0]
            for (perm in go(input.drop(1))) {
                for (i in 0..perm.size) {
                    val newPerm = perm.toMutableList()
                    newPerm.add(i, toInsert)
                    if(!perms.contains(newPerm)) {
                        perms.add(newPerm)
                    }

                }
            }
            return perms
        }
        return go(nums.toList())
    }
}

fun main() {
    val input = intArrayOf(1,1,2)
    val perms = Solution().permute(input)
    for (perm in perms) println(perm)
}