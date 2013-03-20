package br.com.reverson.ControleDeTurmas;

import br.com.renato.utilitarios.io.Console;

public class App {

    public static void main(String[] args) {

        Instituicao instituicao = new Instituicao();
        Console.escrever("Digite a Opção : ");
        //Operacao Matriculas de Aluno
        int opcao = 1;
        do {

            int ra;
            int codigo;
            String nome, descricao;


            Console.escrever("Digite o ra do aluno :");
            ra = Console.lerInt();

            Console.escrever("Digite o nome do aluno :");
            nome = Console.ler();

            Console.escrever("Digite o Código da Turma  do aluno :");
            codigo = Console.lerInt();

            Console.escrever("Digite o nome da turma do aluno :");
            descricao = Console.ler();

            
            Aluno aluno = new Aluno(ra, nome);
            Turma turma = new Turma(codigo, descricao);
            turma.matricula(aluno);

        } while (opcao == 1);

        //System.out.println("Nome: " + aluno.getNome() + ". Média: " + aluno.calcularMedia());
        //System.out.println("Turma: " + t1.getDescricao() + ". Quantidade de Alunos: " + t1.quantidadeAlunos());
    }
}
