package org.pi;

import java.util.Scanner;

/**
 *
 * @author VITÓRIA E OS PREGUIÇAS
 */
public class Principal_Menu {
    public static void main(String[] args) {
        String[][] matrizCliente = new String[0][8];
        String[][] matrizContato = new String[0][5];
        menuPrincipal(matrizCliente, matrizContato);
    }


    public static void menuPrincipal(String[][] matrizCliente, String[][] matrizContato) {
        int opçaoPrincipal = -1;
        do {
            Scanner leia = new Scanner(System.in);
            System.out.println("-------------------------------");
            System.out.println("        MENU PRINCIPAL         ");
            System.out.println("-------------------------------");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Contatos");
            System.out.println("3. Relatórios");
            System.out.println("0. Sair");
            System.out.println("Digite o número corresponde a operação que deseja realizar: ");
            opçaoPrincipal = leia.nextInt();


            switch (opçaoPrincipal) {
                case 1:
                    menuGerenciarCliente(matrizCliente);
                    break;
                case 2:
                    menuGerenciarContatos(matrizContato);
                    break;
                case 3:
                    relatorioFinal(matrizCliente, matrizContato);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção Inválida! Digite novamente.");
                    break;
            }

        } while (opçaoPrincipal != 0);
    }

    // Função CRUD DE CLIENTES
    private static void menuGerenciarCliente(String[][] matrizCliente) {
        int opcaoCliente = -1;
        do {
            Scanner leia = new Scanner(System.in);
            System.out.println("----------------------------------------");
            System.out.println("        MENU GERENCIAR CLIENTES         ");
            System.out.println("----------------------------------------");
            System.out.println("1. Incluir cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Consultar cliente via código");
            System.out.println("4. Alterar cliente");
            System.out.println("5. Apagar cliente");
            System.out.println("6. Ordenar por nome");
            System.out.println("0. Voltar");
            System.out.println("Digite o número corresponde a operação que deseja realizar: ");
            opcaoCliente = leia.nextInt();

            switch (opcaoCliente) {
                case 1:
                    matrizCliente = aumentarMatriz(matrizCliente);
                    incluirCliente(matrizCliente);
                    break;
                case 2:
                    listarCliente(matrizCliente);
                    break;
                case 3:
                    consultarCliente(matrizCliente);
                    break;
                case 4:
                    alterarCliente(matrizCliente);
                    break;
                case 5:
                    matrizCliente = apagarCliente(matrizCliente);

                    break;
                case 6:
                    ordenarPorNome(matrizCliente);
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção Inválida! Digite novamente.");
                    break;
            }

        } while (opcaoCliente != 0);
    }

    // Criando uma matriz que aumenta  a nossa matriz principal de Clientes
    public static String[][] aumentarMatriz(String[][] matrizAntigaCl) {
        String[][] novaCliente = new String[matrizAntigaCl.length + 1][8];
        for (int i = 0; i < matrizAntigaCl.length; i++) {
            for (int j = 0; j < 8; j++) {
                novaCliente[i][j] = matrizAntigaCl[i][j];
            }
        }
        return novaCliente;
    }


    // Função MENU GERENCIAR CONTATOS
    private static void menuGerenciarContatos(String[][] matrizContato) {

    }

    // Criando uma matriz que aumenta a nossa matriz principal de Contatos
    //cria uma maior, copia matrizantiga, devolve a nova
    public static String[][] aumentoMatriz(String[][] matrizAntigaCo) {
        String[][] novaContato = new String[matrizAntigaCo.length + 1][5];
        for (int i = 0; i < matrizAntigaCo.length; i++) {
            for (int j = 0; j < 5; j++) {
                novaContato[i][j] = matrizAntigaCo[i][j];
            }
        }
        return novaContato;
    }


    // Função RELATAR TODOS OS DADOS NO FINAL
    private static void relatorioFinal(String[][] matrizCliente, String[][] matrizContato) {

    }

