/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscabinaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marcos Antonio Silva Lima
 *
 */
public class BuscaBinaria {

    private static int iteracao = 0;
    private static int meio = 0;

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main..
     * @param input: referencia para o objeto instanciado na main.
     */
    private static void preencherVetor(List<Integer> vetor, Scanner input, int tam) {
        int i = 0;
        System.out.println("Digite o vetor de tamanho " + tam + ", separando os elementos por espaço.");
        while (i < tam) {
            vetor.add(i, input.nextInt());
            i++;
        }
    }

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main.
     */
    private static void ordenarVetor(List<Integer> vetor) {
        System.out.println("Ordenando o Vetor...");
        Collections.sort(vetor);
    }

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main.
     */
    private static void exibirVetor(List<Integer> vetor) {
        System.out.println(vetor.toString());
    }

    /**
     *
     * @param vetor, recebe o vetor onde sera feita a busca
     * @param valor, elemento a ser procurado no vetor
     * @return retorna o numero de Iterações
     */
    private static int buscaNaoRecursiva(List<Integer> vetor, int valor) {
        int inicio = 0;
        int fim = vetor.size() - 1;
        meio = 0;

        while (inicio <= fim) {
            iteracao++;
            meio = (inicio + fim) / 2;
            if (valor < vetor.get(meio)) {
                fim = meio - 1;
            } else if (valor > vetor.get(meio)) {
                inicio = meio + 1;
            } else {
                return meio;
            }
        }
        return -1;
    }

    /**
     *
     * @param vetor, recebe o vetor onde será feita a busca.
     * @param inicio, define o inicio do vetor.
     * @param fim, define o final do vetor.
     * @param valor, valor a ser procurado.
     * @return retorna o numero de Iterações.
     */
    private static int buscaRecursiva(List<Integer> vetor, int inicio, int fim, int valor) {
        meio = (inicio + fim) / 2;

        if (inicio > fim) {
            return -1;
        } else if (valor == vetor.get(meio)) {
            iteracao++;
            return meio;
        } else if (valor < vetor.get(meio)) {
            iteracao++;
            return buscaRecursiva(vetor, inicio, meio - 1, valor);
        } else {
            iteracao++;
            return buscaRecursiva(vetor, meio + 1, fim, valor);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o tamanho do Vetor: ");
        final int TAM = input.nextInt();
        List<Integer> vetor = new ArrayList();
        

        preencherVetor(vetor, input, TAM);
        ordenarVetor(vetor);
        exibirVetor(vetor);

        System.out.println("\nInforme o valor que deseja procurar no vetor: ");
        int valor = input.nextInt();

        iteracao = 0;
        int buscaNaoRecursiva = buscaNaoRecursiva(vetor, valor);
        System.out.println("[Busca não Recursiva]");
        if (buscaNaoRecursiva != -1) {
            System.out.println("Elemento procurado: " + valor 
                    + "\nPosição: " + buscaNaoRecursiva 
                    + "\nNº de Iterações: " + iteracao);
        } else {
            System.out.println("Valor não encontrado\nNº de Iterações: " + iteracao);
        }

        iteracao = 0;
        int buscaRecursiva = buscaRecursiva(vetor, 0, vetor.size() - 1, valor);
        System.out.println("\n[Busca Recursiva]");
        if (buscaRecursiva != -1) {
            System.out.println("Elemento procurado: " + valor 
                    + "\nPosição: " + buscaRecursiva 
                    + "\nNº de Iterações: " + iteracao);
        } else {
            System.out.println("Valor não encontrado\nNº de Iterações: " + iteracao);
        }
    }
}
