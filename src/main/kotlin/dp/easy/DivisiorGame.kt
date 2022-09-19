package dp.easy

//Alice and Bob take turns playing a game, with Alice starting first.
//
//Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
//
//Choosing any x with 0 < x < n and n % x == 0.
//Replacing the number n on the chalkboard with n - x.
//Also, if a player cannot make a move, they lose the game.
class DivisiorGame {
    //Example 1:
    //Input: n = 2
    //Output: true
    //Explanation: Alice chooses 1, and Bob has no more moves.

    //Example 2:
    //Input: n = 3
    //Output: false
    //Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
    private var alice = true
    fun divisorGame(n: Int): Boolean {
        divisor(n, true)
        return alice
    }

    private fun divisor(n: Int, turn: Boolean) {
        if (n <= 0) {
            alice = turn
            return
        }
        var k = 1
        for (i in 1 until n) {
            if (n % i == 0) {
                k = i
                break
            }
        }
        divisor(n - k, !turn)
    }

    //we observe that at (n) Odd Number Alice always Lose
    //at (n) Even number if we use odd Number Alice Wins
    //SO, return Is Even Number
    //O(1)
    fun optimDivisorGame(n: Int): Boolean {
        return n % 2 == 0
    }

}