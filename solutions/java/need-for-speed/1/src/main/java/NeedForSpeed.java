class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distance;
    private int battery;

    public NeedForSpeed(int speed, int batteryDrain){
        this.speed        = speed;
        this.batteryDrain = batteryDrain;
        distance          = 0;
        battery           = 100;
    }

    
    public boolean batteryDrained() {
        if (battery < batteryDrain)
            return true;
        return false;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (battery < batteryDrain)
            return;
        distance += speed;
        battery  -= batteryDrain;
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;

    public RaceTrack(int distance){
        this.distance = distance;
    }
    
    public boolean tryFinishTrack(NeedForSpeed car) {
        while (!car.batteryDrained()){
            car.drive();
            if (car.distanceDriven() >= distance)
                return true;
        }

        return false;
    }
}
