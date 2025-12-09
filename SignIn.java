import java.util.Scanner;

public class SignIn {

    public Reader signUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();

        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        Reader reader = new Reader(name, email, username, password);

        System.out.println("Pendaftaran berhasil! Selamat datang, " + reader.name + "!");

        return reader; // penting!

    }
}
