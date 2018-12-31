package util;

import algorithm.GradesArray;

import java.util.Random;

public class Generator {
    public static final int GRADES_NUMBER = 6;
    private static final int RANDOM_SEED = 41;

    private static Generator generator;

    private Random random;

    private Generator() {
        this.random = new Random(RANDOM_SEED);
    }

    public static Generator getInstance() {
        if(generator == null) {
            generator = new Generator();
        }

        return generator;
    }

    public GradesArray generate(int n) {
        int[] grades = new int[n];

        for(int i = 0; i < grades.length; ++i) {
            grades[i] = getNextGrade();
        }

        return new GradesArray(grades);
    }

    private int getNextGrade() {
        return random.nextInt(GRADES_NUMBER) + 1;
    }
}
