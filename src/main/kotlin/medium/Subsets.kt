package medium

class Subsets {
    //Example 1:
    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

    //Example 2:
    //Input: nums = [0]
    //Output: [[],[0]]
    fun subsets(nums: IntArray): List<List<Int>> {
        val sub = mutableListOf<List<Int>>()
        sub.add(listOf( ))
        for (i in nums) {
            val last = sub.lastIndex
            sub.add(listOf(i))
            for (j in 1 .. last) {
                val list = mutableListOf<Int>()
                for (k in 0 .. sub[j].lastIndex) {
                    list.add(sub[j][k])
                }
                list.add(i)
                sub.add(list)
            }
        }
        return sub
    }

    fun dfsSubsets(nums:IntArray):List<List<Int>>{
        var ans = mutableListOf<List<Int>>()
        fun dfs(i:Int,cur:ArrayList<Int>){
           ans.add(ArrayList(cur))
            if(i==nums.size) return
            for(j in i until nums.size){
                cur.add(nums[j])
                dfs(j+1,cur)
                cur.removeAt(cur.lastIndex)
            }
        }
        dfs(0,ArrayList())
        return ans
    }
}