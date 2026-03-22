import java.util.*;

public class CadastroDoAluno {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Cadastrar | 2 - Login");
            String opcao = scanner.next();

            if (opcao.equals("1")) {

                System.out.println("Digite Seu Email: ");
                String email = scanner.next();

                boolean existe = false;

                for (Usuario u : usuarios) {
                    if (u.email.equals(email)) {
                        existe = true;
                        break;
                    }
                }

                if (existe) {
                    System.out.println("Email já cadastrado!");
                } else {
                    System.out.println("Digite Sua Senha: ");
                    String senha = scanner.next();

                    Usuario novo = new Usuario();
                    novo.email = email;
                    novo.senha = senha;

                    usuarios.add(novo);
                    System.out.println("Cadastrado!");
                }

            } else if (opcao.equals("2")) {
                System.out.println("Email:");
                String email = scanner.next();
                System.out.println("Senha:");
                String senha = scanner.next();

                boolean achou = false;

                for (Usuario u : usuarios) {
                    if (u.email.equals(email) && u.senha.equals(senha)) {
                        achou = true;
                        break;
                    }
                }

                if (achou) {
                    System.out.println("Login OK!");
                    break;
                } else {
                    System.out.println("Erro!");
                }
            }
        }
    }
}
