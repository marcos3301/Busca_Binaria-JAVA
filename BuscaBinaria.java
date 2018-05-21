/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscabinaria;

import java.util.Arrays;
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
    private static void preencherVetor(int[] vetor, Scanner input) {
        int i = 0;
        System.out.println("Digite o vetor de tamanho " + vetor.length + ", separando os elementos por espaço.");
        while (i < vetor.length) {
            vetor[i] = input.nextInt();
            i++;
        }
    }

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main.
     */
    private static void ordenarVetor(int[] vetor) {
        System.out.println("Ordenando o Vetor:");
        Arrays.sort(vetor);
    }

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main.
     */
    private static void exibirVetor(int[] vetor) {
        int i = 0;
        while (i < vetor.length) {
            System.out.print(vetor[i] + " ");
            i++;
        }
    }

    /**
     *
     * @param vet, recebe o vetor onde sera feita a busca
     * @param valor, elemento a ser procurado no vetor
     * @return retorna o numero de Iterações
     */
    private static int buscaNaoRecursiva(int[] vet, int valor) {
        int inicio = 0;
        int fim = vet.length - 1;
        meio = 0;

        while (inicio <= fim) {
            iteracao++;
            meio = (inicio + fim) / 2;
            if (valor < vet[meio]) {
                fim = meio - 1;
            } else if (valor > vet[meio]) {
                inicio = meio + 1;
            } else {
                return meio;
            }
        }
        iteracao++;
        return -1;
    }

    /**
     *
     * @param vet, recebe o vetor onde será feita a busca.
     * @param inicio, define o inicio do vetor.
     * @param fim, define o final do vetor.
     * @param valor, valor a ser procurado.
     * @return retorna o numero de Iterações.
     */
    private static int buscaRecursiva(int[] vet, int inicio, int fim, int valor) {
        iteracao++;
        meio = (inicio + fim) / 2;

        if (inicio > fim) {
            return -1;
        } else if (valor == vet[meio]) {
            return meio;
        } else if (valor < vet[meio]) {
            return buscaRecursiva(vet, inicio, meio - 1, valor);
        } else {
            return buscaRecursiva(vet, meio + 1, fim, valor);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o tamanho do Vetor: ");
        final int TAM = input.nextInt();
        int[] vetor = new int[TAM];

        preencherVetor(vetor, input);
        ordenarVetor(vetor);
        exibirVetor(vetor);

        System.out.println("\nInforme o valor que deseja procurar no vetor: ");
        int valor = input.nextInt();

        iteracao = 0;
        System.out.println("[Busca não Recursiva]");
        if (buscaNaoRecursiva(vetor, valor) != -1) {
            System.out.println("Elemento procurado: " + valor 
                    + "\nPosição: " + buscaNaoRecursiva(vetor, valor) 
                    + "\nNº de Iterações: " + iteracao);
        } else {
            System.out.println("Valor não encontrado\nNº de Iterações: " + iteracao);
        }

        iteracao = 0;
        System.out.println("\n[Busca Recursiva]");
        if (buscaRecursiva(vetor, 0, vetor.length - 1, valor) != -1) {
            System.out.println("Elemento procurado: " + valor 
                    + "\nPosição: " + buscaRecursiva(vetor, 0, vetor.length - 1, valor) 
                    + "\nNº de Iterações: " + iteracao);
        } else {
            System.out.println("Valor não encontrado\nNº de Iterações: " + iteracao);
        }
    }
}
