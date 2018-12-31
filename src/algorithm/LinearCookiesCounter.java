package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearCookiesCounter implements CookiesCounter {
    @Override
    public int countCookies(GradesArray gradesArray) {
        int[] grades = gradesArray.getGrades().clone();
        int[] cookies = new int[grades.length];

        Arrays.fill(cookies, 0);

        if (grades.length == 1) {
            //differentiate the case when there is only 1 student
            cookies[0] = 1;
            return cookies[0];
        }

        ArrayList<Integer> emptyValues = new ArrayList<>();

        int cookiesCount = 0;
        for (int index = 0; index < grades.length; ++index) {
            if (index == 0) {
                if (grades[index] <= grades[index + 1]) {
                    cookies[index] = 1;
                } else {
                    //value cannot be found in this iteration
                    emptyValues.add(index);
                }
            } else if (index == grades.length - 1) {
                if (grades[index] > grades[index - 1]) {
                    cookies[index] = cookies[index - 1] + 1;
                } else {
                    cookies[index] = 1;
                }
            } else {
                if (grades[index] <= grades[index - 1]
                        && grades[index] <= grades[index + 1]) {
                    cookies[index] = 1;
                } else if (grades[index] > grades[index - 1]
                        && grades[index] <= grades[index + 1]) {
                    cookies[index] = cookies[index - 1] + 1;
                } else {
                    //value cannot be found in this iteration
                    emptyValues.add(index);
                }
            }

            cookiesCount += cookies[index];
        }

        for (int index = emptyValues.size() - 1; index >= 0; --index) {
            int i = emptyValues.get(index);

            if (i == 0) {
                cookies[i] = cookies[i + 1] + 1;
            } else {
                if (grades[i] > grades[i + 1] && grades[i] > grades[i - 1]) {
                    cookies[i] = cookies[i - 1] > cookies[i + 1] ?
                            cookies[i - 1] + 1 : cookies[i + 1] + 1;
                } else {
                    cookies[i] = cookies[i + 1] + 1;
                }
            }

            cookiesCount += cookies[i];
        }

        return cookiesCount;
    }
}