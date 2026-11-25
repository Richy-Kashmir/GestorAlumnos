class Menu {

    private val gestor = GestorAlumnos()

    fun iniciar() {

        var opcion: Int

        do {

            // El menú donde mostrará las opciones
            println("===== GESTOR DE ALUMNOS =====")
            println("1. Registrar alumno")
            println("2. Listar alumnos")
            println("3. Calcular media del grupo")
            println("4. Mostrar aprobados")
            println("5. Mostrar suspensos")
            println("6. Buscar alumno")
            println("7. Eliminar alumno")
            println("0. Salir")
            print("Seleccione una opción: ")

            opcion = readln().toIntOrNull() ?: 0

            // When encargado de ejecutar cada opción del menú

            when (opcion) {
                1 -> gestor.registrarAlumno()
                2 -> gestor.listarAlumnos()
                3 -> gestor.mostrarMedia()
                4 -> gestor.mostrarAprobados()
                5 -> gestor.mostrarSuspensos()
                6 -> gestor.buscarAlumno()
                7 -> gestor.eliminarAlumno()
                0 -> println("¡Ciao!.")
                else -> println("Opción no es correcta.")
            }

        } while (opcion != 0)
    }
}