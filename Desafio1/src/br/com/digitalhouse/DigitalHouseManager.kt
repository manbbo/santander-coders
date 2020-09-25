package br.com.digitalhouse

data class DigitalHouseManager (var listaDeAlunos: MutableList<Aluno> = mutableListOf(),
                                var listaDeProfs: MutableList<Professor> = mutableListOf(),
                                var listaDeMatrs: MutableList<Matricula> = mutableListOf(),
                                var listaDeCursos: MutableList<Curso> = mutableListOf()) {

    // metodos de registro
    fun registrarCurso(nome: String, cod : Int, qtMaxAlunos: Int) {
        println("$nome registrado com sucesso!")
        listaDeCursos.add(Curso(nome, cod, qtMaxAlunos))
    }

    fun registrarProfessorAdjunto(nome: String , sobrenome: String ,codigoProfessor: Int, quantidadeDeHoras: Int){
        println("$nome registrado com sucesso!")
        listaDeProfs.add(ProfessorAdjunto(nome, sobrenome, 0, quantidadeDeHoras, codigoProfessor))
    }

    fun registrarProfessorTitular(nome: String , sobrenome: String ,codigoProfessor: Int, especialidade: String){
        println("$nome registrado com sucesso!")
        listaDeProfs.add(ProfessorTitular(nome, sobrenome, 0, especialidade, codigoProfessor))
    }

    fun registrarAluno(nome: String , sobrenome: String, codigoAluno: Int){
        println("$nome registrado com sucesso!")
        listaDeAlunos.add(Aluno(nome, sobrenome, codigoAluno))
    }
    //////////////////////////

    // metodos de alocacao
    fun matricular(codigoAluno: Int, codCurso: Int)  {
        for (a in 0..listaDeAlunos.size-1) {
            if (listaDeAlunos[a].equals(codigoAluno)) {
                println("Aluno encontrado $codigoAluno")
                for (c in 0..listaDeCursos.size-1) {
                    if (listaDeCursos[c].equals(codCurso)) {
                        println("Curso encontrado")
                        if (listaDeCursos[c].addAluno(listaDeAlunos[a])) {
                            listaDeMatrs.add(Matricula(listaDeAlunos[a], listaDeCursos[c]))
                            println("Aluno matriculado com sucesso")
                            return
                        } else {
                            return
                        }
                    }
                }
            }
        }

        println("Aluno ou Curso nao encontrado $codigoAluno")
        return
    }

    fun alocarProf(codCurso: Int, codProfTitular: Int, codProfAdjunto: Int) {

        for (p in 0..listaDeProfs.size-1) {
            if (listaDeProfs[p].equals(codProfAdjunto)) {
                for (c in 0..listaDeCursos.size-1) {
                    if (listaDeCursos[c].equals(codCurso)) {
                        listaDeCursos[c].addProf(listaDeProfs[p] as ProfessorAdjunto)
                        println("Professor $codProfAdjunto cadastrado com sucesso")
                        //return
                    }
                }
            } else if (listaDeProfs[p].equals(codProfTitular)) {
                for (c in 0..listaDeCursos.size-1) {
                    if (listaDeCursos[c].equals(codCurso)) {
                        listaDeCursos[c].addProf(listaDeProfs[p] as ProfessorTitular)
                        println("Professor $codProfTitular cadastrado com sucesso")
                        //return
                    }
                }
            }
        }

        println("Codigo de curso ou de professor nao encontrado")
        return
    }
    //////////////////////////

    //metodos de exclusao
    fun excluirProfessor(codigoProfessor: Int) {
        for (prof in listaDeProfs) {
            if (prof.equals(codigoProfessor)) {
                listaDeProfs.remove(prof);
                return
            }
        }

        println("Codigo nao encontrado")
        return
    }

    fun excluirCurso(codigoCurso: Int) {
        for (curso in listaDeCursos) {
            if (curso.equals(codigoCurso)) {
                listaDeCursos.remove(curso)
                return
            }
        }

        println("Codigo nao encontrado")
        return
    }
    /////////////////////////////////////
}