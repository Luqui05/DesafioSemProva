package Desafio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class Menu {
    public static void imprimirMenu() {
        System.out.println("## Menu de Opções ##");
        System.out.println("## 1. Cálculo de Estatísticas por Disciplina/Ano  ##");
        System.out.println("## 2. Cálculo de Estatísticas por Disciplina ##");
        System.out.println("## 3. Identificação de Desempenho dos Alunos ##");
        System.out.println("## 4. Classificação dos Alunos ##");
        System.out.println("## 5. Criação de Arquivos de Saída (formato .TXT)");
        System.out.println("## Digite a opção desejada: ");
    }

    public static void roteador(List<Aluno> alunos, int opcao) {
        Scanner sc = new Scanner(System.in);
        switch (opcao) {
            case 1:
                System.out.println(calcularMediaDisciplinaPorAno(alunos, 2023));
                System.out.println(calcularMedianaDisciplinaPorAno(alunos, 2023));
                System.out.println(calcularDesvioPadraoDisciplinaPorAno(alunos, 2023));
                System.out.println(calcularMediaDisciplinaPorAno(alunos, 2024));
                System.out.println(calcularMedianaDisciplinaPorAno(alunos, 2024));
                System.out.println(calcularDesvioPadraoDisciplinaPorAno(alunos, 2024));
                break;
            case 2:
                System.out.println(calcularMediaDisciplina(alunos));
                System.out.println(calcularMedianaDisciplina(alunos));
                System.out.println(calcularDesvioPadraoDisciplina(alunos));
                break;
            case 3:
                System.out.println(identificarMelhorDesempenho(alunos));
                System.out.println(identificarPiorDesempenho(alunos));
            case 4:
                System.out.println(determinarQuantidadeAlunos(alunos));
                System.out.println(determinarAlunosAprovadosReprovados(alunos));
            case 5:
                criarArquivoDeMedia(alunos);
                criarArquivoDeAlunosAprovados(alunos);
                criarArquivoDeAlunosReprovados(alunos);
        }
    }

    static void criarArquivoDeAlunosAprovados(List<Aluno> alunos) {
        Scanner sc = new Scanner(System.in);
        List<Aluno> alunosAprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if(aluno.getNota1() >= 70 && aluno.getNota2() >= 70 && aluno.getNota3() >= 70 && aluno.getNota4() >= 70) {
                alunosAprovados.add(aluno);
            }
        }
        String resultado = "Os aprovados foram: " + alunosAprovados;

        String[] linhas = {resultado};

        //Caminho adaptado para o pc do IFPR
        String path = "C:\\Users\\Aluno\\Desktop\\aprovados.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void criarArquivoDeAlunosReprovados(List<Aluno> alunos) {
        Scanner sc = new Scanner(System.in);
        List<Aluno> alunosReprovados1 = new ArrayList<>();
        List<Aluno> alunosReprovados2 = new ArrayList<>();
        List<Aluno> alunosReprovados3 = new ArrayList<>();
        List<Aluno> alunosReprovados4 = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if(aluno.getNota1() < 70) {
                alunosReprovados1.add(aluno);
            }
            if(aluno.getNota2() < 70) {
                alunosReprovados2.add(aluno);
            }
            if(aluno.getNota3() < 70) {
                alunosReprovados3.add(aluno);
            }
            if(aluno.getNota4() < 70) {
                alunosReprovados4.add(aluno);
            }
        }
        String resultado = "Na Disciplina 1, foram reprovados os alunos: " + alunosReprovados1
                +"\nNa Disciplina 2, foram reprovados os alunos: " +alunosReprovados2
                +"\nNa Disciplina 3, foram reprovados os alunos: " +alunosReprovados3
                +"\nNa Disciplina 4, foram reprovados os alunos: " + alunosReprovados4;

        String[] linhas = {resultado};

        //Caminho adaptado para o pc do IFPR
        String path = "C:\\Users\\Aluno\\Desktop\\reprovados.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void criarArquivoDeMedia(List<Aluno> alunos) {
        Scanner sc = new Scanner(System.in);
        String resultadoMedias2023 = calcularMediaDisciplinaPorAno(alunos, 2023);
        String resultadoMedias2024 = calcularMediaDisciplinaPorAno(alunos, 2024);
        String resultadoMedias = calcularMediaDisciplina(alunos);
        String[] linhas = {resultadoMedias, resultadoMedias2023, resultadoMedias2024};

        //Caminho adaptado para o pc do IFPR
        String path = "C:\\Users\\Aluno\\Desktop\\medias.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String linha : linhas) {
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String determinarAlunosAprovadosReprovados(List<Aluno> alunos) {
        List<Aluno> alunosAprovados1 = new ArrayList<>();
        List<Aluno> alunosReprovados1 = new ArrayList<>();
        List<Aluno> alunosAprovados2 = new ArrayList<>();
        List<Aluno> alunosReprovados2 = new ArrayList<>();
        List<Aluno> alunosAprovados3 = new ArrayList<>();
        List<Aluno> alunosReprovados3 = new ArrayList<>();
        List<Aluno> alunosAprovados4 = new ArrayList<>();
        List<Aluno> alunosReprovados4 = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if(aluno.getNota1() >= 70) {
                alunosAprovados1.add(aluno);
            } else {
                alunosReprovados1.add(aluno);
            }
            if(aluno.getNota2() >= 70) {
                alunosAprovados2.add(aluno);
            } else {
                alunosReprovados2.add(aluno);
            }
            if(aluno.getNota3() >= 70) {
                alunosAprovados3.add(aluno);
            } else {
                alunosReprovados3.add(aluno);
            }
            if(aluno.getNota4() >= 70) {
                alunosAprovados4.add(aluno);
            } else {
                alunosReprovados4.add(aluno);
            }
        }
        return "Na Disciplina 1, foram aprovados os alunos: " + alunosAprovados1
                + "\ne foram reprovados os alunos: " + alunosReprovados1
                +"\nNa Disciplina 2, foram aprovados os alunos: " + alunosAprovados2
                + "\ne foram reprovados os alunos: " + alunosReprovados2
                +"\nNa Disciplina 3, foram aprovados os alunos: " + alunosAprovados3
                + "\ne foram reprovados os alunos: " + alunosReprovados3
                +"\nNa Disciplina 4, foram aprovados os alunos: " + alunosAprovados4
                + "\ne foram reprovados os alunos: " + alunosReprovados4;
    }

    static String identificarMelhorDesempenho(List<Aluno> alunos) {
        List<AlunoMedia> medias = new ArrayList<>();

        for (Aluno aluno : alunos) {
            double media = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4;
            medias.add(new AlunoMedia(aluno.getID(), media));
        }
        medias.sort(Comparator.comparingDouble(AlunoMedia::getMedia));
        List<AlunoMedia> melhoresMedias = medias.subList(0, 3);

        return "As 3 melhores médias de notas finais foram: " + melhoresMedias;
    }

    static String identificarPiorDesempenho(List<Aluno> alunos) {
        List<AlunoMedia> medias = new ArrayList<>();

        for (Aluno aluno : alunos) {
            double media = (aluno.getNota1() + aluno.getNota2() + aluno.getNota3() + aluno.getNota4()) / 4;
            medias.add(new AlunoMedia(aluno.getID(), media));
        }

        medias.sort(Comparator.comparingDouble(AlunoMedia::getMedia).reversed());

        List<AlunoMedia> pioresMedias = medias.subList(medias.size() - 3, medias.size());

        return "As 3 piores médias de notas finais foram: " + pioresMedias;
    }

    static String determinarQuantidadeAlunos(List<Aluno> alunos) {
        Integer quantidadeAlunos = alunos.size();

        return "O número total de alunos é: " + quantidadeAlunos;
    }

    private static List<Aluno> filtrarAlunosPorAno(List<Aluno> alunos, int ano) {
        return alunos.stream()
                .filter(aluno -> aluno.getAno() == ano)
                .collect(Collectors.toList());
    }

    static String calcularMedianaDisciplina(List<Aluno> alunos) {
        List<Aluno> alunosSort = alunos;

        alunosSort.sort(Comparator.comparingDouble(Aluno::getNota1));
        double medianaNota1 = calcularMediana(alunosSort, Aluno::getNota1);

        alunosSort.sort(Comparator.comparingDouble(Aluno::getNota2));
        double medianaNota2 = calcularMediana(alunosSort, Aluno::getNota2);

        alunosSort.sort(Comparator.comparingDouble(Aluno::getNota3));
        double medianaNota3 = calcularMediana(alunosSort, Aluno::getNota3);

        alunosSort.sort(Comparator.comparingDouble(Aluno::getNota4));
        double medianaNota4 = calcularMediana(alunosSort, Aluno::getNota4);

        return "Mediana disciplina 1: " + medianaNota1 + "\nMediana disciplina 2: " + medianaNota2
                + "\nMediana disciplina 3: " + medianaNota3 + "\nMediana disciplina 4: " + medianaNota4;
    }

    static String calcularMedianaDisciplinaPorAno(List<Aluno> alunos, int ano) {
        List<Aluno> alunosDoAno = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getAno() == ano) {
                alunosDoAno.add(aluno);
            }
        }

        if (alunosDoAno.isEmpty()) {
            return "Nenhum aluno encontrado para o ano " + ano;
        }

        alunosDoAno.sort(Comparator.comparingDouble(Aluno::getNota1));
        double medianaNota1 = calcularMediana(alunosDoAno, Aluno::getNota1);

        alunosDoAno.sort(Comparator.comparingDouble(Aluno::getNota2));
        double medianaNota2 = calcularMediana(alunosDoAno, Aluno::getNota2);

        alunosDoAno.sort(Comparator.comparingDouble(Aluno::getNota3));
        double medianaNota3 = calcularMediana(alunosDoAno, Aluno::getNota3);

        alunosDoAno.sort(Comparator.comparingDouble(Aluno::getNota4));
        double medianaNota4 = calcularMediana(alunosDoAno, Aluno::getNota4);

        return "Mediana disciplina 1 " + ano + ": " + medianaNota1 + "\nMediana disciplina 2 " + ano + ": " + medianaNota2
                + "\nMediana disciplina 3 " + ano + ": " + medianaNota3 + "\nMediana disciplina 4 " + ano + ": " + medianaNota4;
    }

    private static double calcularMediana(List<Aluno> alunos, ToDoubleFunction<Aluno> getNota) {
        int tamanho = alunos.size();
        if (tamanho % 2 == 1) {
            return getNota.applyAsDouble(alunos.get(tamanho / 2));
        } else {
            return (getNota.applyAsDouble(alunos.get(tamanho / 2 - 1)) + getNota.applyAsDouble(alunos.get(tamanho / 2))) / 2.0;
        }
    }

    public static String calcularMediaDisciplinaPorAno(List<Aluno> alunos, int ano) {
        List<Aluno> alunosAno = filtrarAlunosPorAno(alunos, ano);

        if (alunosAno.isEmpty()) {
            return "Nenhum aluno encontrado para o ano " + ano;
        }

        double[] medias = calcularMedias(alunosAno);

        return String.format("Média disciplina 1 %d: %.2f\nMédia disciplina 2 %d: %.2f\nMédia disciplina 3 %d: %.2f\nMédia disciplina 4 %d: %.2f",
                ano, medias[0], ano, medias[1], ano, medias[2], ano, medias[3]);
    }

    public static String calcularMediaDisciplina(List<Aluno> alunos) {
        double[] medias = calcularMedias(alunos);

        return String.format("Média disciplina 1: %.2f\nMédia disciplina 2: %.2f\nMédia disciplina 3: %.2f\nMédia disciplina 4: %.2f",
                medias[0],medias[1],medias[2],medias[3]);
    }

    private static double[] calcularMedias(List<Aluno> alunos) {
        double somaNota1 = 0, somaNota2 = 0, somaNota3 = 0, somaNota4 = 0;
        int contador = alunos.size();

        for (Aluno aluno : alunos) {
            somaNota1 += aluno.getNota1();
            somaNota2 += aluno.getNota2();
            somaNota3 += aluno.getNota3();
            somaNota4 += aluno.getNota4();
        }

        return new double[]{somaNota1 / contador, somaNota2 / contador, somaNota3 / contador, somaNota4 / contador};
    }

    private static double[] calcularVariancias(List<Aluno> alunos, double[] medias) {
        double somaQuadrados1 = 0, somaQuadrados2 = 0, somaQuadrados3 = 0, somaQuadrados4 = 0;
        int contador = alunos.size();

        for (Aluno aluno : alunos) {
            somaQuadrados1 += Math.pow(aluno.getNota1() - medias[0], 2);
            somaQuadrados2 += Math.pow(aluno.getNota2() - medias[1], 2);
            somaQuadrados3 += Math.pow(aluno.getNota3() - medias[2], 2);
            somaQuadrados4 += Math.pow(aluno.getNota4() - medias[3], 2);
        }

        return new double[]{somaQuadrados1 / contador, somaQuadrados2 / contador, somaQuadrados3 / contador, somaQuadrados4 / contador};
    }

    public static String calcularDesvioPadraoDisciplinaPorAno(List<Aluno> alunos, int ano) {
        List<Aluno> alunosAno = filtrarAlunosPorAno(alunos, ano);

        if (alunosAno.isEmpty()) {
            return "Nenhum aluno encontrado para o ano " + ano;
        }

        double[] medias = calcularMedias(alunosAno);
        double[] variancias = calcularVariancias(alunosAno, medias);

        return String.format("Desvio padrão Disciplina 1 %d: %.2f\nDesvio padrão Disciplina 2 %d: %.2f\nDesvio padrão Disciplina 3 %d: %.2f\nDesvio padrão Disciplina 4 %d: %.2f",
                ano, Math.sqrt(variancias[0]), ano, Math.sqrt(variancias[1]), ano, Math.sqrt(variancias[2]), ano, Math.sqrt(variancias[3]));
    }

    public static String calcularDesvioPadraoDisciplina(List<Aluno> alunos) {
        double[] medias = calcularMedias(alunos);
        double[] variancias = calcularVariancias(alunos, medias);

        return String.format("Desvio padrão Disciplina 1: %.2f\nDesvio padrão Disciplina 2: %.2f\nDesvio padrão Disciplina 3: %.2f\nDesvio padrão Disciplina 4: %.2f",
                Math.sqrt(variancias[0]), Math.sqrt(variancias[1]), Math.sqrt(variancias[2]), Math.sqrt(variancias[3]));
    }
}
