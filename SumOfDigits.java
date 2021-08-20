package week2.day2;

public class SumOfDigits {

	public static void main(String[] args) {
		
		
String text = "Tes12Le79af65";
		 int sum = 0;
		 for(int i=0;i<text.length();i++)
		 {
			 if(Character.isDigit(text.charAt(i)))
			 {
				 sum = Character.getNumericValue(text.charAt(i)) + sum;
				 			 } 
		 }
		 
		System.out.println("Sum of Digits in the String is "+sum);
		
		
	}
	
}

