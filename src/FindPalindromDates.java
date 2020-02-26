
public class FindPalindromDates {

	static final int MAX_VALID_YR = 9999; 
	static final int MIN_VALID_YR = 1800; 
	  
	// Returns true if 
	// given year is valid 
	static boolean isLeap(int year) 
	{ 
	    // Return true if year 
	    // is a multiple pf 4 and 
	    // not multiple of 100. 
	    // OR year is multiple of 400. 
	    return (((year % 4 == 0) 
	            && (year % 100 != 0)) 
	            || (year % 400 == 0)); 
	} 
	  
	// Returns true if given 
	// year is valid or not. 
	static boolean isValidDate(int d, int m, int y) 
	{ 
	    // If year, month and day 
	    // are not in given range 
	    if (y > MAX_VALID_YR || y < MIN_VALID_YR) 
	        return false; 
	    if (m < 1 || m > 12) 
	        return false; 
	    if (d < 1 || d > 31) 
	        return false; 
	  
	    // Handle February month 
	    // with leap year 
	    if (m == 2)  
	    { 
	        if (isLeap(y)) 
	            return (d <= 29); 
	        else
	            return (d <= 28); 
	    } 
	  
	    // Months of April, June, 
	    // Sept and Nov must have 
	    // number of days less than 
	    // or equal to 30. 
	    if (m == 4 || m == 6 || m == 9 || m == 11) 
	        return (d <= 30); 
	  
	    return true; 
	} 
	  
	// Function to print the palindrome 
	// dates between the given years 
	static void printPalindromeDates(int y1, int y2) 
	{ 
	  
	    // For every year 
	    for (int year = y1; year <= y2; year++) 
	    { 
	  
	        // Current year as a String 
	        String str = String.valueOf(year); 
	  
	        // To store the reverse of year 
	        String rev = str; 
	        rev = reverse(rev); 
	  
	        // Get the day and the month 
	        int day = Integer.parseInt(rev.substring(0, 2)); 
	        int month = Integer.parseInt(rev.substring(2, 2 + 2)); 
	  
	        // If the current palindrome date is valid 
	        if (isValidDate(day, month, year)) 
	        { 
	            System.out.print(rev + str +"\n"); 
	        } 
	    } 
	} 
	static String reverse(String input)  
	{ 
	        char[] a = input.toCharArray(); 
	        int l, r = a.length - 1; 
	        for (l = 0; l < r; l++, r--)  
	        { 
	            char temp = a[l]; 
	            a[l] = a[r]; 
	            a[r] = temp; 
	        } 
	        return String.valueOf(a); 
	    } 
	      
	// Driver code 
	public static void main(String[] args) 
	{ 
	    int y1 = 1900, y2 = 2100; 
	  
	    printPalindromeDates(y1, y2); 
	  
	} 
	} 
