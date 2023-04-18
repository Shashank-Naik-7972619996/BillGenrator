package AllLogical;

public class OccuranceOfCharInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// occurances of char in string
			String a = "shashanka";
			char b = 'a';
			int count = 0;
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == b) {
					count++;
				}
			}
			System.out.println("count 'a' occurances: " + count);
		}
	}
