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
    public Reader addReader(String username, String password, String name, String email) {
        Reader newReader = new Reader(username, password, name, email);
        Node newNode = new Node(newReader);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        return newReader;  // ← supaya bisa disimpan ke variabel
    }


    // LOGIN
    public Reader login(String username, String password) {
        username = username.trim();
        password = password.trim();

        Node temp = head;
        while (temp != null) {
            if (temp.data.username.trim().equals(username) &&
                temp.data.password.trim().equals(password)) {
                return temp.data;
            }
            temp = temp.next;
        }
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
