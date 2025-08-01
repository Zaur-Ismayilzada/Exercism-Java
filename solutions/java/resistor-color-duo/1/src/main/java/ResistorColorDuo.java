class ResistorColorDuo {

    int value(String[] colors) {
		
		int a = get_color_number (colors[0]);
		int b = get_color_number (colors[1]);
		
        String res = Integer.toString (a) + Integer.toString (b);
		
		return Integer.parseInt(res);
    }
	
	String[] get_colors (){
		return new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
	}
	
	int get_color_number (String color){
		String[] arr = get_colors();
		for (int i = 0; i < arr.length; i++)
			if (arr[i].equals(color))
				return i;
		return -1;
	}
}
