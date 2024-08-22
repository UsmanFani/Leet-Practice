package Dfs.medium

import java.util.Stack

//@author Usman Fani

//Leetcode: 210

//Example 1:
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

//Example 2:
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

//Example 3:
//Input: numCourses = 1, prerequisites = []
//Output: [0]
class CourseSchedule2 {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val preMap = mutableMapOf<Int, MutableList<Int>>()
        prerequisites.forEach { (a, b) ->
            if (preMap.containsKey(a)) preMap[a]!!.add(b)
            else preMap[a] = mutableListOf(b)
        }

        val cycle = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()
        val result = mutableListOf<Int>()

        fun dfs(course: Int): Boolean {
            if (course in cycle) return true
            if (course in visited) return false

            cycle += course
            if (preMap.containsKey(course)) {
                preMap[course]!!.forEach {
                    if (dfs(it)) return true
                }
            }
        cycle -= course

        visited += course
        result.add(course)
        return false
    }

    repeat(numCourses)
    {
        if (dfs(it)) return intArrayOf()
    }

    return result.toIntArray()
}

}