class Cuenta(val numCuenta: String, var saldo: Double = 0.0) {

    fun recibirAbonos(abono: Double): Double {
        saldo += abono
        return saldo
    }

    fun realizarPago(pago: Double): Double {
        saldo -= pago
        return saldo
    }

}

class Persona(val DNI: String) {
    var cuentas: Array<Cuenta> = arrayOf()
    fun incorporar(c: Cuenta) {
        if (cuentas.size < 3) {
            cuentas += c
        }
    }

    fun moroso(): Boolean {
        for (i in 0..2) {
            try {
                if (cuentas[i].saldo < 0) {
                    return true
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
            }
        }
        return false
    }

    fun transferencia(pasa: Cuenta, recibe: Cuenta, transfer: Double) {
        pasa.realizarPago(transfer)
        recibe.recibirAbonos(transfer)
    }
}

fun main() {
    val p = Persona("73458679L")
    val c1 = Cuenta("cuenta1")
    val c2 = Cuenta("Cuenta2", 700.0)
    p.incorporar(c1)
    p.incorporar(c2)
    c1.recibirAbonos(1100.0)
    c2.realizarPago(750.0)
    if (p.moroso()) {
        println("La persona con DNI ${p.DNI} es moroso/a")
    }
    p.transferencia(c1, c2, 100.0)
    println("La cuenta ${c1.numCuenta} tiene actualmente ${c1.saldo}")
    println("La cuenta ${c2.numCuenta} tiene actualmente ${c2.saldo}")
}
