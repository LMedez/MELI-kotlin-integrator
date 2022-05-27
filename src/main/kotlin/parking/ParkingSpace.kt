package parking

import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*
import kotlin.math.ceil

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

    /*
    * Function calculateFee returns the price to be paid by the driver
    *
    * */
    fun calculateFee(type: VehicleType, parkedTime:Int):Int{
        val TWO_HOUR_IN_MILLISECONDS = MINUTES_IN_MILLISECONDS * 120
        val PRICE_FRACTION = 5
        val fraction = parkedTime - TWO_HOUR_IN_MILLISECONDS
        return when {
            fraction <= 0 -> type.tarifa
            fraction > 0 -> type.tarifa + ceil(fraction/15.0*PRICE_FRACTION).toInt()
            else -> 0
        }
    }

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
}
