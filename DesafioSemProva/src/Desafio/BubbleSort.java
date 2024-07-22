package Desafio;

import java.util.List;

public class BubbleSort {
    public static List<AlunoMedia> ordenarCrescente(List<AlunoMedia> lista) {
        boolean trocou = true;
        int contador = 0;
        do {
            trocou = false;
            for (int x = 0; x < lista.size() - 1; x++) {
                contador++;
                if (lista.get(x).getMedia() > lista.get(x + 1).getMedia()) {
                    AlunoMedia valor = lista.get(x);
                    lista.set(x, lista.get(x + 1));
                    lista.set(x + 1, valor);
                    trocou = true;
                }
            }
        } while (trocou);
        System.out.println(contador);
        return lista;
    }
    public static List<Aluno> ordenarCrescente1(List<Aluno> lista) {
        boolean trocou = true;
        int contador = 0;
        do {
            trocou = false;
            for (int x = 0; x < lista.size() - 1; x++) {
                contador++;
                if (lista.get(x).getNota1() > lista.get(x + 1).getNota1()) {
                    Aluno valor = lista.get(x);
                    lista.set(x, lista.get(x + 1));
                    lista.set(x + 1, valor);
                    trocou = true;
                }
            }
        } while (trocou);
        System.out.println(contador);
        return lista;
    }
    public static List<Aluno> ordenarCrescente2(List<Aluno> lista) {
        boolean trocou = true;
        int contador = 0;
        do {
            trocou = false;
            for (int x = 0; x < lista.size() - 1; x++) {
                contador++;
                if (lista.get(x).getNota2() > lista.get(x + 1).getNota2()) {
                    Aluno valor = lista.get(x);
                    lista.set(x, lista.get(x + 1));
                    lista.set(x + 1, valor);
                    trocou = true;
                }
            }
        } while (trocou);
        System.out.println(contador);
        return lista;
    }
    public static List<Aluno> ordenarCrescente3(List<Aluno> lista) {
        boolean trocou = true;
        int contador = 0;
        do {
            trocou = false;
            for (int x = 0; x < lista.size() - 1; x++) {
                contador++;
                if (lista.get(x).getNota3() > lista.get(x + 1).getNota3()) {
                    Aluno valor = lista.get(x);
                    lista.set(x, lista.get(x + 1));
                    lista.set(x + 1, valor);
                    trocou = true;
                }
            }
        } while (trocou);
        System.out.println(contador);
        return lista;
    }
    public static List<Aluno> ordenarCrescente4(List<Aluno> lista) {
        boolean trocou = true;
        int contador = 0;
        do {
            trocou = false;
            for (int x = 0; x < lista.size() - 1; x++) {
                contador++;
                if (lista.get(x).getNota4() > lista.get(x + 1).getNota4()) {
                    Aluno valor = lista.get(x);
                    lista.set(x, lista.get(x + 1));
                    lista.set(x + 1, valor);
                    trocou = true;
                }
            }
        } while (trocou);
        System.out.println(contador);
        return lista;
    }
    public static List<AlunoMedia> ordenarDecrescente(List<AlunoMedia> lista) {
        boolean trocou = true;
        int contador = 0;
        do {
            trocou = false;
            for (int x = 0; x < lista.size() - 1; x++) {
                contador++;
                if (lista.get(x).getMedia() < lista.get(x + 1).getMedia()) {
                    AlunoMedia valor = lista.get(x);
                    lista.set(x, lista.get(x + 1));
                    lista.set(x + 1, valor);
                    trocou = true;
                }
            }
        } while (trocou);
        System.out.println(contador);
        return lista;
    }
}
