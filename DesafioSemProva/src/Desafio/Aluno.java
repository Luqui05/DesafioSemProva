package Desafio;

public class Aluno {
    private Integer ID;
    private Integer Nota1;
    private Integer Nota2;
    private Integer Nota3;
    private Integer Nota4;
    private Integer Ano;

    public Aluno(Integer ID, Integer nota1, Integer nota2, Integer nota3, Integer nota4, Integer ano) {
        this.ID = ID;
        Nota1 = nota1;
        Nota2 = nota2;
        Nota3 = nota3;
        Nota4 = nota4;
        Ano = ano;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getNota1() {
        return Nota1;
    }

    public void setNota1(Integer nota1) {
        Nota1 = nota1;
    }

    public Integer getNota2() {
        return Nota2;
    }

    public void setNota2(Integer nota2) {
        Nota2 = nota2;
    }

    public Integer getNota3() {
        return Nota3;
    }

    public void setNota3(Integer nota3) {
        Nota3 = nota3;
    }

    public Integer getNota4() {
        return Nota4;
    }

    public void setNota4(Integer nota4) {
        Nota4 = nota4;
    }

    public Integer getAno() {
        return Ano;
    }

    public void setAno(Integer ano) {
        Ano = ano;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "ID=" + ID +
                ", Nota1=" + Nota1 +
                ", Nota2=" + Nota2 +
                ", Nota3=" + Nota3 +
                ", Nota4=" + Nota4 +
                ", Ano=" + Ano +
                '}';
    }
}
