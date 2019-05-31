package _41_60._46_Permutations
/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
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
                    perms.add(newPerm)
                }
            }
            return perms
        }
        return go(nums.toList())
    }
}

fun main() {
    val input = intArrayOf(1,2,3)
    val perms = Solution().permute(input)
    for (perm in perms) println(perm)
}