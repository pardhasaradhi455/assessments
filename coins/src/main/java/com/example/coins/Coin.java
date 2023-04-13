package com.example.coins;

import java.util.Arrays;

public class Coin {
    public int minCoins(int coins[], int V) {

        if (V == 0) return 0;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= V) {
                int sub_result = minCoins(coins, V - coins[i]);
                if (sub_result != Integer.MAX_VALUE && sub_result + 1 < result) result = sub_result + 1;
            }
        }
        return result;
    }

}
