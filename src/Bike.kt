class Bike : Vehicle() {
    private val numOfWheels = 0

    override fun displayInfo() {
        super.displayInfo()
        println("Num of wheels $numOfWheels")
    }

    override fun makeSound() {
        println("Bicycle bell sound")
    }
}