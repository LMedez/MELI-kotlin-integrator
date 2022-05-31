package parking

import vehicle.Vehicle

/*
*
* Answer 1: The list of vehicles is a mutable set because the set
* cannot contain equal elements, and a vehicle is equal to another if
* these contain the same plate.
* */
data class Parking(val vehicles: MutableSet<Vehicle>) {

    companion object {
        const val LIMIT_OF_CARS = 20
    }

    var vehiclesRemovedAndTotalFee: Pair<Int, Int> = Pair(0, 0)

    fun removeVehicle(vehicle: Vehicle, fee: Int) {
        val newPair = Pair(vehiclesRemovedAndTotalFee.first + 1, vehiclesRemovedAndTotalFee.second + fee)
        vehiclesRemovedAndTotalFee = newPair
        vehicles.remove(vehicle)
    }

    fun showFee() {
        println("${vehiclesRemovedAndTotalFee.first} vehicles have checked out and have earnings of ${vehiclesRemovedAndTotalFee.second}")
    }

    fun addVehicle(vehicle: Vehicle): Boolean =
        if (vehicles.size >= LIMIT_OF_CARS)
            false
        else vehicles.add(vehicle)

// listVehicle() displays a list of all parked vehicle plates
    fun listVehicle(){
        vehicles.forEach {
            println(it.plate)
        }
    }
}
