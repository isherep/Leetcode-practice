package Company.Amazon;

public class TurnStyle {
    private static int[] amazonTurnstile(int numCustomers, int[] arrTime, int[] direction) {
        int[] output = new int[numCustomers];
        int prev = 1;
        int i = 0, j = 1, k = 0;

        while (j < numCustomers) {
            // if both customers are trying to pass at the same time
            if (arrTime[i] == arrTime[j]) {
                if (direction[i] == prev) { // i goes first
                    output[i] = k; // first element in the output takes 0 sec to wait
                    arrTime[j]++; // move j poiter to 3rd customer
                    i = j;
                    j++;
                } else { // j goes first
                    output[j] = k;
                    arrTime[i]++;
                    j++;
                }

            } else {
                output[i] = k;
                prev = direction[i];
                i = j;
                j++;

            }
            k++;
        }
        output[i] = Math.max(k, arrTime[i]);
        return output;
    }

    public static void main(String[] args){
        int numCustomers = 4;
        int[] arrTime = {0,0,1,5};
        int[] direction = {0,1,1,0};
        int[] res = amazonTurnstile(numCustomers, arrTime, direction);
        for(int n: res){
            System.out.print(n + ", ");
        }


    }
}
