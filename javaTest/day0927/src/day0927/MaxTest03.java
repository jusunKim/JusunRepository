package day0927;

import java.util.Scanner;

//사용자한테 a,b 2개의 정수 입력받아 a가 큰지 b가 큰지, 서로 같은지 판별하는 프로그램
public class MaxTest03 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a, b;
		System.out.print("a를 입력하세요 ==>");
		a = sc.nextInt();		
		System.out.print("b를 입력하세요 ==>");
		b = sc.nextInt();
		
		if(a>b) {
			System.out.println("a is bigger");
		}
		if(a<b) {
			System.out.println("b is bigger");
		}
		if(a==b) {
			System.out.println("they are the same");
		} //이렇게 해도 값은 잘 나오는데 불필요하게 시간이 더 많이 들어 
			
		
//		
//		if(a>b) {
//			System.out.println("a가 더 커요");
//		}else if(a<b) {
//			System.out.println("b가 더 커요");
//		}else {
//			System.out.println("서로 같아요");
//		}
		
		
		sc.close();
		}
	}


