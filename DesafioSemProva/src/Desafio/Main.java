package Desafio;
import java.util.List;
import java.util.Scanner;

import static Desafio.Menu.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo: ");
        String caminho = sc.nextLine();
        List<Aluno> alunos = LeituraArquivo.tratamentoDados(caminho);
        System.out.println(calcularMediaDisciplinaPorAno(alunos, 2023));
        System.out.println(calcularMedianaDisciplinaPorAno(alunos, 2023));
        System.out.println(calcularDesvioPadraoDisciplinaPorAno(alunos, 2023));
        System.out.println(calcularMediaDisciplinaPorAno(alunos, 2024));
        System.out.println(calcularMedianaDisciplinaPorAno(alunos, 2024));
        System.out.println(calcularDesvioPadraoDisciplinaPorAno(alunos, 2024));
        System.out.println(calcularMediaDisciplina(alunos));
        System.out.println(calcularMedianaDisciplina(alunos));
        System.out.println(calcularDesvioPadraoDisciplina(alunos));
        System.out.println(identificarMelhorDesempenho(alunos));
        System.out.println(identificarPiorDesempenho(alunos));
        System.out.println(determinarQuantidadeAlunos(alunos));
        System.out.println(determinarAlunosAprovadosReprovados(alunos));
        criarArquivoDeMedia(alunos);
        criarArquivoDeAlunosAprovados(alunos);
        criarArquivoDeAlunosReprovados(alunos);
    }
}
