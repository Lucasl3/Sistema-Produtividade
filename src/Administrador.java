package Project_Software.src;

import java.util.Scanner;

import Project_Software.src.Colaboradores.Colaboradores;
public class Administrador {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema.\nDigite o nome do laboratório.");

        String nomeLaboratorio = teclado.nextLine();

        LaboratorioPesquisa laboratorio = new LaboratorioPesquisa(nomeLaboratorio);

        boolean loop = true;
        
        while(loop){
            
            System.out.println("[1] - Adicionar novo colaborador.");
            System.out.println("[2] - Criar novo projeto.");
            System.out.println("[3] - Alocar colaborador a uma projeto.");
            System.out.println("[4] - Alterar status de um projeto.");
            System.out.println("[5] - Consultar projeto.");
            System.out.println("[0] - Sair.");

            int option = Integer.parseInt(teclado.nextLine());

            switch(option){
                case 1:
                    Colaboradores colaboradores = new Colaboradores();
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

                    break;
                default:
                    loop = false;
                    break;
            }
        }

        // laboratorio.getColaboradores();
        Projetos p = new Projetos();
        p.listaDadosProjeto();

    }
}
