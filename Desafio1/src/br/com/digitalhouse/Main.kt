package br.com.digitalhouse

fun main() {
    var digitalHouseManager = DigitalHouseManager()

    println("------Cadastro dos professores")
    digitalHouseManager.registrarProfessorTitular("Jefferson", "Briola", 0, "Tecnico")
    digitalHouseManager.registrarProfessorAdjunto("Anderson", "Briola", 1, 8)
    digitalHouseManager.registrarProfessorTitular("Wagnerson", "Briola", 2, "Tecnico")
    digitalHouseManager.registrarProfessorAdjunto("Vanesserson", "Briola", 3, 8)

    println("\n\n------Cadastro dos Cursos")
    digitalHouseManager.registrarCurso("Fullstack", 20001, 3)
    digitalHouseManager.registrarCurso("Android", 20002, 2)

    println("\n\n------Alocação dos Profs")
    digitalHouseManager.alocarProf(20001, 0, 1)
    digitalHouseManager.alocarProf(20002, 2, 3)


    println("\n\n------Registro dos Alunos")
    digitalHouseManager.registrarAluno("Alinerson", "Briola", 0)
    digitalHouseManager.registrarAluno("Brunerson", "Briola", 1)
    digitalHouseManager.registrarAluno("Carolineson", "Briola", 2)
    digitalHouseManager.registrarAluno("Danielson", "Briola", 3)
    digitalHouseManager.registrarAluno("Ednilson", "Briola", 4)

    println("\n\n------Matricula dos Alunos")
    digitalHouseManager.matricular(0, 20001)
    digitalHouseManager.matricular(1, 20001)
    digitalHouseManager.matricular(2, 20002)
    digitalHouseManager.matricular(3, 20002)
    digitalHouseManager.matricular(4, 20002)

    println("\n\n------Consultar Matricula dos Alunos")
    digitalHouseManager.consultarCadastro(0)
    digitalHouseManager.consultarCadastro(1)
    digitalHouseManager.consultarCadastro(2)
    digitalHouseManager.consultarCadastro(3)
    digitalHouseManager.consultarCadastro(4)
    //digitalHouseManager.consultarCadastro(0)
}