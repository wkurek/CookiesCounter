package algorithm;


public class GradesArray {
    private int[] grades;

    public GradesArray(int[] grades) {
        this.grades = grades.clone();
    }

    int[] getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        if(grades.length > 0) {
            for(int grade : grades) {
                stringBuilder.append(grade);
                stringBuilder.append(", ");
            }

            stringBuilder.delete(stringBuilder.length() - 2,
                    stringBuilder.length() - 1);
        }

        return stringBuilder.append("]").toString();
    }
}
