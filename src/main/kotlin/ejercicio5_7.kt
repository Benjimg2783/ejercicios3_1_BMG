class Coche constructor(
    var color: String,
    val marca: String,
    val modelo: String,
    val numCababallos: Int,
    val numPuertas: Int,
    val matricula: String
) {
    override fun toString(): String {
        println("El coche es $color")
        println("El coche es un $marca $modelo")
        println("El coche tiene $numCababallos y $numPuertas puertas")
        println("La matrícula del coche es $matricula")
        return ""
    }
}

fun main() {
    println("COCHE1")
    val coche1 = Coche("negro mate", "audi", "A4", 204, 2, "5342 AYB")
    println(coche1)
    repeat(80) { print("_") }
    println()

    val coche2 = Coche("Blanco", "Dacia", "Sandero", 90, 5, "6342 CHZ")
    println(coche2)
    repeat(80) { print("_") }
    println()

    val coche3 = Coche("Verde", "Opel", "Astra", 101, 4, "4653 FHT")
    println(coche3)
    println("Dime el nuevo color del coche")
    coche3.color= readLine()!!
    println(coche3)
    repeat(80) { print("_") }
}