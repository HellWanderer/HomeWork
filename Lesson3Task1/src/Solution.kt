class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var rottingProcess: Boolean = true;
        var numberOfMinutes = 0 //Количество "минут"

        var numberOfRottenOrange = 0 //Количество гнилых апельсинов для коллекции rottenOrange
        var numberOFreshOrange = 0 //Количество свежих апельсинов для коллекции rottenOrange

        val rottenOrange = mutableMapOf<Int, List<Int>>() //буферная коллекция для хранения индексов гнилых апельсинов

        //Первоначальное получение индексов гнилых апельсинов
        for (i in 0 until grid.size) {
            for(j in 0 until grid[i].size) {
                if(grid[i][j] == 2) {
                    numberOfRottenOrange++ //Увеличение кол-ва гнилых апельсинов
                    rottenOrange[numberOfRottenOrange] = listOf(i, j)
                }
                else if (grid[i][j] == 1) {
                    numberOFreshOrange++ //Увеличение свежих апельсинов
                }
            }
        }

        while (rottingProcess) {
            var topRotting: Boolean = true
            var downRotting: Boolean = true
            var leftRotting: Boolean = true
            var rightRotting: Boolean = true

            var bufRottingProcess = numberOfRottenOrange

            for (orange in 1 .. numberOfRottenOrange) {
                val i = rottenOrange[orange]!![0] //Индекс i гнилого апельсина
                val j = rottenOrange[orange]!![1] //Индекс j гнилого апельсина

                //Проверка верхнего направления
                if(i - 1 >= 0 && grid[i - 1][j] == 1) {
                    topRotting = true //Если апельсин испортился, то true
                    bufRottingProcess++ //Увеличение буферного количества гнилых апельсинов
                    numberOFreshOrange-- //Уменьшение количества свежих апельсинов
                    rottenOrange[bufRottingProcess] = listOf(i - 1, j) //Добавление индексов гнилого апельсина
                    grid[i - 1][j] = 2 //Замена свежего апельсина на гнилой
                }
                else
                    topRotting = false //Если апельсин не испортился, то false

                //Проверка нижнего направления
                if(i + 1 < grid.size && grid[i + 1][j] == 1) {
                    downRotting = true
                    bufRottingProcess++
                    numberOFreshOrange--
                    rottenOrange[bufRottingProcess] = listOf(i + 1, j)
                    grid[i + 1][j] = 2
                }
                else
                    downRotting = false

                //Проверка левого направления
                if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                    leftRotting = true
                    bufRottingProcess++
                    numberOFreshOrange--
                    rottenOrange[bufRottingProcess] = listOf(i, j - 1)
                    grid[i][j - 1] = 2
                }
                else
                    leftRotting = false

                //Проверка правого направления
                if(j + 1 < grid[0].size && grid[i][j + 1] == 1) {
                    rightRotting = true
                    bufRottingProcess++
                    numberOFreshOrange--
                    rottenOrange[bufRottingProcess] = listOf(i, j + 1)
                    grid[i][j + 1] = 2
                }
                else
                    rightRotting = false
            }

            numberOfRottenOrange = bufRottingProcess //Увеличение общего количества гнилых апельсинов

            if (!topRotting && !downRotting && !leftRotting && !rightRotting)
                //Если больше не удается испортить апельсины, то останавливаем процесс
                rottingProcess = false
            else
                numberOfMinutes++ //Увеличение счетчика минут
        }

        return if(numberOFreshOrange == 0) {
            numberOfMinutes
        } else
            -1
    }
}