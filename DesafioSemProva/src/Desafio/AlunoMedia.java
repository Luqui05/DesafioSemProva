package Desafio;

public class AlunoMedia {
    private int id;
    private double media;

    public AlunoMedia(int id, double media) {
        this.id = id;
        this.media = media;
    }

    public int getId() {
        return id;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Média: " + media;
    }
}
