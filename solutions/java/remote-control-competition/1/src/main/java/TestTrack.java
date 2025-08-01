import java.util.List;
import java.util.ArrayList;

public class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(ProductionRemoteControlCar prc1,
                                                                 ProductionRemoteControlCar prc2) {
        List<ProductionRemoteControlCar> list = new ArrayList<ProductionRemoteControlCar>();
        
        if(prc1.compareTo(prc2) == 1)
        {list.add(prc1); list.add(prc2);}
        else if (prc2.compareTo(prc1) == 1)
        {list.add(prc2); list.add(prc1);}
        return list;
    }
}
