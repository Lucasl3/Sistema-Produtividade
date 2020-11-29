package Project_Software.src.Colaboradores;

import Project_Software.src.Orientacoes;

import java.util.ArrayList;
import java.util.Scanner;

public class Alunos extends Colaboradores { 
    public String tipo;

    static Scanner teclado = new Scanner(System.in);

    public Alunos(String tipo) {
        this.tipo = tipo;

    }

    public String getTipo() {
        return tipo;
    }

    static Alunos escolhaTipoAluno() {

        System.out.println("Qual o tipo de aluno?");
        System.out.println("[1] - Aluno de graduação");
        System.out.println("[2] - Aluno de mestrado");
        System.out.println("[3] - Aluno de doutorado");

        int option = Integer.parseInt(teclado.nextLine());

        Alunos aluno;

        switch(option){
            case 1:
                aluno = new Alunos("graduação");
                
                return aluno;
            case 2: 
                aluno = new Alunos("mestrado");
                return aluno;
            case 3:
                aluno = new Alunos("doutorado");
                return aluno;
            
            default:
                return null;
        }
    }
}
