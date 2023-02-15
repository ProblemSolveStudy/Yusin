package b;

import java.util.Scanner;

public class b2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        
        b+=c;
        if(b>=60)
        {
        	b-=60;
        	System.out.println((a+((b/60)+1))%24 + " "+ b%60);
        }
        else
        System.out.println(a +" "+ b);
	}

}
