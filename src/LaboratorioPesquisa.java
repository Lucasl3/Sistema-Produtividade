package Project_Software.src;

import Project_Software.src.Colaboradores.Colaboradores;
import java.util.ArrayList;


public class LaboratorioPesquisa {
    private String nomeLaboratorio;
    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
    private ArrayList<Orientacoes> orientacoes = new ArrayList<Orientacoes>();
    public static ArrayList<Colaboradores> colaboradores = new ArrayList<Colaboradores>();

    public ArrayList<Colaboradores> getColaboradores() {
        return colaboradores;
    }

    public void setPublicacoes(Publicacoes publicacoes) {
        this.publicacoes.add(publicacoes);
    }

    public ArrayList<Publicacoes> getPublicacoes() {
        return publicacoes;
    }

    public void todasPublicacoes() {

        for(int i = 0;i < publicacoes.size();i++){
            System.out.println("Publicação " + (i + 1));
            System.out.println("Autores: ");

            for(int j = 0;j < publicacoes.get(i).getAutores().size();j++){
                System.out.println("Autor " + (j + 1));
                System.out.println("Nome: " + publicacoes.get(i).getAutores().get(j).getNome() + " " + publicacoes.get(i).getAutores().get(j).getTipoColaborador());
                

            }

            System.out.println("Título: " + publicacoes.get(i).getTitulo());
            System.out.println("Conferência: " + publicacoes.get(i).getNomeConferencia());
            System.out.println("Ano de publicação: " + publicacoes.get(i).getAnoPublicacao() + "\n");

            if(publicacoes.get(i).getProjeto() != null){
                System.out.println("\nProjeto associado: ");

                System.out.println("Título: " + publicacoes.get(i).getProjeto().getTitulo());
                System.out.println("Data de início: " + publicacoes.get(i).getProjeto().getDataInicio() + " até " + "data de término: " + publicacoes.get(i).getProjeto().getDataTermino());
                System.out.println("Agência financiadora: " + publicacoes.get(i).getProjeto().getAgenciaFinanciadora());
                System.out.println("Valor financiado: " + publicacoes.get(i).getProjeto().getValorFinanciado());
                System.out.println("Descrição: " + publicacoes.get(i).getProjeto().getDescricao());
                System.out.println("Objetivo: " + publicacoes.get(i).getProjeto().getObjetivo());
                System.out.println("Status do projeto: " + publicacoes.get(i).getProjeto().getStatus() + "\n");

            }

        }
    }

    public void getColaboradoresAlocamento() {
        for(int i = 0;i< colaboradores.size();i++){
            System.out.println("Colaborador " + (i + 1));
            System.out.print("Nome: " + colaboradores.get(i).getNome());
            System.out.print("| Email: " + colaboradores.get(i).getEmail());
            System.out.println("| Tipo de colaborador: " + colaboradores.get(i).getTipoColaborador() + "\n");
        }
    }

    public void listaColaboradores() {

        System.out.println("Quantidade de colaboradores: " + colaboradores.size());
        System.out.println("Colaboradores do laboratório " + nomeLaboratorio + "\n");

        for(int i = 0;i< colaboradores.size();i++){
            System.out.println("Colaborador " + (i + 1));
            System.out.println("Nome: " + colaboradores.get(i).getNome());
            System.out.println("Email: " + colaboradores.get(i).getEmail());
            System.out.println("Tipo de colaborador: " + colaboradores.get(i).getTipoColaborador() + "\n");
        }
    }

    public ArrayList<Colaboradores> getProfessores() {
        ArrayList<Colaboradores> professores = new ArrayList<Colaboradores>();

        for(int i = 0;i < colaboradores.size();i++){
            if(colaboradores.get(i).getTipoColaborador() == "Professor"){
                System.out.println(i);
                professores.add(colaboradores.get(i));
            }
        }

        return professores;
        

    }

    public LaboratorioPesquisa(String nomeLaboratorio){
        this.nomeLaboratorio = nomeLaboratorio;
    }
    public LaboratorioPesquisa(){
        
    }
    
    public void adicionarColaborador(Colaboradores colaborador){
        colaboradores.add(colaborador);
    }
}
