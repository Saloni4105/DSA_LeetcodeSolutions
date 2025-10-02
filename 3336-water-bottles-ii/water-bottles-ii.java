class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            // exchange once
            empty -= numExchange;   // spend empties
            numExchange++;          // cost increases
            empty++;                // get 1 new bottle
            total++;                // drink it
        }
        return total;
    }
}
