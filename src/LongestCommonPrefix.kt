package prob14

import org.junit.Test
import kotlin.test.assertEquals

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var count = 0
        var result = ""
        if (strs.size==0) return result
        for(i in 0..(strs[0].length-1)){
            val c = strs[0][i]
            var go = true
            for (j in 1..(strs.size-1)){
                if (i > (strs[j].length-1) || c != strs[j][i]) {
                    go = false
                    break
                }
            }
            if(go) count++ else break
        }

        if (count > 0) result = strs[0].slice(0..(count-1))

        return result
    }
}

class Tests{
    @Test fun Test1(){
        assertEquals("", Solution().longestCommonPrefix(arrayOf("dog","racecar","car")))
    }

    @Test fun Test2(){
        assertEquals("fl", Solution().longestCommonPrefix(arrayOf("flower","flow","flight")))
    }

}