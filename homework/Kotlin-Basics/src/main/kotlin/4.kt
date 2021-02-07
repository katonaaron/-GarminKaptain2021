data class Rectangle(val x: Int, val y: Int, val w: Int, val h: Int)

class Paint {
    var color: Long = 0x00FF00
    var strokeWidth: Int = 5
    fun drawRectangle(rect: Rectangle) {
        println("Drawing $rect color: $color stroke: $strokeWidth")
    }
}

fun render(paint: Paint?, rectangles: List<Rectangle?>) {
    paint?.run {
        color = 0xFF0000
        rectangles.filterNotNull().forEach { drawRectangle(it) }
    }
}


// Test
fun main() {
    val rectangles = listOf(
        Rectangle(1, 2, 3, 4),
        Rectangle(4, 5, 6, 7)
    )
    val paint = Paint()

    println("#1")
    render(paint, rectangles)
    println("#2")
    render(null, rectangles)
    println("#3")
    render(paint, rectangles + listOf(null, null))
}

