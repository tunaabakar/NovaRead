public class Main {
    public static void main(String[] args) {
        SignIn signIn = new SignIn();
        Reader user = signIn.signUp();

        Login login = new Login();

        if (login.performLogin(user)) {
            MainMenu menu = new MainMenu(user);
            menu.start();
        }
    }
}
