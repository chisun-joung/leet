package _21_40._30_SubstringwithConcatenationofAllWords2

import org.junit.Test
import kotlin.test.assertEquals

/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
s = "barfoothefoobarman",
words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
s = "wordgoodgoodgoodbestword",
words = ["word","good","best","word"]
Output: []*/



class Solution {
    var items = hashMapOf<String,Int?>()
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = mutableListOf<Int>()
        if (s.isEmpty() || words.isEmpty()) return result
        val wlength = words.size
        val word_length = words[0].length
        val total_length = word_length*wlength
        val slength = s.length
        for (item in words){
            if (items.containsKey(item))
                items[item] = items[item]?.inc()
            else
                items[item] = 1
        }
        var i = 0
        while (i < (slength-total_length+1)){
            val substring = s.substring(i,i+total_length)
            if (match(substring, words, total_length, word_length)){
                result.add(i)
            }
            i++
        }
        return result
    }

    private fun match(substring:String, words: Array<String>,total_length:Int, word_length:Int):Boolean {

        val t_item = items.clone() as HashMap<String,Int?>

        var index = 0
        while (index < total_length - word_length + 1) {
            val cs = substring.substring(index, index+word_length)
            if (t_item.containsKey(cs)) {
                if (t_item[cs]!! > 1){
                    t_item[cs] = t_item[cs]?.dec()
                }
                else
                    t_item.remove(cs)
            }
            else{
                return false
            }
            index += word_length
        }

        return t_item.isEmpty()
    }




}


class Tests {
    @Test fun test1(){
        assertEquals(listOf(8),
            Solution().findSubstring("wordgoodgoodgoodbestword", arrayOf("word","good","best","good")))
    }
}


//fun main(args: Array<String>) {
//    val input = arrayOf("dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb")
//    val s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel"
//
//
//    println(_1_20._6_ZigZagConversion.Solution().findSubstring(s,input))
//}