    // Função que coleta/registar os dados do CLIENTE
    private static void incluirCliente(String[][] matrizCliente) {
        int novaLinha = matrizCliente.length - 1;
        matrizCliente[novaLinha][0] = String.valueOf(novaLinha + 1);

        Scanner leia = new Scanner(System.in);
        System.out.println("------ CADASTRANDO O CLIENTE ------");
        System.out.println("Digite o Nome do cliente : ");
        matrizCliente[novaLinha][1] = leia.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        matrizCliente[novaLinha][2] = leia.nextLine();
        System.out.println("Digite a Data de Nascimento do cliente: ");
        matrizCliente[novaLinha][3] = leia.nextLine();
        System.out.println("Digite o Sexo do cliente: ");
        matrizCliente[novaLinha][4] = leia.nextLine();
        System.out.println("Digite a Cidade do cliente: ");
        matrizCliente[novaLinha][5] = leia.nextLine();
        System.out.println("Digite o Estado do cliente: ");
        matrizCliente[novaLinha][6] = leia.nextLine();
        System.out.println("Digite o Status do cliente: ");
        matrizCliente[novaLinha][7] = leia.nextLine();
        System.out.println("Cadastro realizado com sucesso!");

    }


    private static void listarCliente(String[][] matrizCliente) {
        if (matrizCliente.length == 0) {
            System.out.println("Nenhum cadastro foi encontrado");
        } else {
            System.out.print("Código    | ");
            System.out.print("Nome      | ");
            System.out.print("CPF       | ");
            System.out.print("Nascimento    | ");
            System.out.print("Sexo       | ");
            System.out.print("Cidade     | ");
            System.out.print("Estado     | ");
            System.out.println("Status     | ");
            System.out.println("----------------------------------------------");
            for (int i = 0; i < matrizCliente.length; i++) {
                System.out.println(i + "  |  ");
                System.out.println(matrizCliente[i][0] + "  |  ");
                System.out.println(matrizCliente[i][1] + "  |  ");
                System.out.println(matrizCliente[i][2] + "  |  ");
                System.out.println(matrizCliente[i][3] + "  |  ");
                System.out.println(matrizCliente[i][4] + "  |  ");
                System.out.println(matrizCliente[i][5] + "  |  ");
                System.out.println(matrizCliente[i][6] + "  |  ");
                System.out.println(matrizCliente[i][7] + "  |  ");

            }
        }
    }

    private static void consultarCliente(String[][] matrizCliente) {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite o código do cliente: ");
        String codiBusca = leia.next();
        boolean achou = false;

        for (String[] matrizCliente1 : matrizCliente) {
            if (matrizCliente1[0].equals(codiBusca)) {
                achou = true;
                System.out.println("----------------------------------------");
                System.out.println("           CLIENTE ENCONTRADO           ");
                System.out.println("----------------------------------------");

                System.out.println("Código     | " + matrizCliente1[0]);
                System.out.println("Nome       | " + matrizCliente1[1]);
                System.out.println("CPF        | " + matrizCliente1[2]);
                System.out.println("Nascimento    | " + matrizCliente1[3]);
                System.out.println("Sexo       | " + matrizCliente1[4]);
                System.out.println("Cidade     | " + matrizCliente1[5]);
                System.out.println("Estado     | " + matrizCliente1[6]);
                System.out.println("Status   | " + matrizCliente1[7]);
                break;
            }
        }
        if (achou == false) {
            System.out.println("Cliente não encontrado1");
        }
    }


    private static void alterarCliente(String[][] matrizCliente) {
        Scanner leia = new Scanner(System.in);

        System.out.println("-- ALTERAR DADOS --");
        System.out.println("Digite o código do cliente:");
        String codigoBusca = leia.nextLine();

        boolean achou = false;

        for (int i = 0; i < matrizCliente.length; i++) { //percorre todas as linhas

            if (matrizCliente[i][0].equals(codigoBusca)) { // i sempre aumenta por conta do for, quando i = numero digitado ;  ele entra no if

                achou = true; // por mais que if seja true, o achou ainda era false
                // serve para não aparecer "Cliente não encontrado" no final

                System.out.println("Cliente encontrado!");

                //alterar os dados
                System.out.println("Digite o novo nome: ");
                matrizCliente[i][1] = leia.nextLine();

                System.out.println("Digite o novo CPF: ");
                matrizCliente[i][2] = leia.nextLine();

                System.out.println("Digite a nova data de nascimento: ");
                matrizCliente[i][3] = leia.nextLine();

                System.out.println("Digite o novo sexo: ");
                matrizCliente[i][4] = leia.nextLine();

                System.out.println("Digite a nova cidade: ");
                matrizCliente[i][5] = leia.nextLine();

                System.out.println("Digite o novo estado: ");
                matrizCliente[i][6] = leia.nextLine();

                System.out.println("Digite o novo status: ");
                matrizCliente[i][7] = leia.nextLine();

                System.out.println("Cliente alterado com sucesso!");

                break;
            }
        }

        if (achou == false) {
            System.out.println("Cliente não encontrado.");
        }
    }


