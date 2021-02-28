import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

internal class IdTest {

    @org.junit.jupiter.api.Test
    fun getId() {
        val idLib = Id(101)
        (0..100).forEach {
            idLib.getSpecificId(it)
        }

        val result = idLib.getId()
        assertTrue(result is Result.ERROR)
        assertEquals("All ids are gone.", (result as Result.ERROR).errorMessage)


        val idLib2 = Id(101)
        (0..99).forEach {
            idLib2.getSpecificId(it)
        }

        val result2 = idLib2.getId()
        assertTrue(result2 is Result.SUCCESS)
        assertEquals(100, (result2 as Result.SUCCESS).id)

        val result3 = idLib2.getSpecificId(100)
        assertTrue(result3 is Result.ERROR)
        assertEquals("Id 100 is gone.", (result3 as Result.ERROR).errorMessage)
    }

    @org.junit.jupiter.api.Test
    fun getSpecificId() {
        val idLib = Id(101)

        val result = idLib.getSpecificId(33)
        assertTrue(result is Result.SUCCESS)
        assertEquals(33, (result as Result.SUCCESS).id)

        val result2 = idLib.getSpecificId(33)
        assertTrue(result2 is Result.ERROR)
        assertEquals("Id 33 is gone.", (result2 as Result.ERROR).errorMessage)

        val result3 = idLib.getSpecificId(133)
        assertTrue(result3 is Result.ERROR)
        assertEquals("Id 133 is not in 0..100.", (result3 as Result.ERROR).errorMessage)
    }

    @org.junit.jupiter.api.Test
    fun returnId() {
        val idLib = Id(101)
        idLib.getSpecificId(55)

        val result = idLib.returnId(55)
        assertTrue(result is Result.SUCCESS)
        assertEquals(55, (result as Result.SUCCESS).id)

        val result2 = idLib.returnId(66)
        assertTrue(result2 is Result.ERROR)
        assertEquals("Id 66 already exists.", (result2 as Result.ERROR).errorMessage)

        val result3 = idLib.returnId(166)
        assertTrue(result3 is Result.ERROR)
        assertEquals("Id 166 is not in 0..100.", (result3 as Result.ERROR).errorMessage)
    }
}