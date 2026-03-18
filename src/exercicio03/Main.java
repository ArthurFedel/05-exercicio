package exercicio03;

import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[3];
    static Scanner sc = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n1. Cadastrar bilhete");
            System.out.println("2. Carregar bilhete");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Passar na catraca");
            System.out.println("5. Finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> consultar();
                case 4 -> passar();
                case 5 -> System.out.println("Até breve!");
                default -> System.out.println("Opção inválida!\n");
            }

        } while (opcao != 5);
    }

    public static void passar() {
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            if (!bilheteUnico.passarNaCatraca()){
                System.out.println("Saldo insuficinete! ");
            }
            System.out.println("Saldo atual --> " + bilheteUnico.saldo);
        }
    }

    public static void consultar() {
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
             System.out.println("Saldo do bilhete --> " + bilheteUnico.saldo);
        }
    }

    public static void carregar() {
        double valor;
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null){
            System.out.print("Valor da recarga --> ");
            valor = sc.nextDouble();
            bilheteUnico.carregar(valor);
        }
    }

    public static void cadastrar() {
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
        } else {
            System.out.println("Errro ao gerar bilhete! Procure um posto de atendimente.");
        }
    }

    public static BilheteUnico pesquisar() {
        long cpf;
        System.out.println("CPF para pesquisar");
        cpf = sc.nextLong();
        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf == cpf){
                return bilhete[i];
            }
        }
        System.out.println("Bilhete não encontrado! ");
        return null;
    }
}