    private static String[][] apagarCliente(String[][] matrizCliente) {

        Scanner leia = new Scanner(System.in);

        System.out.println("-- APAGAR CLIENTE --");
        System.out.println("Digite o código do cliente que deseja apagar:");
        String codigoBusca = leia.nextLine();

        boolean achou = false;


        String[][] novaMatriz = new String[matrizCliente.length - 1][8]; // cria nova matriz com -1 linha
        // é apenas uma matriz com um espaço a menos, ela ainda não sabe qual cliente vai de comes
        // ainda não há dados dentro dela

        int novaLinha = 0;


        for (int i = 0; i < matrizCliente.length; i++) { // percorre todas as linhas da matriz antiga


            //PULAR O CLIENTE QUE VAI SER APAGADO //
            if (matrizCliente[i][0].equals(codigoBusca)) { // verifica se o código da linha atual é igual ao digitado

                achou = true;  // por mais que if seja true, o achou ainda era false
                // serve para não aparecer "Cliente não encontrado" no final

                continue; // pula o cliente encontrado (não copia ele); mas o i vai continuando copiando o resto das linhas
            }


            if (novaLinha < novaMatriz.length) { // evita erro caso o cliente não exista


                for (int j = 0; j < 8; j++) { // percorre todas as colunas


                    novaMatriz[novaLinha][j] = matrizCliente[i][j]; // copia os dados da matriz antiga para a nova
                }


                novaLinha++; // passa para próxima linha da nova matriz
            }
        }


        if (achou == false) { // se nunca encontrou o cliente

            System.out.println("Cliente não encontrado.");


            return matrizCliente; // retorna matriz original sem alterações
        }

        System.out.println("Cliente apagado com sucesso!");


        return novaMatriz; // retorna matriz nova sem o cliente apagado
    }


    private static void ordenarPorNome(String[][] matrizCliente) {
        for (int i = 0; i < matrizCliente.length; i++) {
            for (int j = 1; j < matrizCliente.length; j++) {
                if (maiorNome(matrizCliente[i][1], matrizCliente[j][1])) {

                    String codigo = matrizCliente[i][0];
                    String nome = matrizCliente[i][1];
                    String cpf = matrizCliente[i][2];
                    String nasc = matrizCliente[i][3];
                    String sexo = matrizCliente[i][4];
                    String cidade = matrizCliente[i][5];
                    String estado = matrizCliente[i][6];
                    String status = matrizCliente[i][7];


                    matrizCliente[i][0] = matrizCliente[j][0];
                    matrizCliente[i][1] = matrizCliente[j][1];
                    matrizCliente[i][2] = matrizCliente[j][2];
                    matrizCliente[i][3] = matrizCliente[j][3];
                    matrizCliente[i][4] = matrizCliente[j][4];
                    matrizCliente[i][5] = matrizCliente[j][5];
                    matrizCliente[i][6] = matrizCliente[j][6];
                    matrizCliente[i][7] = matrizCliente[j][7];

                    matrizCliente[j][0] = codigo;
                    matrizCliente[j][1] = nome;
                    matrizCliente[j][2] = cpf;
                    matrizCliente[j][3] = nasc;
                    matrizCliente[j][4] = sexo;
                    matrizCliente[j][5] = cidade;
                    matrizCliente[j][6] = estado;
                    matrizCliente[j][7] = status;
                }

            }
        }
    }

    // Função que guarda o maior nome
    private static boolean maiorNome(String nome1, String nome2) {
        nome1 = nome1.toUpperCase();
        nome2 = nome2.toUpperCase();

        int menorTamanho;

        if (nome1.length() < nome2.length()) {
            menorTamanho = nome1.length();
        } else {
            menorTamanho = nome2.length();
        }
        for (int i = 0; i < menorTamanho; i++) {
            char letra1 = nome1.charAt(i);
            char letra2 = nome2.charAt(i);

            if (letra1 > letra2) {
                return true;
            } else if (letra1 < letra2) {
                return false;
            }
        }
        if (nome1.length() > nome2.length()) {
            return true;
        } else {
            return false;
        }
    }
}





