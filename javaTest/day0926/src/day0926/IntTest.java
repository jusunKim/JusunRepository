package day0926;

import java.util.Date;

public class IntTest {

	public static void main(String[] args) {
		byte data;
		data = 127;
		System.out.println(data);
		//data = 5000;
		
		data = (byte)(data + 1); //overflow 발생
		System.out.println(data); //-128
		
		byte data2 = -128; //byte이 표현할 수 있는 최소값
		data2 = (byte)(data2 -1); //underflow 발생
		System.out.println(data2);
		
		short data3 = 100;
		long data4 = 100;
		System.out.println(data3);
		System.out.println(data4);
		
		//1970년부터 현재까지의 시간을 밀리세컨드로 알려주는 기능 System.currentTimeMills()
		//얘는 Long으로 반환됨
		//int now = System.currentTimeMillis();
		long now = System.currentTimeMillis();
		System.out.println(now);
		
		Date today = new Date();
		Date today02 = new Date(now);
		
		System.out.println(today.getYear() +1900);
		System.out.println(today02.getYear() +1900);
	}

}
