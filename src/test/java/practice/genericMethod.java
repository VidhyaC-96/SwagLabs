package practice;

public class genericMethod {
public static void main(String[] args) {
	add(10,20);
	int sum=add(20,30);
	System.out.println(sum+"@"+add(10,20));
}
public static int add(int a,int b) {
	int c=a+b;
	
	return c;
}
		
	}

