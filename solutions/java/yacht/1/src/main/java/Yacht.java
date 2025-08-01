import java.util.Arrays;
class Yacht {
	
	private YachtCategory yacht;
	private int[] dice;
	
    Yacht(int[] dice, YachtCategory yacht) {
        this.yacht = yacht;
		this.dice  = dice;
    }

    int score() {
		//YACHT
        if (yacht == YachtCategory.YACHT){
			for (int i = 0; i < dice.length - 1; i++)
				if (dice[i] != dice[i + 1])
					return 0;
			return 50;
		}
		
		switch (yacht){
			case ONES   : return 1 * getNum(1);
			case TWOS   : return 2 * getNum(2);
			case THREES : return 3 * getNum(3);
			case FOURS  : return 4 * getNum(4);
			case FIVES  : return 5 * getNum(5);
			case SIXES  : return 6 * getNum(6);
		}
		
		//LITTLE_STRAIGHT
		if (yacht == YachtCategory.LITTLE_STRAIGHT)
			return littleBig(1);
			
		//BIG_STRAIGHT
		if (yacht == YachtCategory.BIG_STRAIGHT)
			return littleBig(2);
		
		//CHOICE
		if (yacht == YachtCategory.CHOICE){
			int sum = 0;
			for (int i = 1; i <= 6; i++)
				sum += i * getNum(i);
			return sum;
		}
		
		//FOUR_OF_A_KIND
		if (yacht == YachtCategory.FOUR_OF_A_KIND){
			for (int i = 1; i <= 6; i++)
				if (getNum(i) >= 4)
					return i * 4;
			return 0;
		}
		
		//FULL_HOUSE
		if (yacht == YachtCategory.FULL_HOUSE){
			int sum = 0;
			boolean flag_2 = false;
			boolean flag_3 = false;
			for (int i = 1; i <= 6; i++){
				int temp = getNum(i);
				
				if (temp == 2)
					{sum += 2 * i; flag_2 = true;}
				if (temp == 3)
					{sum += 3 * i; flag_3 = true;}
			}
			
			if (flag_2 && flag_3)
				return sum;
		}
		
		return 0;
    }
	
	private int getNum(int num){
		int res = 0;
		
		for (int temp : dice)
			if (temp == num)
				res++;
				
		return res;
	}
	
	private int littleBig (int start){
		Arrays.sort(dice);
			
		if (dice[0] == start){
			for (int i = 0; i < dice.length - 1; i++)
				if (dice[i + 1] - dice[i] != 1)
					return 0;
			return 30;
		}
		
		return 0;		
	}

}
