package br.com.smartcondo.controllers;

public class RandomController {
    public static int getRandom() {
        int max = 99999;
        int min = 10000;
        int intervalo = max - min + 1;

        return (int) (Math.random() * intervalo) + min;
    }
}