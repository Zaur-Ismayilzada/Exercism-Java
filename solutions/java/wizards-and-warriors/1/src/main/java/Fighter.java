abstract class Fighter {
	
    boolean isVulnerable() {
		return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int damagePoints(Fighter wizard) {
        if (wizard.isVulnerable())
			return 10;
		else
			return 6;
    }
}

class Wizard extends Fighter {

	private boolean prepared = false; 
	
    @Override
    boolean isVulnerable() {
        if (!prepared)
			return true;
		else
			return false;
    }

    @Override
    int damagePoints(Fighter warrior) {
        if (prepared)
			return 12;
		else
			return 3;
    }

    void prepareSpell() {
        prepared   = true;
    }

}
