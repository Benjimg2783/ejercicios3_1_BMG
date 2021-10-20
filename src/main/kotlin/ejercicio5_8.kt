class Tiempo(val horas:Int,val minutos:Int,val segundos:Int){
    override fun toString(): String {
        return ""
    }
}
fun main(){
    println("Dime la hora")
    val inHoras= readLine()!!.toInt()
    println("Dime los minutos")
    val inMinutos= readLine()!!.toInt()
    println("Dime los segundos")
    val inSegundos= readLine()!!.toInt()
    val tiempo=Tiempo(inHoras,inMinutos,inSegundos)
    println("Dime en que formato quieres que se muentre la hora   horas/horas y minutos/horas minutos y segundos")
    val formato=readLine()!!.uppercase()
    println(tiempo)
}


