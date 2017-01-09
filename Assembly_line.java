package new1;

public class Assembly_line {
	public static void main(String args[]) {
		//=======================================================================
		// variables dafinitions
		//=======================================================================
		int[] Assembly_1 = { 11, 9, 3, 4, 8, 55 };
		int[] Assembly_2 = { 8, 4, 6, 22, 9, 77 };
		int[] time_1 = { 5, 3, 1, 3, 4 };
		int [] time_2 = { 2, 1, 2, 2, 1 };
		
		int e1 = 2, e2 = 4, x1 = 3, x2 = 3, f, l, k;
		int[] temp_1, temp_2, l1, l2;
		
		temp_1 = new int[6];
		temp_2 = new int[6];
		l1 = new int[6];
		l2 = new int[6];
		temp_1[0] = e1 + Assembly_1[0];
		temp_2[0] = e2 + Assembly_2[0];
		
		//=======================================================================
         
		System.out.println("============  Assembly line ==============");

		System.out.println("\nAssembly times for stations on line 1");
		System.out.print("Station\t\t:");
		for (int i = 0; i < 6; i++)
			System.out.print(" " + (i + 1));
		System.out.print("\nAssembly Time\t:");
		for (int i = 0; i < 6; i++)
			System.out.print(" " + Assembly_1[i]);
		System.out.println("\n==========================================\n");
		System.out.println("\n\nAssembly times for stations on line 2");
		System.out.print("Station\t\t:");
		for (int i = 0; i < 6; i++)
			System.out.print(" " + (i + 1));
		System.out.print("\nAssembly Time\t:");
		for (int i = 0; i < 6; i++)
			System.out.print(" " + Assembly_2[i]); // Assembly_1
		System.out.println();
		System.out.println("==========================================");
		//=======================================================================
        //  comparing times on both assembly lines 
		//=======================================================================
		
		for (int j = 1; j < 6; j++) {
			if ((temp_1[j - 1] + Assembly_1[j]) <= (temp_2[j - 1] + time_2[j - 1] + Assembly_1[j])) {
				temp_1[j] = temp_1[j - 1] + Assembly_1[j];
				l1[j] = 1;
			} else {
				temp_1[j] = temp_2[j - 1] + time_2[j - 1] + Assembly_1[j];
				l1[j] = 2;
			}
			if ((temp_2[j - 1] + Assembly_2[j]) <= (temp_1[j - 1] + time_1[j - 1] + Assembly_2[j])) {
				temp_2[j] = temp_2[j - 1] + Assembly_2[j];
				l2[j] = 2;
			} else {
				temp_2[j] = temp_1[j - 1] + time_1[j - 1] + Assembly_2[j];
				l2[j] = 1;
			}
		}
		

		if (temp_1[5] + x1 < temp_2[5] + x2) {
			f = temp_1[5] + x1;
			l = 1;
		} else {
			f = temp_2[5] + x2;
			l = 2;
		}
		
		//=======================================================================

		System.out.print("temp_1\t:");
		for (int i = 0; i < 6; i++)
			System.out.print(temp_1[i] + " ");
		
		System.out.print("temp_2\t:");
		for (int i = 0; i < 6; i++)
			System.out.print(temp_2[i] + " ");
		System.out.print("l1\t:");
		for (int i = 1; i < 6; i++)
			System.out.print(l1[i] + " ");
		System.out.print("l2\t:");
		for (int i = 1; i < 6; i++)
			System.out.print(l2[i] + " ");

		System.out.println("\nMost Optimal Path will be: \n");
		k = l;
		for (int j = 1; j <=5; j++) {

			if (k == 1) {
				k = l1[j];
				System.out.println("Line " + k + " Station " + (j) + " ");
			} else {
				k = l2[j];
				System.out.println("Line " + k + " Station " + (j) + " ");
			}
		}
		System.out.println("Line " + l + " Station " + 6);

		System.out.println();

	}
}
