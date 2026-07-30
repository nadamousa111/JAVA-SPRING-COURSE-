package student;

import java.util.Scanner;

public class Student {

    private int studentID;
    private String name;
    private double grade;

    public Student() {

    }

    public Student(int studentID, String name, double grade) {

        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public double validateGrade(double grade ,Scanner in) {

        while (grade < 0 || grade > 100) {
            System.out.println("invalid grade , please enter grade again");
            grade = in.nextDouble();

        }

        return grade;
    }

    public void displayStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {


            System.out.println("Student number " + (i + 1) + " Name is " + students[i].getStudentName() + "\n" + "Student ID is " + students[i].getStudentID() + "\n" + "Student grade is " + students[i].getStudentGrade())
            ;
            if (students[i].getStudentGrade() >= 90 && students[i].getStudentGrade() <= 100) {
                System.out.println("your grade status is Excellent"+"\n");
            } else if (students[i].getStudentGrade() >= 75 && students[i].getStudentGrade() < 90) {
                System.out.println("your grade status is very good"+"\n");
            } else if (students[i].getStudentGrade() >= 60 && students[i].getStudentGrade() < 75) {
                System.out.println("your grade status is pass"+"\n");
            } else {
                System.out.println("your grade status is failed"+"\n");
            }
        }
    }


    public void countPassedStudents(Student[] grades) {

        int passedStudentsCount = 0;
        int failedStudentsCount = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i].getStudentGrade() >= 60) {
                passedStudentsCount++;
            } else {
                failedStudentsCount++;
            }

        }
        System.out.println("number of students passed are:" + passedStudentsCount);
        System.out.println("number of students failed are:" + failedStudentsCount);


    }

    public boolean searchStudent(int ID, Student[] IDs) {

        for (int i = 0; i < IDs.length; i++) {
            if (ID == IDs[i].getStudentID()) {
                System.out.println("Student Found! \n");
                return true;

            }


        }

        System.out.println("Student not found");
        return false;

    }

    public void subjectAverage(Student[] studentGrade) {
        double count = 0;
        for (int i = 0; i < studentGrade.length; i++) {
            count = count + studentGrade[i].getStudentGrade();
        }
        System.out.println("The average grade for students is " + count / studentGrade.length);
    }


    public double displayHighestGrade(Student[] grades) {
        double max = grades[0].getStudentGrade();
        for (int i = 1; i < grades.length; i++) {
            if (grades[i].getStudentGrade() > max) {
                max = grades[i].getStudentGrade();
            }

        }
        return max;
    }

    public void sortGrades(Student[] grades) {

        for (int i = 0; i < grades.length - 1; i++) {
            int temp = i;

            for (int j = i + 1; j < grades.length; j++) {

                if (grades[j].getStudentGrade() < grades[temp].getStudentGrade()) {
                    temp = j;
                }


            }

            Student temp2 = grades[i];
            grades[i] = grades[temp];
            grades[temp] = temp2;


        }

        System.out.println("The sorted grades are: ");
        for (Student grade : grades) {
            System.out.println(grade.getStudentGrade());
        }

    }


    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String name) {
        this.name = name;
    }

    public String getStudentName() {
        return name;
    }

    public void setStudentGrade(double grade) {
        this.grade = grade;
    }

    public double getStudentGrade() {
        return grade;
    }
}
