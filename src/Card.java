import java.util.HashMap;

/** represents a playing card that can draw itself. */
public class Card implements Drawable, Updateable{
    public class Card implements Comparable<Card>{
        // need some instance variables
        public static final HashMap<Integer, String> dictValues = new HashMap<Integer, String>();
        private int suit;
        private int value;
        //1 is Spades
        //2 is Clubs
        //3 is Hearts
        //4 is Diamonds
        static{
            dictValues.put(1,"Ace");
            dictValues.put(2,"2");
            dictValues.put(3,"3");
            dictValues.put(4,"4");
            dictValues.put(5,"5");
            dictValues.put(6,"6");
            dictValues.put(7,"7");
            dictValues.put(8,"8");
            dictValues.put(9,"9");
            dictValues.put(10,"10");
            dictValues.put(11,"Jack");
            dictValues.put(12,"Queen");
            dictValues.put(13,"King");
        }
        /** Must have this constructor.  You can add others*/
        public Card(int suit, int value){
            this.suit=suit;
            this.value=value;

        }

        //getters
        public int getSuit(){
            return suit;
        }
        public int getValue(){
            return value;
        }


        @Override
        /** This method satisfies the Comparable interface which determines
         * if this Object is smaller than, greater than or equal to the
         * specified Card c
         * Formally, if this Card is smaller than c, a negative int is returned
         *           if this Card is larger than c, a positive int is returned
         *           if this Card is equal to c, zero is returned	*/
        public int compareTo(Card c){
            int answer = 0;
            if (value<c.getValue()){
                answer=-1;
            }
            else if (value>c.getValue()){
                answer=1;
            }
            else {
                answer=0;
            };
            return answer;
        }

        // represents this Card in the following manner
        // if the card is the Ace of Spades, then
        // it returns "Ace of Spades". 2 - 10 can be represented
        // as "2 of Hearts" or "Two of Hearts".  Your choice.
        @Override
        public String toString(){
            String s = "";
            s+=dictValues.get(value);
            s+=" of ";
            if (suit==1) {
                s+="Spades";
            }
            else if (suit==2) {
                s+="Clubs";
            }
            else if (suit==3) {
                s+="Hearts";
            }
            else if (suit==4) {
                s+="Diamonds";
            }
            return s;
        }
    }

}
