package greedy.medium

import java.util.PriorityQueue

//@author Usman Fani

//Leetcode-1353

//Example 1:
//Input: events = [[1,2],[2,3],[3,4]]
//Output: 3
//Explanation: You can attend all the three events.
//One way to attend them all is as shown.
//Attend the first event on day 1.
//Attend the second event on day 2.
//Attend the third event on day 3.

//Example 2:
//Input: events= [[1,2],[2,3],[3,4],[1,2]]
//Output: 4
// 2 2 , 2 2 , 2 3 , 2 3, 1 10
class MaxNumberOfEvent {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortWith(compareBy({ it[0] }, { it[1] }))
        val min = events.minByOrNull { it[0] }!![0]
        val max = events.maxByOrNull { it[1] }!![1]
        var iter = 0
        var attended = 0
        val eventEndingDays = PriorityQueue<Int>()
        for (i in min..max) {
            while (eventEndingDays.isNotEmpty() && eventEndingDays.peek() < i) eventEndingDays.remove()
            while (iter < events.size && events[iter][0] == i) {
                eventEndingDays.add(events[iter++][1])
            }
            if (eventEndingDays.isNotEmpty()) {
                eventEndingDays.remove()
                attended++
            }
        }
        return attended
    }
}