import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        int cardNumber1 = drawRandomCard();
        int cardNumber2 = drawRandomCard();
        System.out.println("\n You get a \n" + cardString(cardNumber1) + "\n and a \n" + cardString(cardNumber2));
        int playerTotal = Math.min(cardNumber1, 10) + Math.min(cardNumber2, 10);
        System.out.println("your total is: " + playerTotal);

        int dealerCardNum1 = drawRandomCard();
        int dealerCardNum2 = drawRandomCard();
        System.out.println(
                "The dealer shows \n " + cardString(dealerCardNum1) + "\nand has a card facing down \n" + faceDown());
        int dealerTotal = Math.min(dealerCardNum1, 10) + Math.min(dealerCardNum2, 10);
        System.out.println("\nThe dealer's total is hidden");

        while (true) {

            if (hitOrStay().equals("hit")) {
                int newCardNum = drawRandomCard();
                playerTotal += newCardNum;
                System.out.println(cardString(newCardNum));
                System.out.println("your total is: " + playerTotal);
                if (playerTotal > 21) {
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
            } else {
                break;
            }
        }

        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are: \n" + cardString(dealerCardNum1) + "\n and a \n"
                + cardString(dealerCardNum2));

        while (dealerTotal < 17) {
            int newDealerCardNum = drawRandomCard();
            dealerTotal += newDealerCardNum;
            System.out.println("The dealer shows \n " + cardString(newDealerCardNum));
            System.out.println("\nDealer's total is: " + dealerTotal);
            if (dealerTotal > 21) {
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
        }
        if (playerTotal > dealerTotal) {
            System.out.println("Player Wins!");
        } else if (playerTotal == dealerTotal) {
            System.out.println("it's a tie");
        } else {
            System.out.println("Dealer Wins!");
        }

        scan.close();
    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13 + 1;
        return (int) randomNumber;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";
            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";

            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";

            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";
            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default:
                return "not possible";
        }
    }

    public static String faceDown() {
        return "   _____\n" +
                "  |     |\n" +
                "  |  J  |\n" +
                "  | JJJ |\n" +
                "  |  J  |\n" +
                "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println("hit or stay?");
        while (true) {
            String option = scan.nextLine();
            if (option.equals("hit") || option.equals("stay")) {
                return option;
            }
            System.out.println("Please write 'hit' or 'stay'");
        }

    }

}
