import parking.Parking
import vehicle.Vehicle
import vehicle.VehicleType
import java.util.*
import java.util.logging.Handler
import java.util.Timer
import kotlin.concurrent.schedule

fun check_In() {


    val car = Vehicle("AAC667C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car2 = Vehicle("AAC667C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_003")
    val moto = Vehicle("BBC467N", VehicleType.MOTO, Calendar.getInstance())
    val bus = Vehicle("CCA677M", VehicleType.BUS, Calendar.getInstance())
    val miniBus = Vehicle("PPA617T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carTwo = Vehicle("ROP569K", VehicleType.AUTO, Calendar.getInstance())
    val motoTwo = Vehicle("BBC468N", VehicleType.MOTO, Calendar.getInstance())
    val busTwo = Vehicle("CCA678M", VehicleType.BUS, Calendar.getInstance())
    val miniBusTwo = Vehicle("PPA618T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carThree = Vehicle("AAC669C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motoFour = Vehicle("BBC469N", VehicleType.MOTO, Calendar.getInstance())

    val carFour = Vehicle("AAC667C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motoFive = Vehicle("BBC467N", VehicleType.MOTO, Calendar.getInstance())
    val busFive = Vehicle("CCA677M", VehicleType.BUS, Calendar.getInstance())
    val miniBusThree = Vehicle("PPA617T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carFive = Vehicle("BBC468N", VehicleType.AUTO, Calendar.getInstance())
    val motoThree = Vehicle("BBC468N", VehicleType.MOTO, Calendar.getInstance())
    val busThree = Vehicle("CCA678M", VehicleType.BUS, Calendar.getInstance())
    val miniBusFour = Vehicle("PPA618T", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val carSix = Vehicle("AAC669C", VehicleType.AUTO, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motoSix = Vehicle("BBC469N", VehicleType.MOTO, Calendar.getInstance())

    val parking = Parking(mutableSetOf(
            car, moto, bus, miniBus, carTwo, motoTwo, busTwo, miniBusTwo, carThree, motoFour,
            carFour, motoFive, busFive, miniBusThree, carFive, motoThree, busThree, miniBusFour,
            carSix, motoSix

    ))
    /*
    * Test insert a car with the same plate.
    * return false.
    */

    val isCardInserted = parking.vehicles.add(car2)


    val arrayParkin = arrayOf(
            car, moto, bus, miniBus, carTwo, motoTwo, busTwo, miniBusTwo, carThree, motoFour,
            carFour, motoFive, busFive, miniBusThree, carFive, motoThree, busThree, miniBusFour,
            carSix, motoSix

    )
    var num = 1;


    fun complexCriteria(arrayParking: Int): Any = when {
        arrayParking <= Parking.LIMIT_OF_CARS -> for (arrayParking in arrayParkin ){
            println("The vehicle:  ${num++} type of: ${arrayParking.vehicleType} Welcome to AlkeParking:   of plate:  ${arrayParking.plate} date:${Date()}  ")
        }
        else -> println("Sorry, the has check-in failed Vehicle ${isCardInserted.toString()+ " Repeat of type:" +arrayParkin[0].vehicleType } whit plate: ${arrayParkin[0].plate} date: ${Date()}")


    }



    complexCriteria(20)

}
