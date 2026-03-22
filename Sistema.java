import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Cadastrar | 2 - Login | 0 - Sair");
            String opcao = scanner.next();

            if (opcao.equals("1")) {
                cadastrarUsuario(usuarios, scanner);

            } else if (opcao.equals("2")) {
                boolean logado = loginUsuario(usuarios, scanner);

                if (logado) {
                    System.out.println("Login OK!");
                    break;
                } else {
                    System.out.println("Email ou senha incorretos!");
                }

            } else if (opcao.equals("0")) {
                System.out.println("Encerrando...");
                break;

            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }

    // 🔹 Método para cadastrar
    public static void cadastrarUsuario(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.println("Digite seu email:");
        String email = scanner.next();

        if (emailExiste(usuarios, email)) {
            System.out.println("Email já cadastrado!");
            return;
        }

        System.out.println("Digite sua senha:");
        String senha = scanner.next();

        Usuario novo = new Usuario(email, senha);
        usuarios.add(novo);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    // 🔹 Método para login
    public static boolean loginUsuario(ArrayList<Usuario> usuarios, Scanner scanner) {
        System.out.println("Digite seu email:");
        String email = scanner.next();

        System.out.println("Digite sua senha:");
        String senha = scanner.next();

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }

    // 🔹 Método para verificar email duplicado
    public static boolean emailExiste(ArrayList<Usuario> usuarios, String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
