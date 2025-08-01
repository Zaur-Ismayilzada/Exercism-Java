import java.util.NoSuchElementException;

class SimpleLinkedList<T> {
    T value;
    SimpleLinkedList<T> next;

    SimpleLinkedList() {
        value = null;
        next  = null;
    }

    SimpleLinkedList(T[] values) {
        if (values.length == 0)return;

        SimpleLinkedList<T> temp = this;

        for (int i = 0; i < values.length; i++)temp.push(values[i]);
    }

    void push(T value) {
        if (this.value == null){
            this.value = value;
            return;
        }

        SimpleLinkedList<T> temp = new SimpleLinkedList<T>();
        temp.push(value);

        temp.next       = new SimpleLinkedList<T>();
        temp.next.next  = this.next;
        temp.next.value = this.value;
        this.value      = temp.value;
        this.next       = temp.next;
    }

    T pop() {
        if (this.value == null)
            throw new NoSuchElementException();

        T res = this.value;

        this.value = null;

        if (this.next != null){
            this.value = this.next.value;
            this.next  = this.next.next;
        }

        return res;
    }

    void reverse() {
        SimpleLinkedList<T> temp     = this;
        SimpleLinkedList<T> reversed = new SimpleLinkedList<T>();

        while (temp.size() != 0){
            reversed.push(temp.pop());
        }

        this.value = reversed.value;
        this.next  = reversed.next;
    }

    T[] asArray(Class<T> clazz) {
        int k   = 0;
        T[] arr = (T[])(java.lang.reflect.Array.newInstance(clazz, size()));

        if (this.value == null)
            return arr;

        SimpleLinkedList<T> temp = this;

        while (temp.next != null){
            arr[k] = temp.value;
            temp   = temp.next;
            k     += 1;
        }

        arr[k] = temp.value;

        return arr;
    }

    int size() {
        if (this.value == null)
            return 0;

        int count = 0;

        SimpleLinkedList<T> temp = this;

        while (temp.next != null){
            count++;
            temp = temp.next;
        }

        return count + 1;
    }
}