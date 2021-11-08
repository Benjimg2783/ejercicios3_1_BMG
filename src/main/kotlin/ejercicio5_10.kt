class Libro(val titulo: String, val autor: String, var calificacion: Int) {
    init {
        require(calificacion in 0..10) { "La calificación debe estar entre 0 y 10" }
    }

    override fun toString(): String {
        return "\"$titulo\", escrito por \"$autor\""
    }

}

class ConjuntoLibros(tamanyo: Int) {
    val size = tamanyo
    var libros = arrayOfNulls<Libro>(size)

    fun anyadir(libro: Libro): String {
        if (libro !in libros) {
            var counter = 0
            while (counter in 0 until size) {
                if (libros[counter] == null) {
                    libros[counter] = libro
                    counter = size
                } else counter++
            }
            return "El libro $libro ha sido añadido."
        } else return "El libro $libro ya ha sido añadido."
    }

    fun almacenados(): Int {
        var cantidad = 0
        for (i in 0 until  size) {
            if (libros[i] != null) cantidad++
        }
        return cantidad
    }

    fun borrar(titulo: String): String {
        val cantidadinicial = almacenados()
        var contador = 0
        while (contador in 0 until size) {
            if (libros[contador]?.titulo == titulo) {
                libros[contador] = null
                contador = size
            } else contador++
        }
        if (cantidadinicial != almacenados())
            return "El libro \"$titulo\" ha sido eliminado."
        else return "El libro \"$titulo\" no se ha encontrado."
    }

    fun borrarAutor(autor: String): String {
        val cantidadinicial = almacenados()
        for (i in 0 until size) {
            if (libros[i]?.autor == autor) libros[i] = null
        }
        if (cantidadinicial != almacenados())
            return "Se ha eliminado ${cantidadinicial - almacenados()} libros del autor \"$autor\"."
        else return "No se encontró \"$autor\" entre los autores."
    }

    override fun toString(): String {
        val posicionLista = mutableListOf<Int>()
        var listalibros = "Libros almacenados:"
        if (almacenados() > 0) {
            for (i in 0 until  size) {
                if (libros[i] != null) posicionLista.add(i)
            }
            for (i in 0 until posicionLista.size) {
                listalibros += "\n- ${libros[posicionLista[i]]}."
            }
            return listalibros
        } else return "No hay libros almacenados"
    }

}


fun main() {
    val libreria = ConjuntoLibros(10)
    val libro = Libro("Harry potter y la piedra filosofal", "J.K. Rowling", 10)
    val libro2 = Libro("El bosón de higgs no te va a hacer la cama", "Javier Santaolalla", 7)

    println(libreria.anyadir(libro))
    println(libreria.anyadir(libro2))
    println(libreria.borrar("Harry potter y la piedra filosofal"))
    println(libreria.borrarAutor("Javier Santaolalla"))
    println(libreria.anyadir(libro))
    println(libreria)
}