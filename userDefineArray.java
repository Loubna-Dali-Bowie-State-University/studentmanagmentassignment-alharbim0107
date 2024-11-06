import java.util.Scanner;
public class userDefineArray {
public static int findMinimum(int num11, int num22,int num33){
    int result;
     result = (Math.min(num11,num22,num33));
    return result;
}

  public static void main(String args[]) {
 Scanner scnr= new Scanner(System.in);
 int num1, num2, num3;
 System.out.println("Enter first number: ");
 num1= scnr.nextInt();
 System.out.println("Enter second number: ");
 num2 = scnr.nextInt();
  System.out.println("Enter third number: ");
 num3= scnr.nextInt();
 System.out.printf("The minimum of %d,%d, and %d is: %d ",num1, num2,num3,findMinimum(num1,num2,num3));
 
  }
  
}