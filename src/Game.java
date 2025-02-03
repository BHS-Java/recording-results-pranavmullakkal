import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    // PROPERTIES---------------
    private List<Person> players;

    // CONSTRUCTORS-------------
    public Game(Person... persons) {
        players = new ArrayList<>();
        for (Person person : persons) {
            players.add(person);
        }
    }

    // METHODS-----------------
    public void addPerson(Person person) {
        players.add(person);
    }

    public Results getResults() {
        return new Results(players);
    }

    public List<Person> getPlayers() {
        return players;
    }

    public void loadPlayers() {
        try (FileWriter writer = new FileWriter("people.csv")) {
            // Write header
            writer.append("name,height,years,stair direction\n");

            // Write player data
            for (Person player : players) {
                writer.append(player.getName())
                      .append(",")
                      .append(String.valueOf(player.getHeight()))
                      .append(",")
                      .append(String.valueOf(player.getAge()))
                      .append(",")
                      .append(player.getClimbingDirection())
                      .append("\n");
            }
            System.out.println("Player data has been written to people.csv");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
