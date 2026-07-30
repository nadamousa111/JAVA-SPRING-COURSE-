package student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        Scanner in = new Scanner(System.in);
        System.out.println("please enter the number of student");
        int numOfStudents = in.nextInt();

        if(numOfStudents<=0){
            System.out.println("invalid number of students");
            return;
        }

        Student[] students = new Student[numOfStudents];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.println("enter the student ID , NAME , AND GRADE ");
            int studentID = in.nextInt();
            students[i].setStudentID(studentID);
            in.nextLine();
            String studentName = in.nextLine();
            students[i].setStudentName(studentName);
            double studentGrade = in.nextDouble();
            studentGrade = student.validateGrade(studentGrade,in) ;
            students[i].setStudentGrade(studentGrade);


        }
        while (true) {
            System.out.println("please choose from the following menu: \n 1- Display Students \n 2- Calculate Average Grade \n 3- Find Highest Grade \n 4- Search Student by ID \n 5-" +
                    " Count Passed and failed students \n 6- sort students by grade \n 0- Exit \n");
            int option = in.nextInt();
            in.nextLine();

            switch (option) {

                case 1:
                    student.displayStudents(students);


                    break;
                case 2:
                    student.subjectAverage(students);

                    break;

                case 3:

                    student.displayHighestGrade(students) ;
                    break;

                case 4:
                    System.out.println("Enter the ID for student you want to search:");
                    int id = in.nextInt();
                    student.searchStudent(id, students);
                    break;

                case 5:

                    student.countPassedStudents(students);

                    break;

                case 6:

                    student.sortGrades(students);

                    break;

                case 0:

                    return;

                default:
                    System.out.println("invalid option");
                    break;

            }


        }


    }
}
