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
    public void addReader(String username, String password) {
        Reader newReader = new Reader(username, password);
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
        Node temp = head;
        while (temp != null) {
            if (temp.data.username.equals(username) && temp.data.password.equals(password)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null; // tidak ditemukan
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
