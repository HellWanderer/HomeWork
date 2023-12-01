import java.util.Scanner
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val taskList = mutableListOf<Task>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Choose an action:")
        println("1.Add a task") //Добавление задачи
        println("2.View tasks") //Вывод всех задач
        println("3.Deleting a task") //Удаление задачи
        println("4.Editing a task") //Редактирование задачи
        println("5.Displaying a task by number or date") //Вывод задачи по номеру или дате
        println("6.Exit") //Выход

        //Прочитать про работу scanner
        when(scanner.next().toInt()) {
            1 -> addTask(scanner, taskList)
            2 -> viewTasks(taskList)
            3 -> deleteTask(scanner, taskList)
            4 -> editTask(scanner, taskList)
            5 -> displayTask(scanner, taskList)
            6 -> exitProcess(-1)
        }
    }
}

fun addTask(scanner: Scanner, taskList: MutableList<Task>) {
    scanner.nextLine() //Обработка последнего символа /n в строке

    println("Enter a task description:")
    val description = scanner.nextLine()

    println("Enter the due date (for example, 2023-11-26)")
    val dueDate = scanner.nextLine()

    if(description != "" && dueDate != "") {
        val newTask = Task(description, dueDate)
        taskList.add(newTask)

        println("Task added successfully")
    }
    else {
        println("The task description or date entered are incorrect")
    }
}

fun viewTasks(taskList: MutableList<Task>) {
    if(taskList.isEmpty()) {
        println("The task list is empty")
    }
    else {
        println("Task list:")

        for ((index, task) in taskList.withIndex()) {
            println("${index + 1}. Description: ${task.getDescription()} Date: ${task.getDueDate()}")
        }
    }
}

fun deleteTask(scanner: Scanner, taskList: MutableList<Task>) {
    scanner.nextLine() //Обработка последнего символа /n в строке

    println("Enter the number of the task to be deleted:")
    val numberTask = scanner.next().toInt() - 1

    //Проверка, чтобы указанный индекс задачи не выходил за границы листа
    if((numberTask < taskList.size) && (numberTask >= 0)) {
        taskList.removeAt(numberTask)

        println("The task was successfully deleted")
    }
    else {
        println("Invalid task number entered")
    }
}

fun editTask(scanner: Scanner, taskList: MutableList<Task>) {
    scanner.nextLine() //Обработка последнего символа /n в строке

    println("Enter the task number to edit:")
    val numberTask = scanner.next().toInt() - 1

    //Проверка, чтобы указанный индекс задачи не выходил за границы листа
    if((numberTask < taskList.size) && (numberTask >= 0)) {
        println("${numberTask + 1}. Description: ${taskList[numberTask].getDescription()} Date: ${taskList[numberTask].getDueDate()}")

        println("Enter a task description:")
        val description = scanner.nextLine()

        println("Enter the due date (for example, 2023-11-26)")
        val dueDate = scanner.nextLine()

        if(description != "" && dueDate != "") {
            taskList[numberTask].setDescription(description)
            taskList[numberTask].setDueDate(dueDate)
            println("The task was successfully edited")
        }
        else
            println("The task description or date entered is incorrect or empty")
    }
    else {
        println("Invalid task number entered")
    }
}

fun displayTask(scanner: Scanner, taskList: MutableList<Task>) {
    scanner.nextLine() //Обработка последнего символа /n в строке

    var checkFound = false

    println("Enter the task description or date:")
    val descriptionOrDate = scanner.nextLine()

    if(descriptionOrDate != "") {
        for ((index, task) in taskList.withIndex()) {
            if(task.getDescription() == descriptionOrDate || task.getDueDate() == descriptionOrDate) {
                println("Found task: ${index + 1}. Description: ${task.getDescription()} Date: ${task.getDueDate()}")
                checkFound = true
            }
        }
        if (!checkFound) println("Task for given values not found")
    }
    else {
        println("The task description or date entered are incorrect")
    }
}