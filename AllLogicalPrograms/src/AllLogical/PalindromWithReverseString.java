package AllLogical;

public class PalindromWithReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Palindrom with reverse String.
			String a = "madama";
			String b = "";
			for (int i = a.length() - 1; i >= 0; i--) {
				b = b + a.charAt(i);
			}
			System.out.println(b);
			if (a.equals(b)) {
				System.out.println("String is Palindrom");
			} else {
				System.out.println("string is not palindrom.");
			}
		}
	}
