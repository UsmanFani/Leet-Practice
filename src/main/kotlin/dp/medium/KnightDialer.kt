package dp.medium

import kotlin.math.pow

//@author Usman Fani
class KnightDialer {
    //Example 1:
    //Input: n = 1
    //Output: 10
    //Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.

    //Example 2:
    //Input: n = 2
    //Output: 20
    //Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]

    //Example 3:
    //Input: n = 3131
    //Output: 136006598
    //Explanation: Please take care of the mod.

    //Top-Down Approach (Recursive + Memoization)
    //O(n)
    //O(n)
    fun knightDialer(n: Int): Int {
        var path: Long = 0
        val dp = Array(n) { LongArray(10) { -1 } }

        for (i in 0..3) {
            for (j in 0..2) {
                path += dialer(i, j, n, dp)
            }

        }
        return (path % (Math.pow(10.0, 9.0) + 7)).toInt()
    }

    private fun dialer(i: Int, j: Int, k: Int, dp: Array<LongArray>): Long {
        if ((i == 3 && j == 0) || (i == 3 && j == 2)) return 0
        if (i < 0 || i > 3 || j < 0 || j > 2) return 0
        if (k == 1) return 1
        val num = when {
            i == 0 && j == 0 -> 1
            i == 0 && j == 1 -> 2
            i == 0 && j == 2 -> 3
            i == 1 && j == 0 -> 4
            i == 1 && j == 1 -> 5
            i == 1 && j == 2 -> 6
            i == 2 && j == 0 -> 7
            i == 2 && j == 1 -> 8
            i == 2 && j == 2 -> 9
            i == 3 && j == 1 -> 0
            else -> {
                0
            }
        }

        if (dp[k - 1][num] != -1L) {
            return dp[k - 1][num]
        }

        val path = dialer(i + 1, j + 2, k - 1, dp) +
                dialer(i + 1, j - 2, k - 1, dp) +
                dialer(i - 1, j + 2, k - 1, dp) +
                dialer(i - 1, j - 2, k - 1, dp) +
                dialer(i + 2, j - 1, k - 1, dp) +
                dialer(i + 2, j + 1, k - 1, dp) +
                dialer(i - 2, j + 1, k - 1, dp) +
                dialer(i - 2, j - 1, k - 1, dp)



        dp[k - 1][num] = path % (Math.pow(10.0, 9.0) + 7).toLong()
        return path
    }

    //Bottom-Up Approach (Tabulation)
    //Time: O(n*10)->O(n)
    //Space: O(n*10)->O(n)
    fun tabKnightDialer(n: Int): Int {
        val dp = Array(n) { LongArray(10) }

        for (i in 0..9) {
            dp[0][i] = 1
        }

        val num = (Math.pow(10.0, 9.0) + 7).toLong()
        for (i in 1 until n) {
            for (j in 0..9) {
                if (j == 5) continue
                getPath(j).forEach { index ->
                    dp[i][j] += dp[i - 1][index] % num
                }
            }
        }

        var res = 0L
        dp[n - 1].forEach {
            res += (it % num).toInt()
        }

        return (res % num).toInt()
    }

    private fun getPath(n: Int): IntArray {
        return when (n) {
            0 -> intArrayOf(4, 6)
            1 -> intArrayOf(6, 8)
            2 -> intArrayOf(7, 9)
            3 -> intArrayOf(4, 8)
            4 -> intArrayOf(0, 3, 9)
            5 -> intArrayOf()
            6 -> intArrayOf(0, 1, 7)
            7 -> intArrayOf(2, 6)
            8 -> intArrayOf(1, 3)
            9 -> intArrayOf(2, 4)
            else -> {
                intArrayOf()
            }
        }
    }


    //O(n)
    //O(1)
    fun optimKnightDialer(n: Int): Int {
        var x0 = 1L
        var x1 = 1L
        var x2 = 1L
        var x3 = 1L
        var x4 = 1L
        var x5 = 1L
        var x6 = 1L
        var x7 = 1L
        var x8 = 1L
        var x9 = 1L

        val modPeak = (Math.pow(10.0, 9.0) + 7).toLong()
        for (i in 1 until n) {
            val a0 = x4 % modPeak + x6 % modPeak
            val a1 = x6 % modPeak + x8 % modPeak
            val a2 = x7 % modPeak + x9 % modPeak
            val a3 = x4 % modPeak + x8 % modPeak
            val a4 = x0 % modPeak + x3 % modPeak + x9 % modPeak
            val a5 = 0L
            val a6 = x0 % modPeak + x1 % modPeak + x7 % modPeak
            val a7 = x2 % modPeak + x6 % modPeak
            val a8 = x1 % modPeak + x3 % modPeak
            val a9 = x2 % modPeak + x4 % modPeak

            x0 = a0
            x1 = a1
            x2 = a2
            x3 = a3
            x4 = a4
            x5 = a5
            x6 = a6
            x7 = a7
            x8 = a8
            x9 = a9
        }

        return ((x0 + x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9) % modPeak).toInt()
    }

}
