fun main(args: Array<String>) {
    val grid = Solution()

    print("Enter the number of rows: ")
    val n = readLine()!!.toInt()

    print("Enter the number of columns: ")
    val m = readLine()!!.toInt()

    val table = Array(n) { IntArray(m) { 0 } }

    for (i in 0 until n) {
        for(j in 0 until m) {
            table[i][j] = readLine()!!.toInt()
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            print("[${table[i][j]}]")
        }
        println()
    }

    if (grid.orangesRotting(table) == -1)
        println("Not all oranges can become rotten")
    else
        println("Number of minutes until no cell has a fresh orange: ${grid.orangesRotting(table)}")
}