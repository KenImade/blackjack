import java.util.Scanner;

public class BlackJack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");

        scan.nextLine();

        int playerCardOne = generateRandomNumber();
        int playerCardTwo = generateRandomNumber();
        int playerTotal = Math.min(playerCardOne, 10) + Math.min(playerCardTwo, 10);
        
        System.out.print("\n You get a \n " + cardString(playerCardOne) + "\n and a \n" + cardString(playerCardTwo));

        System.out.println("Your total is: " + playerTotal);

        int computerFirstCard = generateRandomNumber();
        int computerSecondCard = generateRandomNumber();
        int computerTotal = Math.min(computerFirstCard, 10) + Math.min(computerSecondCard, 10);

        System.out.print("The dealer shows \n" + cardString(computerFirstCard) + "\nand has a card facing down \n" + faceDownCard());
        System.out.print("\nThe dealer's total is hidden\n");

        

        while(true) {
               String playerInput = hitOrStay();

               if (playerInput.equals("hit")){
                        int newNumber = generateRandomNumber();
                        String newCard = cardString(newNumber);
                        playerTotal += newNumber;

                        System.out.print("\n You get a \n " + newCard);
                        System.out.println("Your new total is " + playerTotal);

                        if (playerTotal > 21) {
                                System.out.println("Bust! Player loses");
                                System.exit(0);
                        }
                } else if (playerInput.equals("stay")) {
                        break;
                }
        }

        System.out.println("\nDealer's turn");
        System.out.println("\n The dealer's cards are \n" + cardString(computerFirstCard) + "\n and a \n" + cardString(computerSecondCard));
        System.out.println("Dealer's total is " + computerTotal);

        while (computerTotal < 17) {
                int newComputerCard = generateRandomNumber();

                computerTotal += Math.min(newComputerCard, 10);
                System.out.println("\n Dealer gets a \n" + cardString(newComputerCard));
                System.out.println("Dealer's total is " + computerTotal);
        }

        if(computerTotal > 21) {
                System.out.println("Bust! Dealer loses.");
                System.exit(0);
        }

        if( playerTotal > computerTotal) {
                System.out.println("Player wins!");
        } else {
                System.out.println("Dealer wins!");
        }
        
        scan.close();
    }

    /**
     * Function: generateRandomNumber
     * @return (int)
     * 
     * Inside the function:
     *  1. Gets a random number between 1 and 13.
     *  2. Returns a card.
     */

    public static int generateRandomNumber() {
        int randomNumber = (int)(Math.random() * 13) + 1;
        return randomNumber;
    }

    /**
     * Function: cardString
     * @param cardNumber (int)
     * @return (String)
     * 
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */

    public static String cardString(int cardNumber) {
        switch(cardNumber) {
            case 1:   
            return "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";
            case 2:
            return  "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
                  
            case 3:
            return"   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n";

            case 4:
            return "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";

            case 5:
            return  "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";

            case 6:
            return  "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";

            case 7:
            return  
                    "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
          

            case 8:
            return  "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9:
            return  "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";

            case 10:
            return  "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11:
            return  "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
            case 12:
            return  "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
            case 13:
            return  "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";

             default: return "not possible";
        }
    }

    public static String faceDownCard() {
            return 
            "   _____\n"+
            "  |     |\n"+
            "  |  J  |\n"+
            "  | JJJ |\n"+
            "  |  J  |\n"+
            "  |_____|\n";
        }

    /**
 * Function name - hitOrStay
 * @return (String)
 * 
 * Inside the function: 
 *      1. Asks the user to hit or stay.
 *      2. If the user doesn't enter "hit" or "stay", 
 *      keep asking them to try again by printing:
 *              Please write "hit" or "stay"
 *      3. Returns the user's option
 */

    public static String hitOrStay() {
        
        while (true) {
                System.out.print("Hit or Stay?: ");
                String response = scan.nextLine().toLowerCase();
                if (!(response.equals("hit") || response.equals("stay"))) {
                        System.out.println("Please write 'hit' or 'stay'");
                        continue;
                } else {
                        return response;
                }
        }
    } 
}