package Arrays.medium

class BagOfTokens {
    //Example 1:
    //Input: tokens = [100], power = 50
    //Output: 0
    //Explanation: Playing the only token in the bag is impossible because you either have too little power or too little score.

    //Example 2:
    //Input: tokens = [100,200], power = 150
    //Output: 1
    //Explanation: Play the 0th token (100) face up, your power becomes 50 and score becomes 1.
    //There is no need to play the 1st token since you cannot play it face up to add to your score.

    //Example 3:
    //Input: tokens = [100,200,300,400], power = 200
    //Output: 2
    //Explanation: Play the tokens in this order to get a score of 2:
    //1. Play the 0th token (100) face up, your power becomes 100 and score becomes 1.
    //2. Play the 3rd token (400) face down, your power becomes 500 and score becomes 0.
    //3. Play the 1st token (200) face up, your power becomes 300 and score becomes 1.
    //4. Play the 2nd token (300) face up, your power becomes 0 and score becomes 2.
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        tokens.sort()
        var left = 0
        var right = tokens.lastIndex
        if (tokens.isEmpty()) return 0
        if (power < tokens[left]) return 0
        var score = 0
        var power = power
        var maxScore = score
        while (left <= right) {
            if (left != tokens.lastIndex && power < tokens[left]) {
                power += tokens[right]
                score--
                right--
            } else {
                if (power >= tokens[left]) {
                    power -= tokens[left]
                    score++
                }
                left++
            }
            maxScore = maxOf(maxScore, score)
        }
        return maxScore
    }
}