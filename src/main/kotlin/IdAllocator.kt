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
            return Error("All ids are gone.")
        }

        val returnId = currentAvailableIds.removeFirst()
        booleanArray[returnId] = false
        return Success(returnId)
    }

    internal fun getSpecificId(id: Int): Result {
        if (id < 0 || id >= size) {
            return Error("Id $id is not in 0..${size - 1}.")
        }
        return when (booleanArray[id]) {
            true -> {
                currentAvailableIds.remove(id)
                booleanArray[id] = false
                Success(id)
            }
            false -> Error("Id $id is gone.")
        }
    }

    fun returnId(id: Int): Result {
        if (id < 0 || id >= size) {
            return Error("Id $id is not in 0..${size - 1}.")
        }
        return when (booleanArray[id]) {
            false -> {
                currentAvailableIds.add(id)
                booleanArray[id] = true
                Success(id)
            }
            true -> Error("Id $id already exists.")
        }
    }
}

sealed class Result 
class Error(val errorMessage: String) : Result()
class Success(val id: Int) : Result()

