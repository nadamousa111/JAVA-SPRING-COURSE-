import java.util.Scanner;

public class Cinema {

public static void showMovies(String[]movies){
    System.out.println("The available Movies are: ");
    for(int i=0;i< movies.length;i++){
        System.out.println(movies[i]);
    }

}

public static char[][] bookSeat(int seatNumber,char[][]seats){
    Scanner sc = new Scanner(System.in);
     int row = seatNumber / 10 ;
     int col = seatNumber %10;

     while(row<=0 || row> seats.length && col<=0 || col>seats[0].length) {


         System.out.println("invalid seat , please enter seat again");
         seatNumber = sc.nextInt() ;
          row = seatNumber / 10 ;
          col = seatNumber %10;

     }
    seats[row - 1][col - 1] = 'X';

     return seats ;
    }

    public static char[][] cancelBooking(int seatNumber,char[][]seats){
        Scanner sc = new Scanner(System.in);
        int row = seatNumber / 10 ;
        int col = seatNumber %10;
        while(row<=0 || row> seats.length && col<=0 || col>seats[0].length) {

            System.out.println("invalid seat , please enter seat again");
            seatNumber = sc.nextInt();
            row = seatNumber / 10 ;
            col = seatNumber %10;

        }
        seats[row - 1][col - 1] = 'O';


        return seats ;

    }


  public static  void main(String[] args){

    Scanner input = new Scanner(System.in);

      System.out.println("Enter the number of rows and columns in the cinema :");
     int rows = input.nextInt();
     int columns = input.nextInt();
    int availableSeatsCount = rows*columns ;
    int bookedSeatsCount = 0;
      int seatNumber;
      int moviesNumber ;

      System.out.println("Enter the number of movies to show in the cinema :");
      moviesNumber = input.nextInt();
      String [] movieNames = new String[moviesNumber] ;
      System.out.println("Enter the movies you want to show in the cinema :");
      for(int i=0;i< movieNames.length;i++){
           movieNames[i] = input.nextLine();
      }

      char[][] seats = new char[rows][columns];
      for(int i=0;i<rows;i++){
          for(int j=0;j<columns;j++){
              seats[i][j] = 'O';
          }

      }

      while(true){
          System.out.println("please choose from the following menu: \n 1- Display Seats \n 2- Book Seat \n 3- Cancel Booking \n 4- Show all movies \n 5- Show number of available and booked seats \n 0- Exit \n");
          int option = input.nextInt() ;
          input.nextLine();

          switch (option){

              case 1 :

                  for(int i=0;i<rows;i++){
                      for(int j=0;j<columns;j++){
                          System.out.print(seats[i][j] + " ");
                      }
                      System.out.println();
                  }


                  break ;
              case  2 :
                  System.out.println("Enter the seat you want to book:");
                  seatNumber = input.nextInt();
                  bookSeat(seatNumber,seats);
                  bookedSeatsCount ++ ;
                  availableSeatsCount -- ;

                  break;

              case 3:
                  System.out.println("Enter the seat you want to cancel:");
                  seatNumber = input.nextInt();
                  cancelBooking(seatNumber,seats);
                  availableSeatsCount ++ ;
                  bookedSeatsCount -- ;


                  break;

              case 4:

                  showMovies(movieNames);

                  break;

              case 5:

                  System.out.println("The number of Available seats is " + availableSeatsCount);
                  System.out.println("The number of Booked seats is " + bookedSeatsCount);
                  if(bookedSeatsCount > 0.8*availableSeatsCount){
                      System.out.println("Seats are almost ful!!");
                  }

                  break;

              case 0 :
                  System.out.println("Thank you for choosing our cinema!");
                  return;

              default:
                  System.out.println("invalid option");
                  break;

          }


      }








  }




}
