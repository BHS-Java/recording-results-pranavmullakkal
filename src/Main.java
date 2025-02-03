import java.util.Scanner;

public class Main implements Spec {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Person person1 = main.makePerson(main.askString("Enter your name: "));
        person1.setHeight(main.askNumber("Enter your height in inches: "));
        person1.setAge(main.askNumber("Enter your age in years: "));
        
        String direction = main.askString("Enter the direction for climbing stairs (left down, right down, left up, right up): ");
        person1.climb(direction);
        
        Game game = new Game(person1);
        
        while (main.askString("Do you want to add another player? (y/n): ").equalsIgnoreCase("y")) {
            Person person = main.makePerson(main.askString("Enter your name: "));
            person.setHeight(main.askNumber("Enter your height in inches: "));
            person.setAge(main.askNumber("Enter your age in years: "));
            
            String newDirection = main.askString("Enter the direction for climbing stairs (left down, right down, left up, right up): ");
            person.climb(newDirection);
            
            game.addPerson(person);
        }

        // Call loadPlayers to save player data to CSV
        game.loadPlayers();

        Results results = game.getResults();
        results.getResults();
        
        // Close the scanner at the end of the program
        main.scanner.close();
    }

    @Override
    public String askString(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askNumber(String question) {
        System.out.print(question);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next(); // Consume the invalid input
        }
        int number = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return number;
    }

    @Override
    public Results getResults(Game sigmaGame) {
        return null;
    }

    @Override
    public Person makePerson(String name) {
        Person person = new PersonImpl();
        person.setName(name);
        return person;
    }

    @Override
    public void addResults(Person player) {
        // Implementation can be added if needed
    }
}
