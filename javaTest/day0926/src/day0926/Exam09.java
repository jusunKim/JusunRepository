package day0926;

import java.util.Scanner;

public class Exam09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input, place1000,place100,place10,place1;
		System.out.print("정수를 입력하시오: ");
		input = sc.nextInt();    //5623
		place1000 = input / 1000;//5
		input = input % 1000;    //623
		place100 = input / 100;  //6
		input = input % 100;     //23
		place10 = input / 10;    //2
		place1 = input % 10;     //3
		
		System.out.println("천의자리: "+place1000);
		System.out.println("백의자리: "+place100);
		System.out.println("십의자리: "+place10);
		System.out.println("일의자리: "+place1);

	}

}
