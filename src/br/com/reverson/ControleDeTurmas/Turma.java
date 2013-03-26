package br.com.reverson.ControleDeTurmas;

import br.com.reverson.utilitarios.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Turma {
    //Variaveis de atributos da turma

    private int codigo;
    private String descricao;
    //Classe Alunos é uma variaveis com seus repectivos atributos
    private ArrayList<Aluno> alunos;

    //construtor de turmas 
    public Turma(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
        alunos = new ArrayList<Aluno>();
    }

    //Geracao de getter e Setter da turma
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void matricula(Aluno al) {
        alunos.add(al);
        al.setTurma(this);
    }

//Operacao Setar Notas do Aluno
    public void setarNotas(Aluno aluno) {
        
        Console.escrever("Digite A nota G1 do aluno :");
        aluno.setNotaG1(Console.lerFloat());
        
        Console.escrever("Digite A nota G2 do aluno :");
        aluno.setNotaG2(Console.lerFloat());

    }

    //Operacao Quantidade de Alunos
    public int quantidadeAlunos() {
        return alunos.size();
    }

    //Operacao Quantidade de Alunos Aprovados
    public int quantidadeAlunosAprovados() {
        int quantidade = 0;
        for (int x = 0; x < alunos.size(); x++) {
            //BUSCA O ALUNOS DETERMINADO NA POSICAO X
            Aluno aluno;
            aluno = alunos.get(x);
            //SE A MÉDIA DESSE ALUMOS FOR MAIOR QUE 6 ESTA APROVADO
            if (aluno.calcularMedia() > 7) {
                quantidade++;
            }
        }
        return quantidade;
    }

    //Operacao Quantidade de Alunos Reprovados
    public int quantidadeAlunosReprovados() {
        int quantidade = 0;
        for (int x = 0; x < alunos.size(); x++) {
            //BUSCA O ALUNOS DETERMINADO NA POSICAO X
            Aluno aluno;
            aluno = alunos.get(x);
            //SE A MÉDIA DESSE ALUMOS FOR MENOR QUE 6 ESTA REPROVADO
            if (aluno.calcularMedia() < 7) {
                quantidade++;
            }
        }
        return quantidade;
    }

//Operacao Porcentagem de ALuno Aprovados
    public float porcentagemAlunoAprovados() {
        float porcentagem;
        int quantidade;

        quantidade = alunos.size();

        porcentagem = (quantidade / 100) * this.quantidadeAlunosAprovados();
        return porcentagem;

    }

    //Operacao Porcentagem de ALuno Reprovados
    public float porcentagemAlunoReprovados() {
        float porcentagem;
        int quantidade;

        quantidade = alunos.size();

        porcentagem = (quantidade / 100) * this.quantidadeAlunosReprovados();
        return porcentagem;

    }
       

    public double media_geral_turma() {
        int nContador, nTotal = 0;

        for (nContador = 0; nContador <= this.alunos.size(); nContador++) {
            nTotal += alunos.get(nContador).calcularMedia();
        }
        return nTotal / quantidadeAlunos();
    }
}