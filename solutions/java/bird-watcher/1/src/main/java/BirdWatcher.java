
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
		if (birdsPerDay.length == 0)
			return 0;
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        int temp = getToday();
		birdsPerDay[birdsPerDay.length - 1] = temp + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int count : birdsPerDay)
			if (count == 0)
				return true;
		return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int res = 0;
		
		for (int count : birdsPerDay){
			if (numberOfDays != 0){
				res += count;
				numberOfDays--;
			}
		}
		
		return res;
    }

    public int getBusyDays() {
        int res = 0;
		
		for (int count : birdsPerDay)
			if (count >= 5)
				res++;
		return res;
    }
}
