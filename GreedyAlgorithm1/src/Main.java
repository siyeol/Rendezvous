import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int i, j;
		
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		
		int[] input = new int[size];
		
		for (int m=0; m<size; m++) {
			input[m]=scan.nextInt();
		}
		
		
		
		int temp=0;
		
		for (i = 0; i < size -1; i++) {

			for (j = 0; j < size -1 - i; j++) {

				if (input[j]>input[j+1]) {
					temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
				
			}

		}
		
		int result=0, total = 0;
		for (int k=0; k<size ; k++) {
			result += input[k];
			total = total + result;
		}
		System.out.println(total);
	}

}
