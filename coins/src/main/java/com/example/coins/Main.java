package com.example.coins;

public class Main {
    public static void main(String args[]) {
        Coin coin = new Coin();
        int coins[] = {9, 6, 5, 1};
        int V = 10;
        int minCoins = coin.minCoins(coins, V);
        System.out.println("Minimum coins required is " + minCoins);
    }
}