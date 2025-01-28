/*
 * name: Pranav Mullakkal
 * class: AP CSA P7
 * date: 1/28/25
 * Prompt: Use the interfaces provided and use a scanner to get the name hight and age of the person.


    Your code must also run.

    Longer term. you will make a text file that shows a record of all the game scores for all the players.
 */

 public interface Spec {
    public String  askString(String question);
    public int     askNumber(String question);
    public Results getResults(Game guessingOrBetter);
    public Person  makePerson(String name);
    public void    addResults(Person player);
}

