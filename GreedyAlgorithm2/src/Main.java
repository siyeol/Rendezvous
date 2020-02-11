import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 입력 받는 부분
		
		Scanner scan = new Scanner(System.in);
		
		int N, K;
		
		
		N = scan.nextInt();
		K= scan.nextInt();
		
		int[] array = new int[N];
		
		for (int i=0; i<N; i++) {
			array[i]= scan.nextInt();
			/*
			if (array[i]%array[i-1] != 0) {
				System.out.println("오류입니다.");
			}
			*/
		}
		
		
		
		// 처리하는 부분
		int result=0;
		int mock=0;
		
		while(true) {
			N=N-1;
			mock = K/array[N];
			result+=mock;
			K=K%array[N];
			if (N==0) break;

		}
		
		System.out.println(result);

		
	}

}
