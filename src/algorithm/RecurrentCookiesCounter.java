package algorithm;

import java.util.Arrays;

public class RecurrentCookiesCounter implements CookiesCounter {
    private int[] grades, cookies;

    @Override
    public int countCookies(GradesArray gradesArray) {
        this.grades = gradesArray.getGrades().clone();
        this.cookies = new int[grades.length];

        //init cookies number array
        cookies = new int[grades.length];
        Arrays.fill(cookies, 0);

        if(grades.length == 1) {
            //differentiate the case when there is only 1 student
            cookies[0] = 1;
            return cookies[0];
        }


        int cookiesNumber = 0;
        for(int i = 0; i < grades.length; ++i) {
            cookiesNumber += getGradeCookiesNumber(i);
        }

        return cookiesNumber;
    }

    private int getGradeCookiesNumber(int index) {
        //check if cookies fot this grade are not already counted
        if(cookies[index] > 0) return cookies[index];


        if(index == 0) {
            if(grades[index] > grades[index + 1]) {
                cookies[index + 1] = getGradeCookiesNumber(index + 1);
                cookies[index] = cookies[index + 1] + 1;
            } else {
                cookies[index] = 1;
            }
        } else if (index == this.grades.length - 1) {
            if(grades[index] > grades[index -1]) {
                cookies[index] = cookies[index - 1] + 1;
            } else {
                cookies[index] = 1;
            }

        } else {
            //both prev and next grades exists

            if(grades[index] > grades[index + 1]) {
                //get cookies number of (index + 1) grade if not already counted
                if(cookies[index + 1] < 1)
                    cookies[index + 1] = getGradeCookiesNumber(index + 1);

                if(grades[index] > grades[index - 1]) {
                    cookies[index] = cookies[index - 1] > cookies[index + 1] ?
                            cookies[index - 1] + 1 : cookies[index + 1] + 1;
                } else {
                    cookies[index] = cookies[index + 1] + 1;
                }
            } else if(grades[index] > grades[index - 1] && grades[index] <= grades[index + 1]) {
                cookies[index] = cookies[index - 1] + 1;
            } else {
                cookies[index] = 1;
            }
        }

        return cookies[index];

    }
}
