package day0927;
//학생 이름, 국어, 영어, 수학 입력받아 총점, 펴균 구해 출력하고 합격여부 판별해 출력
//과목별 과락(40점미만) 없고 평균 60점 이상이면 합격
import java.util.Scanner;
public class practice001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int kor, eng, math, total;
		double avg;
		
		System.out.print("이름 입력하세요: ");
		name = sc.next();
		System.out.print("국어 성적 입력하세요: ");
		kor = sc.nextInt();
		System.out.print("영어 성적 입력하세요: ");
		eng = sc.nextInt();
		System.out.print("수학 성적 입력하세요: ");
		math = sc.nextInt();
		
		total = (kor + eng + math);
		avg = total / 3.0;
		String result = "불합격";
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부");
		System.out.print(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t");
		if(kor>=40 && eng>=40 && math>=40 && avg>=60)
		{
			result = "합격";
		}
		System.out.println(result);
		sc.close();
		
				
		
	}

}
