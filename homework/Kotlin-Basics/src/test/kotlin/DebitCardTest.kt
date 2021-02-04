import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class DebitCardTest {

    @Test
    fun `Empty constructor should set the balance to 0`() {
        val card = DebitCard()
        assertEquals(0, card.balance)
    }

    @Test
    fun `Constructor with 12 as parameter should set the balance to 12`() {
        val card = DebitCard(12)
        assertEquals(12, card.balance)
    }

    @Test
    fun `Depositing 2 when the balance is 12 should result in the balance 14`() {
        val card = DebitCard(12)
        card.deposit(2)
        assertEquals(14, card.balance)
    }

    @Test
    fun `Depositing a non-positive amount should throw an IllegalArgumentException`() {
        val card = DebitCard(12)
        assertThrows(IllegalArgumentException::class.java) { card.deposit(0) }
        assertThrows(IllegalArgumentException::class.java) { card.deposit(-1) }
        assertThrows(IllegalArgumentException::class.java) { card.deposit(-12) }
    }

    @Test
    fun `Paying 11 when the balance is 12 should set the balance to 1`() {
        val card = DebitCard(12)
        card.pay(11)
        assertEquals(1, card.balance)
    }

    @Test
    fun `Paying 12 when the balance is 12 should set the balance to 0`() {
        val card = DebitCard(12)
        card.pay(12)
        assertEquals(0, card.balance)
    }

    @Test
    fun `Paying 12 when the balance is 13 should throw an InsufficientFundsException`() {
        val card = DebitCard(12)
        assertThrows(InsufficientFundsException::class.java) { card.pay(13) }
    }

    @Test
    fun `Paying a non-positive amount should throw an IllegalArgumentException`() {
        val card = DebitCard(12)
        assertThrows(IllegalArgumentException::class.java) { card.pay(0) }
        assertThrows(IllegalArgumentException::class.java) { card.pay(-1) }
        assertThrows(IllegalArgumentException::class.java) { card.pay(-12) }
    }

    @Test
    fun `Withdrawing 12 when the balance is 12 should set the balance to 0`() {
        val card = DebitCard(12)
        card.withdraw(12)
        assertEquals(0, card.balance)
    }

    @Test
    fun `Withdrawing 12 when the balance is 13 should throw an InsufficientFundsException`() {
        val card = DebitCard(12)
        assertThrows(InsufficientFundsException::class.java) { card.withdraw(13) }
    }

    @Test
    fun `Withdrawing a non-positive amount should throw an IllegalArgumentException`() {
        val card = DebitCard(12)
        assertThrows(IllegalArgumentException::class.java) { card.withdraw(0) }
        assertThrows(IllegalArgumentException::class.java) { card.withdraw(-1) }
        assertThrows(IllegalArgumentException::class.java) { card.withdraw(-12) }
    }
}
