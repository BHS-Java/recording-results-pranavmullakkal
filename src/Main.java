import java.util.Scanner;

public class Main implements Spec {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        Person person = main.makePerson(main.askString("Enter your name: "));
        
        person.setHeight(main.askNumber("Enter your height in cm: "));
        person.setAge(main.askNumber("Enter your age in years: "));
        
        System.out.println("Name: " + person.getName());
        System.out.println("Height: " + person.getHeight() + " cm");
        System.out.println("Age: " + person.getAge() + " years");
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
        return scanner.nextInt();
    }

    @Override
    public Results getResults(Game guessingOrBetter) {
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
