package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.Colaboradores.Colaboradores;

public class Orientacoes {
    private Colaboradores professor;
    private Colaboradores aluno;
    private static int numeroAlunos = 0;
    private static int numeroProfessores = 0;
    private static ArrayList<Orientacoes> orientacoes = new ArrayList<Orientacoes>();
    private static int numeroOrientacoes = 0;

    Scanner teclado = new Scanner(System.in);

    public Orientacoes(){

    }

    public Orientacoes(Colaboradores professor, Colaboradores aluno){
        this.professor = professor;
        this.aluno = aluno;
    }

    public static int getNumeroOrientacoes() {
        return numeroOrientacoes;
    }

    public Colaboradores getProfessor() {
        return professor;
    }

    public Colaboradores getAluno() {
        return aluno;
    }

    public static void incrementaNumeroAlunos() {
        Orientacoes.numeroAlunos++;
    }

    public static void incrementaNumeroProfessores() {
        Orientacoes.numeroProfessores++;
    }

    public void listaOrientacoes(){
        for(int i = 0;i < orientacoes.size();i++){
            System.out.println("Orientação " + (i + 1));
            System.out.println("Orientador: " + orientacoes.get(i).professor.getNome());
            System.out.println("Aluno orientado: " + orientacoes.get(i).aluno.getNome() + "\n");
        }
    }

    public void adicionarOrientacao(){
        if(numeroAlunos == 0 || numeroProfessores == 0){
            System.out.println("É necessário ao menos 1 professor e 1 aluno para adicionar uma orientação;");
        } else {
            System.out.print("Digite o nome do professor que vai ser o orientador: ");
            String nomeProfessor = teclado.nextLine();
    
            Colaboradores professor = buscarProfessor(nomeProfessor);
    
            while(professor == null){
                System.out.print("Digite o nome de um professor: ");
                nomeProfessor = teclado.nextLine();
                professor = buscarProfessor(nomeProfessor);
            }

            System.out.print("Digite o nome do aluno que vai ser orientado pelo professor " + professor.getNome() + ": ");
            String nomeAluno = teclado.nextLine();

            Colaboradores aluno = buscarAluno(nomeAluno);

            while(aluno == null){
                System.out.print("Digite o nome de um aluno: ");
                nomeAluno = teclado.nextLine();
                aluno = buscarAluno(nomeAluno);
            }
            Orientacoes orientacao = new Orientacoes(professor, aluno);
            System.out.println("Orientação criada com sucesso\n");
            orientacoes.add(orientacao);
            numeroOrientacoes++;
            LaboratorioPesquisa.orientacoes.add(orientacao);

        }

    }

    public Colaboradores buscarProfessor(String nome) {
        ArrayList<Colaboradores> colaboradores = LaboratorioPesquisa.colaboradores;
        boolean flag = false;
        for(int i = 0;i < colaboradores.size();i++){
            if(colaboradores.get(i).getNome().equalsIgnoreCase(nome) && colaboradores.get(i).getTipoColaborador().equals("Professor")){
                return LaboratorioPesquisa.colaboradores.get(i);
            } else if(colaboradores.get(i).getNome().equalsIgnoreCase(nome)){
                flag = true;
            } 
        }

        if(flag) {
            System.out.println("Esse colaborador não é um professor.");
            return null;
        } else{
            System.out.println("Nome inválido");
            return null;
        }
        
    }

    public Colaboradores buscarAluno(String nome) {
        ArrayList<Colaboradores> colaboradores = LaboratorioPesquisa.colaboradores;
        boolean flag = false;
        for(int i = 0;i < colaboradores.size();i++){
            if(colaboradores.get(i).getNome().equalsIgnoreCase(nome) && !colaboradores.get(i).getTipoColaborador().equals("Professor") && !colaboradores.get(i).getTipoColaborador().equals("Pesquisador")){
                return LaboratorioPesquisa.colaboradores.get(i);
            } else if(colaboradores.get(i).getNome().equalsIgnoreCase(nome)){
                flag = true;
            }
        }

        if(flag){
            System.out.println("Esse colaborador não é um aluno.");
            return null;
        } else {
            System.out.println("Nome inválido.");
            return null;
        }

        
    }
}
