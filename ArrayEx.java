package javaFund;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArr[] = new int[4]; //4개 길이의 int 타입의 배열 생성
		double[] douArr = {1,2,3}; //초기화 생성식
		String[] strArr = new String[] {"A","B","C"};
		
		//위 구문은 배열 생성식입니다.
		//배열 객체는 만약 초기 값을 주지 않은 상태로 생성하면 각 타입의 기본값으로 자동으로 세팅되어집니다
		//정수는 0, 실수는 0.0, boolean은 false, object는 null
		
		System.out.println(strArr); //해시코드 나옴
		System.out.println(Arrays.toString(strArr));
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		//향상된 for
		for(String str : strArr) {
			System.out.println(str); //str변수가 배열의 리턴되는 값을 자동으로 대입해서 출력시키도록 함
		}
		//배열에 값 대입
		strArr[0] = "hello";
//		intArr[0] = false; //배열 타입에 맞게 넣어야됨 
		douArr[0] = 10; //강제 형변환
		
//		System.out.println(strArr[strArr.length]); //3번째 인덱스라 에러
		//객체는 실행 이후 만들어짐 그래서 컴파일러가 오류를 관리해주지 않음 -> 예외
		
		//다중 배열 배열 내부에 배열을 가지고 있는 형태
		int[] multi[] = new int[2][3];
		multi[0][0] = 10;
		multi[1][multi.length] = 50; //multi.length = 2
		
		for(int i = 0; i < multi.length; i++) {
			for(int j = 0; j < multi[i].length; j++) {
				System.out.println(multi[i][j]);
			}
		}
	}
	

}
