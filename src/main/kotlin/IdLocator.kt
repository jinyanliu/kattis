fun main() {
}

class Id {
    //true: this id is available, false: this id is not available
    private val idsMap = mutableMapOf<Int, Boolean>()

    init {
        (0..100).forEach {
            idsMap[it] = true
        }
    }

    fun getId(): Result {
        if (!idsMap.any { it.value }) {
            return Result.ERROR("All ids are gone.")
        }

        val firstAvailableId = idsMap.asSequence().first { it.value }.key
        idsMap[firstAvailableId] = false
        return Result.SUCCESS(firstAvailableId)
    }

    fun getSpecificId(id: Int): Result {
        return when (idsMap[id]) {
            true -> {
                idsMap[id] = false
                Result.SUCCESS(id)
            }
            false -> Result.ERROR("Id $id is gone.")
            null -> Result.ERROR("Id $id is not in 0..100.")
        }
    }

    fun returnId(id: Int): Result {
        return when (idsMap[id]) {
            false -> {
                idsMap[id] = true
                Result.SUCCESS(id)
            }
            true -> Result.ERROR("Id $id already exists.")
            null -> Result.ERROR("Id $id is not in 0..100.")
        }
    }
}

sealed class Result {
    class ERROR(val errorMessage: String) : Result()
    class SUCCESS(val id: Int) : Result()
}
