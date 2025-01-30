import java.util.ArrayList;
import java.util.List;

public class Game {
    //PROPERTIES---------------
    private List<Person> players;
    //CONSTRUCTORS-------------
    public Game(Person... persons) {
        players = new ArrayList<>();
        for (Person person : persons) {
            players.add(person);
        }
    }
    //METHODS-----------------
    public void addPerson(Person person) {
        players.add(person);
    }

    public Results getResults() {
        return new Results(players);
    }

    public List<Person> getPlayers() {
        return players;
    }
}
