package medium

class PairOfSongsDiv60 {
    //Example 1:
    //
    //Input: time = [30,20,150,100,40]
    //Output: 3
    //Explanation: Three pairs have a total duration divisible by 60:
    //(time[0] = 30, time[2] = 150): total duration 180
    //(time[1] = 20, time[3] = 100): total duration 120
    //(time[1] = 20, time[4] = 40): total duration 60
    //Example 2:
    //Input: time = [60,60,60]
    //Output: 3
    //Explanation: All three pairs have a total duration of 120, which is divisible by 60.
    fun numPairsDivisibleBy60(time: IntArray): Int {
        var pairSum = 0
        for (i in 0 until time.lastIndex) {
            for (j in i + 1..time.lastIndex) {
                if ((time[i] + time[j]) % 60 == 0) pairSum++
            }
        }
        return pairSum
    }

    fun optimNumPairsDivisibleBy60(time: IntArray): Int {
        var pairSum = 0
        val set = mutableSetOf<Int>()
        var zeros = 0
        for (i in time.indices) {
            time[i] = time[i] % 60
            if (time[i] == 0) {
                if (zeros > 0) pairSum += zeros
                zeros++
            } else {
                if (set.contains(60 - time[i])) pairSum++
                set.add(time[i])
            }
        }
        return pairSum
    }

    fun optNumPairsDivisibleBy60(time: IntArray): Int {
        var pairSum:Long = 0
        var map = mutableMapOf<Int, Long>()
        for (i in time.indices) {
            time[i] = time[i] % 60
            if (map.contains(time[i])) map[time[i]] = map[time[i]]!! + 1
            else map[time[i]] = 1
        }
        map.forEach { key, value ->
            if (key == 0) {
                pairSum += (value * (value - 1)) / 2
            } else if (key == 30) {
                pairSum += (value * (value - 1)) / 2
            } else {
                var sum = 60 - key
                if (map.containsKey(sum)) {
                    pairSum += map[sum]!! * value
                    map[sum] = 0
                    map[key] = 0
                }
            }
        }

        return pairSum.toInt()
    }
}