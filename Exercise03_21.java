/*
 * Zeller’s congruence is an algorithm developed by Christian Zeller to calculate the day of the week.
The formula is :
h = (q + 26(m+1)/10 + k + k/4 + j/4 + 5j) % 7
where
- h is the day of the week (0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5: Thursday, 6: Friday).
- q is the day of the month.
- m is the month (3: March, 4: April, ..., 12: December). January and February are counted as months 13 and 14 of the previous year.
- j is the century (i.e., year/100)
- k is the year of the century (i.e., year%100).
Note that the division in the formula performs an integer division.
Write a program that prompts the user to enter a year, month, and day of the month, and displays the name of the day of the week.
(Hint: January and February are counted as 13 and 14 in the formula, so you need to convert the user input 1 to 13 and 2 to 14 for the month and change the year to the previous year.)
 * 
 */

import java.util.Scanner;

public class Exercise03_21 {

	public static void main(String[] args) {
		//declare variables
		int h; //day of the week
		int q; //day of the month
		int y; //year
		int m; //month
		int j; //century
		int k; //year of century
		String dayOfWeek = "";  
		
		//get user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter year [y]: (e.g., 2012): ");
		y = input.nextInt();
		
		System.out.print("Enter month [m]: (1-12): ");
		m = input.nextInt();
		
		System.out.print("Enter the day of the month [q]: 1-31: ");
		q = input.nextInt();
		
		input.close();
		
			//debug
			System.out.println("\nconfirm user input");
			System.out.println("year [y]: " + y);
			System.out.println("month [m]: " + m);
			System.out.println("date [q]: " + q);
		
		//logic to convert month to 13 for January and 14 for February and subtract 1 from year
		if (m == 1) {
			m = 13; 
			y--;
		}
		else if (m == 2) {
			m = 14;
			y--;
		}
			
			//debug
				System.out.println("\njanuary february logic");
				System.out.println("year [y]: " + y);
				System.out.println("month [m]: " + m);
				System.out.println("date [q]: " + q);
					
		//logic to calculate the century and year of century
		j = y / 100; 		//- j is the century (i.e., year/100)
		k = y % 100;		//- k is the year of the century (i.e., year%100)
		
			//debug
				System.out.println("\ncentury calculations");
				System.out.println("year [y]: " + y);
				System.out.println("century [j]: " + j);
				System.out.println("year of century [k]: " + k);
				
		//calculate the day of the week (Zeller's Formula)
		h = (q + 26 * (m + 1) /10 + k + k/4 + j/4 + 5 * j) % 7;
		
			//debug
				System.out.println("\nzeller's formula:");
				System.out.println("h = (q + 26(m+1)/10 + k + k/4 + j/4 + 5j) % 7");
				System.out.println("year [y]: " + y);
				System.out.println("month [m]: " + m);
				System.out.println("date [q]: " + q);
				System.out.println("century [j]: " + j);
				System.out.println("year of century [k]: " + k);
				System.out.println("day of week [h]: " + h);	
		
		//use switch statement to print
		switch (h) {
		case 0: dayOfWeek = "Saturday"; break;
		case 1: dayOfWeek = "Sunday"; break;
		case 2: dayOfWeek = "Monday"; break;
		case 3: dayOfWeek = "Tuesday"; break;
		case 4: dayOfWeek = "Wednesday"; break;
		case 5: dayOfWeek = "Thursday"; break;
		case 6: dayOfWeek = "Friday"; break;
		}
		System.out.println("Day of the week is " + dayOfWeek);

	}

}

/*
(0: Saturday, 1: Sunday, 2: Monday, 3: Tuesday, 4: Wednesday, 5: Thursday, 6: Friday)
Sample Run 1
Enter year: (e.g., 2012): 2015
Enter month: 1-12:  1
Enter the day of the month: 1-31: 25
Day of the week is Sunday

Sample Run 2
Enter year: (e.g., 2012): 2012
Enter month: 1-12: 5
Enter the day of the month: 1-31: 12
Day of the week is Saturday

Sample Run 3
Enter year: (e.g., 2012): 2002 
Enter month: 1-12: 3 
Enter the day of the month: 1-31: 26 
Day of the week is Tuesday

Sample Run 4
Enter year: (e.g., 2012): 2008 
Enter month: 1-12:  1
Enter the day of the month: 1-31: 1 
Day of the week is Tuesday 

Sample Run 5
Enter year: (e.g., 2012): 2000 
Enter month: 1-12: 2 
Enter the day of the month: 1-31: 12 
Day of the week is Saturday 
*/
