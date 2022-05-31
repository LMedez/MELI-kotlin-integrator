import parking.Parking
import parking.ParkingSpace
import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*

fun main(args: Array<String>) {
    val car = Vehicle("AAC667C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("BBC467N", VehicleType.MOTO, Calendar.getInstance())
    val bus = Vehicle("CCA677M", VehicleType.BUS, Calendar.getInstance())
    val miniBus = Vehicle("PPA617T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val parking = Parking(mutableSetOf(car, moto, bus, miniBus))

    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(bus))
    println(parking.vehicles.contains(miniBus))

    /*
    * Test insert a car with the same plate.
    * return false.
    * */
    val car2 = Vehicle("AAC667C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val isCardInserted = parking.vehicles.add(car2)
    println(isCardInserted)

    /*
    * Exercise 10
    *
    * */

    val parkingSpace = ParkingSpace(moto, parking)
    parkingSpace.checkOutVehicle(moto.plate, { fee ->
        // onSuccess
        println("Your fee is $$fee. Come back soon.")
    }, {
        // onError
        println("Sorry, the check-out failed")
    })
}

fun checkIn(vehicle: Vehicle) {

}