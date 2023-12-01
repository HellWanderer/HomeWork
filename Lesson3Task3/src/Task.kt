class Task(descriptionParam: String, dueDateParam: String) {
    private var description = descriptionParam
    private var dueDate = dueDateParam

    fun getDescription() = description

    fun setDescription(descriptionParam: String) {
        description = descriptionParam
    }

    fun getDueDate() = dueDate

    fun setDueDate(dueDateParam: String) {
        dueDate = dueDateParam
    }
}