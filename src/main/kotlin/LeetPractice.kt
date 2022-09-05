import ProblemOfTheDay.NumberOfIslands
import dp.KnapsackProblem
import easy.*
import hard.FirstMissingPositive
import hard.LargestRectangleInHistogram
import hard.RandomizedCollection
import medium.*

fun main() {
   var randomize = RandomizedCollection()
    println(randomize.insert(1))
    println(randomize.insert(1))
    println(randomize.insert(2))
    println(randomize.insert(1))
    println(randomize.insert(2))
    println(randomize.insert(2))

    println(randomize.remove(1))
    println(randomize.remove(2))
    println(randomize.remove(2))
    println(randomize.remove(2))

    println(randomize.getRandom())
    println(randomize.getRandom())
    println(randomize.getRandom())
    println(randomize.getRandom())
    println(randomize.getRandom())

}