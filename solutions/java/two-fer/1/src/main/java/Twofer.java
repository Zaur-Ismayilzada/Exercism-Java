public class Twofer {
    public String twofer(String name) {
		 if (name == null)
		 	return "One for you, one for me.";
         if (name.isEmpty())
		 	return "One for , one for me.";
		return "One for " + name + ", one for me.";
	}
}
