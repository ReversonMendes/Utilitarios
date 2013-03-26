package br.com.reverson.ControleDeTurmas;

import br.com.reverson.utilitarios.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Instituicao {

    private List<Turma> turmas = new ArrayList<Turma>();
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public List<Aluno> getAluno(){
        return alunos;
    }

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

   
    public void addAluno(Aluno al) {
         alunos.add(al);
    }
    public void listarTurmas() {
        Turma t;
        Console.escreverln("------------------------------------");
        Console.escreverln("Código \tDescrição");
        Console.escreverln("------------------------------------");

        for (int nContador = 0; nContador < this.turmas.size(); nContador++) {
            t = this.turmas.get(nContador);
            Console.escreverln(t.getCodigo() + "\t" + t.getDescricao());
        }
    }

    public void listarAlunos() {
        Aluno a;
        Console.escreverln("------------------------------------");
        Console.escreverln("R.A \tNome");
        Console.escreverln("------------------------------------");

        for (int nContador = 0; nContador < this.turmas.size(); nContador++) {
            a = this.alunos.get(nContador);
            Console.escreverln(a.getRa() + "\t" + a.getNome());
        }
    }

}