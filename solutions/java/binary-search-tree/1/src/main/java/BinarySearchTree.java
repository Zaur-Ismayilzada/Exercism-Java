import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class BinarySearchTree<T extends Comparable<T>> {
    Node<T> root;

    void insert(T value) {
        if (root == null){
            root = new Node<T>(value, null, null);
            return;
        }

        Node<T> temp = root;

        while (true){
            if (value.compareTo(temp.data) > 0){
                if (temp.right == null){
                    temp.right = new Node<T>(value, null, null);
                    return;
                }else
                    temp = temp.right;
            }else /*if (value.compareTo(temp.data) < 0)*/ {
                if (temp.left == null){
                    temp.left = new Node<T>(value, null, null);
                    return;
                }else
                    temp = temp.left;
            }
        }

    }

    List<T> getAsSortedList() {
        List<T> res = getAsLevelOrderList();

        Collections.sort(res);

        return res;
    }

    List<T> getAsLevelOrderList() {
        List<T> res = new ArrayList<T>();

        if (root == null)
            return res;

        Node<T> temp = root;

        boolean changed = true;
        int     level   = 0;

        while (changed){
            changed = false;

            changed = recursial_add(res, temp, level);
            level++;
        }

        return res;
    }

    private boolean recursial_add(List<T> list, Node<T> root, int level){
        if (level == 0){
            list.add(root.data);
            return true;
        }
        else{
            boolean left = false, right = false;

            if (root.left != null)
                left  = recursial_add(list, root.left, level - 1);
            if (root.right != null)
                right = recursial_add(list, root.right, level - 1);

            if (left || right)
                return true;

        }

        return false;
    }

    Node<T> getRoot() {
        return root;
    }

    static class Node<T> {
        T data;
        Node<T> right;
        Node<T> left;

        Node(T data, Node<T> left, Node<T> right){
            this.data  = data;
            this.left  = left;
            this.right = right;
        }

        Node<T> getLeft() {
            return left;
        }

        Node<T> getRight() {
            return right;
        }

        T getData() {
            return data;
        }

    }
}
