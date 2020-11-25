package Project_Software.src;

import Project_Software.src.Colaboradores.Colaboradores;
import Project_Software.src.Colaboradores.Professores;

import java.util.ArrayList;
import java.util.Scanner;

import Aula.index;


public class Projetos {
    private String titulo;
    private String dataInicio, dataTermino;
    private String agenciaFinanciadora;
    private double valorFinanciado;
    private String objetivo;
    private String descricao;
    private String status;
    private boolean trocaStatus = false;
    private ArrayList<Colaboradores> participantes = new ArrayList<Colaboradores>();
    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
    static ArrayList<Projetos> projetos = new ArrayList<Projetos>();

    static Scanner teclado = new Scanner(System.in);

    public Projetos(String titulo, String dataInicio, String dataTermino, String agenciaFinanciadora, double valorFinanciado, String objetivo, String descricao) {
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.status = "Em elaboração";
    }

    public Projetos() {

    }

    public void setTrocaStatus(boolean trocaStatus) {
        this.trocaStatus = trocaStatus;
    }

    public boolean getTrocaStatus(){
        return this.trocaStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    public void getParticipantesProjeto(ArrayList<Colaboradores> participantes) {

        System.out.println("Quantidade de participantes do projeto: " + participantes.size() + "\n");

        for(int i = 0;i< participantes.size();i++){
            System.out.println("Colaborador " + (i + 1));
            System.out.println("Nome: " + participantes.get(i).getNome());
            System.out.println("Email: " + participantes.get(i).getEmail());
            System.out.println("Tipo de colaborador: " + participantes.get(i).getTipoColaborador() + "\n");
        }
    }

    public void listaDadosProjeto() {
        System.out.println("Escolha de qual projeto deseja os dados");

        for (int i = 0; i < projetos.size(); i++) {
            System.out.println("Projeto " + (i + 1) + " " + projetos.get(i).titulo);
        }

        int option = Integer.parseInt(teclado.nextLine());

        System.out.println("Título: " + projetos.get(option - 1).titulo);
        System.out.println("Data de início: " + projetos.get(option - 1).dataInicio + " até " + "data de término: " + projetos.get(option - 1).dataTermino);
        System.out.println("Agência financiadora: " + projetos.get(option - 1).agenciaFinanciadora);
        System.out.println("Valor financiado: " + projetos.get(option - 1).valorFinanciado);
        System.out.println("Descrição: " + projetos.get(option - 1).descricao);
        System.out.println("Objetivo: " + projetos.get(option - 1).objetivo);
        System.out.println("Status do projeto: " + projetos.get(option - 1).status + "\n");

        ArrayList<Colaboradores> participantesProjetoAtual = projetos.get(option - 1).participantes;

        getParticipantesProjeto(participantesProjetoAtual);
    }

    public static void listaProfessoresLaboratorio(LaboratorioPesquisa lab) {
        ArrayList<Colaboradores> professores = lab.getProfessores();

        System.out.println("O projeto precisa de ao menos um professor como participante.");
        System.out.println("Escolha um professor para alocar a esse projeto:\n");

        if (professores.size() == 0) {
            System.out.println(
                    "Não há professores colaboradores no laboratório, adicione algum professor para mudar o status do projeto.");
        } else {

            for (int i = 0; i < professores.size(); i++) {
                System.out.println("Professor " + (i + 1));
                System.out.println("Nome: " + professores.get(i).getNome());
                System.out.println("Email: " + professores.get(i).getEmail() + "\n");
            }

            System.out.println("Escolha pelo indice um professor para ser alocado a esse projeto.");

            int option = Integer.parseInt(teclado.nextLine()) - 1;
            Colaboradores professor = professores.get(option);
            int indexProjeto = projetos.size() - 1;
            Projetos projetoAtual = projetos.get(indexProjeto);
            projetoAtual.participantes.add(professor);
            projetoAtual.setTrocaStatus(true);

            System.out.println("Professor '" + professor.getNome() + "' alocado com sucesso para o projeto '" + projetoAtual.titulo + "'.");


        }

    }

    public static void adicionarProjeto(LaboratorioPesquisa laboratorio) {
        System.out.println("Criação de um projeto:");

        System.out.print("Título do projeto: ");
        String titulo = teclado.nextLine();

        System.out.print("Data de início, digite no formato 'dd/mm/yyyy': ");
        String dataInicio = teclado.nextLine();

        System.out.print("Data de término, digite no formato 'dd/mm/yyyy': ");
        String dataTermino = teclado.nextLine();

        System.out.print("Informe a agência financiadora: ");
        String agenciaFinanciadora = teclado.nextLine();

        System.out.print("Informe o valor financiado no projeto: ");
        double valorFinanciado = Double.parseDouble(teclado.nextLine());

        System.out.println("Qual o objetivo do projeto: ");
        String objetivo = teclado.nextLine();

        System.out.println("Descrição do projeto: ");
        String descricao = teclado.nextLine();

        Projetos novoProjeto = new Projetos(titulo, dataInicio, dataTermino, agenciaFinanciadora, valorFinanciado, objetivo, descricao);

        projetos.add(novoProjeto);

        System.out.println("Projeto criado com sucesso!\n");

        listaProfessoresLaboratorio(laboratorio);

    }


    public static void alocarColaborador(LaboratorioPesquisa lab){
        lab.getColaboradoresAlocamento();

        System.out.println("Escolha o indice do colaborador que deseja alocar a um projeto: ");

        int option = Integer.parseInt(teclado.nextLine());
        Colaboradores colaborador = lab.getColaboradores().get(option - 1);

        System.out.println("Escolha o projeto que deseja alocar " + colaborador.getNome());
        listaProjetos();

        int optionProjeto = Integer.parseInt(teclado.nextLine());

        Projetos projeto = projetos.get(optionProjeto - 1);

        projeto.participantes.add(colaborador);

        if(colaborador.getTipoColaborador() == "Professor") projeto.setTrocaStatus(true);
        
    }

    public static void listaProjetos() {
        for(int i = 0;i < projetos.size();i++){
            System.out.println("Projeto " + (i + 1));
            System.out.println("Título: " + projetos.get(i).titulo);
            System.out.println("Status: " + projetos.get(i).status);
        }
    }

    public static void alterarStatusProjeto(){
        listaProjetos();
        System.out.println("Escolha pelo indice qual projeto deseja alterar o status: ");
        int optionProjeto = Integer.parseInt(teclado.nextLine());

        Projetos projeto = projetos.get(optionProjeto - 1);

        System.out.println("[1] Alterar status para 'Em andamento'.");
        System.out.println("[2] Alterar status para 'Concluído'.");

        int option = Integer.parseInt(teclado.nextLine());

        if(option == 1 && projeto.trocaStatus){
            projeto.setStatus("Em andamento");
            System.out.println("Projeto " + projeto.titulo + ": status trocado para 'Em andamento'.");
            return;
        } else {
            System.out.println("O projeto deve ter ao menos um professor para ter seu status trocado.");
        }

        if(option == 2 && projeto.publicacoes.size() != 0){
            projeto.setStatus("Concluído");
        } else {
            System.out.println("O projeto deve ter ao menos uma publicação para ser publicado");
        }
    }

    public static void buscarProjeto(){
        System.out.println("Digite o título do projeto que deseja.");
        
    }
}
