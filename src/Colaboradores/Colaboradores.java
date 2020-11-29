package Project_Software.src.Colaboradores;

import java.util.ArrayList;
import java.util.Scanner;

import Project_Software.src.LaboratorioPesquisa;
import Project_Software.src.Orientacoes;
import Project_Software.src.Projetos;
import Project_Software.src.Publicacoes;

public class Colaboradores{
    private String nome;
    private String email;
    private String tipoColaborador;
    private ArrayList<Projetos> projetos = new ArrayList<Projetos>();
    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
    private static int numeroColaboradores = 0;
    private int numeroProjetosAndamento = 0;

    Scanner teclado = new Scanner(System.in);

    public void setPublicacoes(Publicacoes publicacao) {
        
        if(publicacoes.isEmpty()){
            this.publicacoes.add(publicacao);
        } else{
            for(int i = 0;i < publicacoes.size();i++){
                if(publicacao.getAnoPublicacao() > publicacoes.get(i).getAnoPublicacao()){
                    System.out.println("entrou");
                    this.publicacoes.add(i, publicacao);
                    return;
                }
            }
            this.publicacoes.add(publicacao);
        }
    }

    public static int getNumeroColaboradores() {
        return numeroColaboradores;
    }

    public int getNumeroProjetosAndamento() {
        return numeroProjetosAndamento;
    }

