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
 */
public class BuscaBinaria {

    private static final Scanner INPUT = new Scanner(System.in);
    private static final List<Integer> VETOR = new ArrayList();

    private static int tamanho;
    private static int valor;
    private static int meio = 0;
    private static int iteracao = 0;

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main..
     */
    private static void preencherVetor(List<Integer> vetor) {
        int i = 0;
        System.out.println("\nDigite o vetor de tamanho " + tamanho + ", separando os elementos por espaço.");
        while (i < tamanho) {
            vetor.add(i, INPUT.nextInt());
            i++;
        }
    }

    /**
     *
     * @param vetor: referencia para o vetor instanciado na main.
     */
    private static void ordenarVetor(List<Integer> vetor) {
        System.out.println("\nOrdenando o Vetor...");
        Collections.sort(vetor);
    }

    
    /**
     * 
     * @param busca: Retorno da função de busca binária.
     */
    private static void status(int busca) {

        if (busca != -1) {
            System.out.println("Elemento procurado: " + valor
                    + "\nPosição: " + busca
                    + "\nNº de Iterações: " + iteracao);
            iteracao = 0;
        } else {
            System.out.println("Valor não encontrado\nNº de Iterações: " + iteracao);
            iteracao = 0;
        }
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
        System.out.println("\n[Busca não Recursiva]");
        int inicio = 0;
        int fim = vetor.size() - 1;
        meio = 0;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            iteracao++;

            if (valor == vetor.get(meio)) {
                status(meio);
                return meio;
            } else if (valor > vetor.get(meio)) {
                inicio = meio + 1;
            } else if (valor < vetor.get(meio)) {
                fim = meio - 1;
            }
        }
        status(-1);
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

        iteracao++;
        if (inicio > fim) {
            System.out.println("\n[Busca Recursiva]");
            status(-1);
            return -1;
        } else if (valor == vetor.get(meio)) {
            System.out.println("\n[Busca Recursiva]");
            status(meio);
            return meio;
        } else if (valor < vetor.get(meio)) {
            return buscaRecursiva(vetor, inicio, meio - 1, valor);
        } else {
            return buscaRecursiva(vetor, meio + 1, fim, valor);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Informe o tamanho do Vetor: ");
        tamanho = INPUT.nextInt();

        preencherVetor(VETOR);
        ordenarVetor(VETOR);
        exibirVetor(VETOR);

        System.out.println("\nInforme o valor que deseja procurar no vetor: ");
        valor = INPUT.nextInt();

        buscaRecursiva(VETOR, 0, tamanho - 1, valor);
        buscaNaoRecursiva(VETOR, valor);

    }
}
