package javaFund.inheri;

public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal animal = new Animal("동물");
//		System.out.println("이것은 " + animal.type);
		
//		Dog dog = new Dog("몽실이", "말티즈");
//		System.out.println(dog);
//		Cat cat = new Cat("나비", "길고양이");
//		System.out.println(cat);
//		Duck duck = new Duck("꽥꽥", "오리");
//		System.out.println(duck);
		
		// 다형성: 상속관계에서 instance 를 발생시, super 타입으로 하위 instance 를 생성하는 형태를 말함
		// 이렇게 하면 타입은 super 로 해당 instance의 외형은 자식으로, 내부에는 부모 인스턴스가 생성이 되어짐
		// 호출되는 메서드나 필드는 강의했던데로, 제일 먼저 걸리는 애들이 호출됨
		Animal dog = new Dog("몽실이", "말티즈");
		System.out.println(dog);
		Animal cat = new Cat("나비", "길고양이");
		System.out.println(cat);
		Animal duck = new Duck("꽥꽥", "오리");
		System.out.println(duck);
		
//		System.out.println(dog.sound());
		dog.sound();
		cat.sound();
		duck.sound();
		
//		System.out.println(dog); // dog.toString()
		
		Animal[] animals = {dog, cat, duck};
		for(Animal animal : animals) {
			System.out.println(animal);
			animal.sound();
		}
		
		// casting duck은 현재 Animal 그래서 layEggs()가 없음
		((Duck)duck).layEggs();
		
		for(int i = 0; i < animals.length; i++) {
			Animal ani = animals[(int)(Math.random() * animals.length)];
			System.out.println(ani);
			ani.sound();
			if(ani instanceof Duck) { // 아래 이유로 if instanceof 사용
				((Duck)ani).layEggs(); //ClassCastException 개체는 실행시 만들어져 컴파일러는 알 수 없음
				((Fly)ani).fly(); // interface 활용 Fly = super 타입
			}
		}
		Fly fly = new Duck("","");
		
		Object eagle1 = new Eagle("독수리");
		Animal eagle2 = new Eagle("독수리");
		Eagle eagle3 = new Eagle("독수리");
		Fly eagle4 = new Eagle("독수리");
		BirdVelocity eagle5 = new Eagle("독수리");
		
		/*
		 * final: 고정의 의미를 담고 있음
		 * 클래스 앞에 선언되면 상속금지, 
		 * 메서드 앞에 선언되면 오버라이드 금지, 
		 * 변수 앞에 선언되면 값 변경금지,
		 * static final 로 선언되면 상수로 표현되는 의미로 사용됨
		 * InheritanceExam.java
		 */
		
		// 익명 구현 객체: 이름이 없는 객체를 말함
		// 일반적으로 사용하는 이유는 특정 추상 or 인터페이스의 하위 객체를 한번만 만들어서 사용하고 버릴 때
		// 이름 그대로 이름이 없는 객체로 모든 추상 메서드를 오버라이드를 필요에 따라서 오버라이드 하면서 사용함
		
		BirdInter bi = new BirdInter() {
			
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
