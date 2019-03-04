package prob19

//Given a linked list, remove the n-th node from the end of list and return its head.
//
//Example:
//
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//
//Given n will always be valid.
//


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var current = head
        var nth = current
        var result : ListNode?
        var remain = n
        while (current != null){
            current = current.next
            if(remain==0){
                nth = nth?.next
            } else if ( remain > 0){
                remain--
            }
        }
        current = head
        result = current
        while(current != null){
            if(current == nth){
                current = nth.next
            }else{
                current = current.next
            }

        }


        return result
    }
}
fun printNode(head : ListNode?) : Unit {
    var v = head
    while ( v != null){
        print(" ${v.`val`}->")
        v = v.next
    }
    println()

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    fun add(node: ListNode): Unit {
        var temp = this@ListNode
        while (temp.next !=null )
        {
            temp = temp.next as ListNode
        }
        temp.next = node
    }
}

fun main() {
    var head = ListNode(1)
    head.add(ListNode(2))
    head.add(ListNode(3))
    head.add(ListNode(4))
    head.add(ListNode(5))
    printNode(Solution().removeNthFromEnd(head,2))
}