import java.util.*;
import java.util.concurrent.TimeUnit;
public class Quizlet{
    public static void main(String args[]){
        // INSTRUCTIONS !!!!!!!!!!
        // copy these lines of code and change the words inside the ""
        // to what you want your term to be if it says vocab[Vcount] = "CHANGE THIS"
        // and change it to the definition you want if it says def[Vcount] = "CHANGE THIS";
        // COPY AND PASTE THIS
        /*
        vocab [Vcount] = "revulsion";
        def [Vcount] = "an intense dislike, disgust, or horror";
        Vcount++;
        */
        // there should be a Vcount++; after each set of vocab and def
        // VERY IMPORTANT: change this to the correct # of terms in your list,
        // if you have 30 defintions matched with 30 vocab words, you would change it to 30:
        int amountOfTerms = 30;
        // ^^^
        boolean menuAgain = true;
        int menu1;
        boolean menu1Test = true;
        boolean menu1_1Test = false;
        boolean menu1_2Test = false;
        int menu2;
        boolean menu2Test = false;
        boolean menu2_1Test = false;
        boolean menu2_2Test = false;
        boolean menu2_3Test = false;
        int menu3;
        boolean menu3Test = false;
        boolean menu3_1Test = false;
        boolean menu3_2Test = false;
        int mistakes = 0;
        boolean playCount = true;
        int countInput = 2;
        int termCount = 0;
        int currentTermV;
        int pastTerm1 = 100;
        int pastTerm2 = 100;
        int pastTerm3 = 100;
        int pastTerm4 = 100;
        boolean runAgain = true;
        String currentTerm;
        boolean mistakesTF = true;
        int blank = 0;
        int outOf;
        String playAgainTest = "a";
        boolean exit = true;
        int shuffleCount;
        int sCount = 0;
        Random termRand = new Random();
        Random dtRand = new Random();
        Random shuffleRand = new Random();
        int shuffleInt;
        int Vcount = 0;
        boolean shuffleTest = true;
        int dtRandInt = dtRand.nextInt(2) + 0;
        String shuffleListV[] = new String[amountOfTerms];
        for (int Rcount = 0;Rcount < amountOfTerms;Rcount++){
            shuffleListV[Rcount] = "a";
        }
        String shuffleListD[] = new String[amountOfTerms];
        for (int Rcount = 0;Rcount < amountOfTerms;Rcount++){
            shuffleListD[Rcount] = "a";
        }
        String shuffleRepeat[] = new String[amountOfTerms];
        for (int Rcount = 0;Rcount < amountOfTerms;Rcount++){
            shuffleRepeat[Rcount] = "a";
        }
        String vocab[] = new String[amountOfTerms];
        String def[] = new String[amountOfTerms];
        
        // list 9
        vocab [Vcount] = "ponderous";
        def [Vcount] = "having great weight or bulk; heavy";
        Vcount++;
        vocab [Vcount] = "carrion";
        def [Vcount] = "dead and rotting flesh";
        Vcount++;
        vocab [Vcount] = "harried";
        def [Vcount] = "harrased, burdened by problems";
        Vcount++;
        vocab [Vcount] = "valor";
        def [Vcount] = "great courage especially in battle";
        Vcount++;
        vocab [Vcount] = "formitable";
        def [Vcount] = "causing fear, dread or apprehension; or to discourage attack";
        Vcount++;
        vocab [Vcount] = "lout";
        def [Vcount] = "an awkwardly brutish person";
        Vcount++;
        vocab [Vcount] = "victuals";
        def [Vcount] = "food usuable by people";
        Vcount++;
        vocab [Vcount] = "appall";
        def [Vcount] = "to be overcome by shock or dismay";
        Vcount++;
        vocab [Vcount] = "plundered";
        def [Vcount] = "to take by force, especially in warfare";
        Vcount++;
        vocab [Vcount] = "guile";
        def [Vcount] = "slyness; craftiness; skillful deception";
        // list 10
        Vcount++;
        vocab [Vcount] = "ardor";
        def [Vcount] = "passion; intensity of emotion; enthusiasm";
        Vcount++;
        vocab [Vcount] = "besiege";
        def [Vcount] = "to surround; to harrass with requests or demands";
        Vcount++;
        vocab [Vcount] = "contentious";
        def [Vcount] = "tending to argue; quarrelsome";
        Vcount++;
        vocab [Vcount] = "mortal";
        def [Vcount] = "capable of death";
        Vcount++;
        vocab [Vcount] = "maelstrom";
        def [Vcount] = "a large, powerful, or violent whirlpool";
        Vcount++;
        vocab [Vcount] = "mischievous";
        def [Vcount] = "causing annoyance, harm, or trouble";
        Vcount++;
        vocab [Vcount] = "restitution";
        def [Vcount] = "the restorations of property or rights, the act of giving compensation";
        Vcount++;
        vocab [Vcount] = "shroud";
        def [Vcount] = "to cover as with a burial cloth; to conceal";
        Vcount++;
        vocab [Vcount] = "supplication";
        def [Vcount] = "an act of humble prayer or petition";
        Vcount++;
        vocab [Vcount] = "tumultuous";
        def [Vcount] = "making an uproar";
        Vcount++;
        //list 11
        vocab [Vcount] = "cower";
        def [Vcount] = "to crouch or shrink back in fear or shame";
        Vcount++;
        vocab [Vcount] = "impudence";
        def [Vcount] = "a speech or behavior that is agressive or rude";
        Vcount++;
        vocab [Vcount] = "guise";
        def [Vcount] = "an outward apperance, false appearance";
        Vcount++;
        vocab [Vcount] = "renowned";
        def [Vcount] = "widely known";
        Vcount++;
        vocab [Vcount] = "shun";
        def [Vcount] = "to keep away from; avoid";
        Vcount++;
        vocab [Vcount] = "jostle";
        def [Vcount] = "to bump, push, or shove roughly";
        Vcount++;
        vocab [Vcount] = "lavish";
        def [Vcount] = "to give generously";
        Vcount++;
        vocab [Vcount] = "aloof";
        def [Vcount] = "emotionally or shave roughly";
        Vcount++;
        vocab [Vcount] = "implacable";
        def [Vcount] = "emotionally distant; disinterested";
        Vcount++;
        vocab [Vcount] = "revulsion";
        def [Vcount] = "an intense dislike, disgust, or horror";
        Vcount++;
        // list 12
        
        /*
        def [0] = "having a bad reputation of the worst kind; vicious; notoriously bad";
        vocab [0] = "infamous";
        def [1] = "a platform raised above the surrounding level to give prominence to the person upon it";
        vocab [1] = "dais";
        def [2] = "an offical approval, praise, or commendation";
        vocab [2] = "approbation";
        def [3] = "to turn away from sin";
        vocab [3] = "atone";
        def [4] = "to distinguish between two or more things";
        vocab [4] = "discern";
        def [5] = "to make wrinkles or grooves";
        vocab [5] = "furrow";
        def [6] = "likely to decay or spoil";
        vocab [6] = "perishable";
        def [7] = "giving or surrendering oneself to the will of another";
        vocab[7] = "submissive";
        def [8] = "a violation of a law, command, or duty";
        vocab[8] = "transgression";
        def [9] = "the state of being alone or removed from society";
        vocab[9] = "solitude";
        
        def [10] = "of or relating to marriage";
        vocab [10] = "connubial";
        def [11] = "the theft of personal property";
        vocab [11] = "larcany";
        def [12] = "a person who takes part in a dialogue or conversation";
        vocab [12] = "interlocutor";
        def [13] = "exciting amazement or wonder";
        vocab [13] = "prodigiously";
        def [14] = "happy or joyous";
        vocab [14] = "blithe";
        def [15] = "to absolve; to relase someone from a duty or boligation";
        vocab [15] = "exonerated";
        def [16] = "of keen judgement; indicating acute discernment";
        vocab [16] = "sagacious";
        def [17] = "the state of good humor, merriment";
        vocab[17] = "joviality";
        def [18] = "pleasant because of personality, quality, or interest similar to one's own";
        vocab[18] = "congenial";
        def [19] = "a protest";
        vocab[19] = "remonstrance";
        */
        while(menuAgain = true){
            blank = 0;
            playCount = true;
            exit = true;
            termCount = 0;
            mistakes = 0;
        while (menu1Test == true){
            System.out.println('\u000c' + "Please enter the number of the option you want to select:\nn1)Infinite loop\nn2)Review the list once");
            Scanner menu1Input = new Scanner(System.in);
            menu1 = menu1Input.nextInt();
            while (menu1Test == true){
                if (menu1 == 1){
                    menu1_1Test = true;
                    menu1Test = false;
                    menu2Test = true;
                }
                else if (menu1 == 2){
                    menu1_2Test = true;
                    menu1Test = false;
                    menu2Test = true;
                }
                else{
                    System.out.println('\u000c' + "That is not a valid option, please enter another number:\nn1)Infinite loop\nn2)Review the list once");
                    menu1Input = new Scanner(System.in);
                    menu1 = menu1Input.nextInt();
                }
            }
        }
        while (menu2Test == true){
            System.out.println('\u000c' + "Do you want:\nn1)To be given the term and enter the definition\nn2)Be given the definition and enter the term\nn3)Randomly be given either the deifnition or term first and enter the other");
            Scanner menu2Input = new Scanner(System.in);
            menu2 = menu2Input.nextInt();
            while (menu2Test == true){
                if (menu2 == 1){
                    menu2_1Test = true;
                    menu3Test = true;
                    menu2Test = false;
                }
                else if (menu2 == 2){
                    menu2_2Test = true;
                    menu3Test = true;
                    menu2Test = false;
                }
                else if (menu2 == 3){
                    menu2_3Test = true;
                    menu3Test = true;
                    menu2Test = false;
                }
                else{
                    System.out.println('\u000c' + "That is not a valid option, please enter another number:\nn1)To be given the term and enter the definition\nn2)Be given the definition and enter the term\nn3)Randomly be given either the deifnition or term first and enter the other");
                    menu2Input = new Scanner(System.in);
                    menu2 = menu2Input.nextInt();
                }
            }
        }
        while (menu3Test == true){
            System.out.println('\u000c' + "Do you want the the terms and defintions to be:\nn1)In order\nn2)Randomized");
            Scanner menu3Input = new Scanner(System.in);
            menu3 = menu3Input.nextInt();
            while (menu3Test == true){
                if (menu3 == 1){
                    menu3_1Test = true;
                    menu3Test = false;
                }
                else if (menu3 == 2){
                    menu3_2Test = true;
                    menu3Test = false;
                }
                else{
                    System.out.println('\u000c' + "That is not a valid option, please enter another number:\nn1)In order\nn2)Randomized");
                    menu3Input = new Scanner(System.in);
                    menu3 = menu3Input.nextInt();
                }
            }
        }
        // infinite loop with entering in definition first and in order
        if (menu1_1Test == true && menu2_1Test == true && menu3_1Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                while (exit == true){
                    System.out.println("\n\"" + vocab[termCount] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(def[termCount])){
                        System.out.println("\nCorrect!");
                        try {TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                        blank++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe definition was \"" + def[termCount] + "\" and the term was \n\"" + vocab[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                        blank++;
                    }
                    else if (vocab1.equals("EXIT")){
                        exit = false;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                    if (termCount > amountOfTerms)
                    {
                        termCount = 0;
                    }
                }
                outOf = blank - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + blank + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // one go through list and defintion first and in order
        if (menu1_2Test == true && menu2_1Test == true && menu3_1Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                while (termCount < amountOfTerms){
                    System.out.println("\n\"" + vocab[termCount] + ".\"");
                    System.out.println("Enter \"idk\" if you do not know the answer");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(def[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe definition was \"" + def[termCount] + "\" and the term was \n\"" + vocab[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                outOf = amountOfTerms - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + amountOfTerms + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // infinite loop with entering in term and in order
        if (menu1_1Test == true && menu2_2Test == true && menu3_1Test == true){
            while (playCount == true){
                while (exit == true){
                    System.out.println("\n\"" + def[termCount] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(vocab[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                        blank++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe term was \"" + vocab[termCount] + "\" which meant \n\"" + def[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                        blank++;
                    }
                    else if (vocab1.equals("EXIT")){
                        exit = false;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                    if (termCount > amountOfTerms)
                    {
                        termCount = 0;
                    }
                }
                outOf = blank - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + blank + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // one go through list and term first and in order
        if (menu1_2Test == true && menu2_2Test == true && menu3_1Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                while (termCount < amountOfTerms){
                    System.out.println("\n\"" + def[termCount] + ".\"");
                    System.out.println("Enter \"idk\" if you do not know the answer");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(vocab[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe term was \"" + vocab[termCount] + "\" which meant \n\"" + def[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next term is: ");
                        mistakesTF = false;
                        termCount++;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                outOf = amountOfTerms - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + amountOfTerms + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // infinite loop with random def or term and in order
        if (menu1_1Test == true && menu2_3Test == true && menu3_1Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                while (exit == true){
                    while (exit == true && dtRandInt == 0){
                        System.out.println("\n\"" + vocab[termCount] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                        Scanner vocab1Input = new Scanner(System.in);
                        String vocab1 = vocab1Input.nextLine();
                        System.out.println('\u000c');
                        if (vocab1.equals(def[termCount])){
                            System.out.println("\nCorrect!");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                            termCount++;
                            dtRandInt = dtRand.nextInt(2) + 0;
                            blank++;
                        }
                        else if (vocab1.equals("idk")){
                            System.out.println("\nThe definition was \"" + def[termCount] + "\" and the term was \n\"" + vocab[termCount] + "\".");
                            try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                            System.out.println('\u000c');
                            dtRandInt = dtRand.nextInt(2) + 0;
                            if (dtRandInt == 0){
                                System.out.println("\nThe next term is: ");
                            }
                            else{
                                System.out.println("\nThe next definition is: ");
                            }
                            mistakesTF = false;
                            termCount++;
                            blank++;
                        }
                        else if (vocab1.equals("EXIT")){
                            exit = false;
                        }
                        else{
                            mistakesTF = false;
                            System.out.println("\nIncorrect.");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                        }
                        if (mistakesTF == false){
                            mistakes++;
                            mistakesTF = true;
                        }
                        if (termCount > amountOfTerms)
                        {
                            termCount = 0;
                        }
                    }
                    while (exit == true && dtRandInt == 1){
                        System.out.println("\n\"" + def[termCount] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                        Scanner vocab1Input = new Scanner(System.in);
                        String vocab1 = vocab1Input.nextLine();
                        System.out.println('\u000c');
                        if (vocab1.equals(vocab[termCount])){
                            System.out.println("\nCorrect!");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                            termCount++;
                            dtRandInt = dtRand.nextInt(2) + 0;
                            blank++;
                        }
                        else if (vocab1.equals("idk")){
                            System.out.println("\nThe term was \"" + vocab[termCount] + "\" which means \n\"" + def[termCount] + "\".");
                            try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                            System.out.println('\u000c');
                            dtRandInt = dtRand.nextInt(2) + 0;
                            if (dtRandInt == 0){
                                System.out.println("\nThe next term is: ");
                            }
                            else{
                                System.out.println("\nThe next definition is: ");
                            }
                            mistakesTF = false;
                            termCount++;
                            dtRandInt = dtRand.nextInt(2) + 0;
                            blank++;
                        }
                        else if (vocab1.equals("EXIT")){
                            exit = false;
                        }
                        else{
                            mistakesTF = false;
                            System.out.println("\nIncorrect.");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                        }
                        if (mistakesTF == false){
                            mistakes++;
                            mistakesTF = true;
                        }
                        if (termCount > amountOfTerms)
                        {
                            termCount = 0;
                        }
                    }
                }
                outOf = blank - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + blank + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // one go through list and random def or term and in order
        if (menu1_2Test == true && menu2_3Test == true && menu3_1Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                while (termCount < amountOfTerms){
                    while (termCount < amountOfTerms && dtRandInt == 0){
                        System.out.println("\n\"" + def[termCount] + ".\"");
                        System.out.println("Enter \"idk\" if you do not know the answer");
                        Scanner vocab1Input = new Scanner(System.in);
                        String vocab1 = vocab1Input.nextLine();
                        System.out.println('\u000c');
                        if (vocab1.equals(vocab[termCount])){
                            System.out.println("\nCorrect!");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                            termCount++;
                            dtRandInt = dtRand.nextInt(2) + 0;
                        }
                        else if (vocab1.equals("idk")){
                            System.out.println("\nThe term was \"" + vocab[termCount] + "\" which meant \n\"" + def[termCount] + "\".");
                            try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                            System.out.println('\u000c');
                            dtRandInt = dtRand.nextInt(2) + 0;
                            if (dtRandInt == 0){
                                System.out.println("\nThe next term is: ");
                            }
                            else{
                                System.out.println("\nThe next definition is: ");
                            }
                            mistakesTF = false;
                            termCount++;
                        }
                        else{
                            mistakesTF = false;
                            System.out.println("\nIncorrect.");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                        }
                        if (mistakesTF == false){
                            mistakes++;
                            mistakesTF = true;
                        }
                    }
                    while (termCount < amountOfTerms && dtRandInt == 0){
                        System.out.println("\n\"" + vocab[termCount] + ".\"");
                        System.out.println("Enter \"idk\" if you do not know the answer");
                        Scanner vocab1Input = new Scanner(System.in);
                        String vocab1 = vocab1Input.nextLine();
                        System.out.println('\u000c');
                        if (vocab1.equals(def[termCount])){
                            System.out.println("\nCorrect!");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                            termCount++;
                            dtRandInt = dtRand.nextInt(2) + 0;
                        }
                        else if (vocab1.equals("idk")){
                            System.out.println("\nThe definition was \"" + def[termCount] + "\" and the term was \n\"" + vocab[termCount] + "\".");
                            try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                            System.out.println('\u000c');
                            if (dtRandInt == 0){
                                System.out.println("\nThe next term is: ");
                            }
                            else{
                                System.out.println("\nThe next definition is: ");
                            }
                            mistakesTF = false;
                            termCount++;
                        }
                        else{
                            mistakesTF = false;
                            System.out.println("\nIncorrect.");
                            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                            System.out.println('\u000c');
                        }
                        if (mistakesTF == false){
                            mistakes++;
                            mistakesTF = true;
                        }
                    }
                }
                outOf = amountOfTerms - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + amountOfTerms + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        
        // going from in order to random
        
        // infinite loop with entering in definition first and random
        if (menu1_1Test == true && menu2_1Test == true && menu3_2Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                currentTermV = shuffleRand.nextInt(amountOfTerms);
                while (exit == true){
                    System.out.println("\n\"" + vocab[currentTermV] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(def[currentTermV])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                        currentTermV = shuffleRand.nextInt(amountOfTerms);
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms);
                        }
                        }
                        runAgain = true;
                        blank++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe definition was \"" + def[currentTermV] + "\" which meant \n\"" + vocab[currentTermV] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        blank++;
                    }
                    else if (vocab1.equals("EXIT")){
                        exit = false;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                    if (termCount > amountOfTerms)
                    {
                        termCount = 0;
                    }
                }
                outOf = blank - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + blank + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // one go through list and defintion first and random
        if (menu1_2Test == true && menu2_1Test == true && menu3_2Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                sCount = 0;
                termCount = 0;
                while (termCount < amountOfTerms){
                    shuffleInt = shuffleRand.nextInt(amountOfTerms) + 0;
                    shuffleListV[termCount] = vocab[shuffleInt];
                    shuffleListD[termCount] = def[shuffleInt];
                    currentTerm = shuffleListV[termCount];
                    while (sCount < termCount){
                        if (shuffleRepeat[sCount].equals(shuffleListV[sCount])){
                            shuffleInt = shuffleRand.nextInt(amountOfTerms) + 0;
                            shuffleListV[sCount] = vocab[shuffleInt];
                            shuffleListD[sCount] = def[shuffleInt];
                            currentTerm = shuffleListV[termCount];
                        }
                        else{
                            sCount++;
                        }
                    }
                    sCount = 0;
                    termCount++;
                }
                termCount = 0;
                while (termCount < amountOfTerms){
                    System.out.println("\n\"" + shuffleListV[termCount] + ".\"");
                    System.out.println("Enter \"idk\" if you do not know the answer");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(shuffleListD[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe term was \"" + shuffleListV[termCount] + "\" and the definition was \n\"" + shuffleListD[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                outOf = amountOfTerms - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + amountOfTerms + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // infinite loop with entering in term and random
        if (menu1_1Test == true && menu2_2Test == true && menu3_2Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                while (exit == true){
                    System.out.println("\n\"" + def[currentTermV] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(vocab[currentTermV])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                        currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        blank++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe term was \"" + vocab[currentTermV] + "\" which meant \n\"" + def[currentTermV] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        blank++;
                    }
                    else if (vocab1.equals("EXIT")){
                        exit = false;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                    if (termCount > amountOfTerms)
                    {
                        termCount = 0;
                    }
                }
                outOf = blank - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + blank + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // one go through list and term first and random
        if (menu1_2Test == true && menu2_2Test == true && menu3_2Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                sCount = 0;
                termCount = 0;
                while (termCount < amountOfTerms){
                    shuffleInt = shuffleRand.nextInt(amountOfTerms) + 0;
                    currentTerm = vocab[shuffleInt];
                    sCount = 0;
                    while (sCount < termCount){
                        if(currentTerm.equals(shuffleListV[sCount])){
                            shuffleInt = shuffleRand.nextInt(amountOfTerms) + 0;
                            currentTerm = vocab [shuffleInt];
                            sCount = 0;
                        }
                        else{
                            sCount++;
                        }
                    }
                    shuffleListV[termCount] = vocab[shuffleInt];
                    shuffleListD[termCount] = def[shuffleInt];
                    termCount++;
                }
                termCount = 0;
                while (termCount < amountOfTerms){
                    System.out.println("\n\"" + shuffleListD[termCount] + ".\"");
                    System.out.println("Enter \"idk\" if you do not know the answer");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(shuffleListV[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe definition was \"" + shuffleListV[termCount] + "\" and the term was \n\"" + shuffleListD[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        System.out.println("\nThe next definition is: ");
                        mistakesTF = false;
                        termCount++;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                outOf = amountOfTerms - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + amountOfTerms + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // infinite loop with random def or term and random
        if (menu1_1Test == true && menu2_3Test == true && menu3_2Test == true){
            System.out.println('\u000c');
            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
            while (playCount == true){
                while (exit == true){
                while (exit == true && dtRandInt == 0){
                    System.out.println("\n\"" + def[currentTermV] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(vocab[currentTermV])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        dtRandInt = dtRand.nextInt(2) + 0;
                        blank++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe term was \"" + vocab[currentTermV] + "\" which meant \n\"" + def[currentTermV] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        dtRandInt = dtRand.nextInt(2) + 0;
                        if (dtRandInt == 1){
                            System.out.println("\nThe next term is: ");
                        }
                        else{
                            System.out.println("\nThe next definition is: ");
                        }
                        mistakesTF = false;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        blank++;
                    }
                    else if (vocab1.equals("EXIT")){
                        exit = false;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                while (exit == true && dtRandInt == 1){
                    System.out.println("\n\"" +vocab[currentTermV] + ".\"\nEnter \"idk\" if you do not know the answer.\nEnter EXIT if you wish to stop studying.");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(def[currentTermV])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        dtRandInt = dtRand.nextInt(2) + 0;
                        blank++;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe definition was \"" + def[currentTermV] + "\" which meant \n\"" + vocab[currentTermV] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        dtRandInt = dtRand.nextInt(2) + 0;
                        if (dtRandInt == 1){
                            System.out.println("\nThe next term is: ");
                        }
                        else{
                            System.out.println("\nThe next definition is: ");
                        }
                        mistakesTF = false;
                        while(runAgain){
                        if (currentTermV != pastTerm4 && currentTermV != pastTerm3 && currentTermV != pastTerm2 && currentTermV != pastTerm1){
                        pastTerm4 = pastTerm3;
                        pastTerm3 = pastTerm2;
                        pastTerm2 = pastTerm1;
                        pastTerm1 = currentTermV;
                        runAgain = false;
                        }
                        else{
                            currentTermV = shuffleRand.nextInt(amountOfTerms) + 0;
                        }
                        }
                        runAgain = true;
                        blank++;
                    }
                    else if (vocab1.equals("EXIT")){
                        exit = false;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                }
                outOf = blank - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + blank + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // one go through list and random def or term and random
        if (menu1_2Test == true && menu2_3Test == true && menu3_2Test == true){
            System.out.println('\u000c');
            while (playCount == true){
                sCount = 0;
                termCount = 0;
                while (termCount < amountOfTerms){
                    shuffleInt = shuffleRand.nextInt(amountOfTerms) + 0;
                    shuffleListV[termCount] = vocab[shuffleInt];
                    shuffleListD[termCount] = def[shuffleInt];
                    currentTerm = shuffleListV[termCount];
                    while (sCount < termCount){
                        if (shuffleRepeat[sCount].equals(shuffleListV[sCount])){
                            shuffleInt = shuffleRand.nextInt(amountOfTerms) + 0;
                            shuffleListV[sCount] = vocab[shuffleInt];
                            shuffleListD[sCount] = def[shuffleInt];
                            currentTerm = shuffleListV[termCount];
                        }
                        else{
                            sCount++;
                        }
                    }
                    sCount = 0;
                    termCount++;
                }
                termCount = 0;
                playCount = false;
                while (playCount == false){
                while (termCount < amountOfTerms && dtRandInt == 0){
                    System.out.println("\n\"" + shuffleListV[termCount] + ".\"");
                    System.out.println("Enter \"idk\" if you do not know the answer");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(shuffleListD[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                        dtRandInt = dtRand.nextInt(2) + 0;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe definition was \"" + shuffleListD[termCount] + "\" and the term was \n\"" + shuffleListV[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        dtRandInt = dtRand.nextInt(2) + 0;
                        if (dtRandInt == 0){
                            System.out.println("\nThe next term is: ");
                        }
                        else{
                            System.out.println("\nThe next definition is: ");
                        }
                        mistakesTF = false;
                        termCount++;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                while (termCount < amountOfTerms && dtRandInt == 1){
                    System.out.println("\n\"" + shuffleListD[termCount] + ".\"");
                    System.out.println("Enter \"idk\" if you do not know the answer");
                    Scanner vocab1Input = new Scanner(System.in);
                    String vocab1 = vocab1Input.nextLine();
                    System.out.println('\u000c');
                    if (vocab1.equals(shuffleListV[termCount])){
                        System.out.println("\nCorrect!");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                        termCount++;
                        dtRandInt = dtRand.nextInt(2) + 0;
                    }
                    else if (vocab1.equals("idk")){
                        System.out.println("\nThe term was \"" + shuffleListV[termCount] + "\" and which meant \n\"" + shuffleListD[termCount] + "\".");
                        try{TimeUnit.SECONDS.sleep(4);}catch(Exception e){}
                        System.out.println('\u000c');
                        dtRandInt = dtRand.nextInt(2) + 0;
                        if (dtRandInt == 0){
                            System.out.println("\nThe next term is: ");
                        }
                        else{
                            System.out.println("\nThe next definition is: ");
                        }
                        mistakesTF = false;
                        termCount++;
                    }
                    else{
                        mistakesTF = false;
                        System.out.println("\nIncorrect.");
                        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                        System.out.println('\u000c');
                    }
                    if (mistakesTF == false){
                        mistakes++;
                        mistakesTF = true;
                    }
                }
                if (termCount == amountOfTerms){
                    playCount = true;
                }
                }
                outOf = amountOfTerms - mistakes;
                System.out.println("End of terms list, you got " + outOf + " / " + amountOfTerms + " terms correct. Good job!\nDo you want to study again?\nEnter Y if yes, N if no\nAlso, enter BACK if you want to study another way.");
                Scanner playAgainInput = new Scanner(System.in);
                playAgainTest = playAgainInput.nextLine();
                playAgainTest = playAgainTest.toUpperCase();
                if (!playAgainTest.equals("Y")){
                    playCount = false;
                }
                // reset
                mistakes = 0;
                termCount = 0;
            }
        }
        // reset menu booleans
        if(playAgainTest.equals("BACK")){
            menu1Test = true;
            menuAgain = true;
        }
        else if (playAgainTest.equalsIgnoreCase("n")){
            menuAgain = false;
        }
        else{
            menuAgain = false;
        }
        menu1_1Test = false;
        menu1_2Test = false;
        menu2_1Test = false;
        menu2_2Test = false;
        menu2_3Test = false;
        menu3_1Test = false;
        menu3_2Test = false;
        }
    }
}