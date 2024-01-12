open class Car : Vehicle() {
    private val carMake = ""

    override fun displayInfo() {
        super.displayInfo()
        println("Car make $carMake")
    }

    override fun makeSound() {
        println("The sound of a car horn")
    }
}