package parking

import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*
import kotlin.math.ceil

data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    companion object {
        const val MINUTES_IN_MILLISECONDS = 60_000
    }

    private val twoHourInMilliseconds = MINUTES_IN_MILLISECONDS * 120
    private val pricePerFraction = 5
    private val fifteenMinutesInMilliseconds = MINUTES_IN_MILLISECONDS * 15
    private val discountRate = 15

    /*
    * Exercise 6
    *
    * */
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit) {
        val vehicle = parking.vehicles.firstOrNull { it.plate == plate }
        vehicle?.let {
            parking.vehicles.remove(it)
            onSuccess(calculateFee(it.vehicleType,parkedTime.toInt(),it.discountCard?.let { true } ?: false))
        }?: onError()
    }

    /*
    * Function calculateFee returns the price to be paid by the driver (exercises 8, 9)
    *
    * */
    fun calculateFee(type: VehicleType, parkedTime:Int, hasDiscountCard:Boolean):Int{
        val fractionTime = parkedTime - twoHourInMilliseconds
        var priceToPay = 0
        when {
            fractionTime <= 0 -> priceToPay = type.tarifa
            fractionTime > 0 -> {
                priceToPay = (type.tarifa + ceil(fractionTime.toDouble() / fifteenMinutesInMilliseconds.toDouble()) * pricePerFraction).toInt()
            }
        }
        if (hasDiscountCard) {
            priceToPay -= priceToPay*discountRate/100
        }
        return priceToPay
    }

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS
}
