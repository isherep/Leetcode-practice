package Company.Amazon;

import java.util.LinkedList;
import java.util.List;

/**
 * Amazon Fresh is running a promotion in which customers receive prizes for purchasing a secret combination of fruits. The combination will change each day, and the team running the promotion wants to use a code list to make it easy to change the combination. The code list contains groups of fruits. Both the order of the groups within the code list and the order of the fruits within the groups matter. However, between the groups of fruits, any number, and type of fruit is allowable. The term "anything" is used to allow for any type of fruit to appear in that location within the group.
 * Consider the following secret code list: [[apple, apple], [banana, anything, banana]]
 * Based on the above secret code list, a customer who made either of the following purchases would win the prize:
 * orange, apple, apple, banana, orange, banana
 * apple, apple, orange, orange, banana, apple, banana, banana
 * Write an algorithm to output 1 if the customer is a winner else output 0.
 *
 * Input
 * The input to the function/method consists of two arguments:
 * codeList, a list of lists of strings representing the order and grouping of specific fruits that must be purchased in order to win the prize for the day.
 * shoppingCart, a list of strings representing the order in which a customer purchases fruit.
 * Output
 * Return an integer 1 if the customer is a winner else return 0.
 * Note
 * 'anything' in the codeList represents that any fruit can be ordered in place of 'anything' in the group. 'anything' has to be something, it cannot be "nothing."
 * 'anything' must represent one and only one fruit.
 * If secret code list is empty then it is assumed that the customer is a winner.
 *
 * Example 1:
 *
 * Input: codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [orange, apple, apple, banana, orange, banana]
 * Output: 1
 * Explanation:
 * codeList contains two groups - [apple, apple] and [banana, anything, banana].
 * The second group contains 'anything' so any fruit can be ordered in place of 'anything' in the shoppingCart. The customer is a winner as the customer has added fruits in the order of fruits in the groups and the order of groups in the codeList is also maintained in the shoppingCart.
 *
 * Example 2:
 *
 * Input: codeList = [[apple, apple], [banana, anything, banana]]
 * shoppingCart = [banana, orange, banana, apple, apple]
 * Output: 0
 * Explanation:
 * The customer is not a winner as the customer has added the fruits in order of groups but group [banana, orange, banana] is not following the group [apple, apple] in the codeList.
 *
 * Example 3:
 *
 * Input: codeList = [[apple, apple], [banana, anything, banana]] shoppingCart = [apple, banana, apple, banana, orange, banana]
 * Output: 0
 * Explanation:
 * The customer is not a winner as the customer has added the fruits in an order which is not following the order of fruit names in the first group.
 *
 * Example 4:
 *
 * Input: codeList = [[apple, apple], [apple, apple, banana]] shoppingCart = [apple, apple, apple, banana]
 * Output: 0
 * Explanation:
 * The customer is not a winner as the first 2 fruits form group 1, all three fruits would form group 2, but can't because it would contain
 */

public class FreshPromotion {
    /*
    The code list contains groups of fruits

    The order of the groups within the code list and the order of the fruits within the groups matter.
    However, between the groups of fruits, any number, and type of fruit is allowable

   The term "anything" is used to allow for any type of fruit to appear in that location within the group.

     */

    /**
     * @param codeList, a list of lists of strings
     * @return
     */
    public static int isAWinner(List<List<String>> codeList, List<String> shoppingCart){
        if(codeList == null || codeList.size() < 1) return 1;
        for(List<String> group: codeList) {
            //   group      [apple, apple]
            // cart [orange, apple, apple, banana, orange, banana]
            int i = 0, j = 0;
            // We then move only the right pointer on the target string.
            //                [[apple, apple], [apple, apple, banana]]
            // shoppingCart = [banana, orange, banana, apple, apple]
            while (i < group.size() && j < shoppingCart.size()) {
                String groupItem = group.get(i);
                String cartItem = shoppingCart.get(j);
                if ((groupItem.equals(cartItem)) || group.get(i).equals("anything")) {
                    i++;
                }
                // move pointer in the group
                j++;
            }

            if(j == shoppingCart.size()){
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args){

        /* TEST CASE 1******* SHOULD RETURN WINNER */
        List<List<String>> codeList = new LinkedList<>();
        List<String> group1 = new LinkedList<>();
        group1.add("apple");
        group1.add("apple");
        codeList.add(group1);

        List<String> shoppingCart = new LinkedList<>();
        shoppingCart.add("banana");
        shoppingCart.add("orange");
        shoppingCart.add("banana");
        shoppingCart.add("apple");
        shoppingCart.add("apple");

        System.out.println("is a winner: " + isAWinner(codeList, shoppingCart));

        /* TEST CASE 2 example 3******* SHOULD RETURN 0 */

        List<String> group1T2 = new LinkedList<>();
        group1T2.add("banana");
        group1T2.add("anything");
        group1T2.add("banana");
        List<List<String>> codeList2 = new LinkedList<>();
        codeList.add(group1);
        codeList.add(group1T2);

        List<String> shoppingCart2 = new LinkedList<>();

        shoppingCart2.add("apple");
        shoppingCart2.add("banana");
       // shoppingCart2.add("apple");
        shoppingCart2.add("banana");
        //shoppingCart2.add("orange");
        shoppingCart2.add("banana");

        System.out.println("is a winner case 2: " + isAWinner(codeList2, shoppingCart2));



    }
}
