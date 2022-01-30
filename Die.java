/*
* Name: Josh Grainge
* Student Number: A00129117
* Creates dice with variable amount of faces and variable names, as well as having the ability to roll the die and get the die's side that is facing up
*/
public class Die 
{
    private String type;
    private int numberOfSides;
    private int sideUp;

    public String getType() {return type;}
    public int getNumOfSides() {return numberOfSides;}
    public int getSideUp() {return sideUp;}
    // Set new side up when face is within die face range
    public void setSideUp(int newSideUp) 
    {
        if(newSideUp <= numberOfSides && newSideUp > 0)
        {
            sideUp = newSideUp;
        }
    }

    // Create 6 sided die by default and rolls die
    public Die()
    {
        numberOfSides = 6;
        type = "d" + numberOfSides;
        Roll();
    }

    // Create die with custom amount of faces, then rolls die
    public Die(int numberOfSides)
    {
        this.numberOfSides = numberOfSides;
        type = "d" + numberOfSides;
        Roll();
    }

    // Creates die with custom type and number of faces, then rolls die
    public Die(int numberOfSides, String type)
    {
        this.numberOfSides = numberOfSides;
        this.type = type;
        Roll();
    }
    
    // Changes die's side that is facing up
    public void Roll()
    {
        sideUp =  (int)(Math.random() * numberOfSides) + 1;
    }

    // Print the die's type, number of sides, and side that is currently up
    public String toString()
    {
        return String.format("Type: %s, Number of sides: %2d, Side currently up: %2d", getType(), getNumOfSides(), getSideUp());
    }
}
