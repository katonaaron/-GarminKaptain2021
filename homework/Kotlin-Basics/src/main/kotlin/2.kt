/**
 * Models for exercise 2. Test classes can be found int 'src/test/kotlin'
 */

abstract class Card(initialBalance: Int = 0) {
    // To prevent floating point precision errors, the amount is an integer
    // e.g. $12.32 -> 1232
    var balance: Int = initialBalance
        protected set

    open fun pay(amount: Int) {
        checkPositiveAmount(amount)
        balance -= amount
    }

    open fun withdraw(amount: Int) {
        checkPositiveAmount(amount)
        balance -= amount
    }

    open fun deposit(amount: Int) {
        checkPositiveAmount(amount)
        balance += amount
    }

    private fun checkPositiveAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("The amount should be greater than 0. $amount was given")
        }
    }
}

class DebitCard(initialBalance: Int = 0) : Card(initialBalance) {
    override fun pay(amount: Int) {
        checkAmount(amount, "pay")
        super.pay(amount)
    }

    override fun withdraw(amount: Int) {
        checkAmount(amount, "withdraw")
        super.withdraw(amount)
    }

    private fun checkAmount(amount: Int, operation: String) {
        if (balance - amount < 0) {
            throw InsufficientFundsException(
                "Cannot $operation ${amountToString(amount)}. Balance: ${amountToString(balance)}"
            )
        }
    }
}

class CreditCard(val creditLimit: Int, initialBalance: Int = 0) : Card(initialBalance) {
    companion object {
        val rewardPercentage = 5 // 5%

        fun computeReward(amount: Int) = amount * rewardPercentage / 100
    }

    /**
     * Total spendable money
     */
    val funds: Int
        get() = balance + creditLimit

    override fun pay(amount: Int) {
        checkAmount(amount, "pay")
        super.pay(amount)
        balance += computeReward(amount)
    }

    override fun withdraw(amount: Int) {
        checkAmount(amount, "withdraw")
        super.withdraw(amount)
    }

    private fun checkAmount(amount: Int, operation: String) {
        if (funds - amount < 0) {
            throw InsufficientFundsException(
                "Cannot $operation ${amountToString(amount)}. Total funds: ${amountToString(funds)}"
            )
        }
    }
}

// Exceptions

class InsufficientFundsException(message: String) : Exception(message)

// Helper

fun amountToString(amount: Int) = "$${amount / 100}.${amount % 100}"
