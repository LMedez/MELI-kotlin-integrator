package parking

import vehicle.Vehicle
import java.util.*

data class ParkingSpace(var vehicle: Vehicle) {
    companion object {
        const val MINUTES_IN_MILISECONDS = 60_000
    }

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS
}
