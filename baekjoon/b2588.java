package b;
import java.util.Scanner;
public class b2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			int a=sc.nextInt();
			int b=sc.nextInt();
			System.out.println(((b%10))*a);
			System.out.println(((b%100)/10)*a);
			System.out.println(((b%1000)/100)*a);
			System.out.println(b*a);
	}

}
