package javaFund;
/*
 * 자바의 데이터 타입: 크게 Ptype(기본자료형), Rtype(객체형)으로 나뉩니다
 * 
 * 기본 자료형은 다시 Data의 성격에 따라서 아래처럼 구분됩니다
 * Ptype
 * 정수형
 * byte(1byte 크기), short(2byte), int(4byte - default), long(8byte)
 * 
 * 실수형
 * float(4byte), double(8byte - default)
 * 
 *  논리형
 *  boolean
 *  
 *  문자형(문자열 아님 문자 하나만 담을 수 있는 타입 애는 내부적으로 정수형을 취함
 *  char(2byte)
 *  
 *  위에 나열된 타입외에는 전부 Rtype 즉 객체형 타입 ex) String 객체
 *  객체는 속성 + 메소드
 */
public class DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 127; //선언 및 초기화
		byte b = 125;
		//Remember 자바의 리터럴 데이터가 연산을 하게 될때는 반드시
		//해당 값의 default 타입의 메모리를 먼저 생성하고 값을 넣은 후
		//연산을 하게 됩니다.
		//이때 연산자의 피연산항의 타입의 크기가 서로 틀릴 경우엔,
		//큰타입으로 변환되어 결과를 냅니다.
		
		//b = b + 1; Typemismatch 1 = int(default)
		i = b + 1;
		
		long l = 1L;
		//int in = l + 1;
		
		//casting 연산자: 우측의 데이터 타입을 지정된 타입으로 강제 형변형
		//연산자 우측 항 하나에만 적용
		int in = (int)(l + 1);
		in = (int)l + 1;
		
		//float: 4byte 실수형
		//float f = 3.14; //3.14 double
		float f = 3.14f;
		
		//l = f;
		l = (long)f;
		f = l;
		
		double d = 3.14;
		d = d + 1; //double
		
		/*
		 * 여러분이 과수원을 한다고 가정
		 * 배, 오렌지, 사과를 하루에 각 5, 7, 4를 생산
		 * 하루를 기준으로 시간당 총 생산량을 출력
		 * 단, 한번의 리터럴데이터와 케스팅 연산자를 사용
		 */
		int p = 5;
		int o = 7;
		int a = 4;
		
		int total = p + o + a;
		
		double perhtotal = (double)total/24;
		System.out.println(perhtotal);
		
		/*
		 * 문자형 데이터 char
		 * ''를 이용해서 문자 하나만을 담을 수 있음
		 */
		char ch1 = 'a';
		char ch2 = '가';
		
		//Unicode 문자셋을 이용합니다 때문에 내부적으로는 정수형 사용됩니다
		ch1 = ++ch1;
		System.out.println(ch1);
		//Unicode는 0~65535까지의 문자 주소를 사용하므로, char는 음수를 표현할 수 없습니다
		//ch2 = -1;
		int chInt = ch1;
		System.out.println(chInt); //98
		System.out.println((char)chInt); //b
		
		//논리형 boolean true or false만 가능
		boolean run = true;
		boolean isStop = false;
		//chInt = run;
		
		//println(): 파라미터로 주어지는 값을 콘솔에 출력하는 메소드
		//모드 데이터 타입(Rtype 포함)을 파라미터로 받을 수 있고 값을 출력한다
		//리터럴과 변수는 +를 이용해서 연결한다
		//\를 이용해서 escape 문자 사용 가능함
		String myName = "서준원";
		System.out.println("안녕하세요: \n\t" + myName);
		
		//printf(포멧출력)
		//특정 포맷대로 출력을 지원하는 콘솔 출력 메소드
		//%b boolean 형식, %d 정수, %o 8진수 정수, %x 16진수
		//%f 소수점, %c 문자형식, %s 문자열 형식
		int age = 25; String addr = "강원도";
		System.out.printf("내 나이는 %d 입니다 %n", age);
		System.out.printf("내 나이는 %d 이고, 주소는 %s 입니다. %n", age, addr);
		
		//자리수 지정 여부에 따른 결과
		System.out.printf("자리수 미지정: %d%n", 1);
		System.out.printf("자리수 미지정: %d%n", 10);
		System.out.printf("자리수 미지정: %d%n", 100);
		System.out.printf("자리수 미지정: %d%n", 1000);
		System.out.printf("자리수 지정: %04d%n", 1);
		System.out.printf("자리수 지정: %4d%n", 10);
		
		System.out.printf("자리수 지정: %4d%n", 1000);
		
		//소수점 표현법: 자리수로 소숫점 자리수 지정
		float ff = 1.23456f;
		System.out.printf("소수점 자리수 지정: %.3f%n", ff);
		
		//연습문제
		int colorPen = 5 * 12;
		int studentCount = 27;
		int divColorPen = colorPen/studentCount;
		System.out.println("학생당 나눠가지는 색연필수 :"+divColorPen);
		
		int remainColorPen = colorPen%studentCount;
		System.out.println("똑같이 나눠가지고 남은 볼펜수 : "+remainColorPen);
		//
		int agee = 11, height = 150;
		boolean parent = true, heart = false;
//		(agee >= 6 || (height >=120 && parent == true) && heart = false
		//
		int year = 2020;
		boolean leapYear = (year%4 == 0 && year%100 != 0) || (year%400 == 0);
		System.out.println(leapYear);
		//
		int price = 187000;
		int oman = price/50000;
//		int ilman = (price - oman*50000)/10000;	
//		int ochun = (price - (oman*50000 + ilman*10000))/5000;
//		int ilchun = (price - (oman*50000 + ilman*10000 + ochun*5000))/1000;
		int ilman = (price%50000)/10000;
		int ochun = (price%10000)/5000;
		int ilchun = (price%5000)/1000;
		//
		int number = 1234;
		int result = (number / 100) * 100;
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
	}

}
