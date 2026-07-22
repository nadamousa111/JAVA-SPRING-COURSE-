import java.util.Scanner;

public class Grade {

    public static double validateGrade(double grade){
         Scanner sc = new Scanner(System.in);
        while(grade <0 || grade >100){
            System.out.println("invalid grade , please enter grade again");
            grade = sc.nextDouble();
        }

        return  grade ;
    }

    public static void displayStudentsNames(String[] names){
        for(int i =0;i< names.length;i++){

            System.out.println("Name of student number "+ (i+1)+ " is: " + names[i]  +"\n");
        }
    }

    public static void displayGrades(double[]englishGrades , double[]arabicGrades ,double[]mathGrades){
        System.out.println("Grades in English class are:");
        for(int i =0;i< englishGrades.length;i++){
            System.out.println(englishGrades[i]);

        }
        System.out.println("Grades in Arabic class are:");
        for(int i =0;i< arabicGrades.length;i++){
            System.out.println(arabicGrades[i]);

        }
        System.out.println("Grades in Math class are:");
        for(int i =0;i< mathGrades.length;i++){
            System.out.println(mathGrades[i]);

        }
    }

    public static void countPassedStudents(double[]englishGrades , double[]arabicGrades ,double[]mathGrades) {

        int englishCount = 0, arabicCount =0 , mathCount = 0;

        for (int i = 0; i < englishGrades.length; i++) {
            if(englishGrades[i]>=50){
                englishCount ++ ;
            }

        }
        System.out.println("number of students passed in English class are:" + englishCount);

        for (int i = 0; i < arabicGrades.length; i++) {
           if(arabicGrades[i]>=50){
               arabicCount ++ ;
           }

        }
        System.out.println("number of students passed in Arabic class are:" + arabicCount);

        for(int i = 0; i < mathGrades.length; i++) {
           if(mathGrades[i]>=50){
               mathCount ++ ;
           }

        }
        System.out.println("number of students passed in Math class are:" + mathCount);



    }

    public static boolean searchStudent(String name , String[]names){

        for(int i=0;i< names.length;i++){
            if(name.equalsIgnoreCase(names[i])){
                System.out.println("Student Found! \n");
                return true ;

            }


        }

        System.out.println("Student not found");
        return  false ;

    }

    public static double subjectAverage(double[]subjectGrades){
        double count = 0;
        for(int i=0;i<subjectGrades.length;i++){
            count = count + subjectGrades[i] ;
        }
       return  count/subjectGrades.length;
    }

    public static void displayGradeLetter(double grade){
      if(grade>=85 && grade <=100){
          System.out.println("A");
      }
      else if(grade>=75 && grade<85){
          System.out.println("B");
      }
      else if(grade>=65 && grade< 75){
          System.out.println("C");
      }
      else if(grade>=50 && grade <65){
          System.out.println("D");
      }
      else {
          System.out.println("F");
      }

    }

    public static double displayHighestGrade(double[]grades) {
        double max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
            }

        }
        return max;
    }





    public static void main(String[] args) {

   String[] studentsNames = new String [5];
   double[] englishGrades = new double [5];
   double[] arabicGrades= new double [5];
   double[] mathGrades = new double [5];

        //System.out.println(studentsNames.length);
   Scanner input = new Scanner(System.in);
   for(int i=0;i<studentsNames.length;i++) {
       System.out.println("please enter name of student number " + (i+1) +"\n" );
       studentsNames[i] = input.nextLine();
       System.out.println("please enter English grade of student number " + (i+1) +"\n");
       englishGrades[i] = validateGrade(input.nextDouble());
       System.out.println("please enter Arabic grade of student number " + (i+1) +"\n");
       arabicGrades[i] = validateGrade(input.nextDouble());
       System.out.println("please enter Math grade of student number " + (i+1) +"\n");
       mathGrades[i] = validateGrade(input.nextDouble());
       input.nextLine();
   }

   while(true){
       System.out.println("please choose from the following menu: \n 1- Display all students names \n 2- Display all students grades in all subjects \n 3- search student by name \n 4- count passed students \n 0- Exit \n");
       int option = input.nextInt() ;
       input.nextLine();

       switch (option){

           case 1 :

          displayStudentsNames(studentsNames);
          break ;
           case  2 :

         displayGrades(englishGrades,arabicGrades,mathGrades);
         break;

           case 3:
           System.out.println("please enter the name of student to search:");
           String name = input.nextLine();

           searchStudent(name,studentsNames);
           break;

           case 4:
               countPassedStudents(englishGrades,arabicGrades,mathGrades);
               break;

           case 0 :

               return;

           default:
               System.out.println("invalid option");
               break;

       }


   }







    }

}
