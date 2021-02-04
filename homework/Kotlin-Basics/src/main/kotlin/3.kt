import org.junit.jupiter.api.Assertions.assertEquals

val factorial: (Int) -> Int = { n ->
    tailrec fun factAcc(n: Int, acc: Int): Int =
        if (n == 0)
            acc
        else
            factAcc(n - 1, n * acc)

    factAcc(n, 1)
}

fun factorial2(n: Int): Int =
    if (n == 0)
        1
    else
        (1..n).reduce { acc, i -> acc * i }


// Test driver

fun main() {
    testFactorial(factorial)

    factorial(1)

    testFactorial(::factorial2)
}

fun testFactorial(fact: (Int) -> Int) {
    assertEquals(1, fact(0))
    assertEquals(1, fact(1))
    assertEquals(2, fact(2))
    assertEquals(6, fact(3))
    assertEquals(24, fact(4))
    assertEquals(120, fact(5))
    assertEquals(3628800, fact(10))
    assertEquals(479001600, fact(12))
}
