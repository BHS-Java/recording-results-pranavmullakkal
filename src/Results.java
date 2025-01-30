import java.util.List;

public class Results {
    private List<Person> players;

    public Results(List<Person> players) {
        this.players = players;
    }

    public void displayResults() {
        for (Person player : players) {
            System.out.println("Player: " + player.getName() + ", Height: " + player.getHeight() + " cm, " + "Age: " + player.getAge() + " years");
            player.climb(player.getClimbingDirection());
        }
    }
}
