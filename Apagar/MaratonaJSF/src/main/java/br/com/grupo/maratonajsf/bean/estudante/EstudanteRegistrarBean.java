package br.com.grupo.maratonajsf.bean.estudante;

import java.io.Serializable;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

//Managed Bean sera descontinuado, utilizaremos CDI como Injetor de Dependencias
@Named
public class EstudanteRegistrarBean implements Serializable{
    
    private String nome = "Douglas";
    private String sobreNome = "Eleuterio";
    private double nota1;
    private double nota2;
    private double nota3 = 10;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
    
    
    
    
}
