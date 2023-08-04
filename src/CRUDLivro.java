import java.util.ArrayList;
import java.util.Scanner;

public class CRUDLivro {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Livro> listaLivro = new ArrayList<>();

    public void mostrarSubMenu() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("SUBMENU");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Visualizar Livros cadastrados");
            System.out.println("3 - Atualizar cadastro de um Livro");
            System.out.println("4 - Deletar Livro");
            System.out.println("5 - Voltar");

            int opcaoSubMenu = scanner.nextInt();
            scanner.nextLine();

            if (opcaoSubMenu == 1) {
                System.out.println("Cadastrar Livro");
                System.out.println("Digite o Código do Livro a ser cadastrado:");
                String codigo = scanner.nextLine();
                System.out.println("Digite o Título do Livro a ser cadastrado:");
                String titulo = scanner.nextLine();
                System.out.println("Digite a Edição do Livro a ser cadastrado:");
                String edicao = scanner.nextLine();
                System.out.println("Digite o nome do Autor do Livro a ser cadastrado:");
                String autor = scanner.nextLine();
                System.out.println("----------------------------------------------");

                Livro livroNovo = new Livro();

                livroNovo.create(codigo, titulo, edicao, autor); //chamada do método que cria
                listaLivro.add(livroNovo);

                System.out.println("Livro cadastrado com sucesso!");

            } if (opcaoSubMenu == 2) {
                System.out.println("Visualização de Livro(s) cadastrado(s)");
                System.out.println("Digite o CÓDIGO do Livro:");

                String codigoPesquisa = scanner.nextLine();

                for (int i = 0; i < listaLivro.size(); i++) {
                    if (listaLivro.get(i).codigo.equals(codigoPesquisa)) {
                        listaLivro.get(i).read();
                    }
                }
            } if (opcaoSubMenu == 3) {
                System.out.println("Atualização de cadastro(s) de Livro(s)");
                System.out.println("Digite o Código do Livro que deseja modificar:");

                String codigoPesquisa = scanner.nextLine();

                for (int i = 0; i < listaLivro.size(); i++) {
                    if (listaLivro.get(i).codigo.equals(codigoPesquisa)) {

                        System.out.println("O que você deseja atualizar?");
                        System.out.println("1 - Título");
                        System.out.println("2 - Autor");

                        int opcaoSubSubMenu = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoSubSubMenu == 1) {
                            System.out.println("Digite um novo Título para o Livro: ");
                            String novoTitulo = scanner.nextLine();
                            listaLivro.get(i).update(1, novoTitulo);
                            System.out.println("Título atualizado com sucesso.");
                        }
                        if (opcaoSubSubMenu == 2) {
                            System.out.println("Digite o novo Autor: ");
                            String novoAutor = scanner.nextLine();
                            listaLivro.get(i).update(2, novoAutor);
                            System.out.println("Autor atualizado com sucesso.");
                        }
                    }
                }
            } if (opcaoSubMenu == 4) {
                System.out.println("Deletar Livro");
                System.out.println("Digite o Código do Livro que deseja deletar:");

                String codigoPesquisa = scanner.nextLine();

                for (int i = 0; i < listaLivro.size(); i++) {
                    if (listaLivro.get(i).codigo.equals(codigoPesquisa)) {
                        listaLivro.get(i).delete(listaLivro.get(i));
                    }
                }

                System.out.println("Livro removido.");
                System.out.println("Lista de Livros Cadastrados:");

                for (int i = 0; i < listaLivro.size(); i++) {
                    System.out.println(listaLivro.get(i).codigo);
                }
            } if (opcaoSubMenu == 5) {
                break;
            }
        }
    }

    public class Livro {
        //classe responsável por "criar" um livro, pois possui dados para inicialização do mesmo (Padrão GRASP Creator)

        String codigo;
        String titulo;
        String edicao;
        String autor;
        public String getCodigo() {
            return codigo;
        }
        public String getTitulo() {
            return titulo;
        }
        public String getEdicao() {
            return edicao;
        }
        public String getAutor() {
            return autor;
        }


        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }
        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        public void setEdicao(String edicao) {
            this.edicao = edicao;
        }
        public void setAutor(String autor) {
            this.autor = autor;
        }


        //método responsável por criar o fornecedor
        public void create(String codigo, String titulo, String edicao, String autor ) {
            setCodigo(codigo);
            setTitulo(titulo);
            setEdicao(edicao);
            setAutor(autor);
        }

        public void read() {
            System.out.println("CÓDIGO: " + getCodigo());
            System.out.println("TÍTULO: " + getTitulo());
            System.out.println("EDIÇÃO: " + getEdicao());
            System.out.println("AUTOR: " + getAutor());
        }

        public void update(int opcao, String novoDado) {
            if (opcao == 1) {
                setTitulo(novoDado);
            } if (opcao == 2) {
                setAutor(novoDado);
            }
        }

        public void delete(Livro livro) {
            listaLivro.remove(livro);
        }
    }

}
