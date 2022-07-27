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
}