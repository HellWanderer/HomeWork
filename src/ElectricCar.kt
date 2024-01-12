class ElectricCar : FuelEfficient {
    val batteryCapacity = 0
    override val speed = 0
    override val color = ""

    override fun fuelEfficiency() {
        println("Electric fuel is more environmentally friendly")
    }

    fun startElectricCar() {
        println("Electric car is start")
    }

    override fun displayInfo() {
        println("The vehicle has color $color and speed $speed")
    }
}