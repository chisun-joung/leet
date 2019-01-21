package leet4
//
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//You may assume nums1 and nums2 cannot be both empty.
//
//Example 1:
//
//nums1 = [1, 3]
//nums2 = [2]
//
//The median is 2.0
//Example 2:
//
//nums1 = [1, 2]
//nums2 = [3, 4]
//
//The median is (2 + 3)/2 = 2.5

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val size_nums1 = nums1.size
        val size_nums2 = nums2.size
        val size_total = size_nums1 + size_nums2
        var i = 0
        var j = 0
        val isEvenSize = size_total%2 == 0
        val medianIndex : Int = size_total/2
        var medianValue :Double = 0.0
        var premedianValue1 = 0
        var premedianValue2 = 0
        while( (i + j) <= medianIndex){



            if (isEvenSize) premedianValue2 = premedianValue1

            if ( i == size_nums1 ) {
                premedianValue1 = nums2[j]
                j++
                continue
            }

            if ( j == size_nums2 ) {
                premedianValue1 = nums1[i]
                i++
                continue
            }

            if ( nums1[i] < nums2[j]){
                premedianValue1 = nums1[i]
                i++
            } else {
                premedianValue1 = nums2[j]
                j++
            }
        }
        medianValue = if (isEvenSize)
            (premedianValue1 + premedianValue2)/2.0
        else
            premedianValue1.toDouble()
        return medianValue
    }
}

fun main(args: Array<String>) {
    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(3, 4)
    println(Solution().findMedianSortedArrays(nums1, nums2))
}