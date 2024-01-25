package day0927;

import java.util.Scanner;

//학생 이름, 국영수 입력받아서 총점, 평균 계산해 출력
//합격 여부 출력(기준: 평균 60이상)
public class StudentTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name, result="불합격";
		int kor, eng, math, total;
		double avg;
		
		System.out.print("이름을 입력하세요: ");
		name = sc.next();
		System.out.print("국어 점수를 입력하세요: ");
		kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요: ");
		eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요: ");
		math = sc.nextInt();
		
		total = (kor+eng+math);
		avg = total/3.0;
		
		System.out.println("*** 성적 처리 결과***");
		System.out.println("-------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t결과");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+avg+"\t"+result);
		if(avg>=60)
		{
			result = "합격";
		}
		System.out.println( result+"입니다");
		sc.close();
	}

}
