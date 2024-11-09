class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {

        if (head == null){
            head = new Element<T>(value, null, null);
            return;
        }

        Element<T> temp = head;

        while (temp.next != null)
            temp = temp.next;

        
        Element<T> new_element = new Element<T>(value, temp, null);

        temp.next = new_element;
    }

    T pop() {
        Element<T> temp = head;

        while (temp.next != null)
            temp = temp.next;

        T res = temp.value;

        if (temp.prev != null){
            temp.prev.next = null;
            temp.prev      = null;
        }

        temp = null;

        return res;

    }

    void unshift(T value) {
        if (head == null){
            head = new Element<T>(value, null, null);
            return;            
        }

        Element<T> temp = head;

        head = new Element<T>(value, null, head);

        temp.prev = head; 
    }

    T shift() {
        T res = head.value;

        if (head.next != null){
            Element<T> temp = head.next;

            head.next.prev = null;
            head.next      = null;
            head           = null;
            head           = temp;
        }else head = null;

        return res;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev  = prev;
            this.next  = next;
        }
    }
}
