import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("MENU");
            System.out.println("1 - Usuarios");
            System.out.println("2 - Livros");
            System.out.println("3 - Fornecedor");
            System.out.println("4 - Sair");
            System.out.println("----------------------------------------------");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                CRUDUsuario crudUsuario = new CRUDUsuario(); //fachada (Padrão GoF Facade)
                crudUsuario.mostrarSubMenu();
            } if (opcao == 2) {
                CRUDLivro CRUDLivro = new CRUDLivro(); //fachada (Padrão GoF Facade)
                CRUDLivro.mostrarSubMenu();
            } if (opcao == 3) {
                CRUDFornecedor CRUDFornecedor = new CRUDFornecedor(); //fachada (Padrão GoF Facade)
                CRUDFornecedor.mostrarSubMenu();
            } if (opcao == 4) {
                break;
            }
        }
    }
}
