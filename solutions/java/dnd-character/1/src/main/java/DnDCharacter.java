class DnDCharacter {
	
	private int Str, Dxt, Cons, Int, Wis, Char;
	
	DnDCharacter(){
		Str  = ability();
		Dxt  = ability();
		Cons = ability();
		Int  = ability();
		Wis  = ability();
		Char = ability();
	}
	
    int ability() {
		int[] arr = new int[4];
		int   sum = 0;
		
        for (int i = 0; i < arr.length; i++)
			arr[i] = (int)(Math.random() * 6 + 1);
		
		removeMin(arr);
		
		for (int a : arr)
			if (a != 0)
				sum += a;
		return sum;
    }

    int modifier(int input) {
        return (int)(Math.floor((input - 10.0) / 2.0));
    }

    int getStrength() {
        return Str;
    }

    int getDexterity() {
        return Dxt;
    }

    int getConstitution() {
        return Cons;
    }

    int getIntelligence() {
        return Int;
    }

    int getWisdom() {
        return Wis;
    }

    int getCharisma() {
        return Char;
    }

    int getHitpoints() {
        return 10 + modifier(getConstitution());
    }
	
	private void removeMin(int[] arr){
		int idx = 0;
		
		for (int i = 1; i < arr.length; i++)
			if(arr[idx] > arr[i])
				idx = i;
				
		arr[idx] = 0;
	}
}
