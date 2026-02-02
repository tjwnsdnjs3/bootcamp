package javaFund.util;
/*
 * HashSet 에 Student 를 저장하려 함 학번이 같으면 동일한 Student 객체라고 인식해서
 * 중복 저장이 안되도록 하여야 함 
 * Student 의 학번이 hash 코드라고 생각하고 Student 클래스를 정의합니다
 */

import java.util.HashSet;
import java.util.Set;

class Student {
	public int studentNum;
	public String name;
	
	public Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	// 여기에 코드 완성하시오
	@Override
	public int hashCode() {
		return studentNum;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student target) {
			return target.studentNum == studentNum;
		}
		else return false; 
	}
}
public class HashSetQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set = new HashSet<Student>();
		
		set.add(new Student(1, "제니"));
		set.add(new Student(2, "로제"));
		set.add(new Student(1, "리사"));
		
		System.out.println("저장된 학색 수: " + set.size());
	}

}
