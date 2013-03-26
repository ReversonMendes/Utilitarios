package br.com.reverson.ControleDeTurmas;

import br.com.reverson.utilitarios.io.Console;

public class App {

    Instituicao insti = new Instituicao();

    public static void main(String[] args) {
        App app = new App();
        app.M_menuPrincipal();
    }

    private void M_menuPrincipal() {
        Console.escreverln("------------------------------------------------------------------------------------------");
        Console.escrever("1 - Cadastrar Aluno\t");
        Console.escrever("2 - Cadastrar Turma\t");
        Console.escrever("3 - Relatorios\t");
        Console.escrever("4 - Manutenção\t");
        Console.escrever("5 - Sair \n");
        Console.escreverln("------------------------------------------------------------------------------------------");

        switch (Console.lerInt()) {
            case 1:
                M_cadastrarAluno();
                break;
            case 2:
                M_cadastrarTurma();
                break;
            case 3:
                M_menuRelatorios();
            case 4:
                M_menuManutencao();
            case 5:
                System.exit(0);
            default:
                Console.escreverln("Opção inválida.");
                M_menuPrincipal();

        }

    }

    private void M_cadastrarAluno() {
        int ra;
        String nome;
        boolean lb_Axou;
        do {
            do {
                lb_Axou = true;
                Console.escrever("Digite o R.A.... ");
                ra = Integer.parseInt(Console.ler());
                if (!F_validaCodigoAluno(ra)) {
                    Console.escreverln("Já existe aluno com esse R.A.\n");
                    lb_Axou = false;
                }

            } while (!lb_Axou);

            Console.escrever("Digite o Nome... ");
            nome = Console.ler();

            Aluno al = new Aluno(ra, nome);
            insti.addAluno(al);

            Console.escreverln("Aluno " + nome + " Cadastrado com Sucesso!");
            Console.escreverln("Deseja realizar outro cadastro? \n   [s]Sim  [n]Não");
            if ("n".equals(Console.ler())) {
                M_menuPrincipal();
            }
        } while (Console.ler().equalsIgnoreCase("s"));
    }

    private void M_cadastrarTurma() {
        int codigo;
        String descricao;
        boolean lb_Axou;

        do {
            do {
                lb_Axou = true;
                Console.escrever("Digite o Código da Turma... ");
                codigo = Integer.parseInt(Console.ler());
                if (!F_validaCodigoTurma(codigo)) {
                    Console.escreverln("Já existe turma com esse código!");
                    lb_Axou = false;
                }
            } while (!lb_Axou);

            Console.escrever("Digite uma Descrição para a Turma... ");
            descricao = Console.ler();

            Turma tur = new Turma(codigo, descricao);
            insti.addTurma(tur);

            Console.escreverln("Turma " + descricao + " Cadastrada com Sucesso!");
            Console.escreverln("Deseja realizar outro cadastro? \n   [s]Sim  [n]Não");
            if ("n".equals(Console.ler())) {
                M_menuPrincipal();
            }
        } while (Console.ler().equalsIgnoreCase("s"));


    }

    private void M_menuRelatorios() {
        Console.escreverln("-----------------------------------------------------------------------------------------------------");
        Console.escrever("1 - Quantidade de alunos\t");
        Console.escrever("2 - Quantidade de Alunos Aprovados\t");
        Console.escrever("3 - Quantidade de Alunos Reprovados\n");
        Console.escrever("4 - Porcentagem de Alunos Aprovados\t");
        Console.escrever("5 - Porcentagem de Alunos Reprovados\t");
        Console.escrever("6 - Media geral por Turma\t");
        Console.escrever("7 - Voltar\n");
        Console.escreverln("-----------------------------------------------------------------------------------------------------");

        switch (Console.lerInt()) {
            case 1:
                M_quantidadeAlunos();
                break;
            case 2:
                M_quantidadeAprovados();
                break;
            case 3:
                M_quantidadeReprovados();
                break;
            case 4:
                M_porcentagemAprovados();
                break;
            case 5:
                M_porcentagemReprovados();
                break;
            case 6:
                M_mediaGeral();
                break;
            case 7:
                M_menuPrincipal();
                break;
            default:
                Console.escreverln("Opção inválida.");
                M_menuRelatorios();
        }

    }

    public void M_quantidadeAlunos() {
        Console.escrever("Quantidade de Alunos: " + insti.getAluno().size() + "\n");
        M_menuRelatorios();
    }

