package br.com.javalist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Gato> gatos = new ArrayList<>() {{
            add(new Gato("tobias", 12, "preto"));
            add(new Gato("xaninha", 6, "branca"));
            add(new Gato("jaum", 5, "verde"));
            add(new Gato("smells", 1, "amarelo"));
        }};

        System.out.println(gatos);
        Collections.shuffle(gatos);
        System.out.println(gatos);
        gatos.sort(new Gato.Gatoo());
        gatos.sort(new Gato.Gatooo());
        gatos.sort(new Gato.Gatoooo());
        System.out.println(gatos);
    }

    static class Gato implements Comparable<Gato> {
        private final String nome;
        private final int idade;
        private final String cor;

        public Gato(String nome, int idade, String cor) {
            this.nome = nome;
            this.idade = idade;
            this.cor = cor;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public String getCor() {
            return cor;
        }

        @Override
        public String toString() {
            return "Gato{" +
                    "nome='" + nome + '\'' +
                    ", idade=" + idade +
                    ", cor='" + cor + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Gato o) {
            return this.getNome().compareToIgnoreCase(o.getNome());
        }

        static class Gatoo implements Comparator<Gato> {

            @Override
            public int compare(Gato o1, Gato o2) {
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        }

        static class Gatooo implements Comparator<Gato> {

            @Override
            public int compare(Gato o1, Gato o2) {
                return o1.getCor().compareToIgnoreCase(o2.getCor());
            }
        }

        static class Gatoooo implements Comparator<Gato> {

            @Override
            public int compare(Gato o1, Gato o2) {
                int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
                int cor = o1.getCor().compareToIgnoreCase(o2.getCor());

                if (nome != 0) {
                    return nome;
                }
                if (cor != 0) {
                    return cor;
                }
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        }
    }
}
