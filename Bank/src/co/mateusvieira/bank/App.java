package co.mateusvieira.bank;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scannerResponse = new Scanner(System.in);
        String response;

        Scanner scannerName = new Scanner(System.in);
        System.out.println("Digite o nome do titular da conta: ");
        String name = scannerName.nextLine();
        Scanner scannerAg = new Scanner(System.in);
        System.out.println("Digite a agencia da conta: ");
        String ag = scannerAg.nextLine();
        Scanner scannerCc = new Scanner(System.in);
        System.out.println("Digite o numero da conta: ");
        String cc = scannerCc.nextLine();
        Account account = new Account(ag, cc, name);

        do {
            System.out.println("Seja bem vindo ao banco MVM\n");
            System.out.println("Escolha uma das opções: \n");
            Scanner scannerOption = new Scanner(System.in);
            System.out.println("1- SAQUE");
            System.out.println("2- DEPOSITO");
            System.out.println("3- SAIR");
            int option = scannerOption.nextInt();

//            if (option == 1 || option == 2) {
//                // criar conta(agencia, conta, nome)
//                // limitar o nome = 12 caracteres
//                //limitar agencia = 4 caracteres
//                //limitar conta = 5 caracteres

            if (option == 1) {
                    // sacar valores
                    //  não pode sacar mais do que tem
                Scanner scannerWithDraw = new Scanner(System.in);
                System.out.println("Digite o valor que deseja sacar: ");
                double withDraw = scannerWithDraw.nextDouble();
                boolean succeed = account.withDraw(withDraw);
                if (!succeed) {
                    System.out.println("Saldo insuficiente para o saque!");
                }
            } else if (option == 2) {
                    // depositar
                Scanner scannerDeposit = new Scanner(System.in);
                System.out.println("Digite o valor que deseja depositar: ");
                double deposit = scannerDeposit.nextDouble();
                account.deposit(deposit);


                    // informar para o usuário as operações (saque, depósito)
                    System.out.println(account);
                } else {
                break;
            }
            System.out.println("Deseja realizar outra operação? (s/n): ");
            response = scannerResponse.nextLine();
         }while (response.equalsIgnoreCase("s"));

        System.out.println("Programa Encerrado");
        }










    }

