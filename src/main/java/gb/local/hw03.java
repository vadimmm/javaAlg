package gb.local;

public class hw03 {
    public static void main(String[] args) {
        NodeList list = new NodeList();
        System.out.println ("Создать двусвязный список длиной 10");
        for (int i = 0; i < 10; i++) {
            int arr = (int)(Math.random() * 100);
            Node node = new Node(arr);
            if (i == 0) {
                list.head = node; // головной узел
            } else {
                list.head.append(node);
            }
            list.last = node; // хвостовой узел
        }
        // Траверс
        System.out.println(list);
        // реверс
        System.out.println(list.reverse());
    }

    public static class Node {
        private Node pre; // предыдущий узел
        private Node next; // следующий узел
        private int data; // данные
        public Node(int data) {
            this.data = data;
        }

        public void append(Node node) {
            if (this.next == null) {
                this.next = node;
                node.pre = this;
            } else {
                this.next.append(node);
            }
        }
        public Node getPre() {
            return pre;
        }
        public void setPre(Node pre) {
            this.pre = pre;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public void setData(int data) {
            this.data = data;
        }
        public boolean hasPre() {
            return this.pre != null;
        }
        public boolean hasNext() {
            return this.next != null;
        }
        public int getData() {
            return data;
        }
    }

    public static class NodeList {
        Node head;
        Node last;

        public void append(Node node) {
            if (head.getNext() == null) {
                head.setNext(node);
                node.setPre(head);
            } else {
                head.getNext().append(node);
            }
        }

         // Траверс
        public String toString() {
            Node curr = head;
            StringBuilder sBuilder = new StringBuilder();
            while (curr != null) {
                sBuilder.append(curr.getData()).append(curr.hasNext() ? "->" : "");
                curr = curr.getNext();
            }
            return sBuilder.toString();
        }

         // Сверху вниз
        public String reverse() {
            Node curr = head;
            Node newHead = null;
            Node newLast = null;
            while (curr != null) {
                Node pre = curr.getPre();
                Node next = curr.getNext();
                if (pre == null) newLast = curr; // Предыдущий узел пуст, как новый хвостовой узел
                if (next == null) newHead = curr; // Следующий узел пуст, как новый головной узел
                curr.setNext(pre); // Следующий узел текущего узла используется как предыдущий узел текущего узла
                curr.setPre(next); // Предыдущий узел текущего узла является следующим узлом текущего узла
                curr = curr.getPre(); // Продолжаем обработку следующего узла исходного узла связанного списка
            }
            head = newHead; // Устанавливаем головной узел
            last = newLast; // Устанавливаем конечный узел
            return this.toString();
        }
    }
}
