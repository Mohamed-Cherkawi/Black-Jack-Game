import java.util.ArrayList;
// Tiles --> Hearts --> Speads --> Clovers
public class Game {
    private int balance = 20_000;
    Card firstCard = new Card(Value.LAS1 , Shape.TILES);
    ArrayList<Card> cardsList = new ArrayList<Card>();

    public static void main(String[] args) {
        // Creating A New Game
        Game game = new Game();
        /* *************************** Variables ***************************** */
        System.out.println("<3 % £> $ &> * §> ====================== Black Jack Game ======================== <3 % £> $ &> * §>\n \n");
        System.out.println("$|-->> 1 : Start A New Game");
        System.out.println("$|-->> 2 : Start A New Game");
    }
    public void createCards(Card fisrtCard){
    // Creating A Loop That Will Loop Through Each Number And Give it a Specefic Shape  Starting from Tiles To Clovers
        // Getting The First Number Of The First Shape Wich Is Tiles
        byte firstShapeNum = firstCard.getCardShape().getShapeNum() , firstCardNum = firstCard.getCardVal().getCardNum();
        for ( byte shapeNum = firstShapeNum ; shapeNum <= 4 ; shapeNum++ ){
            for (byte cardNum = firstCardNum ; cardNum <= 13 ; cardNum++ ){

            }
        }
    }
}
