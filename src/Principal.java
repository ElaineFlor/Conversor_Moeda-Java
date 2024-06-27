import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        System.out.println("""
                \n
                ==========================================
                           CONVERSOR DE MOEDAS
                ==========================================""");

        Menu menu = new Menu();
        menu.exibirMenu();

        System.out.println("""
                ========================================== 
                  ** PROGRAMA FINALIZADO COM SUCESSO **
                ==========================================
                """);
    }
}
