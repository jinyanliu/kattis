import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.xml.bind.JAXBElement
import kotlin.coroutines.coroutineContext

fun main() {
}

class Id(private val size: Int) {
    //true: this id is available, false: this id is not available
    private val booleanArray = BooleanArray(size)
    private val currentAvailableIds = ArrayDeque<Int>()

    init {
        (0 until size).forEach {
            booleanArray[it] = true
        }
        currentAvailableIds.addAll(booleanArray.indices)
    }

    fun getId(): Result {
/*        GlobalScope.launch {
            Mutex().withLock{

            }
        }*/
        if (currentAvailableIds.isEmpty()) {
            return Result.ERROR("All ids are gone.")
        }

        val returnId = currentAvailableIds.removeFirst()
        booleanArray[returnId] = false
        return Result.SUCCESS(returnId)
    }

    internal fun getSpecificId(id: Int): Result {
        if (id < 0 || id >= size) {
            return Result.ERROR("Id $id is not in 0..${size - 1}.")
        }
        return when (booleanArray[id]) {
            true -> {
                currentAvailableIds.remove(id)
                booleanArray[id] = false
                Result.SUCCESS(id)
            }
            false -> Result.ERROR("Id $id is gone.")
        }
    }

    fun returnId(id: Int): Result {
        if (id < 0 || id >= size) {
            return Result.ERROR("Id $id is not in 0..${size - 1}.")
        }
        return when (booleanArray[id]) {
            false -> {
                currentAvailableIds.add(id)
                booleanArray[id] = true
                Result.SUCCESS(id)
            }
            true -> Result.ERROR("Id $id already exists.")
        }
    }
}

sealed class Result {
    class ERROR(val errorMessage: String) : Result()
    class SUCCESS(val id: Int) : Result()
}
