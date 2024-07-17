package Desafio;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o caminho do arquivo: ");
        String caminho = sc.nextLine();
        int opcao;
        do {
            Menu.imprimirMenu();
            opcao = sc.nextInt();
            List<Aluno> alunos = LeituraArquivo.tratamentoDados(caminho);
            Menu.roteador(alunos, opcao);
        } while (opcao != 0);
    }
}