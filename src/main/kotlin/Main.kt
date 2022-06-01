import parking.Parking
import parking.ParkingSpace
import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*

fun main(args: Array<String>) {
    val car = Vehicle("AAC667C", VehicleType.AUTO, "DISCOUNT_CARD_001")
    val moto = Vehicle("BBC467N", VehicleType.MOTO)
    val bus = Vehicle("CCA677M", VehicleType.BUS)
    val miniBus = Vehicle("PPA617T", VehicleType.MINIBUS, "DISCOUNT_CARD_002")
    val carTwo = Vehicle("ROP569K", VehicleType.AUTO)
    val motoTwo = Vehicle("BBC468N", VehicleType.MOTO)
    val busTwo = Vehicle("CCA678M", VehicleType.BUS)
    val miniBusTwo = Vehicle("PPA618T", VehicleType.MINIBUS, "DISCOUNT_CARD_002")
    val carThree = Vehicle("AAC669C", VehicleType.AUTO, "DISCOUNT_CARD_001")
    val motoFour = Vehicle("BBC469N", VehicleType.MOTO)

    val carFour = Vehicle("AAC667O", VehicleType.AUTO, "DISCOUNT_CARD_001")
    val motoFive = Vehicle("BBC467U", VehicleType.MOTO)
    val busFive = Vehicle("CCA677I", VehicleType.BUS)
    val miniBusThree = Vehicle("PPA617K", VehicleType.MINIBUS, "DISCOUNT_CARD_002")
    val carFive = Vehicle("BBC468T", VehicleType.AUTO)
    val motoThree = Vehicle("BBC468R", VehicleType.MOTO)
    val busThree = Vehicle("CCA678E", VehicleType.BUS)
    val miniBusFour = Vehicle("PPA618W", VehicleType.MINIBUS, "DISCOUNT_CARD_002")
    val carSix = Vehicle("AAC669Q", VehicleType.AUTO, "DISCOUNT_CARD_001")
    val motoSix = Vehicle("BBC469A", VehicleType.MOTO)

    val parking = Parking(mutableSetOf())


    val vehiclesArray = arrayOf(
        car, moto, bus, miniBus, carTwo, motoTwo, busTwo, miniBusTwo, carThree, motoFour,
        carFour, motoFive, busFive, miniBusThree, carFive, motoThree, busThree, miniBusFour,
        carSix, motoSix, car)
    println("exercise 6:")
    for(i in 1..21) {
        val vehicleIn = parking.addVehicle(vehiclesArray[i-1])
        if (vehicleIn) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }
    /*
    * Exercise 10
    *
    * */
    println("exercise 7,8,9,10")
    val parkingSpace = ParkingSpace(moto, Calendar.getInstance(), parking)
    parkingSpace.checkOutVehicle(moto.plate, { fee ->
        // onSuccess
        println("Your fee is $$fee. Come back soon.")
    }, {
        // onError
        println("Sorry, the check-out failed")
    })
    println("exercise 11:")
    parking.showFee()
    println("exercise 12:")
    parking.listVehicle()



}

