package Arrays.medium

class MaxPointFromCards {
    //Example 1:
    //Input: cardPoints = [1,2,3,4,5,6,1], k = 3
    //Output: 12
    //Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

    //Example 2:
    //Input: cardPoints = [2,2,2], k = 2
    //Output: 4
    //Explanation: Regardless of which two cards you take, your score will always be 4.

    //Example 3:
    //Input: cardPoints = [9,7,7,9,7,7,9], k = 7
    //Output: 55
    //Explanation: You have to take all the cards. Your score is the sum of points of all cards.
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var score = 0
        for (i in 0 until k) {
            score += cardPoints[i]
        }
        if (cardPoints.size == k) return score

        var first = cardPoints.lastIndex
        var last = k - 1
        var sum = score
        for (i in 0 until k) {
            val temp = sum - cardPoints[last] + cardPoints[first]
            sum = temp
            score = maxOf(score, temp)
            if (last == 0) last = cardPoints.lastIndex
            else last--
            first--
        }
        return score
    }
}