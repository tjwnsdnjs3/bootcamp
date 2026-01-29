package javaFund.langex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ClassExam {
	public static void main(String[] args) throws ClassNotFoundException {
		
		// Class class는 클래스에 필요한 정보를 관리하는 클래스입니다.
		
		Class cls = Class.forName("javaFund.langex.ClassExam");
		
		System.out.println(cls.getName());
		
		Constructor[] cons = cls.getConstructors();
		for(Constructor con : cons) {
			System.out.println(con);
		}
		
		// 메서드 이름을 출력시켜보세요 API를 참조
		Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println("메소드 이름: " + method.getName());
        }

//		Method[] methods = cls.getMethods();
//        for(Method method : methods) {
//            System.out.println("메소드 이름: " + method.getName());
//            System.out.println("메소드 이름: " + method.getParameterCount());
//        }

	}
	
	void a() {
		
	}
}
