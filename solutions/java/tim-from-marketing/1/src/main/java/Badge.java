class Badge {
    public String print(Integer id, String name, String department) {
        String res = "";

        if (id != null){
             res += "[" + id.toString() + "] - ";   
        }
        
        res += name + " - ";

        if (department == null){
            department = "owner";
        }
        
        res += department.toUpperCase();
        return res;
    }
}