package main.java.com.company;

import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int selectOptions;
        boolean userContinue = false;

        String s = """
                Select:\s
                1: gradePointAvgOne()
                2: gradePointAvgTwo()
                0: 0 to quit""";

        do {
            userSelectionPrompt(s);
            selectOptions = input.nextInt();

            if (selectOptions == 1) {
                gradePointAvgOne(input);
            } else {
                System.out.println();
            }
        } while (selectOptions != 0);
    }

    private static void userSelectionPrompt(String s) {
        System.out.println(s);
    }

    private static void gradePointAvgOne(Scanner input) {
        int total = 0, gradeCounter = 1, avg = 0;

        while (gradeCounter <= 10) {
            System.out.printf("Enter Grade %s: %n", gradeCounter);
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;
        }

        avg = total / 10;
        userSelectionPrompt("total = " + total);
        userSelectionPrompt("avg = " + avg);
    }
}
