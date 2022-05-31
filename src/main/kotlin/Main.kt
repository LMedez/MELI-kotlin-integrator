import parking.Parking
import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*

fun main(args: Array<String>) {
    val car = Vehicle("AAC667C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("BBC467N", VehicleType.MOTO, Calendar.getInstance())
    val bus = Vehicle("CCA677M", VehicleType.BUS, Calendar.getInstance())
    val miniBus = Vehicle("PPA617T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carTwo = Vehicle("ROP569K", VehicleType.AUTO, Calendar.getInstance())
    val motoTwo = Vehicle("BBC468N", VehicleType.MOTO, Calendar.getInstance())
    val busTwo = Vehicle("CCA678M", VehicleType.BUS, Calendar.getInstance())
    val miniBusTwo = Vehicle("PPA618T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carThree = Vehicle("AAC669C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motoFour = Vehicle("BBC469N", VehicleType.MOTO, Calendar.getInstance())

    val carFour = Vehicle("AAC667O", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motoFive = Vehicle("BBC467U", VehicleType.MOTO, Calendar.getInstance())
    val busFive = Vehicle("CCA677I", VehicleType.BUS, Calendar.getInstance())
    val miniBusThree = Vehicle("PPA617K", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carFive = Vehicle("BBC468T", VehicleType.AUTO, Calendar.getInstance())
    val motoThree = Vehicle("BBC468R", VehicleType.MOTO, Calendar.getInstance())
    val busThree = Vehicle("CCA678E", VehicleType.BUS, Calendar.getInstance())
    val miniBusFour = Vehicle("PPA618W", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carSix = Vehicle("AAC669Q", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motoSix = Vehicle("BBC469A", VehicleType.MOTO, Calendar.getInstance())

    val parking = Parking(mutableSetOf())

    val vehiclesArray = arrayOf(
        car, moto, bus, miniBus, carTwo, motoTwo, busTwo, miniBusTwo, carThree, motoFour,
        carFour, motoFive, busFive, miniBusThree, carFive, motoThree, busThree, miniBusFour,
        carSix, motoSix, car)

    for(i in 1..21) {
        val vehicleIn = parking.addVehicle(vehiclesArray[i-1])
        if (vehicleIn) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }
}