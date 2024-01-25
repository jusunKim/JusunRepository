package day0926;

public class BooleanCharTest03 {

	public static void main(String[] args) {
		String data;
		data = "hello java";		
		int z;
		for(z=0 ;z<=9  ;z=z+1 )
		{	
			System.out.println(data.charAt(z));
		}
		System.out.println("반복문을 탈출한 뒤의 z값:" + z);
	}

}
