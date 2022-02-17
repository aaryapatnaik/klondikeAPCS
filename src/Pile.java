import java.util.*;

public class Pile {

    protected ArrayList<Card> list=new ArrayList<>();
    // returns the number of Cards left in the Pile
    public int size(){
        return list.size();
    }

    public ArrayList<Card> getList() {
        return list;
    }
    //clear pile//
    public void clear(){
        ArrayList<Card> placeholder=new ArrayList<Card>();
        list=placeholder;
    }

    public void shuffle() {
        /* Randomizes the cards in this deck.
         * You must use the following algorithm:
         * If the size is < 2, return;
         * If the size == 2, "flip a coin", swap if "heads"
         * If the size > 2 repeat the following steps size() * 2 times:
         * select two different indexes (make sure they are different)
         * swap them in the ArrayList
         */
        if (size()<2) return;
        if (size()==2) {
            double coin=Math.random();
            if (coin>=0.5) {
                Card x=list.get(0);
                Card y=list.get(1);
                list.set(0, y);
                list.set(1,x);
            }
        }
        if (size()>2) {
            int indOne= (int)(Math.random() * (list.size()-1)) + 1;
            int indTwo= (int)(Math.random() * (list.size()-1)) + 1;
            Card x=list.get(indOne);
            Card y=list.get(indTwo);
            list.set(indOne, y);
            list.set(indTwo,x);
        }
    }

    /*
     * Returns the "top" Card from this Pile, removing it from its
     *  data structure */

    public Card deal(){
        Card c = list.remove(0);
        return c;
    }


    /*  Adds every Card from p to this Pile
        You should not have to change this method.
    */
    public void addPile(Pile p){
        while(p.size()>0){
            this.add(p.deal());
        }
    }


    public void add(Card c) {
        list.add(c);
    }
    /* This returns a String representation of this Pile.  It should return
     *  a String built out of the Cards that the pile contains
     */

    @Override
    public String toString(){
        String s = "";
        //iterate thru list, add to string
        for (Card c: list) {
            s+=c;
            s+=",";
        }
        return s;
    }
}
