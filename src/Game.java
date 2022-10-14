import java.util.ArrayList;
import java.util.Collections;

// Tiles --> Hearts --> Speads --> Clovers
public class Game {
    private int balance = 20_000; // $
    private ArrayList<Card> cardsList = new ArrayList<>();
    private int[] avalaibleBets = {1000 , 1500 , 2000 , 2500 , 3000 , 5000};// Storing avalaible bets
    private  ArrayList<Card> pickedUserCards = new ArrayList<>();
    private  ArrayList<Card> pickedDealerCards = new ArrayList<>();
    private byte totalPlayerCardsValue;
    private byte totalDealerCardsValue;

    // Rules : if Both black Jack -> Push /2 * 1.5 But if a black jack happens after first distribution it Only Counts As Double
    public void LaunchingNewGame(){
        /* *************************** Variables ***************************** */
        byte chosenBetNum ;
        byte[] cards_result_arr; // This Array Holds The Return Value Of The getTotalCardsValue  Method
        int chosenBet;
        boolean hasStanded = false;
        String balance_formatted , smallMess;
        /* *************************** Variables ***************************** */
        System.out.println("\n Youre About To Start A New Game ... \n \n");
        do {
            if(this.balance == 0) smallMess = " ( Can't Play With This Balance )"; else smallMess = "";
            System.out.println("<3 % £> $ &> * §> <3 % £> $ &> * §> *%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*% <3 % £> $ &> * §> <3 % £> $ &> * §>");
            System.out.println("\t \t \t \t \t \t Current Balance : " + ValidationMet.formatNumber(this.balance) + smallMess +"\n");
            System.out.println("1 |-{> Bet With 1000");
            System.out.println("2 |-{> Bet With 1500");
            System.out.println("3 |-{> Bet With 2000");
            System.out.println("4 |-{> Bet With 2500");
            System.out.println("5 |-{> Bet With 3000");
            System.out.println("6 |-{> Bet With 5000");
            System.out.println("0 |-{> Leave Game <-| |");
            chosenBetNum = ValidationMet.getChoosenUserInputNumber((byte) 0 , (byte) 6 ,"The Number Of Chosen Bet");
            System.out.println("<3 % £> $ &> * §> <3 % £> $ &> * §> *%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*% <3 % £> $ &> * §> <3 % £> $ &> * §>");
            if(chosenBetNum == 0) break;
            chosenBet =  this.avalaibleBets[--chosenBetNum];
            int result = this.balance - chosenBet;
            if( !(result >= 0) ) {
                System.out.println("\nYou Don't Have Enough Balance To Play With this Bet Or Your Balance run out  , Try Another Bet Or Come Back Later ... \n");
            }else {
                balance_formatted = ValidationMet.formatNumber(chosenBet);
                    System.out.println("\n You Beted With  { [ "+ balance_formatted +" ] } Discounting Bet From Balance ....\n");
                    this.balance = result;
                    System.out.println("Shuffling Cards ... \n");
                    this.shuffleCards();
                    System.out.println("Distributing Cards .... \n");
                    /************************ User Play ************************/
                    Collections.addAll(this.pickedUserCards , this.hitCard() , this.hitCard());
                    System.out.println("Picked User Cards \n");
                    Card card1 = this.pickedUserCards.get(0);
                    Card card2 = this.pickedUserCards.get(1);
                    this.totalPlayerCardsValue = this.getTotalCardsValue(true);
                    System.out.print("Given Card Number { 1 } : \t " + card1.getCardVal().getName() + " \tOf \t "+ card1.getCardShape().getName() + " \t Value |-> { " + getCardValue(card1 , true) +" }\n");
                    System.out.print("Given Card Number { 2 } : \t " + card2.getCardVal().getName() + " \tOf \t "+ card2.getCardShape().getName() + " \t Value |-> { " + getCardValue(card2 , true) +" }\n");
                    if(this.totalPlayerCardsValue == 21) {
                        System.out.println("\n \t \t \t \t <3 % £> $ &> * §> <3 % £> $ &> * §> : ) Yeaaaahhh You Got A {{ Black Jack }} <3 % £> $ &> * §> <3 % £> $ &> * §> \t \t \t \t\n");
                        hasStanded = true; // If The Player Got A Black Jack Means That either He Wins Or he Draws so he should stand
                    }
                    System.out.println("\nTotal Points Of The Cards : [ " + this.totalPlayerCardsValue + " ]\n");
                    /************************ Dealer Play ************************/
                    Collections.addAll(this.pickedDealerCards , this.hitCard() , this.hitCard());
                    System.out.println("Picked Dealer Cards \n");
                    card1 = this.pickedDealerCards.get(0);
                    card2 = this.pickedDealerCards.get(1);
                    this.totalDealerCardsValue = this.getTotalCardsValue(false);
                    System.out.print("Given Card Number { 1 } : \t " + card1.getCardVal().getName() + " \tOf \t "+ card1.getCardShape().getName() + " \t Value |-> { " + getCardValue(card1 , false) +" }\n");
                    System.out.print("Given Card Number { 2 } : \t \t \t ~~ Second Dealer Card Is Flipped ~~ \n");
                    while (!hasStanded){

                    }
                    if(this.totalDealerCardsValue == 21) {
                        System.out.println("\n \t \t \t \t <3 % £> $ &> * §> <3 % £> $ &> * §> : (  The Dealer Got  A {{ Black Jack }} <3 % £> $ &> * §> <3 % £> $ &> * §> \t \t \t \t\n");
                    }
                    System.out.println("\nTotal Points Of The Cards : [ " + this.totalDealerCardsValue + " ]\n");
                    // Clearing The Picked Dealer And Player Cards Array
                    this.pickedDealerCards.clear(); this.pickedUserCards.clear();
            }

        }while (chosenBet != 0);
    }
    public void createCards(){
        for (Shape shape : Shape.values()){
            for ( Value value : Value.values() ){
                this.cardsList.add(new Card(value , shape));
            }
        }
    }
    public void shuffleCards(){
        Collections.shuffle(this.cardsList);
    }
    public Card hitCard(){
        byte cardIndex = (byte) (Math.random() * this.cardsList.size());
        return this.cardsList.get(cardIndex);
    }
    public void checkWhoWins(byte numState){ //If numState : -1 --> Dealer Wins || 0 --> Draw || 1 --> Player Wins

    }
    public void doubleBet(){}
    public void splitCards(){}
    public byte getTotalCardsValue(boolean state){
        ArrayList<Card> arr = state ? this.pickedUserCards : this.pickedDealerCards;
        byte sum = 0;
        for( Card card : arr ){
            if( card.getCardVal().getName().equals("Las") && sum <= 10) {
                sum += 11;
            }else {
                sum += card.getCardVal().getCardGameVal();
            }
        }
        return sum;
    }
    public byte getCardValue(Card card , boolean state){
        byte total = state ? this.totalPlayerCardsValue : this.totalDealerCardsValue ;
        byte cardVal = card.getCardVal().getCardGameVal();
        if( card.getCardVal().getName().equals("Las") && total >= 10) {
            cardVal += 10;
        }
        return cardVal;
    }

}
