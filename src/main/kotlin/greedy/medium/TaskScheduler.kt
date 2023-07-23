package greedy.medium

//@author Usman Fani

//Leetcode-621

//Example 1:
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation:
//A -> B -> idle -> A -> B -> idle -> A -> B
//There is at least 2 units of time between any two same tasks.

//Example 2:
//Input: tasks = ["A","A","A","B","B","B"], n = 0
//Output: 6
//Explanation: On this case any permutation of size 6 would work since n = 0.
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//And so on.

//Example 3:
//Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//Output: 16
//Explanation:
//One possible solution is
//A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
class TaskScheduler {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val taskMap = IntArray(26)
        var max = 0                             //max of frequency of tasks
        tasks.forEach {
            taskMap[it - 'A']++
            if (taskMap[it - 'A'] > max) max = taskMap[it - 'A']
        }
        var maxF = 0                          //no. of max freq tasks
        taskMap.forEach {
            if (max == it) maxF++
        }

        val result = (max - 1) * (n + 1) + maxF   //slot = (max-1)

        return maxOf(result, tasks.size)
    }
}