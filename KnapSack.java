import java.util.Scanner;
import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {
    	Scanner SC = new Scanner(System.in);
    	
    	System.out.println("Please enter number of items");
    	int a = SC.nextInt();
    	
    	System.out.println("Please Enter the Weight of each item");
        int[] weight = new int[a];
        for(int i =0;i<a;i++) {
        	weight[i] = SC.nextInt();
        }
        
        
        System.out.println("Please Enter the profit of each item");
        int[] profit = new int[a];
        for(int i =0;i<a;i++) {
        	profit[i] = SC.nextInt();
        }

        System.out.println("Please Enter the capacity");
        int capacity = SC.nextInt();
        int n = profit.length;
        
        System.out.println("Entered Weights: "+Arrays.toString(weight));
        System.out.println("Entered profits: "+Arrays.toString(profit));
        System.out.println("Entered Capacity: "+capacity);

        int result = knapsack(n, capacity, weight, profit);
        System.out.println("Maximum profit: " + result);
    }

    public static int knapsack(int n, int capacity, int[] weight, int[] profit) {
        // if there are no items or capacity is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // If the weight of the current item is greater than the remaining capacity, skip it
        if (weight[n - 1] > capacity) {
            return knapsack(n - 1, capacity, weight, profit); // recursive call 
        }

        
        int chooseItem = profit[n - 1] + knapsack(n - 1, capacity - weight[n - 1], weight, profit);
        //knapsack(n - 1, capacity - weight[n - 1], weight, profit) ==> Recursive call
        return chooseItem;
    }
}
