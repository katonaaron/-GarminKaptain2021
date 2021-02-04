import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

enum class BloodPressureCategory(val description: String) {
    NORMAL("NORMAL"),
    ELEVATED("ELEVATED"),
    HYPERTENSION_1("HIGH BLOOD PRESSURE (HYPERTENSION) STAGE 1"),
    HYPERTENSION_2("HIGH BLOOD PRESSURE (HYPERTENSION) STAGE 2"),
    HYPERTENSIVE_CRISIS("HYPERTENSIVE CRISIS (consult your doctor immediately)")
}

fun bloodPressureToCategory(systolic: Int, diastolic: Int) = when {
    systolic > 180 || diastolic > 120 -> BloodPressureCategory.HYPERTENSIVE_CRISIS
    systolic >= 140 || diastolic >= 90 -> BloodPressureCategory.HYPERTENSION_2
    systolic >= 130 || diastolic >= 80 -> BloodPressureCategory.HYPERTENSION_1
    systolic >= 120 -> BloodPressureCategory.ELEVATED
    else -> BloodPressureCategory.NORMAL
}


// Driver program for testing

fun main() {

    println("Running test cases: ")
    testCases.forEachIndexed { i, testCase ->
        runTest(testCase)
        print("#${i + 1}: ")
        printResult(testCase)
    }

    println()
    println("Generating random values: ")
    (1..10).forEach {
        print("#$it: ")
        val systolic = Random.nextInt(0, 200)
        val diastolic = Random.nextInt(0, 130)
        printResult(systolic, diastolic, bloodPressureToCategory(systolic, diastolic))
    }
}

fun runTest(testCase: TestCase) {
    val result = bloodPressureToCategory(testCase.systolic, testCase.diastolic)
    assertEquals(testCase.expected, result)
}

fun printResult(systolic: Int, diastolic: Int, category: BloodPressureCategory) {
    println("systolic: $systolic, diastolic: $diastolic, category: ${category.description}")
}

fun printResult(testCase: TestCase) {
    printResult(testCase.systolic, testCase.diastolic, testCase.expected)
}


// Test cases
data class TestCase(val systolic: Int, val diastolic: Int, val expected: BloodPressureCategory)

val testCases = listOf(
    TestCase(119, 79, BloodPressureCategory.NORMAL),
    TestCase(119, 80, BloodPressureCategory.HYPERTENSION_1),
    TestCase(119, 89, BloodPressureCategory.HYPERTENSION_1),
    TestCase(119, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(119, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(119, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(120, 79, BloodPressureCategory.ELEVATED),
    TestCase(120, 80, BloodPressureCategory.HYPERTENSION_1),
    TestCase(120, 89, BloodPressureCategory.HYPERTENSION_1),
    TestCase(120, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(120, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(120, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(129, 79, BloodPressureCategory.ELEVATED),
    TestCase(129, 80, BloodPressureCategory.HYPERTENSION_1),
    TestCase(129, 89, BloodPressureCategory.HYPERTENSION_1),
    TestCase(129, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(129, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(129, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(130, 79, BloodPressureCategory.HYPERTENSION_1),
    TestCase(130, 80, BloodPressureCategory.HYPERTENSION_1),
    TestCase(130, 89, BloodPressureCategory.HYPERTENSION_1),
    TestCase(130, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(130, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(130, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(139, 79, BloodPressureCategory.HYPERTENSION_1),
    TestCase(139, 80, BloodPressureCategory.HYPERTENSION_1),
    TestCase(139, 89, BloodPressureCategory.HYPERTENSION_1),
    TestCase(139, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(139, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(139, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(140, 79, BloodPressureCategory.HYPERTENSION_2),
    TestCase(140, 80, BloodPressureCategory.HYPERTENSION_2),
    TestCase(140, 89, BloodPressureCategory.HYPERTENSION_2),
    TestCase(140, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(140, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(140, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(180, 79, BloodPressureCategory.HYPERTENSION_2),
    TestCase(180, 80, BloodPressureCategory.HYPERTENSION_2),
    TestCase(180, 89, BloodPressureCategory.HYPERTENSION_2),
    TestCase(180, 90, BloodPressureCategory.HYPERTENSION_2),
    TestCase(180, 120, BloodPressureCategory.HYPERTENSION_2),
    TestCase(180, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(181, 79, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(181, 80, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(181, 89, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(181, 90, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(181, 120, BloodPressureCategory.HYPERTENSIVE_CRISIS),
    TestCase(181, 121, BloodPressureCategory.HYPERTENSIVE_CRISIS),
)


