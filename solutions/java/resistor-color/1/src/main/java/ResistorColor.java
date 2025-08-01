class ResistorColor {
    int colorCode(String color) {
        String[] arr = colors();
		
		for (int i = 0; i < arr.length; i++)
			if (color.equals(arr[i]))
				return i;
        return -1;
    }

    String[] colors() {
        return new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    }
}