    public void setNumeroProjetosAndamento(int numeroProjetosAndamento) {
        this.numeroProjetosAndamento += numeroProjetosAndamento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTipoColaborador() {
        return tipoColaborador;
    }

    public  ArrayList<Projetos> getProjetos() {
        return projetos;
    }
    public void addProjetosColaboradores(Projetos projeto) {
        this.projetos.add(projeto);
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

    public boolean nomeDisponivel(String nome){
        ArrayList<Colaboradores> colaboradores = LaboratorioPesquisa.colaboradores;
        for(int i = 0;i < colaboradores.size();i++){
            if(colaboradores.get(i).nome.equalsIgnoreCase(nome)){
                return false;
            }
        }
        return true;
    }

    //Pega os dados nome e email ao fazer o cadastro do colaborador
    private void dadosColaborador(Colaboradores colaborador){

        System.out.print("Digite o nome do colaborador: ");
        String nome = teclado.nextLine();

        while (!nomeDisponivel(nome)) {
            System.out.print("Nome indisponível. Digite outro: ");
            nome = teclado.nextLine();
        }
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
                Orientacoes.incrementaNumeroAlunos();
                System.out.println(tipo + " inserido com sucesso!");
                numeroColaboradores++;
                return aluno;
            case 2:
                Professores professor = new Professores();
                dadosColaborador(professor);
                setTipoColaborador("Professor", professor);
                Orientacoes.incrementaNumeroProfessores();
                System.out.println("Professor inserido com sucesso!");
                numeroColaboradores++;
                return professor;
            case 3:
                Pesquisadores pesquisador = new Pesquisadores();
                dadosColaborador(pesquisador);
                setTipoColaborador("Pesquisador", pesquisador);
                System.out.println("Pesquisador inserido com sucesso!");
                numeroColaboradores++;
                return pesquisador;
            default:
                return null;
        }


    }

    public void buscarColaborador(){
        System.out.print("Digite o nome do colaborador que deseja os dados: ");
        ArrayList<Colaboradores> colaboradores = LaboratorioPesquisa.colaboradores;
        String nomeProcurado = teclado.nextLine();
        int index = -1;

        for(int i = 0;i<colaboradores.size();i++){
            if(colaboradores.get(i).nome.equalsIgnoreCase(nomeProcurado)){
                index = i;
            }
        }
        System.out.println();
        if(index == -1){
            System.out.println("Não existe colaborador com esse nome");
            return;
        }

        Colaboradores colaboradorProcurado = colaboradores.get(index);

        System.out.println("Nome: " + colaboradorProcurado.nome);
        System.out.println("Email: " + colaboradorProcurado.email);
        System.out.println("Tipo de colaborador: " + colaboradorProcurado.tipoColaborador + "\n");

        ArrayList<Projetos> projetosColaboradorAtual = colaboradorProcurado.projetos;

        if(projetosColaboradorAtual.isEmpty()){
            System.out.println(colaboradorProcurado.nome + " não está em nenhum projeto\n");
        } else {
            int j = 1;
            for(int i = 0;i < projetosColaboradorAtual.size();i++){
                if(projetosColaboradorAtual.get(i).getStatus() != "Em elaboração"){
                    System.out.println("Projeto " + j);
                    System.out.println("Título: " + projetosColaboradorAtual.get(i).getTitulo());
                    System.out.println("Data início: " + projetosColaboradorAtual.get(i).getDataInicio());
                    System.out.println("Data término: " + projetosColaboradorAtual.get(i).getDataTermino());
                    System.out.println("Status do projeto: " + projetosColaboradorAtual.get(i).getStatus() + "\n");
                    j++;

                }

            }
        }


        System.out.println("Produção acadêmica de " + colaboradorProcurado.getNome() + "\n");

        if(!colaboradorProcurado.publicacoes.isEmpty()){
            System.out.println("Publicações: ");
            for(int i = 0;i < colaboradorProcurado.publicacoes.size();i++){
                System.out.println("Publicação " + (i + 1));
                
                ArrayList<Colaboradores> autores = colaboradorProcurado.publicacoes.get(i).getAutores();

                for(int j = 0;j < autores.size();j++){
                    System.out.println("Autor " + (j + 1));
                    System.out.println("Nome: " + autores.get(j).getNome());
                    System.out.println("Tipo de colaborador: " + autores.get(j).getTipoColaborador() + '\n');
                }
    
                System.out.println("Título: " + colaboradorProcurado.publicacoes.get(i).getTitulo());
                System.out.println("Nome da conferência: " + colaboradorProcurado.publicacoes.get(i).getNomeConferencia());
                System.out.println("Ano de publicação: " + colaboradorProcurado.publicacoes.get(i).getAnoPublicacao() + '\n');

                if(colaboradorProcurado.publicacoes.get(i).getProjeto() != null){
                    System.out.println("\nProjeto associado: ");
    
                    System.out.println("Título: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getTitulo());
                    System.out.println("Data de início: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getDataInicio() + " até " + "data de término: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getDataTermino());
                    System.out.println("Agência financiadora: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getAgenciaFinanciadora());
                    System.out.println("Valor financiado: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getValorFinanciado());
                    System.out.println("Descrição: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getDescricao());
                    System.out.println("Objetivo: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getObjetivo());
                    System.out.println("Status do projeto: " + colaboradorProcurado.publicacoes.get(i).getProjeto().getStatus() + "\n");
    
                }
            }

            
        } else{
            System.out.println("Esse colaborador não possui publicações\n");
        }


        if(!LaboratorioPesquisa.orientacoes.isEmpty()){
            int j = 1;
            for(int i = 0;i < LaboratorioPesquisa.orientacoes.size();i++){
                if(colaboradorProcurado.getNome().equalsIgnoreCase(LaboratorioPesquisa.orientacoes.get(i).getProfessor().getNome()) || colaboradorProcurado.getNome().equalsIgnoreCase(LaboratorioPesquisa.orientacoes.get(i).getAluno().getNome())){
                    System.out.println("Orientação " + j);
                    System.out.println("Orientador: " + LaboratorioPesquisa.orientacoes.get(i).getProfessor().nome);
                    System.out.println("Aluno orientado: " + LaboratorioPesquisa.orientacoes.get(i).getAluno().nome + "\n");
                    j++;
                }
            }
        } else {
            System.out.println("Não há orientações.");
        }
    }


}
