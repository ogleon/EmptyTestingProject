import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.time.Duration
import java.util.concurrent.TimeoutException

internal class CalculatorTests {

    @Nested
    @DisplayName("Sum operand & Timeout")
    inner class SumOperand {

        var calc : Calculator? = null

        @BeforeEach
        fun beforeEach() {
            calc = Calculator()
        }

        @AfterEach()
        fun afterEach() {
            calc = null
        }

        @Test
        fun `1 + 1 = 2`() {
            assertEquals(2, calc!!.add(1, 1), "1 + 1 should equal 2")
        }

        @Test
        fun timeOutTest() {
            assertTimeout(Duration.ofMillis(500)) { calc!!.divide(1, 0) }
        }
    }

    @Nested
    @DisplayName("Division & Multiplication")
    inner class DivAndMultiOperands {

        var calc : Calculator? = null

        @BeforeEach
        fun beforeEach() {
            calc = Calculator()
        }

        @AfterEach()
        fun afterEach() {
            calc = null
        }

        @Test
        fun `division by zero should return AssertionException`() {
            val exception = assertThrows<AssertionError> { calc!!.divide(1, 0) }
            assertEquals("Division by Zero.", exception.message)
        }

        @Test
        fun `multi with parser of 2 by 2 = 4`() {
            val result = calc!!.parse("2 * 2")
            assertEquals(4, result)
        }

        @Disabled
        @Test
        fun `multi with parser and more than space in input should fail`() {
            val exception = assertThrows<IllegalArgumentException> { calc!!.parse("2  * 2") }
            assertEquals("error: Invalid operator.", exception.message)
        }
    }


}