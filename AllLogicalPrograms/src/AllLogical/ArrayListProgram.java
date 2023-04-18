
package AllLogical;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		arraylistMethod();

	}

	public static void arraylistMethod() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Selenium");
		list.add("JUnit");
		list.add("TestNG");
		list.add("Cucumber");
		list.add("Appium");
		
		System.out.println("Elements of ArrayList: " + list);
	}

}
