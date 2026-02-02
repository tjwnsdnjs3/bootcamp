package javaFund.util;


@FunctionalInterface
interface Calcuable2 {
	double calc(double x, double y);
}

class Person2 {
	public void doSome(Calcuable2 calcuable2) {
		double res = calcuable2.calc(10,4);
		System.out.println("결과: " + res);
	}
}
class Computer{
	public static double staticMethod(double x, double y) {
		return x + y;
	}
	public double instanceMethod(double x, double y) {
		return x * y;
	}
}

public class LambdaExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 메소드를 참조하는 람다식을 알아봅니다
		 * 정적 메소드와 인스턴스 메소드를 참조하는 방식이 있는데 
		 * 문법은 다음과 같다
		 * 클래스 :: 메소드 
		 * 인스턴스 변수 :: 메소드
		 */
		
//		Math.max(1, 0);
//		(left, right)->Math.max(left,right);
//		
//		Math :: max;
		
		Person2 p = new Person2();
//		p.doSome((x,y)->Computer.staticMethod(x, y));
		p.doSome(Computer :: staticMethod);
		
		
		Computer computer = new Computer();
		p.doSome(computer :: instanceMethod);
	}

}
