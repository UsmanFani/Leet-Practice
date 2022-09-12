package Arrays.hard

//Input
//["RandomizedCollection", "insert", "insert", "insert", "getRandom", "remove", "getRandom"]
//[[], [1], [1], [2], [], [1], []]
//Output
//[null, true, false, true, 2, true, 1]

// Insert Delete GetRandom O(1) - Duplicates allowed
class RandomizedCollection {
    private var map = mutableMapOf<Int, HashSet<Int>>()
    private var list = mutableListOf<Int>()
    fun insert(`val`: Int): Boolean {

        if (map.containsKey(`val`)) {
            list.add(`val`)
            map[`val`]?.add(list.lastIndex)
            return false
        }
        list.add(`val`)
        map[`val`] = hashSetOf(list.lastIndex)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (map.containsKey(`val`)) {
            //last index of this value in map
            val index = map[`val`]!!.iterator().next()
            if(index==list.lastIndex){
                list.removeAt(index)
                if(map[`val`]!!.size==1) map.remove(`val`)
                else map[`val`]!!.remove(index)
                return true
            }
            //removed given value index from hashset
            if(map[`val`]!!.size==1) map.remove(`val`)
            else map[`val`]!!.remove(index)

            val listLastIndex = list.lastIndex
            var lastListValue = list[listLastIndex]
            //put the lastvalue at removed value
            list[index] = lastListValue
            list.removeAt(listLastIndex)

            if(map.containsKey(lastListValue)) {
                map[lastListValue]!!.remove(listLastIndex)
                map[lastListValue]!!.add(index)
            }
            return true
        }
        return false
    }

    fun getRandom(): Int {
        return list.random()
    }
}