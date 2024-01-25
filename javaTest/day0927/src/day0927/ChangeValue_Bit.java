package day0927;
//
public class ChangeValue_Bit {
	public static void main(String[] args) {
		int cup_kim = 8;
		int cup_park = 5;
		
		System.out.println("지수씨 컵에 담긴 젤리:" +cup_kim);
		System.out.println("세연씨 컵에 담긴 젤리:" +cup_park);
		
		//비트차 연산자 이용하면 임시변수 만들지 않고 두개의 변수만으로도 서로 맞바꿀 수 있따
		cup_kim  = cup_kim ^ cup_park;
		cup_park = cup_kim ^ cup_park;
		cup_kim  = cup_kim ^ cup_park;

		System.out.println("------------------");
		System.out.println("두 사람 컵의 내용물이 서로 바뀌었따");
		System.out.println("지수씨 컵에 담긴 젤리:" +cup_kim);
		System.out.println("세연씨 컵에 담긴 젤리:" +cup_park);
	}
}
