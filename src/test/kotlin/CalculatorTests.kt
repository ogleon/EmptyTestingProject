import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayNameGeneration
import org.junit.jupiter.api.DisplayNameGenerator
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTests {


        @Test
        fun `1 + 1 = 2`() {
            assertEquals(2, Calculator().add(1,1), "1 + 1 should equal 2")
        }

        @Test
        fun `division by zero should return AssertionException`() {
            val exception = assertThrows<AssertionError> { Calculator().divide(1, 0) }
            assertEquals("Division by Zero.", exception.message)
        }


    @Test
    fun `multi with parser of 2 by 2 = 4`() {
        val result = Calculator().parse("2 * 2")
        assertEquals(4, result)
    }

    @Test
    fun `multi with parser and more than space in input should fail`() {
        val result = Calculator().parse("2  * 2")
        assertEquals(4, result)
    }
}