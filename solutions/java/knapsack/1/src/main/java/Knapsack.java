import java.util.List;

class Knapsack{
	int maximumValue(int limit, List<Item> items){
		int index = 0;
		int sum   = 0; 
		return helper(limit, items, index, sum);
	}

	int helper(int limit, List<Item> items, int index, int sum){
		if (index >= items.size())
			return sum;

		Item temp = items.get(index);

		if (temp.weight > limit)
			return helper(limit, items, index + 1, sum);

		return Integer.max(helper(limit - temp.weight, items, index + 1, sum + temp.value),
						   helper(limit, items, index + 1, sum));
	}
}

class Item{
	int weight;
	int value;

	Item(int weight, int value){
		this.weight = weight;
		this.value  = value;
	}
}
