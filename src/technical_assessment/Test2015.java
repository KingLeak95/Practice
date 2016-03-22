package technical_assessment;


import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2015 {

	public static void main(String[] args) {
		System.out.println("Just making sure you still work " 
				+ Palindrome("race car"));
		
		IP_Address_Validation();
		
		substring_calculator("kincenvizh");
		
		/*String correct = "([0-9a-f]){1,4}";
		String testing = "([0-9a-f]){1,4}";
		
		System.out.println(correct.equals(testing));*/
	}
	
	private static boolean Palindrome(String phrase) {
		String sentence = phrase.replaceAll("[^A-Za-z0-9]+", "");
		String reverse = reverse(sentence);
		
		return sentence.equalsIgnoreCase(reverse);
	}
	
	private static String reverse(String phrase) {
		int length = phrase.length();
		String reverse = "";
		
		for (int i = length - 1; i != -1; i--) {
			reverse += phrase.charAt(i);
		}
		
		return reverse;
	}
	
	private static void IP_Address_Validation () {
		 String ipv4Pattern = "(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?"
		 		+ "\\d\\d?|2[0-4]\\d|25[0-5])";
		 String ipv6Pattern = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
		 
		 Pattern VALID_IPV4_PATTERN = 
				 Pattern.compile(ipv4Pattern, Pattern.CASE_INSENSITIVE);
		 Pattern VALID_IPV6_PATTERN = 
				 Pattern.compile(ipv6Pattern, Pattern.CASE_INSENSITIVE);
		  
		Scanner sc = new Scanner(System.in);
		
		int total = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < total;i++) {
		
			String curr = sc.nextLine();
			
			Matcher m1 = VALID_IPV4_PATTERN.matcher(curr);
			boolean ipv4 = m1.matches();
			
			Matcher m2 = VALID_IPV6_PATTERN.matcher(curr);
			boolean ipv6 = m2.matches();
			
			if(ipv4)
				System.out.println("IPv4");
			else if(ipv6)
				System.out.println("IPv6");
			else
				System.out.println("Neither");
		
		}
		
		sc.close();
	}
	
	private static void substring_calculator(String string) {
		    int length = string.length();
		    String[] arrayString = new String[length];
		    for (int i = 0; i < length; ++i) {
		      arrayString[i] = string.substring(length - 1 - i, length);
		    }

		    Arrays.sort(arrayString);
		    
		    long num_substring = arrayString[0].length();

		    for (int i = 0; i < length - 1; ++i) {
		      int j = 0;
		      for (; j < arrayString[i].length(); ++j) {
		        if (!((arrayString[i].substring(0, j + 1)).equals((arrayString)[i + 1]
		            .substring(0, j + 1)))) {
		          break;
		        }
		      }
		      num_substring += arrayString[i + 1].length() - j;
		    }
		    
		    System.out.println(num_substring);
	}
	
}


