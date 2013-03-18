package br.com.reverson.ControleDeTurmas;

public class Aluno {
    //Variaveis de atributos do alunos

    private int ra;
    private String nome;
    //Classe Turma é uma variaveis com seus repectivos atributos
    private Turma turma;
    private float notaG1;
    private float notaG2;

    //construtor de aluno
    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;

    }

    //Geraçao de Get e Setter para cada Atibutos
    public int getRa() {
        return ra;
    }

    public void setRa(int Ra) {
        this.ra = Ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public float getNotaG1() {
        return notaG1;
    }

    public void setNotaG1(float notaG1) {
        this.notaG1 = notaG1;
    }

    public float getNotaG2() {
        return notaG2;
    }

    public void setNotaG2(float notaG2) {
        this.notaG2 = notaG2;
    }

    //Operacao Calucular Média
    public float calcularMedia() {
        float media = (notaG1 + (notaG2 * 2)) / 3;
        return media;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.ra;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.ra != other.ra) {
            return false;
        }
        return true;
    }
}
