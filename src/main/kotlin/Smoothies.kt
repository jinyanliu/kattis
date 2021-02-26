fun main() {

}

class Smoothies {
    private val allIngres =
        listOf(Smoothie.APPLE.ingredients, Smoothie.PEAR.ingredients, Smoothie.WATERMELON.ingredients)
            .flatten().distinct()

    private fun makeOrder(
        smoothie: Smoothie,
        addOn: String? = null,
        remove: String? = null
    ): OrderStatus {
        val currentIngredients = smoothie.ingredients.toMutableList()
        if (addOn != null) {
            if (!allIngres.contains(addOn)) {
                return OrderStatus.Failed("Sorry, we don't have ingredient $addOn.")
            } else {
                currentIngredients.add(addOn)
            }
        }
        if (remove != null) {
            if (allIngres.contains(remove)) {
                currentIngredients.remove(addOn)
            }
        }
        return OrderStatus.Confirmed(smoothie, currentIngredients)
    }
}

enum class Smoothie(val ingredients: List<String>) {
    APPLE(listOf("apple", "sugar", "beer", "water")),
    PEAR(listOf("pear", "peach", "peanuts", "cola")),
    WATERMELON(listOf("watermelon", "banana", "spenat", "cookie"))
}

sealed class OrderStatus {
    class Confirmed(val smoothie: Smoothie, val ingredients: List<String>) : OrderStatus()
    class Failed(val message: String) : OrderStatus()
}

