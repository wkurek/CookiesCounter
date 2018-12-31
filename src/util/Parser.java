package util;

import algorithm.GradesArray;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public static GradesArray parse(InputStream stream) throws Exception {
        Scanner scanner = new Scanner(stream);

        ArrayList<Integer> inputGrades = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] grades = line.split(", ");

            for(String grade : grades) {
                inputGrades.add(Integer.parseInt(grade));
            }
        }

        int[] grades = new int[inputGrades.size()];
        for(int i = 0; i < inputGrades.size(); ++i) {
            int grade = inputGrades.get(i);

            if(grade < 1 || grade > Generator.GRADES_NUMBER)
                throw new Exception("Grade must be between 1 and " + Generator.GRADES_NUMBER);
            else grades[i] = grade;
        }

        GradesArray gradesArray = new GradesArray(grades);

        scanner.close();
        return gradesArray;
    }
}
