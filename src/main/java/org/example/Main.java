package org.example;

import javax.management.ObjectName;
import java.util.*;

public class Main{

    public static char calculateGrade(int studentScore){
        char studentGrade;

        if (studentScore>= 90 && studentScore <=100){
            studentGrade = 'A';
        } else if (studentScore >= 80 && studentScore <= 89) {
            studentGrade = 'B';
        } else if (studentScore >= 70 && studentScore <= 79) {
            studentGrade = 'C';
        } else if (studentScore >= 60 && studentScore <= 69) {
            studentGrade = 'D';
        } else{
            studentGrade = 'F';
        }

        return  studentGrade;
    }

    public static double calculateClassAverage (ArrayList<ArrayList<Object>> studentList){
        double classScoreSum = 0.0;
        for (ArrayList<Object> student : studentList){
            Integer scoreTemp = (Integer) student.get(1);
            classScoreSum +=  scoreTemp.doubleValue();
        }

        return classScoreSum / studentList.size();
    }


    public static int displayGradeCount (char grade, ArrayList<ArrayList<Object>> studentList){
        int gradeCount = 0;
        for (ArrayList<Object> student : studentList){
            char studentGrade = (char) student.get(2);

            if (studentGrade == grade){
                gradeCount += 1;
            }

        }

        return  gradeCount;
    }

    public static void displayTopStudents (ArrayList<ArrayList<Object>> studentList){
        ArrayList<ArrayList<Object>> topStudents = new ArrayList<>();
         int maxGrade = 0;
        for (ArrayList<Object> student : studentList){
            int studentGrade = (int) student.get(1);

            if (studentGrade > maxGrade){
                maxGrade = studentGrade;
            }
        }

        for (ArrayList<Object> student: studentList){
            int studentGrade = (int) student.get(1);

            if(studentGrade == maxGrade){
                System.out.print(student.get(0) + " (" +student.get(1)+") ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        System.out.print("Enter number of students: ");
        int numOfStudents = input.nextInt();
        input.nextLine();

        System.out.println();

        ArrayList<ArrayList<Object>> studentList = new ArrayList<>(numOfStudents);


        for (int i = 1; i <= numOfStudents; i++) {
            ArrayList<Object> studentDetails = new ArrayList<>();
            System.out.print("Enter name of student "+i + ": ");
            String studentName = input.nextLine();

            System.out.print("Enter score for "+studentName+ ": ");
            int studentScore = input.nextInt();
            input.nextLine();
            char studentGrade = calculateGrade(studentScore);
            System.out.println(studentName + " got grade: " + studentGrade);

            System.out.println();

            studentDetails.add(studentName);
            studentDetails.add(studentScore);
            studentDetails.add(studentGrade);

            studentList.add(studentDetails);
        }

        System.out.println("----- Class Summary -----");
        double classAverage = calculateClassAverage(studentList);
        System.out.print("Average Score: ");
        System.out.printf("%.2f", classAverage);
        System.out.println();
        System.out.print("Grade Counts: ");
        System.out.print("A:" + displayGradeCount('A',studentList)+ " ");
        System.out.print("B:" + displayGradeCount('B',studentList)+ " ");
        System.out.print("C:" + displayGradeCount('C',studentList)+ " ");
        System.out.print("D:" + displayGradeCount('D',studentList)+ " ");
        System.out.print("F:" + displayGradeCount('F',studentList)+ " ");

        System.out.println();

        System.out.print("Top Student(s): ");
        displayTopStudents(studentList);

    }
}
