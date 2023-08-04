import java.util.ArrayList;
import java.util.Scanner;

public class CRUDUsuario {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public void mostrarSubMenu() {
        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("SUBMENU");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Visualizar usuario cadastrado");
            System.out.println("3 - Atualizar cadastro de usuario");
            System.out.println("4 - Deletar usuario");
            System.out.println("5 - Voltar");

            int opcaoSubMenu = scanner.nextInt();
            scanner.nextLine();

            if (opcaoSubMenu == 1) {
                System.out.println("Cadastro de usuario");
                System.out.println("Digite o CPF do usuario a ser cadastrado:");
                String cpf = scanner.nextLine();
                System.out.println("Digite o NOME do usuario a ser cadastrado:");
                String nome = scanner.nextLine();
                System.out.println("Digite a DATA DE NASCIMENTO do usuario a ser cadastrado:");
                String dataNascimento = scanner.nextLine();
                System.out.println("Digite o TELEFONE do usuario a ser cadastrado:");
                String telefone = scanner.nextLine();
                System.out.println("Digite o E-MAIL do usuario a ser cadastrado:");
                String email = scanner.nextLine();
                System.out.println("----------------------------------------------");

                Usuario usuarioNovo = new Usuario();

                usuarioNovo.create(cpf, nome, dataNascimento, telefone, email); //chamada do método que cria
                listaUsuarios.add(usuarioNovo);

                System.out.println("Usuario cadastrado com sucesso!");

            } if (opcaoSubMenu == 2) {
                System.out.println("Visualizacao de usuario cadastrado");
                System.out.println("Digite o CPF do usuario:");

                String cpfPesquisa = scanner.nextLine();

                for (int i = 0; i < listaUsuarios.size(); i++) {
                    if (listaUsuarios.get(i).cpf.equals(cpfPesquisa)) {
                        listaUsuarios.get(i).read();
                    }
                }
            } if (opcaoSubMenu == 3) {
                System.out.println("Atualizacao de cadastro de usuario");
                System.out.println("Digite o CPF do usuario:");

                String cpfPesquisa = scanner.nextLine();

                for (int i = 0; i < listaUsuarios.size(); i++) {
                    if (listaUsuarios.get(i).cpf.equals(cpfPesquisa)) {

                        System.out.println("O que voce deseja atualizar?");
                        System.out.println("1 - Telefone");
                        System.out.println("2 - E-mail");

                        int opcaoSubSubMenu = scanner.nextInt();
                        scanner.nextLine();

                        if (opcaoSubSubMenu == 1) {
                            System.out.println("Digite o novo numero de telefone: ");
                            String novoTelefone = scanner.nextLine();
                            listaUsuarios.get(i).update(1, novoTelefone);
                            System.out.println("Telefone atualizado com sucesso.");
                        }
                        if (opcaoSubSubMenu == 2) {
                            System.out.println("Digite o novo e-mail: ");
                            String novoEmail = scanner.nextLine();
                            listaUsuarios.get(i).update(2, novoEmail);
                            System.out.println("E-mail atualizado com sucesso.");
                        }
                    }
                }
            } if (opcaoSubMenu == 4) {
                System.out.println("Deletar usuario");
                System.out.println("Digite o CPF do usuario:");

                String cpfPesquisa = scanner.nextLine();

                for (int i = 0; i < listaUsuarios.size(); i++) {
                    if (listaUsuarios.get(i).cpf.equals(cpfPesquisa)) {
                        listaUsuarios.get(i).delete(listaUsuarios.get(i));
                    }
                }

                System.out.println("Usuario removido.");
                System.out.println("Lista de usuarios:");

                for (int i = 0; i < listaUsuarios.size(); i++) {
                    System.out.println(listaUsuarios.get(i).cpf);
                }
            } if (opcaoSubMenu == 5) {
                break;
            }
        }
    }

    public class Usuario {
        //classe responsável por criar um usuário, pois possui dados para inicialização do mesmo (Padrão GRASP Creator)

        String cpf, nome, dataNascimento, telefone, email;

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCpf() {
            return cpf;
        }

        public String getNome() {
            return nome;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }

        //método responsável por criar o usuário
        public void create(String cpf, String nome, String dataNascimento, String telefone, String email ) {
            setCpf(cpf);
            setNome(nome);
            setDataNascimento(dataNascimento);
            setTelefone(telefone);
            setEmail(email);
        }

        public void read() {
            System.out.println("CPF: " + getCpf());
            System.out.println("Nome: " + getNome());
            System.out.println("Data de nascimento: " + getDataNascimento());
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

        public void delete(Usuario usuario) {
            listaUsuarios.remove(usuario);
        }
    }

}
