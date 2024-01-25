package day0926;

import java.util.Scanner;
//문장 입력받아 단어 수 출력
public class Practice02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data, data2;
		System.out.print("문장을 입력하세요:");
		data = sc.nextLine();
		data2 = sc.next();
		
		System.out.println("단어 수:" +data.length()-data2.length());
				
	}

}
