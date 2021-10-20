class Rectangulo(val base: Double, val altura: Double) {
    override fun toString(): String {
        return "la base es:$base y la altura:$altura"
    }

    fun perimetro(): Double {
        return 2 * base + 2 * altura
    }

    fun area(): Double {
        return base * altura
    }
}

fun main() {
    println("RECTÁNGULO 1")
    val rectangulo1 = Rectangulo(5.0, 2.0)
    println(rectangulo1)
    val areaRetangulo1 = rectangulo1.area()
    println("El area es:$areaRetangulo1")
    val perimetroRectangulo1 = rectangulo1.perimetro()
    println("El perímetro es:$perimetroRectangulo1")
    repeat(80) { print("_") }
    println()

    println("RECTÁNGULO 2")
    val rectangulo2 = Rectangulo(5.7, 2.5)
    println(rectangulo2)
    val areaRetangulo2 = rectangulo2.area()
    println("El area es:$areaRetangulo2")
    val perimetroRectangulo2 = rectangulo2.perimetro()
    println("El perímetro es:$perimetroRectangulo2")
    repeat(80) { print("_") }
    println()

    println("RECTÁNGULO 3")
    val rectangulo3 = Rectangulo(15.0, 7.5)
    println(rectangulo3)
    val areaRetangulo3 = rectangulo3.area()
    println("El area es:$areaRetangulo3")
    val perimetroRectangulo3 = rectangulo3.perimetro()
    println("El perímetro es:$perimetroRectangulo3")
    repeat(80) { print("_") }
    println()
    println("FIN DEL PROGRAMA")
}