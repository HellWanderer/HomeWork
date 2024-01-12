fun main() {
    val m = arrayOf(Car(), Bike())

    for(item in m) {
        item.displayInfo()
    }
}