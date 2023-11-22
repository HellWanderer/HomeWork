//Определите, действительна ли доска для судоку 9 x 9.  Только заполненные ячейки должны быть проверены по следующим правилам:
//1. Каждая строка должна содержать цифры 1–9 без повторений.
//2. Каждый столбец должен содержать цифры 1-9 без повторений.
//3. Каждый из девяти подполей сетки размером 3х3 должен содержать цифры от 1 до 9 без повторений.
//Примечание:
//Доска судоку (частично заполненная) может быть допустимой, но не обязательно решаемой.
//Только заполненные ячейки должны быть проверены в соответствии с упомянутыми правилами.

class Solution
{
    fun isValidSudoku(board: Array<CharArray>): Boolean
    {
        val arrayChecksRowsColumnsX = CharArray(9) {'.'} //Буферный массив для проверки повторений значений в строках
        val arrayChecksRowsColumnsY = CharArray(9) {'.'} //Буферный массив для проверки повторений значений в столбцах

        val arrayChecksSquares = CharArray(9) {'.'} //Буферный массив для проверки повторений значений в столбцах

        var plusI = 0 //Переменная для переходя циклов на следующие квадраты доски судоку
        var plusJ = 0 //Переменная для переходя циклов на следующие квадраты доски судоку
        var counterX = 0 //Переменная счетчик для заполнения массива проверки квадратов

        //Проверка строк и столбцов на наличие повторений
        for(i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] !== '.') {
                    if (board[i][j] !in arrayChecksRowsColumnsX) {
                        arrayChecksRowsColumnsX[j] = board[i][j]
                    } else {
                        println("Row ${i+1} has duplicate value \"${board[i][j]}\"")
                        return false
                    }
                }

                if (board[j][i] !== '.') {
                    if (board[j][i] !in arrayChecksRowsColumnsY) {
                        arrayChecksRowsColumnsY[j] = board[j][i]
                    } else {
                        println("Column ${i+1} has duplicate value \"${board[j][i]}\"")
                        return false
                    }
                }
            }

            //Обнуление буферных массивов, после проверки каждой строки и столбца
            for (k in 0..8) {
                arrayChecksRowsColumnsX[k] = '.'
                arrayChecksRowsColumnsY[k] = '.'
            }
        }

        //Проверка квадратов на валидность
        for(p in 0..8) { //Цикл для проверки каждого квадрата от 1-ого до 9-ого
            for (i in 0..2) {
                for (j in 0..2) {
                    if (board[i + plusI][j + plusJ] !== '.') {
                        if (board[i + plusI][j + plusJ] !in arrayChecksSquares) {
                            arrayChecksSquares[counterX] = board[i + plusI][j + plusJ]
                        } else {
                            println("Square ${p+1} has duplicate value \"${board[i + plusI][j + plusJ]}\"")
                            return false
                        }
                        counterX++
                    }
                }
            }

            for (k in 0..8)
                arrayChecksSquares[k] = '.'

            if (plusI == 6) //Обнуление счетчика перехода циклов по "квадратам"
                plusI = 0
            else
                plusI += 3

            if (p > 5) //Прибавление счетчика по оси y для прохождения всех квадратов
                plusJ = 6
            else if (p > 2)
                plusJ = 3

            counterX = 0 //Обнуление счетчика заполнения буферного массива
        }

        println("The board is valid")
        return true
    }
}

fun main(args: Array<String>)
{
    val sudoku = Solution() //Объявление и инициализация класса Solution
    val board = Array(9) {CharArray(9) {'.'}} //Объявление и заполнение двухмерного массива board

    println("Enter line by line values from 1 to 9 for the Sudoku board using Enter. \nEmpty cells are indicated with the symbol \".\"")

    //Ввод значение для доски судоку
    for(i in 0..8) {
        val x: String = readLine()!!

        for(j in 0..x.length-1) {
            board[i][j] = x[j]
        }
    }

    //Вывод введеного массива на экран
    for(row in board) {
        print("[")
        for(cell in row) {
            print("\"$cell\"")
        }

        print("]\n")
    }

    print(sudoku.isValidSudoku(board)) //Вызов функции класса Solution, для проверки валидности введенной доски
}