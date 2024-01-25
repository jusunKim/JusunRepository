package day0926;

public class BooleanTest04 {

	public static void main(String[] args) {
		//20살 이상인가?
		int age;
		age = 17;
		
		boolean flag = age >=20;
		if( flag ) //if조건식에는 boolean이 오도록해야함!!!!
		{
			System.out.print("20살이상입니다.");
		}
		else
		{
			System.out.println("20살미만임");
		}
	}

}
