fun main(args: Array<String>) {
    val houseList: Array<House> = arrayOf(
        House(1, 23, 20, 1, 3, "street1", "Residential building", 50),
        House(2, 11, 20, 2, 2, "street1", "Residential building", 50),
    )

    println("Enter the number of rooms in the apartment:")
    var numberOfRooms = readLine()!!.toInt()

    for (house in houseList) {
        if (house.getNumberOfRooms() == numberOfRooms) {
            println(house.getApartmentNumber())
        }
    }

    println("Enter the number of rooms in the apartment:")
    numberOfRooms = readLine()!!.toInt()
    println("Enter the start and end of the floor range:")
    val startFloorRange = readLine()!!.toInt()
    val endFloorRange = readLine()!!.toInt()

    for (house in houseList) {
        if ((house.getNumberOfRooms() == numberOfRooms) && (house.getFloor() > startFloorRange && house.getFloor() < endFloorRange)) {
            println(house.getApartmentNumber())
        }
    }

    println("Enter the area of the apartment:")
    val areaOfApartment = readLine()!!.toInt()

    for (house in houseList) {
        if (house.getSquare() > areaOfApartment ) {
            println(house.getApartmentNumber())
        }
    }
}