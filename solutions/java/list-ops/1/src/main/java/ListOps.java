import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

class ListOps {

    static <T> List<T> append(List<T> list1, List<T> list2) {
		List<T> result = new ArrayList<T>();

        result.addAll(list1);
        result.addAll(list2);
			
		return result;
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        List<T> result = new ArrayList<T>();
		
		for (List<T> list : listOfLists){
			for (T element : list)
				result.add(element);
		}
		return result;
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<T>();
        for (T element : list)
			if(predicate.test(element))
				result.add(element);
		return result;
    }

    static <T> int size(List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
		List<U> result = new ArrayList<U>();
		
        for (T element : list){
			U temp = transform.apply(element);
			result.add(temp);
		}
		
		return result;
    }

    static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<T>();
		
		for (int i = list.size() - 1; i >= 0; i--)
			result.add(list.get(i));
			
		return result;
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        for (T element : list)
			initial = f.apply(initial, element);
		
		return initial;
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
		for (int i = list.size() - 1; i >= 0; i--)
			initial = f.apply(list.get(i), initial);
	
        return initial;
    }

    private ListOps() {
        // No instances.
    }

}
