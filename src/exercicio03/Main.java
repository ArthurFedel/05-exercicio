package exercicio03;

import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[3];
    static Scanner sc = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("1. Cadastrar bilhete");
            System.out.println("2. Carregar bilhete");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Passar na catraca");
            System.out.println("5. Finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
            }

        } while (opcao != 5);
    }

    private static void carregar() {
    }

    private static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if (index < bilhete.length){
            System.out.print("Nome do usuario --> ");
            nome = sc.next();
            System.out.print("CPF do usuario --> ");
            cpf = sc.nextLong();
            System.out.print("Tipo da tarifa (estudante / professor / comum) --> ");
            tipoTarifa = sc.next();
            bilhete[index] = new BilheteUnico(new Usuario(nome, cpf, tipoTarifa));
            index++;
        }
    }
}
