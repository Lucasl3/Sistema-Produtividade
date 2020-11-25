package Project_Software.src;

import Project_Software.src.Colaboradores.Alunos;
import Project_Software.src.Colaboradores.Colaboradores;
import java.util.ArrayList;


public class LaboratorioPesquisa {
    private String nomeLaboratorio;
    private String tipoProducaoAcademica;
    private ArrayList<Colaboradores> colaboradores = new ArrayList<Colaboradores>();

    public ArrayList<Colaboradores> getColaboradores() {
        return colaboradores;
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
