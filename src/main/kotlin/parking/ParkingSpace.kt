package parking

import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*

data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    companion object {
        const val MINUTES_IN_MILLISECONDS = 60_000
    }

    /*
    * Exercise 6
    *
    * */
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit) {
        val vehicle = parking.vehicles.firstOrNull { it.plate == plate }
        vehicle?.let {
            parking.vehicles.remove(it)
            onSuccess(1)
        }?: onError()
    }

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
}
