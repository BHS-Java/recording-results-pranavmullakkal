public class PersonImpl implements Person {
    // PROPERTIES-----------------
    private String name;
    private int height;
    private int age;
    private String climbingDirection;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Results getResults() {
        return null;
    }

    @Override
    public void climb(String direction) {
        this.climbingDirection = direction;
        switch (direction.toLowerCase()) {
            case "right up":
                drawStairsRightUp();
                break;
            case "right down":
                drawStairsRightDown();
                break;
            case "left up":
                drawStairsLeftUp();
                break;
            case "left down":
                drawStairsLeftDown();
                break;
            default:
                System.out.println("Please type in either 'left down', 'right down', 'left up', or 'right up'.");
        }
    }

    @Override
    public void setClimbingDirection(String direction) {
        this.climbingDirection = direction;
    }

    @Override
    public String getClimbingDirection() {
        return climbingDirection;
    }

    private void drawStairsRightUp() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(" ".repeat(5 - i) + "#".repeat(i));
        }
    }

    private void drawStairsRightDown() {
        for (int i = 5; i >= 1; i--) {
            System.out.println(" ".repeat(5 - i) + "*".repeat(i));
        }
    }

    private void drawStairsLeftUp() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("[]".repeat(i));
        }
    }

    private void drawStairsLeftDown() {
        for (int i = 5; i >= 1; i--) {
            System.out.println("*".repeat(i));
        }
    }
}
