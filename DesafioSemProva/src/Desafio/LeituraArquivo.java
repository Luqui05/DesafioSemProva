package Desafio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivo {
    public static List<Aluno> tratamentoDados(String path) {
        List<Aluno> alunos = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String itemCsv = br.readLine();
            itemCsv = br.readLine();
            while(itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String ID = fields[0];
                String Nota1 = fields[1];
                String Nota2 = fields[2];
                String Nota3 = fields[3];
                String Nota4 = fields[4];
                String Ano = fields[5];

                alunos.add(new Aluno(Integer.parseInt(ID),
                        Integer.parseInt(Nota1),
                        Integer.parseInt(Nota2),
                        Integer.parseInt(Nota3),
                        Integer.parseInt(Nota4),
                        Integer.parseInt(Ano)));

                itemCsv = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }
}
