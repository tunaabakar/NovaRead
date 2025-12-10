public class Tree {
    class NodeTree {
        String genre;
        DoublyLinkedList books;
        NodeTree left;
        NodeTree right;

        public NodeTree(String genre) {
            this.genre = genre;
            this.books = new DoublyLinkedList();
            this.left = null;
            this.right = null;
        }
    }

    NodeTree root;

    public void insertGenre(String genre) {
        root = insertGenreRecursive(root, genre);
    }

    private NodeTree insertGenreRecursive(NodeTree node, String genre) {
        if (node == null) {
            return new NodeTree(genre);
        }
        if (genre.compareToIgnoreCase(node.genre) < 0) {
            node.left = insertGenreRecursive(node.left, genre);
        } else if (genre.compareToIgnoreCase(node.genre) > 0) {
            node.right = insertGenreRecursive(node.right, genre);
        }
        return node;
    }

    public NodeTree findGenre(String genre) {
        return findGenreRecursive(root, genre);
    }

    private NodeTree findGenreRecursive(NodeTree node, String genre) {
        if (node == null || node.genre.equalsIgnoreCase(genre)) {
            return node;
        }
        if (genre.compareToIgnoreCase(node.genre) < 0) {
            return findGenreRecursive(node.left, genre);
        } else {
            return findGenreRecursive(node.right, genre);
        }
    }


    public void searchByGenre(String genre) {
        NodeTree genreNode = findGenre(genre);

        System.out.println("\n>> Filter Genre: '" + genre + "'");
        boolean found = false;

        if (genreNode != null && !genreNode.books.isEmpty()) {
            DoublyLinkedList current = genreNode.books.getHead();
            while (current != null) {
                if (current.data != null) {
                    printResult(current.data);
                    found = true;
                }
                current = current.next;
            }
        }

        if (!found) {
            System.out.println("   (Tidak ditemukan)");
        }
    }



    public void insertBookToGenre(String genre, Book book) {
        NodeTree genreNode = findGenre(genre);
        if (genreNode == null) {
            insertGenre(genre);
            genreNode = findGenre(genre);
        }
        genreNode.books.addLast(book);
    }

    // Output jika buku ditemukan
    private void printResult(Book b) {
        System.out.println("   Found: " + b.title + " (" + b.rating + "/5.0) - " + b.genre);
    }


    public void displayInOrder() {
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(NodeTree node) {
        if (node != null) {
            displayInOrderRecursive(node.left);
            System.out.println("Genre: " + node.genre);
            node.books.display();
            System.out.println();
            displayInOrderRecursive(node.right);
        }
    }
}
