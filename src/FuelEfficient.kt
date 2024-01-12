interface FuelEfficient {
    val speed: Int
    val color: String

    fun fuelEfficiency()

    fun displayInfo() {
        println("The vehicle has color $color and speed $speed")
    }
}