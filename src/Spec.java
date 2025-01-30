


 public interface Spec {
    public String  askString(String question);
    public int     askNumber(String question);
    public Results getResults(Game sigmaGame);
    public Person  makePerson(String name);
    public void    addResults(Person player);
}

