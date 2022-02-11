public class DiceGame 
{
    public static void main(String[] args)
    {
        // Dice creation
        System.out.println("Creating a default d6...");
        Die d6 = new Die();
        System.out.println("Creating a d20...");
        Die d20 = new Die(20);
        System.out.println("Creating percentile die (a special d10)...");
        Die d10 = new Die(10, "Percentile");

        // Display initial side up of dice
        Die[] currentSideUpDice = new Die[] {d6, d20, d10};
        for (Die die : currentSideUpDice) 
        {
            System.out.println("The current side up for " + die.getType() + " is " + die.getSideUp());
        }

        System.out.println("\nTesting the roll method\n");

        // Roll dice then display new side up value
        System.out.println("Rolling the " + d6.getType() + "...");
        d6.Roll();
        System.out.println("The new value is " + d6.getSideUp());
        System.out.println("Rolling the " + d20.getType() + "...");
        d20.Roll();
        System.out.println("The current side up for " + d20.getType() + " is " + d20.getSideUp());
        System.out.println("Rolling the " + d10.getType() + "...");
        d10.Roll();
        System.out.println("The new value is " + d10.getSideUp());

        // Set side up to be max number on die
        System.out.println("\nSetting the d20 to show 20...");
        d20.setSideUp(d20.getNumOfSides());
        System.out.println("The side up is now " + d20.getSideUp() + ". Finally");

        // YAHTZEE BONUS QUESTION
        System.out.println("-----\nBONUS\n-----");
        System.out.println("Creating 5 d6...");
        // Create and populate yahtzee dice array
        int diceCount = 5;
        Die[] yahtzeeDie = new Die[diceCount];
        for(int i = 0; i < yahtzeeDie.length; i++)
        {
            yahtzeeDie[i] = new Die();
        }

        // Give number of roll initial value of 1 because on die contstruction it automatically rolls them
        int numberOfRolls = 1;
        // Continuously roll until a yahtzee is achieved
        while(!AllDiceEqual(yahtzeeDie))
        {
            for(int i = 0; i < yahtzeeDie.length; i++)
            {
                yahtzeeDie[i].Roll();
            }

            // Increment roll by 1 each time, this is assuming you are group rolling the dice
            numberOfRolls += 1;
        }

        // Display amount of rolls it took before yahtzee was achieved
        System.out.println("YAHTZEE! it took " + numberOfRolls + " rolls");

    }
    
    // Check if all dice objects have the same face side up value
    private static boolean AllDiceEqual(Die[] dice)
    {
        // When empty array is passed return false
        if(dice.length == 0)
        {
            return false;
        }

        // Assign first elements die face to be checked
        int dieFace = dice[0].getSideUp();
        for(int i = 1; i < dice.length; i++)
        {
            // Return false when all die faces aren't equal
            if(dice[i].getSideUp() != dieFace)
            return false;
        }

        // Returns true when all die faces are a equal
        return true;
    }
}
