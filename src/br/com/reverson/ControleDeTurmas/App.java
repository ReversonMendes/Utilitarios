package br.com.reverson.ControleDeTurmas;

public class App {

    public static void main(String[] args) {
      
        Aluno aluno = new Aluno(1, "");
        Instituicao i1 = new Instituicao();
        Turma t1 = new Turma(1, "");

        i1.matriculas(aluno, t1);
        t1.setarNotas(aluno, 0, 0);

        System.out.println("Nome: " + aluno.getNome() + ". Média: " + aluno.calcularMedia());
        System.out.println("Turma: " + t1.getDescricao() + ". Quantidade de Alunos: " + t1.quantidadeAlunos());
    }
}
