package AllLogical;

import java.util.ArrayList;

public class FindUniqueNoFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//find unique numbers from array.
			int a[] = { 2, 2, 3, 3, 3, 5, 9 };

			ArrayList<Integer> al = new ArrayList<Integer>();
			for (int i = 0; i < a.length; i++) {
				int k = 0;
				if (!al.contains(a[i])) {

					al.add(a[i]);
					k++;
					for (int j = i + 1; j < a.length; j++) {
						if (a[i] == a[j]) {
							k++;

						}
					}
					System.out.println("The value " + a[i] + " Appears " + k + " Times");
					if (k == 1) {
						System.out.println("The unique value is: " + a[i]);
					}
				}
			}

		}
	}
