import kotlin.Comparable

fun main() {
    val points = Array(readInt()) { Point(readInt(), readInt()) }
    points.sort()
    val sb = StringBuilder()
    for (point in points) {
        sb.append(point.x).append(' ').append(point.y).append('\n')
    }
    print(sb)
}

private fun readInt(): Int {
    var value = 0
    var negative = false
    var input: Int
    while (true) {
        input = System.`in`.read()
        when (input) {
            10, 32 -> return if (negative) -value else value
            45 -> negative = true
            else -> value = value * 10 + (input - 48)
        }
    }
}

data class Point(
    val x: Int,
    val y: Int
) : Comparable<Point> {

    override fun compareTo(other: Point) = if (x == other.x) y - other.y else x - other.x

}
