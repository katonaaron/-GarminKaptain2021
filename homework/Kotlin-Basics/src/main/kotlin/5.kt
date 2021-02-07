data class HeartRateEntry(val date: Long, val value: Int)

fun populateData(vararg dataPair: Pair<Long, Int>): List<HeartRateEntry> =
    dataPair.map { HeartRateEntry(it.first, it.second) }

val data = populateData(
    1612310400L to 76,
    1612310400L to 89,
    1612310400L to 44,
    1612224000L to 47,
    1612224000L to 115,
    1612224000L to 76,
    1612224000L to 87,
    1612137600L to 90,
    1612137600L to 167
)


fun main() {

    // List of heart rate values
    val heartRates = data.map { it.value }


    // Computing results

    val minVal: Int? = heartRates.minOrNull()

    val avgVal = heartRates.average()

    val above100 = heartRates.filter { it > 100 }

    val heartRateMap = data.groupBy(HeartRateEntry::date, HeartRateEntry::value)

    val maxValPerDay: Map<Long, Int?> = heartRateMap.mapValues { it.value.maxOrNull() }


    // Printing results

    println("Minimum heart rate value: ${minVal.formatString()}")
    println("Average heart rate value: $avgVal")
    println("Heart rate values above 100: $above100")
    println("Heart rate values per day: $heartRateMap")
    println("Maximum heart rate values per each day:")
    maxValPerDay.forEach {
        println("\tDay ${it.key}: ${it.value.formatString()}")
    }
}

fun Int?.formatString(): String = this?.toString() ?: "No data"
