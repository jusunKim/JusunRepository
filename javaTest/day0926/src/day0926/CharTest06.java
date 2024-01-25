package day0926;

import java.util.Scanner;

//사용자에게 문자열 입력받아 그 문자열 데이터 중 소문자 o의 수 파악
//sc.next(); 공백 문자 입력x
//sc.nextLine(); 공백 문자 입력 ㅇ
public class CharTest06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.print("문자를 입력하시오: ");
		data = sc.nextLine();
		
		int count = 0;
		for(int z=0 ;z < data.length()  ;z=z+1 )
		{	
			char ch = data.charAt(z);
			if(ch == 'o') //ch가 소문자 o와 같은가요?
			{
				count = count + 1;
			}
		}
		System.out.printf("문자열 데이터 중 o의 개수는 %d개입니다.",count);
	}

}
