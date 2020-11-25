package Project_Software.src.Colaboradores;

import java.util.ArrayList;
import java.util.Scanner;

import Project_Software.src.LaboratorioPesquisa;
import Sistema_de_Produtividade_Academica.Sistema_de_Produtividade_Academica.src.Laboratorio;

public class Colaboradores{
    private String nome;
    private String email;
    private String tipoColaborador;

    Scanner teclado = new Scanner(System.in);

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    
    public void setNome(String nome, Colaboradores colaborador) {
        colaborador.nome = nome;
    }
    
    public void setEmail(String email, Colaboradores colaborador) {
        colaborador.email = email;
    }
    
    public void setTipoColaborador(String tipoColaborador, Colaboradores colaborador) {
        colaborador.tipoColaborador = tipoColaborador;
    }

    //Pega os dados nome e email ao fazer o cadastro do colaborador
    private void dadosColaborador(Colaboradores colaborador){

        System.out.print("Digite o nome do colaborador: ");
        String nome = teclado.nextLine();
        System.out.println();

        System.out.print("Digite o email do colaborador: ");
        String email = teclado.nextLine();
        System.out.println();

        setNome(nome, colaborador);
        setEmail(email, colaborador);

    }

    //escolhe o tipo de colaborador e insere no arraylist de LaboratorioPesquisa
    public Colaboradores adicionarColaborador(){
            
        System.out.println("Escolha o tipo do colaborador.");
        System.out.println("[1] - Aluno");
        System.out.println("[2] - Professor");
        System.out.println("[3] - Pesquisador");

        int option = Integer.parseInt(teclado.nextLine());

        LaboratorioPesquisa laboratorio = new LaboratorioPesquisa();
        String tipo;
        switch(option){
            case 1:
                Alunos aluno = Alunos.escolhaTipoAluno();
                dadosColaborador(aluno);
                // laboratorio.adicionarColaborador(aluno);
                tipo = "Aluno de " + aluno.getTipo();
                setTipoColaborador(tipo, aluno);
                System.out.println(tipo + " inserido com sucesso!");
                return aluno;
            case 2:
                Professores professor = new Professores();
                dadosColaborador(professor);
                setTipoColaborador("Professor", professor);
                System.out.println("Professor inserido com sucesso!");
                return professor;
            case 3:
                Pesquisadores pesquisador = new Pesquisadores();
                dadosColaborador(pesquisador);
                setTipoColaborador("Pesquisador", pesquisador);
                System.out.println("Pesquisador inserido com sucesso!");
                return pesquisador;
            default:
                return null;
        }


    }

}
