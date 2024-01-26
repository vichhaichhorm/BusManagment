import java.util.Scanner;

public class BusManagementSystem {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int bus;
      int seat;
      char x;
      int id;
      int y=0;
      int c=0;
      System.out.println("------------- Setting Bus ---------------");
      System.out.print("Enter number of Bus: ");bus=input.nextInt();
      System.out.print("Enter number Seat of Bus: ");seat=input.nextInt();
      String [][] buses=new String[bus][seat];
      int []countAvailable=new int[bus];
      //Initialize bus seat
      for(int i=0;i<bus;i++){
         for (int j=0;j<seat;j++){
            buses[i][j]="(+)";
         }
      }
      do {
         System.out.println("1/ Check Bus");
         System.out.println("2/ Booking Bus");
         System.out.println("3/ Cancel Booking");
         System.out.println("4/ Reset Bus");
         System.out.println("5/ Exit");
         System.out.print("Chose option (1-5): ");
         x=input.next().charAt(0);
         switch (x){
           case  '1' :
               System.out.println("----------- Bus Management Sytem---------");
               System.out.printf("%5s%20s%20s%20s\n","id","Seat","Available","Unavailble");
               for(int i=0;i<bus;i++){
                  countAvailable[i]=0;
                  for(int j=0;j<seat;j++){
                  if(buses[i][j].equals("(+)"))
                     countAvailable[i]++;
                  }
                  System.out.printf("%5d%20s%20s%20s\n",i+1,seat,countAvailable[i],seat-countAvailable[i]);
                  }
               System.out.println("--------------------------------");
               System.out.print("Enter 0 to back or Bus id to see detail: ");
               c=input.nextInt();
               if(c-1>=0 && c-1<bus){
                  for(int j=0;j<seat;j++) {
                     System.out.printf("%s%d           ", buses[c - 1][j], j + 1);
                     if ((j+1) % 5 == 0) {
                        System.out.println();
                     }
                  }
                  System.out.printf("(-) :Unvailable (%d)       (+) : Available (%d)\n",seat-countAvailable[c-1],countAvailable[c-1]);
               }
               else {
                  System.out.println("bus not fount");
               }
               break;
           case '2':
               System.out.print("Enter bus's id: ");c=input.nextInt();
               System.out.println("------------- Display Bus information ----------");
               for(int j=0;j<seat;j++) {
                  System.out.printf("%s%d           ", buses[c - 1][j], j + 1);
                  if ((j+1) % 5 == 0) {
                     System.out.println();
                  }
               }
               System.out.printf("(-) : Unvailable (%d)       (+) : Available (%d)\n",seat-countAvailable[c-1],countAvailable[c-1]);
               System.out.print("Enter Chair number to booking: ");id=input.nextInt();
               if(buses[c-1][id-1].equals("(+)")){
                  System.out.printf("Do yo want to book chair number: %d ? (y/n) : ",id);
                  char book=input.next().charAt(0);
                  if(book=='y')
                     buses[c-1][id-1]="(-)";
                  countAvailable[c-1]--;
                  System.out.printf("chair number %d was booked successfully\n",id);

               }
               break;
           case '3':
               System.out.print("Enter bus's id: ");c=input.nextInt();
               if(c<bus && bus>=0) {
                  System.out.println("------------- Display Bus information ----------");
                  for(int j=0; j<seat; j++){
                     System.out.printf("%s%d           ", buses[c - 1][j], j + 1);
                     if ((j + 1) % 5 == 0) {
                        System.out.println();
                     }
                  }
                  System.out.printf("(-) : Unvailable (%d)       (+) : Available (%d)\n",seat-countAvailable[c-1],countAvailable[c-1]);
                  System.out.print("Enter seat number to Cancel booking: ");id=input.nextInt();
                  if(buses[c-1][id-1].equals("(-)") ){
                     System.out.printf("Do yo want to book chair number: %d ? (y/n) : ",id);
                     char book=input.next().charAt(0);
                     if(book=='y')
                        buses[c-1][id-1]="(+)";
                     countAvailable[c-1]++;
                     System.out.printf("chair number %d was Canceled successfully\n",id);

                  }
               }

               break;
           case '4':
               System.out.print("Enter bus's id to reset: ");c=input.nextInt();
               if(c-1<bus && c-1>=0) {
                  for (int j = 0; j < seat; j++) {
                     buses[c - 1][j] = "(+)";
                     countAvailable[c - 1] = seat;
                  }
                  System.out.printf("Bus id %d was reset with all seats available successfully\n",c);
               }
               else {
                  System.out.println("Bus id is not have ");
               }
               break;
           case '5':
               System.out.println("Program exit...!");
               break;
         }
      }while (x!='5');
   }
}
