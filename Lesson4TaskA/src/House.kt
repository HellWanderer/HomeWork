class House (idParam: Int, apartmentNumberParam: Int, squareParam: Int, floorParam: Int, numberOfRoomsParam: Int, streetParam: String, buildingTypeParam: String, lifetimeParam: Int) {
    private var id = idParam
    private var apartmentNumber = apartmentNumberParam
    private var square = squareParam
    private var floor = floorParam
    private var numberOfRooms = numberOfRoomsParam
    private var street = streetParam
    private var buildingType = buildingTypeParam
    private var lifetime = lifetimeParam

    fun getApartmentNumber(): Int {
        return apartmentNumber
    }

    fun getNumberOfRooms(): Int {
        return numberOfRooms
    }

    fun getFloor(): Int {
        return floor
    }

    fun getSquare(): Int {
        return square
    }
}
