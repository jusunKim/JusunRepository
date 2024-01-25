package day0926;

public class CharTest05 {

	public static void main(String[] args) {
		String data;
		data = "hello world hello java";		
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
