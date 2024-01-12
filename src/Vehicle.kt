abstract class Vehicle {
    open val speed = 0
    open val color = ""

    abstract fun makeSound()

    open fun displayInfo() {
        println("The vehicle has color $color and speed $speed")
    }
}