package Project_Software.src;

import Project_Software.src.Colaboradores.Colaboradores;

import java.util.ArrayList;


public class Projetos {
    private String titulo;
    private String dataInicio, dataTermino;
    private String agenciaFinanciadora;
    private double valorFinanciado;
    private String objetivo;
    private String descricao;
    private String status;
    private ArrayList<Colaboradores> participantes = new ArrayList<Colaboradores>();
    private ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();

    public Projetos(String titulo, String dataInicio, String dataTermino, String agenciaFinanciadora, double valorFinanciado, String objetivo, String descricao){
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.valorFinanciado = valorFinanciado;
        this.objetivo = objetivo;
        this.descricao = descricao;
        this.status = "Em elaboração";
    }

}
