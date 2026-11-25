// Clase para gestionar a los alumnos

class GestorAlumnos {

    // Para almacenar a los alumnos
    private val alumnos = mutableListOf<Alumno>()


    // Clase para registrar alumno

    fun registrarAlumno() {

        print("Introduce el nombre: ")
        // Lee el nombre y elimina espacios en blanco
        val nombre = readln().trim()

        if (nombre.isEmpty()) {
            println("El nombre no puede estar vacío.")
            return
        }

        print("Introduce los apellidos: ")
        val apellidos = readln().trim()

        if (apellidos.isEmpty()) {
            println("Los apellidos no pueden estar vacíos.")
            return
        }

        print("Introduce la nota final: ")
        // lee la nota y convierte a Double, sino devuelve null.
        val nota = readln().toDoubleOrNull()

        if (nota == null || nota < 0 || nota > 10) {
            println("La nota debe estar entre 0 y 10.")
            return
        }

        alumnos.add(
            Alumno(
                nombre,
                apellidos,
                nota
            )
        )

        println("Alumno registrado correctamente.")
    }

   // Aquí es donde se le pide al usuario que escriba el nombre, apellidos y nota y se creará un objeto "Alumno" con esos datos.
    fun listarAlumnos() {

        if (alumnos.isEmpty()) {
            println("No hay alumnos registrados.")
            return
        }

        println("===== LISTADO DE ALUMNOS =====")

        for ((indice, alumno) in alumnos.withIndex()) {
            println(
                "${indice + 1}. ${alumno.nombre} ${alumno.apellidos} - Nota: ${alumno.nota}"
            )
        }
    }

   // Función para calcular la media de los alumnos registrados.
    fun calcularMedia(): Double {

        // Este "if" es para verificar si hay alumnos.
        if (alumnos.isEmpty()) {
            // devolverá -1.0 si no hay alumnos registrados.
            return -1.0
        }

        var suma = 0.0

       // Este "for" recorre la lista de alumnos, luego suma las notas y al final divide la suma para obtener la media.
        for (alumno in alumnos) {
            suma += alumno.nota
        }

       // Devuelve la media de las notas de los alumnos.
        return suma / alumnos.size
    }

    // Mostrar la media de los alumnos.
    fun mostrarMedia() {

        // Este "if" es para verificar si hay alumnos.
        if (alumnos.isEmpty()) {
            println("No hay alumnos registrados.")
            return
        }

        println(
            "La media del grupo es: %.2f".format(calcularMedia())
        )
    }

    // Muestra los alumons aprobados.
    fun mostrarAprobados() {

        // variable que si la nota es mayor o igual a 5, se considera como aprobado.
        val aprobados = alumnos.filter {
            // Tiene que tener una nota mayor o igual a 5.
            it.nota >= 5
        }

        if (aprobados.isEmpty()) {
            println("No hay alumnos aprobados.")
            return
        }

        println("===== ALUMNOS APROBADOS =====")

        // Aquí se muestra la lista de alumnos aprobados.
        for (alumno in aprobados) {
            println(
                "${alumno.nombre} ${alumno.apellidos} - Nota: ${alumno.nota}"
            )
        }
    }


    // Muestra los alumnos que esten suspendidos.
    fun mostrarSuspensos() {

        // variable que si la nota es menor a 5, se considera en suspendido.
        val suspensos = alumnos.filter {
            // Al tener una nota menor a 5 estará en suspensos.
            it.nota < 5
        }

        if (suspensos.isEmpty()) {
            println("No hay alumnos suspensos.")
            return
        }

        println("===== ALUMNOS SUSPENSOS =====")

        for (alumno in suspensos) {
            println(
                "${alumno.nombre} ${alumno.apellidos} - Nota: ${alumno.nota}"
            )
        }
    }

    // Función para buscar un alumno.
    fun buscarAlumno() {

        print("Introduce el texto a buscar: ")
        val texto = readln().trim().lowercase()

        val resultados = alumnos.filter {

            it.nombre.lowercase().contains(texto)
                    ||
                    it.apellidos.lowercase().contains(texto)

        }

        if (resultados.isEmpty()) {
            println("No se han encontrado alumnos con ese criterio.")
            return
        }

        println("===== RESULTADOS =====")

        for (alumno in resultados) {
            println(
                "${alumno.nombre} ${alumno.apellidos} - Nota: ${alumno.nota}"
            )
        }
    }

    // Función para eliminar un alumno.
    fun eliminarAlumno() {

        if (alumnos.isEmpty()) {
            println("No hay alumnos registrados.")
            return
        }

        listarAlumnos()

        print("Introduce el número del alumno a eliminar: ")

        val posicion = readln().toIntOrNull()

        // Este "if" es para verificar si la posición es válida.
        if (posicion == null ||
            posicion < 1 ||
            posicion > alumnos.size
        ) {
            println("Alumno inexistente.")
            return
        }

        // Aquí elimará el alumno, restando 1 a la posición.
        alumnos.removeAt(posicion - 1)

        println("Alumno eliminado correctamente.")
    }
}