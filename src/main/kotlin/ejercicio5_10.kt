class Libro(val titulo: String, val autor: String, val numpag: Int, calificacion: Int) {
    var calif: Int = calificacion
        set(value) {
            if (value in 0..10) field = value
            else throw IndexOutOfBoundsException("La calificación debe estar entre 0 y 10")
        }

    init {
        require(calif in 0..10) { "La calificación debe estar entre 0 y 10" }
    }

    override fun toString(): String {
        return "\"$titulo\", escrito por \"$autor\""
    }

}

class ConjuntoLibros(tamanyo: Int) {
    private val size = tamanyo
    var libros = arrayOfNulls<Libro>(size)

    fun add(libro: Libro): String {
        return if (libro !in libros) {
            var counter = 0
            while (counter in 0 until size) {
                if (libros[counter] == null) {
                    libros[counter] = libro
                    counter = size
                } else counter++
            }
            "El libro $libro ha sido añadido."
        } else "El libro $libro ya había sido añadido anteriormente."
    }

    fun almacenados(): Int {
        var cantidad = 0
        for (i in 0 until size) {
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
        return if (cantidadinicial != almacenados()) "El libro \"$titulo\" ha sido eliminado con éxito."
        else "El libro \"$titulo\" no se ha encontrado entre la lista."
    }

    fun borrarAutor(autor: String): String {
        val cantidadinicial = almacenados()
        for (i in 0 until size) {
            if (libros[i]?.autor == autor) libros[i] = null
        }
        return if (cantidadinicial != almacenados()) "Se ha eliminado ${cantidadinicial - almacenados()} libro(s) del autor \"$autor\" con éxito."
        else "No se encontró \"$autor\" entre los autores."
    }

    override fun toString(): String {
        val listapos = mutableListOf<Int>()
        var listalibros = "Libros almacenados:"
        return if (almacenados() > 0) {
            for (i in 0 until size) {
                if (libros[i] != null) listapos.add(i)
            }
            for (i in 0 until listapos.size) {
                listalibros += "\n- ${libros[listapos[i]]}."
            }
            listalibros
        } else "No hay libros almacenados"
    }

}


fun main() {
    val libreria = ConjuntoLibros(10)
    val libro = Libro("Harry potter y la piedra filosofal", "J.K. Rowling", 256, 10)
    val libro2 = Libro("El bosón de higgs no te va a hacer la cama", "Javier Santaolalla", 372, 7)

    println(libreria.add(libro))
    println(libreria.add(libro2))
    println(libreria.borrar("Harry potter y la piedra filosofal"))
    println(libreria.borrarAutor("Javier Santaolalla"))
    println(libreria.add(libro))
    println(libreria)
}