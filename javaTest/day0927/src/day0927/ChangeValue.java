package day0927;
//
public class ChangeValue {
	public static void main(String[] args) {
		int cup_kim = 8;
		int cup_park = 5;
		
		System.out.println("지수씨 컵에 담긴 젤리:" +cup_kim);
		System.out.println("세연씨 컵에 담긴 젤리:" +cup_park);
		
		int cup_temp;
		cup_temp = cup_kim;
		cup_kim = cup_park;
		cup_park = cup_temp;
		System.out.println("------------------");
		System.out.println("두 사람 컵의 내용물이 서로 바뀌었따");
		System.out.println("지수씨 컵에 담긴 젤리:" +cup_kim);
		System.out.println("세연씨 컵에 담긴 젤리:" +cup_park);
	}
}
