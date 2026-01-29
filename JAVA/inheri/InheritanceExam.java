package javaFund.inheri;
/*
 * 자바의 클래스 간의 상속: 클래스 간에는 상속을 통햇 기능과 속성을 자식 클래스가 사용할 수 있도록 할 수 있다.
 * 클래스 간의 상속은 extends 라는 키워드를 통해 ex) A extends B 형식에서, B는 A 클래스를 상속한다라고
 * 선언하는 것이다
 * 
 * 위처럼 상속을 하게 되면, A 클래스의 필드, 메서드는 B 클래스에서도 사용할 수 있도록 상속되어진다
 * 
 * 상속은 클래스 간의 선언을 통해 이뤄지지만, 실제 사용시에 객체간의 상속을 통해 이루어진다.
 * 
 * 클래스 간의 상속은 단일 상속만 가능하다 즉, B 클래스는 오직 하나의 부모 클래스만 상속 할 수 있고,
 * 다른 클래스를 동시에 상속할 수 없다 ex) class A, C가 있고, B 클래스는 class A extends B, C를 할 수 없다는 뜻
 * 
 * 만약 B가 A, C 모두 상속하고 싶으면, 일렬로 순차적으로 상속 받아야 한다
 * 
 * 이렇게 상속을 할 경우, 부모는 위에서 처럼, 필드와 메서드를 상속해주는 데, 단 생성자는 상속을 하지 않는다
 * 
 * 때문에 자식은 부모의 생성자 중 하나를 반드시 호출해서 객체를 발생시켜야만 한다.
 */

/*final*/ class A extends Object {
	public A(int a) {
		this.a = a;
	}
	public int a;
	
	public final void a() {
		System.out.println("A 클래스의 a 메서드 호출됨");
	}
}
class B extends A{
	public B(int b) {
		super(10);
	}
	public int b;
	
	// 공유도이어야 할 값을 사용할 때는 static 과 함께 사용한다
	public static final double PI = 3.14;
	
	public void b(final int a) {
		// a = 10; final 값 변경 금지
		System.out.println("B 클래스의 b 메서드 호출됨");
	}
//	@Override //final 때문에
//	public void a() {
//		
//	}
}
public class InheritanceExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		A a = new A();
//		a.a();
		B b = new B(20);
	}

}