    private void M_quantidadeAprovados() {
        Turma t;
        int quantidade;
        int turma = Integer.parseInt(Console.ler());

        for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
            t = insti.getTurmas().get(nContador);
            quantidade = t.quantidadeAlunosAprovados();
            if (quantidade < 0) {
                Console.escreverln("Nenhum Aluno Aprovado!");
            }

            Console.escrever("Quantidade de Alunos Por turma : " + quantidade + "\n");
            M_menuRelatorios();


        }
    }

    private void M_quantidadeReprovados() {
        Turma t;
        int turma = Integer.parseInt(Console.ler());

        for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
            t = insti.getTurmas().get(nContador);
            if (t.getCodigo() == turma) {
                break;
            }
            Console.escrever("Quantidade de Alunos Por turma : " + t.quantidadeAlunosReprovados() + "\n");
            M_menuRelatorios();
        }
    }

    private void M_porcentagemAprovados() {
        Turma t;
        int turma = Integer.parseInt(Console.ler());

        for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
            t = insti.getTurmas().get(nContador);
            if (t.getCodigo() == turma) {
                break;
            }
            Console.escrever("Porcentagem de alunos Aprovados : " + t.porcentagemAlunoAprovados() + "\n");
            M_menuRelatorios();
        }
    }

    private void M_porcentagemReprovados() {
        Turma t;
        int turma = Integer.parseInt(Console.ler());

        for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
            t = insti.getTurmas().get(nContador);
            if (t.getCodigo() == turma) {
                break;
            }
            Console.escrever("Porcentagem de Alunos reprovados : " + t.porcentagemAlunoReprovados() + "\n");
            M_menuRelatorios();
        }
    }

    private void M_mediaGeral() {
        Turma t;
        int turma = Integer.parseInt(Console.ler());

        for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
            t = insti.getTurmas().get(nContador);
            if (t.getCodigo() == turma) {
                break;
            }
            Console.escrever("Média geral das turmas: " + t.media_geral_turma() + "\n");
            M_menuRelatorios();
        }
    }

    private void M_menuManutencao() {
        Console.escreverln("1 - Matricular Aluno");
        Console.escreverln("2 - Lançar Notas");
        Console.escreverln("3 - Remover alunos da Turma");
        Console.escreverln("4 - Remover alunos");
        Console.escreverln("5 - Remover turmas");
        Console.escreverln("6 - Voltar");

        switch (Console.lerInt()) {
            case 1:
                M_matricularAlunos();
            case 2:
                M_setarNotas();
            case 6:
                M_menuPrincipal();
            default:
                Console.escreverln("Opção inválida.");
                M_menuManutencao();
        }
    }

    private void M_matricularAlunos() {
        Aluno a = null;
        Turma t = null;
        boolean lAux;
        do {
            do {
                lAux = false;

                Console.escrever("\nDigite o código da Turma... ");
                int turma = Integer.parseInt(Console.ler());

                for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
                    t = insti.getTurmas().get(nContador);
                    if (t.getCodigo() == turma) {
                        lAux = true;
                        break;
                    }
                }
                if (!lAux) {
                    Console.escreverln("Turma não Encontrada! Informe uma das seguintes turmas...\n");
                    insti.listarTurmas();
                }
            } while (!lAux);

            do {
                lAux = false;

                Console.escrever("Digite o código do Aluno.. ");
                int aluno = Integer.parseInt(Console.ler());

                for (int nContador = 0; nContador < insti.getAluno().size(); nContador++) {
                    a = insti.getAluno().get(nContador);
                    if (a.getRa() == aluno) {
                        lAux = true;
                        break;
                    }
                }
                if (!lAux) {
                    Console.escreverln("Aluno não Encontrado! Informe uma dos seguintes Alunos...\n");
                    insti.listarAlunos();
                }
            } while (!lAux);

            t.matricula(a);
            Console.escreverln("Aluno " + a.getNome() + " Matriculado com Sucesso!\n");
            Console.escreverln("Deseja realizar outra Matricula ? \n   [1]Sim  [2]Não");
            if ("2".equals(Console.ler())) {
                M_menuManutencao();
            }
        } while (Console.ler().equalsIgnoreCase("1"));


    }

    private void M_setarNotas() {
        Aluno a1 = null;
        Turma t1 = null;
        boolean lb_axou;
        do {
            do {
                lb_axou = false;

                Console.escrever("\nDigite o código da Turma... ");
                int turma = Integer.parseInt(Console.ler());

                for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
                    t1 = insti.getTurmas().get(nContador);
                    if (t1.getCodigo() == turma) {
                        lb_axou = true;
                        break;
                    }
                }
                if (!lb_axou) {
                    Console.escreverln("Turma não Encontrada! Informe uma das seguintes turmas...\n");
                    insti.listarTurmas();
                }
            } while (!lb_axou);

            do {
                lb_axou = false;

                Console.escrever("Digite o código do Aluno.. ");
                int aluno = Integer.parseInt(Console.ler());

                for (int nContador = 0; nContador < insti.getAluno().size(); nContador++) {
                    a1 = insti.getAluno().get(nContador);
                    if (a1.getRa() == aluno) {
                        lb_axou = true;
                        break;
                    }
                }
                if (!lb_axou) {
                    Console.escreverln("Aluno não Encontrada! Informe uma dos seguintes Alunos...\n");
                    insti.listarAlunos();
                }

                t1.setarNotas(a1);
                Console.escrever("Aluno :" + a1.getNome() + "\tTurma : " + t1.getDescricao() + "\n");
                Console.escrever("Notas lançadas Com sucesso!");
                Console.escreverln("Deseja Lançar outras Notas ? \n   [1]Sim  [2]Não");
                if ("2".equals(Console.ler())) {
                    M_menuManutencao();
                }
            } while (!lb_axou);
        } while (Console.ler().equalsIgnoreCase("1"));
    }

    public boolean F_validaCodigoAluno(int ra) {
        Aluno a;
        for (int nContador = 0; nContador < insti.getAluno().size(); nContador++) {
            a = insti.getAluno().get(nContador);
            if (a.getRa() == ra) {
                return false;
            }
        }
        return true;
    }

    public boolean F_validaCodigoTurma(int codigo) {
        Turma t;
        for (int nContador = 0; nContador < insti.getTurmas().size(); nContador++) {
            t = insti.getTurmas().get(nContador);
            if (t.getCodigo() == codigo ) {
                return false;
            }
        }
        return true;
    }
}
