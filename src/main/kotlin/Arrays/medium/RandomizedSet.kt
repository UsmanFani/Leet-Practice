package Arrays.medium

class RandomizedSet {
    //Input
    //["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
    //[[], [1], [2], [2], [], [1], [2], []]
    //Output
    //[null, true, false, true, 2, true, false, 2]
    var set: MutableSet<Int> = mutableSetOf()
    fun insert(`val`: Int): Boolean {
        return set.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return set.remove(`val`)
    }

    fun getRandom(): Int {
        return set.random()
    }
}