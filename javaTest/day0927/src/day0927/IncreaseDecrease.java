package day0927;

public class IncreaseDecrease {
	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 5;
		int r1 = ++n1;
		int r2 = n2++;
		System.out.println("n1:"+n1); //6
		System.out.println("n2:"+n2); //6
		System.out.println("r1:"+r1); //6
		System.out.println("r2:"+r2); //5
		
		
		
		System.out.println("----------------------");
		int i = 5;
		int j = 5;
		++i;
		j++;
		System.out.println(i);
		System.out.println(j);
		
		
		System.out.println("----------------------");
		int a = 5;		
		int b = 5;
		System.out.println(++a); //a값에 변동이 있음. a=a+1 출력값은 6
		System.out.println(b+1); //b값에 변동 없어. 출력값은 6으로 동일하지만
		System.out.println(a); //6
		System.out.println(b); //5
		
		System.out.println("--------------------");
		int age;
		age = 26;
		System.out.println(age); //26
		age++; //age = age+1
		System.out.println(age); //27
	}
}
