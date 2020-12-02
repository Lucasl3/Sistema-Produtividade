package src;

import java.util.Scanner;

import src.Colaboradores.Colaboradores;
public class Administrador {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema.\nDigite o nome do laboratório.");

        String nomeLaboratorio = teclado.nextLine();

        LaboratorioPesquisa laboratorio = new LaboratorioPesquisa(nomeLaboratorio);
        Colaboradores colaboradores = new Colaboradores();
        Publicacoes publicacoes = new Publicacoes();

        boolean loop = true;
        
        while(loop){
            
            System.out.println("[1] - Adicionar novo colaborador.");
            System.out.println("[2] - Criar novo projeto.");
            System.out.println("[3] - Alocar colaborador a uma projeto.");
            System.out.println("[4] - Alterar status de um projeto.");
            System.out.println("[5] - Consultar projeto pelo titulo.");
            System.out.println("[6] - Consultar colaborador pelo nome.");
            System.out.println("[7] - Adicionar publicação.");
            System.out.println("[8] - Adicionar orientação");
            System.out.println("[9] - Relatório de produção acadêmica do laboratório");
            System.out.println("[0] - Sair.");

            int option = Integer.parseInt(teclado.nextLine());

            switch(option){
                case 1:
                    laboratorio.adicionarColaborador(colaboradores.adicionarColaborador());
                    break;
                case 2:
                    Projetos.adicionarProjeto(laboratorio);
                    break;
                case 3:
                    Projetos.alocarColaborador(laboratorio);
                    break;
                case 4:
                    Projetos.alterarStatusProjeto();
                    break;
                case 5:
                    Projetos projeto = new Projetos();
                    projeto.buscarProjeto();
                    break;
                case 6:
                    colaboradores.buscarColaborador();
                    break;
                case 7:
                    publicacoes.adicionarPublicacao(laboratorio);
                    break;
                case 8:
                    Orientacoes orientacao = new Orientacoes();
                    orientacao.adicionarOrientacao();
                    break;
                case 9:
                    laboratorio.relatorioProducaoAcademica();
                    break;
                default:
                    loop = false;
                    break;
            }
        }

        teclado.close();

    }
}
