import kotlin.concurrent.thread

/**
 * @author Leon Matte
 *
 * Simple class with calculation functions.
 */
class Calculator {

    /**
     * This method has only implemented the multiplication functionality but can be used to add different operations within the same function.
     * @param s this string input is split into three different parts: the first would correspond the first value, the second would be the operand and the last one corresponds to the second value.
     * @exception IllegalArgumentException
     */
    fun parse(s : String) : Int {
        val (a, op, b) =  s.split(" ")
        return when (op) {
            "*" -> a.toInt() * b.toInt()
            else -> throw IllegalArgumentException("error: Invalid operator.")
        }
    }

    /**
     * This function adds up the two given values passed as parameters.
     * @param a first value given
     * @param b second value given
     */
    fun add(a: Int, b: Int) : Int {
        return a + b
    }

    /**
     * This function divides the two given values passed as parameters.
     * @param a first value
     * @param b second value
     * @exception ArithmeticException
     */
    fun divide(a: Int, b: Int) : Int {
        assert(b != 0) { "Division by Zero." }
        return a / b * 1
    }

    /**
     * This function multiplies the two given values passed as parameters.
     * @param a first value
     * @param b second value
     */
    fun multiplication(a: Int, b :Int) : Int {
        return a * b
    }

    fun timeOutMethodSimulation() {
        Thread.sleep(1000)
    }
}