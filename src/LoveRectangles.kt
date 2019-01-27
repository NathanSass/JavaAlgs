import kotlin.math.absoluteValue

fun main(args: Array<String>) {
    findOverlapTest()

    val rect1 = Rectangle(0,0,10,5)
    val rect2 = Rectangle(7,3,6,4)
    val overlap1 = findIntersectedRectangle(rect1, rect2)
    val expected1 = Rectangle(7,3,3,2)
    println("overlapping result: " + (overlap1 == expected1))

    val rect3 = Rectangle(0,0, 10, 10)
    val rect4 = Rectangle(5,5,5,5)
    val overlap2 = findIntersectedRectangle(rect3, rect4)
    println("rectangle inside another: " + (overlap2 == rect4))
}


data class Rectangle(val leftX: Int, val bottomY: Int, val width: Int, val height: Int)

data class Line(val start: Int, val size: Int)

fun findIntersectedRectangle(rect1 : Rectangle, rect2: Rectangle) : Rectangle {
    val xOverlap = findOverlap(
            Line(rect1.leftX, rect1.width),
            Line(rect2.leftX, rect1.width))

    val yOverlap = findOverlap(
            Line(rect1.bottomY, rect1.height),
            Line(rect2.bottomY, rect2.height))

    return Rectangle(xOverlap.start, yOverlap.start, xOverlap.size, yOverlap.size)
}

fun findOverlap(firstPoint: Line,
                secondPoint: Line) :Line{
    if (firstPoint.start == secondPoint.start) {
        return Line(firstPoint.start, (firstPoint.size - secondPoint.size).absoluteValue)
    }

    val highestStartPoint = Math.max(firstPoint.start, secondPoint.start)
    val lowestEndPoint = Math.min(firstPoint.start + firstPoint.size, secondPoint.start + secondPoint.size)
    val overlapWidth = lowestEndPoint - highestStartPoint

    return Line(highestStartPoint, overlapWidth)
}

fun findOverlapTest() {
    val test1 = Line(7, 8)
    val test2 = Line(0, 10)
    println(findOverlap(test1, test2) == Line(7,3))

    val test3 = Line(0, 10)
    val test4 = Line(5, 10)
    println(findOverlap(test3, test4) == Line(5, 5))
}