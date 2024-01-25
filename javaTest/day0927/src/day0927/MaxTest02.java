package day0927;

import java.util.Scanner;

//사용자한테 a,b 2개의 정수 입력받아 a가 큰지 b가 큰지, 서로 같은지 판별하는 프로그램
public class MaxTest02 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a, b;
		System.out.print("a를 입력하세요 ==>");
		a = sc.nextInt();		
		System.out.print("b를 입력하세요 ==>");
		b = sc.nextInt();
		
		String result = "";

	
		if(a>b) {
			result = "a is bigger";
		}else if(a<b) {
			result = "b is bigger";
		}else {
			result = "are the same";
		}
		System.out.println(result);
		
		sc.close();
		}
	}


