import java.util.Scanner;

public class Main implements Spec {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Game game = new Game(main);
        game.selectPlayer();
        Results results = game.getResults();
        results.getResults();
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
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
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

    }
}
