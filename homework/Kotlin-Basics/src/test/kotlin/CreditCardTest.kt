import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CreditCardTest {

    @Test
    fun `Single parameter constructor should set the balance to 0`() {
        val card = CreditCard(12)
        assertEquals(0, card.balance)
    }

    @Test
    fun `Constructor with 12 credit limit and 0 balance should set the total funds to 12`() {
        val card = CreditCard(12)
        assertEquals(12, card.funds)
    }

    @Test
    fun `Constructor with 12 credit limit and 13 balance should set the balance to 13`() {
        val card = CreditCard(12, 13)
        assertEquals(13, card.balance)
    }

    @Test
    fun `Constructor with 12 credit limit and 13 balance should set the total funds to 25`() {
        val card = CreditCard(12, 13)
        assertEquals(25, card.funds)
    }

    @Test
    fun `Depositing 2 when the balance is 12 should result in the balance 14`() {
        val card = CreditCard(0, 12)
        card.deposit(2)
        assertEquals(14, card.balance)
    }

    @Test
    fun `Depositing a non-positive amount should throw an IllegalArgumentException`() {
        val card = CreditCard(0, 12)
        assertThrows(IllegalArgumentException::class.java) { card.deposit(0) }
        assertThrows(IllegalArgumentException::class.java) { card.deposit(-1) }
        assertThrows(IllegalArgumentException::class.java) { card.deposit(-12) }
    }

    @Test
    fun `Paying 11 when the balance is 12 should set the balance to 1`() {
        val card = CreditCard(0, 12)
        card.pay(11)
        assertEquals(1, card.balance)
    }

    @Test
    fun `Paying 12 when the balance is 12 should set the balance to 0`() {
        val card = CreditCard(0, 12)
        card.pay(12)
        assertEquals(0, card.balance)
    }

    @Test
    fun `Paying 12 when the balance is 13 and the credit limit is 0 should throw an InsufficientFundsException`() {
        val card = CreditCard(0, 12)
        assertThrows(InsufficientFundsException::class.java) { card.pay(13) }
    }

    @Test
    fun `Paying 12 when the balance is 23 and the credit limit is 10 should throw an InsufficientFundsException`() {
        val card = CreditCard(10, 12)
        assertThrows(InsufficientFundsException::class.java) { card.pay(23) }
    }

    @Test
    fun `Paying 12 when the balance is 13 and the credit limit is 10 should set the balance to -1 and the founds to 9`() {
        val card = CreditCard(10, 12)
        card.pay(13)
        assertEquals(-1, card.balance)
        assertEquals(9, card.funds)
    }

    @Test
    fun `Paying 120 when the balance is 200 and the credit limit is 0 should set the balance to 86 and the founds to 86`() {
        val card = CreditCard(0, 200)
        card.pay(120)
        assertEquals(86, card.balance)
        assertEquals(86, card.funds)
    }

    @Test
    fun `Paying 120 when the balance is 100 and the credit limit is 20 should set the balance to -14 and the founds to 6`() {
        val card = CreditCard(20, 100)
        card.pay(120)
        assertEquals(-14, card.balance)
        assertEquals(6, card.funds)
    }

    @Test
    fun `Paying a non-positive amount should throw an IllegalArgumentException`() {
        val card = CreditCard(0, 12)
        assertThrows(IllegalArgumentException::class.java) { card.pay(0) }
        assertThrows(IllegalArgumentException::class.java) { card.pay(-1) }
        assertThrows(IllegalArgumentException::class.java) { card.pay(-12) }
    }


    @Test
    fun `Withdrawing 11 when the balance is 12 should set the balance to 1`() {
        val card = CreditCard(0, 12)
        card.withdraw(11)
        assertEquals(1, card.balance)
    }

    @Test
    fun `Withdrawing 12 when the balance is 12 should set the balance to 0`() {
        val card = CreditCard(0, 12)
        card.withdraw(12)
        assertEquals(0, card.balance)
    }

    @Test
    fun `Withdrawing 12 when the balance is 13 and the credit limit is 0 should throw an InsufficientFundsException`() {
        val card = CreditCard(0, 12)
        assertThrows(InsufficientFundsException::class.java) { card.withdraw(13) }
    }

    @Test
    fun `Withdrawing 12 when the balance is 23 and the credit limit is 10 should throw an InsufficientFundsException`() {
        val card = CreditCard(10, 12)
        assertThrows(InsufficientFundsException::class.java) { card.withdraw(23) }
    }

    @Test
    fun `Withdrawing 12 when the balance is 13 and the credit limit is 10 should set the balance to -1 and the founds to 9`() {
        val card = CreditCard(10, 12)
        card.withdraw(13)
        assertEquals(-1, card.balance)
        assertEquals(9, card.funds)
    }

    @Test
    fun `Withdrawing 120 when the balance is 200 and the credit limit is 0 should set the balance to 80 and the founds to 80`() {
        val card = CreditCard(0, 200)
        card.withdraw(120)
        assertEquals(80, card.balance)
        assertEquals(80, card.funds)
    }

    @Test
    fun `Withdrawing 120 when the balance is 100 and the credit limit is 20 should set the balance to -20 and the founds to 0`() {
        val card = CreditCard(20, 100)
        card.withdraw(120)
        assertEquals(-20, card.balance)
        assertEquals(0, card.funds)
    }

    @Test
    fun `Withdrawing a non-positive amount should throw an IllegalArgumentException`() {
        val card = CreditCard(0, 12)
        assertThrows(IllegalArgumentException::class.java) { card.withdraw(0) }
        assertThrows(IllegalArgumentException::class.java) { card.withdraw(-1) }
        assertThrows(IllegalArgumentException::class.java) { card.withdraw(-12) }
    }


    @Test
    fun `Depositing 3 when the balance is -2 should result in the balance 3`() {
        val card = CreditCard(2, 12)
        card.withdraw(14)
        assertEquals(-2, card.balance)
        card.deposit(3)
        assertEquals(1, card.balance)
    }
}
