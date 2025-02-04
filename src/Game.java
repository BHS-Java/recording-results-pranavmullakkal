import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Person> players;
    private static final String CSV_FILE = "people.csv";
    private Spec spec;

    public Game(Spec spec, Person... persons) {
        this.spec = spec;
        players = new ArrayList<>();
        for (Person person : persons) {
            players.add(person);
        }
    }

    public void addPerson(Person person) {
        players.add(person);
        savePersonToCSV(person);
    }

    public Results getResults() {
        return new Results(players);
    }

    public List<Person> getPlayers() {
        return players;
    }

    public void selectPlayer() {
        Scanner scanner = new Scanner(System.in);
        List<Person> existingPlayers = loadPlayersFromCSV();

        System.out.println("Select a player from the list below or create a new one:");
        for (int i = 0; i < existingPlayers.size(); i++) {
            Person player = existingPlayers.get(i);
            System.out.println((i + 1) + ". " + player.getName() + " (Height: " + player.getHeight() + ", Age: " + player.getAge() + ", Climbing Direction: " + player.getClimbingDirection() + ")");
        }
        System.out.println((existingPlayers.size() + 1) + ". Create a new player");

        int choice = -1;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        if (choice >= 1 && choice <= existingPlayers.size()) {
            Person selectedPlayer = existingPlayers.get(choice - 1);
            System.out.println("You selected: " + selectedPlayer.getName());
        } else if (choice == existingPlayers.size() + 1) {
            String name = spec.askString("Enter your name: ");
            Person newPerson = spec.makePerson(name);
            newPerson.setHeight(spec.askNumber("Enter your height in inches: "));
            newPerson.setAge(spec.askNumber("Enter your age in years: "));
            String climbingDirection = spec.askString("Enter the direction for climbing stairs (left down, right down, left up, right up): ");
            newPerson.setClimbingDirection(climbingDirection);
            addPerson(newPerson);
            System.out.println("New player created: " + newPerson.getName());
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    private List<Person> loadPlayersFromCSV() {
        List<Person> players = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                if (data.length < 4) {
                    System.out.println("Invalid line in CSV: " + line);
                    continue;
                }
                try {
                    Person person = new PersonImpl();
                    person.setName(data[0]);
                    person.setHeight(Integer.parseInt(data[1]));
                    person.setAge(Integer.parseInt(data[2]));
                    person.setClimbingDirection(data[3]);
                    players.add(person);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing line: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
        return players;
    }

    private void savePersonToCSV(Person person) {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(person.getName()).append(",")
                  .append(String.valueOf(person.getHeight())).append(",")
                  .append(String.valueOf(person.getAge())).append(",")
                  .append(person.getClimbingDirection()).append("\n");
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }
}
