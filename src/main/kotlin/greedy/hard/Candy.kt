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
        if(ratings.size == 1) return 1
        var sum = 0
        var counterArr = IntArray(ratings.size){1}
        var flag = true
        while(flag){
            flag = false
            for (i in 0..ratings.lastIndex) {
                if(i==0){
                    if(ratings[i]>ratings[i+1]&&counterArr[i]<=counterArr[i+1]){
                        counterArr[i] = counterArr[i]+1
                        flag = true
                    }
                }
                else if(i==ratings.lastIndex){
                    if(ratings[i]>ratings[i-1]&&counterArr[i]<=counterArr[i-1]){
                        counterArr[i] = counterArr[i]+1
                        flag = true
                    }
                }
                else if((ratings[i]>ratings[i-1]&&counterArr[i]<=counterArr[i-1])||
                    (ratings[i]>ratings[i+1]&&counterArr[i]<=counterArr[i+1]))
                {
                    counterArr[i] = counterArr[i]+1
                    flag = true
                }
            }
        }
        for(i in counterArr){
            sum += i
        }
        return sum
    }

    fun optimCandy(ratings: IntArray): Int {
        if(ratings.size == 1) return 1
        var sum = 0
        var counterArr = IntArray(ratings.size){1}

        for(i in ratings.indices){
            if(i > 0 && ratings[i]>ratings[i-1]){
                counterArr[i] = counterArr[i-1]+1
            }
        }

        for(i in ratings.lastIndex-1 downTo 0){
            if(ratings[i]>ratings[i+1] && counterArr[i]<= counterArr[i+1]){
                counterArr[i] = counterArr[i+1]+1
            }
        }

        for(i in counterArr){
            sum += i
        }
        return sum
    }

}