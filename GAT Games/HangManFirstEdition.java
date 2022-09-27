import java.util.*;
public class HangManFirstEdition{
    public static void main(String args[]){
    int playagain = 0;
    int nameCount = 1;
    boolean nameTest =  true;
    System.out.println("Player One please enter your name: ");
    Scanner nameOneInBetween = new Scanner(System.in);
    String nameOne = nameOneInBetween.nextLine();
    System.out.println("Player Two please enter your name: ");
    Scanner nameTwoInBetween = new Scanner(System.in);
    String nameTwo = nameTwoInBetween.nextLine();
    int wordLength;
    int countTwo = 1;
    String hi = "hi";
    boolean guessTest;
    String playerOneWord;
    String playAgain;
    String[] inBetween = hi.split("");;
    List playerOneLetters = Arrays.asList(inBetween);
    String spaceOne;
    String spaceTwo;
    String spaceThree;
    String spaceFour;
    String spaceFive;
    String letterOne;
    String letterTwo;
    String letterThree;
    String letterFour;
    String letterFive;
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "D";
    String e = "E";
    String f = "F";
    String g = "G";
    String h = "H";
    String i = "I";
    String j = "J";
    String k = "K";
    String l = "L";
    String m = "M";
    String n = "N";
    String o = "O";
    String p = "P";
    String q = "Q";
    String r = "R";
    String s = "S";
    String t = "T";
    String u = "U";
    String v = "V";
    String w = "W";
    String x = "X";
    String y = "Y";
    String z = "Z";
    String playerTwoLetter;
    int cat;
    int lives;
    int livesCount;
    int mistakes;
    String alpha[] = new String[26];
    String alphabet[] = new String[26];
    alphabet[0] = "A";
    alphabet[1] = "B";
    alphabet[2] = "C";
    alphabet[3] = "D";
    alphabet[4] = "E";
    alphabet[5] = "F";
    alphabet[6] = "G";
    alphabet[7] = "H";
    alphabet[8] = "I";
    alphabet[9] = "J";
    alphabet[10] = "K";
    alphabet[11] = "L";
    alphabet[12] = "M";
    alphabet[13] = "N";
    alphabet[14] = "O";
    alphabet[15] = "P";
    alphabet[16] = "Q";
    alphabet[17] = "R";
    alphabet[18] = "S";
    alphabet[19] = "T";
    alphabet[20] = "U";
    alphabet[21] = "V";
    alphabet[22] = "W";
    alphabet[23] = "X";
    alphabet[24] = "Y";
    alphabet[25] = "Z";
    String alphabetkb[] = new String[26];
    alphabetkb[0] = "A";
    alphabetkb[1] = "B";
    alphabetkb[2] = "C";
    alphabetkb[3] = "D";
    alphabetkb[4] = "E";
    alphabetkb[5] = "F";
    alphabetkb[6] = "G";
    alphabetkb[7] = "H";
    alphabetkb[8] = "I";
    alphabetkb[9] = "J";
    alphabetkb[10] = "K";
    alphabetkb[11] = "L";
    alphabetkb[12] = "M";
    alphabetkb[13] = "N";
    alphabetkb[14] = "O";
    alphabetkb[15] = "P";
    alphabetkb[16] = "Q";
    alphabetkb[17] = "R";
    alphabetkb[18] = "S";
    alphabetkb[19] = "T";
    alphabetkb[20] = "U";
    alphabetkb[21] = "V";
    alphabetkb[22] = "W";
    alphabetkb[23] = "X";
    alphabetkb[24] = "Y";
    alphabetkb[25] = "Z";
    while (playagain == 0)
    {
    if (nameCount == 1)
    {
        System.out.println(nameOne + " please enter one word: ");
    }
    if (nameCount == 2)
    {
        System.out.println(nameTwo + " please enter one word: ");
    }
    Scanner playerOneInput = new Scanner(System.in);
    playerOneWord = playerOneInput.nextLine();
    wordLength = playerOneWord.length();
    countTwo = 1;
    cat = 1;
    for (int countOne = 1;countOne > 0;countTwo++)
    {
    if (wordLength != 5)
    {
        System.out.println("That word is too long or short, please enter another word: ");
        playerOneInput = new Scanner(System.in);
        playerOneWord = playerOneInput.nextLine();
        wordLength = playerOneWord.length();
    }
    if (wordLength == 5)
    {
        countOne--;
    }
    }
    playerOneWord = playerOneWord.toUpperCase();
    spaceOne = "_ ";
    spaceTwo = "_ ";
    spaceThree = "_ ";
    spaceFour = "_ ";
    spaceFive = "_ ";
    
    letterOne = playerOneWord.substring(0,1);
    letterTwo = playerOneWord.substring(1,2);
    letterThree = playerOneWord.substring(2,3);
    letterFour = playerOneWord.substring(3,4);
    letterFive = playerOneWord.substring(4,5);
    letterOne = letterOne.toUpperCase();
    letterTwo = letterTwo.toUpperCase();
    letterThree = letterThree.toUpperCase();
    letterFour = letterFour.toUpperCase();
    letterFive = letterFive.toUpperCase();
    cat = 1;
    lives = 7;
    livesCount = 0;
    mistakes = 0;
    for (int count = 0;count != 26;count++)
    {
        alpha[count] = "";
    }
    System.out.println('\u000c');
    while (cat ==1)
    {
        if (mistakes == 0)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |               / \\\n        |        \n        |\n        |       \n        |           \n        |           \n        |           \n        |           \n        |           \n        |           \n        |  \n        |  \n  ______|______\n");
        }
        if (mistakes == 1)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |             /     \\ \n        |             |     |  \n        |             \\_____/ \n        | \n        |  \n        |  \n        |  \n        |  \n        |  \n        |  \n        |  \n        |  \n  ______|______   ");
        }
        if (mistakes == 2)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |             /     \\ \n        |             |     | \n        |             \\_____/  \n        |                |   \n        |                | \n        |                | \n        |                | \n        |                | \n        |\n        |\n        |\n        |\n  ______|______   \n");
        }
        if (mistakes == 3)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\\n        |         \\   |     |\n        |           \\ \\_____/ \n        |             \\  |  \n        |               \\|\n        |                |\n        |                |\n        |                |\n        |\n        |\n        |\n        |\n  ______|______");
        }
        if (mistakes == 4)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\     /\n        |         \\   |     |   /\n        |           \\ \\_____/ / \n        |             \\  |  /\n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |\n        |\n        |\n        |\n  ______|______\n");
        }
        if (mistakes == 5)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\     /\n        |         \\   |     |   /\n        |           \\ \\_____/ / \n        |             \\  |  /\n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |               /\n        |              /\n        |             /\n        |            /\n  ______|______     /\n");
        }
        if (mistakes == 6)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\     /\n        |         \\   |     |   /\n        |           \\ \\_____/ / \n        |             \\  |  / \n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |               / \\\n        |              /   \\\n        |             /     \\\n        |            /       \\\n  ______|______     /         \\");
        }
        System.out.println("Lives left: " + lives + "\n");
        System.out.println(spaceOne + spaceTwo + spaceThree + spaceFour + spaceFive + "\n\n");
        for(int printCount = 0;printCount < 26;printCount++)
        {
        System.out.print(alphabetkb[printCount] + " ");
        if (printCount == 8)
        {
            System.out.print("\n");
        }
        if (printCount == 17)
        {
            System.out.print("\n");
        }
        }
        if (nameCount == 1)
            {
                System.out.println("\n" + nameTwo + ", please enter one letter to guess: ");
            }
        if (nameCount == 2)
            {
                System.out.println("\n" + nameOne + ", please enter one letter to guess: ");
            }
        Scanner playerTwoInput = new Scanner(System.in);
        playerTwoLetter = playerTwoInput.nextLine();
        playerTwoLetter = playerTwoLetter.toUpperCase();
    for (int countOne = 1;countOne > 0;countTwo++)
    {
        guessTest = true;
        if (playerTwoLetter.length() > 1)
        {
            System.out.println("That is not a valid letter or has already been used ");
            if (nameCount == 1)
            {
                System.out.print(nameTwo);
            }
            if (nameCount == 2)
            {
                System.out.print(nameOne);
            }
            System.out.print(", please enter another letter: ");
            playerTwoInput = new Scanner(System.in);
            playerTwoLetter = playerTwoInput.nextLine();
            guessTest = false;
        }
        if (alpha [0].equals(playerTwoLetter) || alpha [1] == playerTwoLetter || alpha [2] == playerTwoLetter || alpha [3] == playerTwoLetter || alpha [4] == playerTwoLetter || alpha [5] == playerTwoLetter || alpha [6] == playerTwoLetter || alpha [7] == playerTwoLetter || alpha [8] == playerTwoLetter || alpha [9] == playerTwoLetter || alpha [10] == playerTwoLetter || alpha [11] == playerTwoLetter || alpha [12] == playerTwoLetter || alpha [13] == playerTwoLetter || alpha [14] == playerTwoLetter || alpha [15] == playerTwoLetter || alpha [16] == playerTwoLetter  || alpha [17] == playerTwoLetter || alpha [18] == playerTwoLetter || alpha [19] == playerTwoLetter || alpha [20] == playerTwoLetter || alpha [21] == playerTwoLetter || alpha [22] == playerTwoLetter || alpha [23] == playerTwoLetter || alpha [24] == playerTwoLetter || alpha [25] == playerTwoLetter )
        {
            guessTest = false;
        }
        if (guessTest = false)
        {
            System.out.println("That is not a valid letter or has already been used ");
            if (nameCount == 1)
            {
                System.out.print(nameTwo);
            }
            if (nameCount == 2)
            {
                System.out.print(nameOne);
            }
            System.out.print(", please enter another letter: ");
            playerTwoInput = new Scanner(System.in);
            playerTwoLetter = playerTwoInput.nextLine();
        }
        if (guessTest = true)
        {
            countOne--;
        }
    }
    System.out.println('\u000c');
        playerTwoLetter = playerTwoLetter.toUpperCase();
        for (int alphaCount = 0;alphaCount < 26;alphaCount++)
        {
            if (playerTwoLetter.equals(alphabet[alphaCount]))
            {
            alphabetkb[alphaCount] = " ";
            alpha[alphaCount] = alphabet[alphaCount];
            if (letterOne.equals(alphabet[alphaCount]))
            {
                spaceOne = letterOne;
                livesCount++;
            }
            if (letterTwo.equals(alphabet[alphaCount]))
            {
                spaceTwo = letterTwo;
                livesCount++;
            }
            if (letterThree.equals(alphabet[alphaCount]))
            {
                spaceThree = letterThree;
                livesCount++;
            }
            if (letterFour.equals(alphabet[alphaCount]))
            {
                spaceFour = letterFour;
                livesCount++;
            }
            if (letterFive.equals(alphabet[alphaCount]))
            {
                spaceFive = letterFive;
                livesCount++;
            }
        }
        }
        if (livesCount == 0)
        {
            lives--;
            mistakes++;
        }
        livesCount = 0;
        if (lives == 0)
        {
            System.out.println("        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    / 0 0 \\     /\n        |         \\   |  -  |   /\n        |           \\ \\_____/ / \n        |             \\  |  / \n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |               / \\\n        |              /   \\\n        |             /     \\\n        |            /       \\\n  ______|______     /         \\");
        }
        if (lives == 0)
        {
            
            if (nameCount == 1)
            {
                System.out.println("\n" + nameOne + " wins! " + nameTwo + ", you ran out of lives before\nyou could guess " + nameOne + "'s word which was " + playerOneWord + ".\n");
            }
            if (nameCount == 2)
            {
                System.out.print("\n" + nameTwo + " wins! " + nameOne + ", you ran out of lives before\nyou could guess " + nameTwo + "'s word which was " + playerOneWord + ".\n");
            }
            cat = 0;
        }
        if (spaceOne.equals(letterOne) && spaceTwo.equals(letterTwo) && spaceThree.equals(letterThree) && spaceFour.equals(letterFour) && spaceFive.equals(letterFive))
        {
        if (mistakes == 0)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |               / \\\n        |        \n        |\n        |       \n        |           \n        |           \n        |           \n        |           \n        |           \n        |           \n        |  \n        |  \n  ______|______\n");
        }
        if (mistakes == 1)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |             /     \\ \n        |             |     |  \n        |             \\_____/ \n        | \n        |  \n        |  \n        |  \n        |  \n        |  \n        |  \n        |  \n        |  \n  ______|______   ");
        }
        if (mistakes == 2)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |             /     \\ \n        |             |     | \n        |             \\_____/  \n        |                |   \n        |                | \n        |                | \n        |                | \n        |                | \n        |\n        |\n        |\n        |\n  ______|______   \n");
        }
        if (mistakes == 3)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\\n        |         \\   |     |\n        |           \\ \\_____/ \n        |             \\  |  \n        |               \\|\n        |                |\n        |                |\n        |                |\n        |\n        |\n        |\n        |\n  ______|______");
        }
        if (mistakes == 4)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\     /\n        |         \\   |     |   /\n        |           \\ \\_____/ / \n        |             \\  |  /\n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |\n        |\n        |\n        |\n  ______|______\n");
        }
        if (mistakes == 5)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\     /\n        |         \\   |     |   /\n        |           \\ \\_____/ / \n        |             \\  |  /\n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |               /\n        |              /\n        |             /\n        |            /\n  ______|______     /\n");
        }
        if (mistakes == 6)
        {
            System.out.println('\u000c' + "        __________________\n        |                |\n        |                |\n        |              _/_\\_\n        |        \\    /     \\     /\n        |         \\   |     |   /\n        |           \\ \\_____/ / \n        |             \\  |  / \n        |               \\|/\n        |                |\n        |                |\n        |                |\n        |               / \\\n        |              /   \\\n        |             /     \\\n        |            /       \\\n  ______|______     /         \\");
        }
            if (nameCount == 1)
            {
                System.out.println("\n" + nameTwo + " wins! " + nameTwo + " guessed " + nameOne + "'s word\nin time which was " + playerOneWord + "\nwith " + lives + " lives remaining.\n");
            }
            if (nameCount == 2)
            {
                System.out.println("\n" + nameOne + " wins! " + nameOne + " guessed " + nameTwo + "'s word\nin time which was " + playerOneWord + "\nwith " + lives + " lives remaining.\n");
            }
            cat = 0;
        }
    }
    playagain = 1;
    System.out.println("\nDo you want to play again? Enter Y if you do, and N if you do not: ");
    Scanner playAgainTest = new Scanner(System.in);
    playAgain = playAgainTest.nextLine();
    playAgain = playAgain.toUpperCase();
    if (playAgain.equals("Y"))
    {
        playagain = 0;
    }
    if (nameCount == 1)
    {
        nameCount = 2;
        nameTest =  false;
    }
    if (nameCount == 2 && nameTest == true)
    {
        nameCount = 1;
    }
    nameTest = true;
    alphabetkb[0] = "A";
    alphabetkb[1] = "B";
    alphabetkb[2] = "C";
    alphabetkb[3] = "D";
    alphabetkb[4] = "E";
    alphabetkb[5] = "F";
    alphabetkb[6] = "G";
    alphabetkb[7] = "H";
    alphabetkb[8] = "I";
    alphabetkb[9] = "J";
    alphabetkb[10] = "K";
    alphabetkb[11] = "L";
    alphabetkb[12] = "M";
    alphabetkb[13] = "N";
    alphabetkb[14] = "O";
    alphabetkb[15] = "P";
    alphabetkb[16] = "Q";
    alphabetkb[17] = "R";
    alphabetkb[18] = "S";
    alphabetkb[19] = "T";
    alphabetkb[20] = "U";
    alphabetkb[21] = "V";
    alphabetkb[22] = "W";
    alphabetkb[23] = "X";
    alphabetkb[24] = "Y";
    alphabetkb[25] = "Z";
    }
}
}
