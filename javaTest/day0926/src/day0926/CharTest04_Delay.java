package day0926;

public class CharTest04_Delay {

	public static void main(String[] args) throws Exception {
		String data;
		data = "hello world hello java";		
		long start = System.currentTimeMillis();
		for(int z=0 ;z < data.length()  ;z=z+1 )
		{	
			System.out.println(data.charAt(z));
			Thread.sleep(100);
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end-start));
	}

}
