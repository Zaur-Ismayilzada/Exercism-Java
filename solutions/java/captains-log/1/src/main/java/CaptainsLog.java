import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    char randomPlanetClass() {
        int l = PLANET_CLASSES.length;
        return PLANET_CLASSES[random.nextInt(l)];
    }

    String randomShipRegistryNumber() {
        String num = (1000 + random.nextInt(9000)) + "";

        return "NCC-" + num;
    }

    double randomStardate() {
        return 41000 + 1000 * random.nextDouble();
    }
}
