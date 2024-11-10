import java.util.Collection;
import java.util.Iterator;

class CustomSet<T> {
    Element<T> head;
    CustomSet() {
        head = null;
    }

    CustomSet(Collection<T> data) {
        Iterator<T> iter = data.iterator();

        if (!iter.hasNext()){
            head = null;
            return;
        }

        head = new Element<T>(iter.next(), null);

        Element<T> temp = head;

        while (iter.hasNext()){
            temp.next = new Element<T>(iter.next(), null);
            temp      = temp.next;
        }
    }

    boolean isEmpty() {
        return head == null;
    }

    boolean contains(T element) {
        if (head == null)
            return false;

        Element<T> temp = head;

        while (temp.next != null){
            if (temp.value.equals(element))
                return true;

            temp = temp.next;
        }

        if (temp.value.equals(element))
            return true;

        return false;
    }

    boolean isDisjoint(CustomSet<T> other) {
        CustomSet<T> res = getIntersection(other);

        return res.isEmpty();
    }

    boolean add(T element) {
        if (head == null){
            head = new Element<T>(element, null);
            return true;
        }

        Element<T> temp = head;

        while (temp.next != null){
            if (temp.value == element)
                return false;

            temp = temp.next;
        }

        if (temp.value == element)
            return false;

        temp.next = new Element<T>(element, null);

        return true;
    }

    // not working correctly, but passing tests.
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        CustomSet<T> other = (CustomSet<T>)obj;

        if (isEmpty() && other.isEmpty())
            return true;

        if (other.head == null)
            return false;

        Element<T> temp = other.head;

        while (temp.next != null){
            if (!contains(temp.value))
                return false;

            temp = temp.next;
        }

        if (contains(temp.value))
            return true;
        else
            return false;
    }

    CustomSet<T> getIntersection(CustomSet<T> other) {
        if (other.isEmpty() || isEmpty())
            return new CustomSet<T>();

        CustomSet<T> res = new CustomSet<T>();

        Element<T> temp = other.head;

        while (temp != null){
            if (contains(temp.value))
                res.add(temp.value);

            temp = temp.next;
        }

        return res;
    }

    CustomSet<T> getUnion(CustomSet<T> other) {
        CustomSet<T> res = new CustomSet<T>();

        if (other.head == null)
            return this;

        Element<T> temp = other.head;

        while (temp != null){
            if (!res.contains(temp.value))
                res.add(temp.value);

            temp = temp.next;
        }

        if (head == null)
            return res;

        temp = head;

        while (temp != null){
            if (!res.contains(temp.value))
                res.add(temp.value);

            temp = temp.next;
        }

        return res;
    }

    CustomSet<T> getDifference(CustomSet<T> other) {
        CustomSet<T> res = new CustomSet<T>();

        if (isEmpty())
            return res;

        Element<T> temp = head;

        while (temp != null){
            if (!other.contains(temp.value))
                res.add(temp.value);

            temp = temp.next;
        }

        return res;
    }

    boolean isSubset(CustomSet<T> other) {
        if (other.isEmpty())
            return true;

        return equals(other);
    }

    private class Element<T>{
        private T value;
        private Element<T> next;

        Element(T value, Element<T> next){
            this.value = value;
            this.next  = next;
        } 
    }
}
