package b;

import java.util.Scanner;

public class b2884 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        
        if(b<45)
        {
        	if(a==0)
        		a=24;
        	--a;
        	b+=15;
        	 System.out.println(a+" "+b);
        }
        else
        {
        	b-=45;
        	System.out.println(a+" "+b);
        }
	}

}
