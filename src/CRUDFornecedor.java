import java.util.ArrayList;
import java.util.Scanner;

public class CRUDFornecedor {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Fornecedor> listaFornecedor = new ArrayList<>();

    public void mostrarSubMenu() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("SUBMENU");
            System.out.println("1 - Cadastrar fornecedor");
            System.out.println("2 - Visualizar fornecedor cadastrado");
            System.out.println("3 - Atualizar cadastro de fornecedor");
            System.out.println("4 - Deletar fornecedor");
            System.out.println("5 - Voltar");

            int opcaoSubMenu = scanner.nextInt();
            scanner.nextLine();

            if (opcaoSubMenu == 1) {
                System.out.println("Cadastro de fornecedor");
                System.out.println("Digite o CNPJ do fornecedor a ser cadastrado:");
                String cnpj = scanner.nextLine();
                System.out.println("Digite a RAZÃO SOCIAL do fornecedor a ser cadastrado:");
                String razaoSocial = scanner.nextLine();
                System.out.println("Digite o NOME FANTASIA do forncedor a ser cadastrado:");
                String nomeFantasia = scanner.nextLine();
                System.out.println("Digite o TELEFONE do fornecedor a ser cadastrado:");
                String telefone = scanner.nextLine();
                System.out.println("Digite o E-MAIL do usuario a ser cadastrado:");
                String email = scanner.nextLine();
                System.out.println("----------------------------------------------");

                Fornecedor fornecedorNovo = new Fornecedor();

                fornecedorNovo.create(cnpj, razaoSocial, nomeFantasia, telefone, email); //chamada do método que cria
                listaFornecedor.add(fornecedorNovo);

                System.out.println("Fornecedor cadastrado com sucesso!");

            } if (opcaoSubMenu == 2) {
                System.out.println("Visualizacao de fornecedor cadastrado");
                System.out.println("Digite o CNPJ do usuario:");

                String cnpjPesquisa = scanner.nextLine();

                for (int i = 0; i < listaFornecedor.size(); i++) {
                    if (listaFornecedor.get(i).cnpj.equals(cnpjPesquisa)) {
                        listaFornecedor.get(i).read();
                    }
                }
            } if (opcaoSubMenu == 3) {
                System.out.println("Atualizacao de cadastro de fornecedor");
                System.out.println("Digite o CNPJ do fornecedor:");

                String cnpjPesquisa = scanner.nextLine();

                for (int i = 0; i < listaFornecedor.size(); i++) {
                    if (listaFornecedor.get(i).cnpj.equals(cnpjPesquisa)) {

                        System.out.println("O que voce deseja atualizar?");
                        System.out.println("1 - Telefone");
                        System.out.println("2 - E-mail");

                        int opcaoSubSubMenu = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoSubSubMenu == 1) {
                            System.out.println("Digite o novo numero de telefone: ");
                            String novoTelefone = scanner.nextLine();
                            listaFornecedor.get(i).update(1, novoTelefone);
                            System.out.println("Telefone atualizado com sucesso.");
                        }
                        if (opcaoSubSubMenu == 2) {
                            System.out.println("Digite o novo e-mail: ");
                            String novoEmail = scanner.nextLine();
                            listaFornecedor.get(i).update(2, novoEmail);
                            System.out.println("E-mail atualizado com sucesso.");
                        }
                    }
                }
            } if (opcaoSubMenu == 4) {
                System.out.println("Deletar fornecedor");
                System.out.println("Digite o CNPJ do usuario:");

                String cnpjPesquisa = scanner.nextLine();

                for (int i = 0; i < listaFornecedor.size(); i++) {
                    if (listaFornecedor.get(i).cnpj.equals(cnpjPesquisa)) {
                        listaFornecedor.get(i).delete(listaFornecedor.get(i));
                    }
                }

                System.out.println("Fornecedor removido.");
                System.out.println("Lista de fornecedores:");

                for (int i = 0; i < listaFornecedor.size(); i++) {
                    System.out.println(listaFornecedor.get(i).cnpj);
                }
            } if (opcaoSubMenu == 5) {
                break;
            }
        }
    }

    public class Fornecedor {
        //classe responsável por criar um fornecedor, pois possui dados para inicialização do mesmo (Padrão GRASP Creator)

        String cnpj, razaoSocial, nomeFantasia, telefone, email;

        public void setRazao(String razaoSocial) {
            this.razaoSocial = razaoSocial;
        }

        public void setNome(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCnpj() {
            return cnpj;
        }

        public String getRazaoSocial() {
            return razaoSocial;
        }

        public String getNome() {
            return nomeFantasia;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }

        //método responsável por criar o fornecedor
        public void create(String cnpj, String razaoSocial, String nomeFantasia, String telefone, String email ) {
            setCnpj(cnpj);
            setRazao(razaoSocial);
            setNome(nomeFantasia);
            setTelefone(telefone);
            setEmail(email);
        }

        public void read() {
            System.out.println("CNPJ: " + getCnpj());
            System.out.println("Razão Social: " + getRazaoSocial());
            System.out.println("Nome Fantasia: " + getNome());
            System.out.println("Telefone: " + getTelefone());
            System.out.println("E-mail: " + getEmail());
        }

        public void update(int opcao, String novoDado) {
            if (opcao == 1) {
                setTelefone(novoDado);
            } if (opcao == 2) {
                setEmail(novoDado);
            }
        }

        public void delete(Fornecedor fornecedor) {
            listaFornecedor.remove(fornecedor);
        }
    }

}
