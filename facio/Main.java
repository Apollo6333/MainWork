package facio;

import java.util.Random;

public class Main {

    public Main() {

    try {

    Random random = new Random();
    int resultado = random.nextInt(2); // Isso pode resultar em 0 ou 1

    if (resultado == 0) {
        throw new Exception("Exemplo de exceção lançada aleatoriamente");
    } else {
        System.out.println("Operação bem-sucedida!");
    }

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Este bloco sempre será executado, independentemente de ocorrer uma exceção ou não.");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
