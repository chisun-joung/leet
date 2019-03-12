package prob25

//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
//k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
//Example:
//
//Given this linked list: 1->2->3->4->5
//
//For k = 2, you should return: 2->1->4->3->5
//
//For k = 3, you should return: 3->2->1->4->5
//
//Note:
//
//Only constant extra memory is allowed.
//You may not alter the values in the list's nodes, only nodes itself may be changed.


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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        return null
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

fun reverseNode(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    if (head.next == null || k == 1) return head
    var prev:ListNode? = ListNode(0)
    var tail:ListNode? = ListNode(0)
    var cur = head
    var post = head
    while (cur != null) {
        var keepGoing = true
        post = cur
        for(i in k downTo 1){
            post = post?.next
            if (post == null && i > 1) {
                keepGoing = false
                break
            }
        }
        tail?.next = cur
        if (keepGoing) {
            for (i in k downTo 1) {
                var next = cur?.next
                cur?.next = prev?.next
                prev?.next = cur
                cur = next
            }
        } else{
            break
        }

    }
    return prev?.next
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
    val list = ListNode(1)
    list.add(ListNode(2))
    list.add(ListNode(3))
    list.add(ListNode(4))

    printNode(reverseNode(list,2))
}