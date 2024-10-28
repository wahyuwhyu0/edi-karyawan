package com.karyawanedi.utils;

public class RandomNumbers {

    public static long getRandom(long min, long max) {
        long number = min + (long) (Math.random() * (max - min));
        return number;
    }
}
