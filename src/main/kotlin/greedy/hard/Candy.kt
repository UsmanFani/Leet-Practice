package greedy.hard

//@author Usman Fani

//Leetcode: 135

//Example 1:
//Input: ratings = [1,0,2]
//Output: 5
//Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

//Example 2:
//Input: ratings = [1,2,2]
//Output: 4
//Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//The third child gets 1 candy because it satisfies the above two conditions.
class Candy {
    fun candy(ratings: IntArray): Int {
        var sum = 0
        var counter = 0
        for (i in 0..ratings.lastIndex) {
            if (i != 0 && ratings[i] <= ratings[i - 1]) {
                if (i < ratings.lastIndex && ratings[i] > ratings[i + 1])
                    if (i >= 2 && i < ratings.lastIndex && ratings[i] > ratings[i + 1] && ratings[i - 1] > ratings[i - 2]) counter =
                        0
                    else counter = 0
            }
 
            if (i != ratings.lastIndex && ratings[i] > ratings[i + 1]) {
                counter++
            } else if (i != 0 && ratings[i] > ratings[i - 1]) counter++
            else counter = 0
            sum += counter
            if (i != ratings.lastIndex && ratings[i] == ratings[i + 1]) counter = 0
        }
        sum += ratings.size
        return sum
    }

}