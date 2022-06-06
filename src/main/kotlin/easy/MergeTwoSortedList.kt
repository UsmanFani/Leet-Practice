package easy

class MergeTwoSortedList {
    class ListNode(var `val`: Int) {

        var next: ListNode? = null

        override fun toString(): String {
            if (next == null) return `val`.toString()
            return "${`val`} -> ${next.toString()} "
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        var head = ListNode(0)
        var tail = head
        if (l1 == null) return l2
        if (l2 == null) return l1
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                tail?.next = l1
                l1 = l1.next
            } else {
                tail?.next = l2
                l2 = l2.next
            }
            tail = tail?.next!!
        }
        if (l1 == null) {
            tail?.next = l2
            l2 = l2?.next
        }
        else{
            tail.next = l1
            l1 = l1?.next
        }

        if (head.next == null) return head
        return head.next
    }


}