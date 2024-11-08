package co.mateusvieira.bank;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scannerResponse = new Scanner(System.in);
        Bank santander = new Bank("0001");
        // C- Criar conta
        //E- Sair

        while (true) {
            System.out.println("o que deseja fazer? C= criar uma conta, E= sair do sistema");
            String op = scannerResponse.nextLine();

            if (op.equalsIgnoreCase("c")) {
                System.out.println("Digite seu nome");
                String name = scannerResponse.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);

                operateAccount(account);

            } else if (op.equalsIgnoreCase("e")) {
                break;
            } else {
                System.out.println("Operação Inválida. tente novamente.");
            }
        }

        List<Account> accountList = santander.getAccounts();
        for (Account cc: accountList) {
            System.out.println(cc);
        }

    }

        static void operateAccount(Account account) {
            Scanner scannerResponse = new Scanner(System.in);
            String response;
            do {
                System.out.println("Seja bem vindo ao banco MVM\n");
                System.out.println("Escolha uma das opções: \n");
                System.out.println("1- SAQUE");
                System.out.println("2- DEPOSITO");
                System.out.println("3- SAIR");
                int option = scannerResponse.nextInt();
                scannerResponse.nextLine();

//            if (option == 1 || option == 2) {
//                // criar conta(agencia, conta, nome)
//                // limitar o nome = 12 caracteres
//                //limitar agencia = 4 caracteres
//                //limitar conta = 5 caracteres

                if (option == 1) {
                    // sacar valores
                    //  não pode sacar mais do que tem
                    System.out.println("Digite o valor que deseja sacar: ");
                    double value = scannerResponse.nextDouble();
                    scannerResponse.nextLine();
                    boolean succeed = account.withDraw(value);
                    if (!succeed) {
                        System.out.println("Saldo insuficiente para o saque!");
                    }
                } else if (option == 2) {
                    // depositar
                    System.out.println("Digite o valor que deseja depositar: ");
                    double value = scannerResponse.nextDouble();
                    scannerResponse.nextLine();
                    account.deposit(value);


                    // informar para o usuário as operações (saque, depósito)
                    System.out.println(account);
                } else if (option == 3){
                    break;
                } else {
                    System.out.println("Comando inválido! Tente novamente.");
                }
                System.out.println("Deseja realizar outra operação? (s/n): ");
                response = scannerResponse.nextLine();
            }while (response.equalsIgnoreCase("s"));
        }

}

