import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Tiles --> Hearts --> Speads --> Clovers
public class Game {
    private int balance = 20_000; // $
    private ArrayList<Card> cardsList = new ArrayList<Card>();

    public static void main(String[] args) {
        /* *************************** Variables ***************************** */
        String chosenOption;
        /* *************************** Variables ***************************** */
        Game game = new Game(); // Creating A New Game
        game.createCards(); // Calling The Function That Gnerate Cards And Storing Them To The CardsList by For eching in each enum
        /* *************************** Game ***************************** */
        System.out.println("<3 % £> $ &> * §> ========================================= Black Jack Game ======================================= <3 % £> $ &> * §> \n");
        System.out.println("$|-->> Enter The [Start] Method To Begin A New Game");
        System.out.println("$|-->> Enter [Leave] To Leave Applicaton");
        System.out.print("\n \t Please Enter Your Choice Here : ");
        chosenOption = stringScannerMeth((byte) 0);
        System.out.println(game.cardsList.size());
        if(chosenOption.equals("start")) game.LaunchingNewGame();
        System.out.println("<3 % £> $ &> * §> ========================================= Left Black Jack Game ======================================= <3 % £> $ &> * §>");
    }
    // Rules : if Both black Jack -> Push / If Black Jack Happened At First debt * 2 * 1.5 But if a black jack happens after first distribution it Only Counts As Double
    // Guve Bet : 1000-1500-2000-2500-2500-3000 / Give me two cards and gives himself two cards too /
    public void LaunchingNewGame(){
        /* *************************** Variables ***************************** */
        byte chosenBetNum;
        int chosenBet;
        int[] avalaibleBets = {1000 , 1500 , 2000 , 2500 , 3000 , 5000};// Storing avalaible bets
        String balance_formatted , smallMess;
        /* *************************** Variables ***************************** */
        System.out.println("\n Youre About To Start A New Game ... \n \n");
        do {
            if(this.balance == 0) smallMess = " ( Can't Play With This Balance )"; else smallMess = "";
            System.out.println("<3 % £> $ &> * §> <3 % £> $ &> * §> *%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*% <3 % £> $ &> * §> <3 % £> $ &> * §>");
            System.out.println("\n Please Choose A Bet To Begin The Game \n");
            System.out.println("\t \t \t \t \t \t Current Balance : " + formatNumber(this.balance) + smallMess +"\n");
            System.out.println("1 |-{> Bet With 1000");
            System.out.println("2 |-{> Bet With 1500");
            System.out.println("3 |-{> Bet With 2000");
            System.out.println("4 |-{> Bet With 2500");
            System.out.println("5 |-{> Bet With 3000");
            System.out.println("6 |-{> Bet With 5000");
            System.out.println("0 |-{> Leave Game <-| |");
            chosenBetNum = getChoosenUserInputNumber((byte) 0 , (byte) 6 ,"The Number Of Chosen Bet");
            System.out.println("<3 % £> $ &> * §> <3 % £> $ &> * §> *%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*%*% <3 % £> $ &> * §> <3 % £> $ &> * §>");
            if(chosenBetNum == 0) break;
            chosenBet =  avalaibleBets[--chosenBetNum];
            int result = this.balance - chosenBet;
            if( !(result >= 0) ) {
                System.out.println("\nYou Don't Have Enough Balance To Play With this Bet Or Your Balance run out  , Try Another Bet Or Come Back Later ... \n");
            }else {
                balance_formatted = formatNumber(chosenBet);
                System.out.println("\n You Beted With  { [ "+ balance_formatted +" ] } Discounting Bet From Balance ....\n");
                this.balance = result;
                System.out.println("Current Balance : " + formatNumber(this.balance) + "\n");
                System.out.println("Distributing Cards .... \n");
                this.shuffleCards();
            }

        }while (true);
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
    public static byte getChoosenUserInputNumber(byte start , byte end , String text){
        // Defining Variables :
        byte choosenNum ;
        Scanner scanerObj = new Scanner(System.in);
        System.out.print(" \n PLease Enter " + text + " Here : ");
        do {
            if (scanerObj.hasNextByte()) { // Checking what users typed before he submittes , to know what type of data he entered
                choosenNum = scanerObj.nextByte();
                if (choosenNum >= start && choosenNum <= end) {
                    break;
                }
            }
            System.out.print(" Please Type A Valid Number : ");
            // Clearing Buffer so it refreshes , to read again from the user
            scanerObj.next();

        } while (true);

        return choosenNum ;
    }
    public static String formatNumber( int num ){
      return  NumberFormat.getCurrencyInstance().format(num);
    }
    public static String stringScannerMeth( byte length ){
        Scanner scanerObj = new Scanner(System.in);
        // Defining Variable :
        String Text ;
        do {
            Text = scanerObj.nextLine().toLowerCase();
            if( Text.length() > length && ( Text.equals("start") || Text.equals("leave")) ){
                break;
            }
            System.out.print("Field Cannot Be Empty And Must Be Either (Start) Or (Leave) : ");

        }while(true);

        return Text ;

    }
}
