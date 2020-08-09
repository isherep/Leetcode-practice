package Company.Amazon;

import java.util.LinkedList;
import java.util.List;

public class PurchasingSupplies {
    public static void maximumContainers(List<String> scenarios) {
        // Find the maximum number of containers within the budget ["10 2 5", "12 4 4", "6 2 2"] ["4,1,2"]
        // last digit - how many empty for free full
        // start with spliting string into scenarios ints
        for (int i = 0; i < scenarios.size(); i++) {
            String[] scenario = scenarios.get(i).split(" ");
            int currency = Integer.parseInt(scenario[0]);
            int cost = Integer.parseInt(scenario[1]);
            int numEmptyForFull = Integer.parseInt(scenario[2]);
            //System.out.println(currency + ", " + cost + ", " + numEmptyForFull);
            // cost of full container
            // find the cur budget
            // buy full containers with it
            int curBudg = currency;
            // calculate how many containers left after turning
            // curContain
            // figure out starting amount of containers
            int numOfcontainers = currency / cost;
            // while numOfContainsrs is enought to trade
            // keep trading them
            // remaining containers
            int sum = numOfcontainers;
            // int leftOver = numOfcontainers - ((numOfcontainers/numEmptyForFull)*numEmptyForFull);
            while(numOfcontainers >= numEmptyForFull){
                // see how many leftover you cannot trade
                int leftOver = numOfcontainers - ((numOfcontainers/numEmptyForFull)*numEmptyForFull);
                // trade container - how many new can you get
                numOfcontainers = (numOfcontainers - leftOver)/numEmptyForFull + leftOver;
                // now you will have numOfcontainers + leftover and
               // numOfcontainers = numOfcontainers + leftOver;
                // sum+= numOfcontainers/numEmptyForFull;
                sum +=(numOfcontainers - leftOver);
            }

            System.out.println(sum);

        }
    }

    public static void main(String[] args){
        List<List<String>> scenarios = new LinkedList<>();
        List<String> l = new LinkedList<>();
        l.add("6 2 2");
//        l.add("2");
//        l.add("5");
        scenarios.add(l);

        maximumContainers(l);

    }

}
