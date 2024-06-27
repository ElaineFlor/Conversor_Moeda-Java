import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static List<Moeda> listagemConversao = new ArrayList<>();

    public void exibirMenu() throws IOException {

        Scanner leitor = new Scanner(System.in);
        int opcao;
        Moeda moeda;
        String resposta;

        while (true) {
            System.out.println(menu());
            opcao = leitor.nextInt();

            switch (opcao) {

                case 1:
                    moeda = ConversorDeMoedas.
                            checarAPI("BRL", "USD", leitor);
                    System.out.println(moeda);
                    listagemConversao.add(moeda);
                    break;

                case 2:
                    moeda = ConversorDeMoedas.
                            checarAPI("USD", "BRL", leitor);
                    System.out.println(moeda);
                    listagemConversao.add(moeda);
                    break;

                case 3:
                    moeda = ConversorDeMoedas.
                            checarAPI("BRL", "ARS", leitor);
                    System.out.println(moeda);
                    listagemConversao.add(moeda);
                    break;

                case 4:
                    moeda = ConversorDeMoedas.
                            checarAPI("BRL", "COP", leitor);
                    System.out.println(moeda);
                    listagemConversao.add(moeda);
                    break;

                case 5:
                    moeda = ConversorDeMoedas.
                            checarAPI("BRL", "CLP", leitor);
                    System.out.println(moeda);
                    listagemConversao.add(moeda);
                    break;

                case 6:
                    moeda = ConversorDeMoedas.
                            checarAPI("BRL", "BOB", leitor);
                    System.out.println(moeda);
                    listagemConversao.add(moeda);
                    break;

                case 7:
                    System.out.println("Finalizando o programa...");
                    break;

                default:
                    System.out.println("***- ERRO - Opção inválida - ***\n");

            }
            if (opcao == 7) {
                leitor.close();
                savarHistorico();
                break;
            }
            while (true) {
                System.out.println("Deseja continuar? Digite (S) para SIM ou (N) para Não: ");
                resposta = leitor.next().toUpperCase();

                if (resposta.equals("S")) {
                    break; // volta para o loop principal
                } else if (resposta.equals("N")) {
                    System.out.println("Finalizando o programa...");
                    leitor.close();
                    savarHistorico();
                    return; // sai do método
                } else {
                    System.out.println("Caractere invalido!");
                }
            }
        }
    }

    private String menu(){
        return
                """
                      Escolha uma das opções abaixo:
                -------------------------------------------
                1 - Real Brasileiro para Dólar americano
                2 - Dólar americano para Real Brasileiro
                3 - Real Brasileiro para Peso Argentino
                4 - Real Brasileiro para Peso Colombiano
                5 - Real Brasileiro para Peso chileno
                6 - Real Brasileiro para Boliviano boliviano
                7 - Sair
                -------------------------------------------
                Digite uma opção válida: """;
    }

    private void savarHistorico() throws IOException {
        var salvarArquivo = new SalvarArquivo();
        salvarArquivo.salvarJson(listagemConversao);
    }
}
