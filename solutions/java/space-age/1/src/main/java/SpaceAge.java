
class SpaceAge {
	
	private double seconds;
	private final double EARTH_YEAR = 31557600;
    
    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        return this.seconds;
    }

    double onEarth() {
        return seconds / EARTH_YEAR;
    }

    double onMercury() {
        return seconds / (0.2408467 * EARTH_YEAR);
    }

    double onVenus() {
        return seconds / (0.61519726 * EARTH_YEAR);
    }

    double onMars() {
        return seconds / (1.8808158 * EARTH_YEAR);
    }

    double onJupiter() {
        return seconds / (11.862615 * EARTH_YEAR);
    }

    double onSaturn() {
        return seconds / (29.447498 * EARTH_YEAR);
    }

    double onUranus() {
        return seconds / (84.016846 * EARTH_YEAR);
    }

    double onNeptune() {
        return seconds / (164.79132 * EARTH_YEAR);
    }

}
