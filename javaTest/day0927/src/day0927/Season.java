package day0927;

import java.util.Scanner;

//월을 입력받아 계절명을 출력하자
public class Season {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String season;
		
		System.out.print("월을 입력해보세요(1-12): ");
		n = sc.nextInt();
		
		if(n>=3 && n<=5) {
			season = "봄";
		}
		else if(n>=6 && n<=8) {
			season = "여름"; }
		else if(n>=9 && n<=11) {
			season = "가을"; }
		else { 
			season = "겨울";
			}
		System.out.println("계절은 "+season);
		}
	}


