public class GameMaster {

    // TODO: define a 'describe' method that returns a description of a Character

    public String describe(Character chr){
        return "You're a level " + chr.getLevel() + " " + chr.getCharacterClass() + " with " + chr.getHitPoints() + " hit points.";
    }
    

    // TODO: define a 'describe' method that returns a description of a Destination

    public String describe(Destination dst){
        return "You've arrived at " + dst.getName() + ", which has " + dst.getInhabitants() + " inhabitants.";
    }

    // TODO: define a 'describe' method that returns a description of a TravelMethod

    public String describe(TravelMethod mtd){
        String res = "";

        switch(mtd){
            case TravelMethod.HORSEBACK:
                res = "on horseback.";
                break;
            case TravelMethod.WALKING:
                res = "by walking.";
                break;
        }
        return "You're traveling to your destination " + res; 
    }

    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod

    public String describe(Character chr, Destination dst, TravelMethod mtd){
        return describe(chr) + " " + 
               describe(mtd) + " " + 
               describe(dst);
        
    }

    // TODO: define a 'describe' method that returns a description of a Character and Destination
    public String describe(Character chr, Destination dst){
        return describe(chr) + " " + 
                "You're traveling to your destination by walking. " + 
               describe(dst);
    }
}
