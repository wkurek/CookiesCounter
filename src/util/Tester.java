package util;

import algorithm.CookiesCounter;
import algorithm.GradesArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class Tester {
    private int n, step, problemsNumber, instancesNumber;
    private ArrayList<TableRow> results;

    private class TableRow {
        private int problemSize;
        private long time;
        private double factor;

        int getProblemSize() {
            return problemSize;
        }

        void setProblemSize(int problemSize) {
            this.problemSize = problemSize;
        }

        void setTime(long time) {
            this.time = time;
        }

        void setFactor(double factor) {
            this.factor = factor;
        }

        @Override
        public String toString() {
            return String.format(Locale.US, "n=%d\tt(n)=%d\tq(n)=%.2f",
                    problemSize, time, factor);
        }
    }

    public Tester(int n, int step, int problemsNumber, int instancesNumber) {
        this.n = n;
        this.step = step;
        this.problemsNumber = problemsNumber;
        this.instancesNumber = instancesNumber;
    }

    public void test(CookiesCounter cookiesCounter) {
        this.results = new ArrayList<>();
        wormUp(cookiesCounter);

        int median = getMedian();
        long medianTime = getProblemAverageTime(cookiesCounter, median);

        TableRow medianTableRow = new TableRow();
        medianTableRow.setProblemSize(median);
        medianTableRow.setTime(medianTime);
        medianTableRow.setFactor(1.0);

        results.add(medianTableRow);

        for(int i = 0; i < problemsNumber; ++i) {
            long time = getProblemAverageTime(cookiesCounter, n);
            double factor = ((double) time / (double) medianTime);
            factor *= (double) median / n;


            TableRow tableRow = new TableRow();
            tableRow.setProblemSize(n);
            tableRow.setTime(time);
            tableRow.setFactor(factor);

            results.add(tableRow);

            n += step;
        }

        results.sort(Comparator.comparingInt(TableRow::getProblemSize));

        printTable();

    }

    private long getProblemAverageTime(CookiesCounter cookiesCounter, int problemSize) {
        long timeSum = 0;

        for(int j = 0; j < instancesNumber; ++j) {
            GradesArray gradesArray = Generator.getInstance().generate(problemSize);

            //measure time
            long startTime = System.nanoTime();
            cookiesCounter.countCookies(gradesArray);
            long totalTime = System.nanoTime() - startTime;

            timeSum += totalTime;
        }

        return (timeSum / instancesNumber);
    }

    private int getMedian() {
        return (((2 * n) + ((problemsNumber - 1) * step)) / 2);
    }

    private void printTable() {
        for(TableRow tableRow : results) {
            System.out.println(tableRow);
        }
    }

    private void wormUp(CookiesCounter cookiesCounter) {
        for(int i = 0; i < 10; ++i) {
            getProblemAverageTime(cookiesCounter, n);
        }
    }
}
