class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar>{
    private int victory;
    int distance = 0;
    public void drive() {
        this.distance += 10;
        return;
    }

    public int getDistanceTravelled() {
        return this.distance;
    }

    public int getNumberOfVictories() {
        return victory;
    }

    public void setNumberOfVictories(int numberofVictories) {
        victory = numberofVictories;
    }
    @Override
    public int compareTo(ProductionRemoteControlCar prc){
        if(victory < prc.getNumberOfVictories())
            return 1;
        if (victory > prc.getNumberOfVictories())
            return -1;
        return 0;
    }
}
