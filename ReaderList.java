public class ReaderList {

    class Node {
        Reader data;
        Node next;

        Node(Reader data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public ReaderList() {
        head = null;
    }

    // REGISTER
    public void addReader(String username, String password, String name, String email) {
        Reader newReader = new Reader(username, password, name, email);
        Node newNode = new Node(newReader);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // LOGIN
    public Reader login(String username, String password) {
        // username = username.trim();
        // password = password.trim();

        // Node temp = head;
        // while (temp != null) {
        //     if (temp.data.username.trim().equals(username) &&
        //         temp.data.password.trim().equals(password)) {
        //         return temp.data;
        //     }
        //     temp = temp.next;
        // }
        // return null;
        System.out.println("DEBUG INPUT USERNAME = [" + username + "]");
    System.out.println("DEBUG INPUT PASSWORD = [" + password + "]");

    Node temp = head;
    while (temp != null) {
        System.out.println("DEBUG DATA USERNAME = [" + temp.data.username + "]");
        System.out.println("DEBUG DATA PASSWORD = [" + temp.data.password + "]");

        if (temp.data.username.equals(username) &&
            temp.data.password.equals(password)) {
            System.out.println("MATCH FOUND");
            return temp.data;
        }
        temp = temp.next;
    }
    System.out.println("NO MATCH");
    return null;
    }

    // Cek username sudah ada atau belum
    public boolean exists(String username) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.username.equals(username)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
