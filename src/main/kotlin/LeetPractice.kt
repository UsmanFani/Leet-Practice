import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    var transactions = arrayOf("alice,20,800,mtv","alice,50,100,beijing")
    var invalid = InvalidTransactions().invalidTransactions(transactions)
    println(invalid)
}