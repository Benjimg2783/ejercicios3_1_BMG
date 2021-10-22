class Cuenta(val numCuenta:Int,var saldo:Double){
    fun consultarSaldo():String{
        return "$saldo€"
    }
    fun recibirAbonos(abono:Double):String{
        saldo+=abono
        return "Has recibido $abono€ ahora tu saldo es $saldo€"
    }
    fun realizarPago(pago:Double):String{
        saldo-=pago
        return "Has realizado un pago de $pago€ ahora tu saldo es $saldo€"
    }
}
class Persona(val DNI:String, var vector:Array<Cuenta>){

}
fun main(){
    val cuenta1= Cuenta(545456,1783.98)
    println(cuenta1.realizarPago(345.00))
    println(cuenta1.consultarSaldo())
}