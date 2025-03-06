                                                                                                                                                              
public class Card {

    
    private int suit;
    private int rank;
    private int value;

    public Card(int suit, int rank, int value) {
    	
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String SpecialAdress() {
    	
        String s1 = "";
        String s2 = "";
        if (rank == 11) {
            s1 = "Jack";
        } else if (rank == 12) {
            s1 = "queen";
        } else if (rank == 13) {
            s1 = "king";
        } 
        else if(rank==1){
            s1 = "ace";
        }else {
            s1 = Integer.toString(rank);
        }

        if (suit == 0) {//Club
            s2 = "c";
        } else if (suit == 1) {
            s2 = "s";
        } else if (suit == 2) {
            s2 = "d";
        } else if (suit == 3) {
            s2 = "h";

        }
        return s1 + s2;
    }

    public String AdressOfImage() {
        String adress = SpecialAdress();
        return "C:\\Users\\melih\\OneDrive - Antalya Bilim University\\Desktop\\cs201jpg\\" + adress + ".jpg";
    }

}
