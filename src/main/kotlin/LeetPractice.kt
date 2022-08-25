import dp.KnapsackProblem
import easy.*
import medium.*

fun main() {
    var transactions = arrayOf("alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt")
    var invalid = InvalidTransactions().invalidTransaction(transactions)
    println(invalid)
}