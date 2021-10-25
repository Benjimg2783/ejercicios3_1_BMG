class Cuenta(val numCuenta: Int, var saldo: Int) {
    fun consultarSaldo(): String {
        return "Tienes $saldo€"
    }

    fun recibirAbonos(abono: Int): String {
        saldo += abono
        return "Has recibido $abono€, ahora tu saldo es $saldo€"
    }

    fun realizarPago(pago: Int): String {
        saldo -= pago
        return "Has realizado un pago de $pago€, ahora tu saldo es $saldo€"
    }

    fun moroso(): Unit {
        if (saldo < 0) {
            println("Tu saldo es negativo debes $saldo€")
        } else {
            println("Tu saldo es positivo, tienes $saldo€")
        }
    }
}

class Persona(val DNI: String, var cuentas: Array<Cuenta?>) {

}

fun main() {
    val persona1 = Persona("75740978H", arrayOfNulls(3))
    persona1.cuentas= listOf<Cuenta>(Cuenta(987766553, 0), Cuenta(726767623, 700)).toTypedArray()

}
