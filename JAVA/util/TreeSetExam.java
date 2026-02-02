package javaFund.util;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
 * 정렬과 검색 기능을 특화한 API TreeSet, TreeMap
 */
public class TreeSetExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> scores = new TreeSet<Integer>();
		
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		scores.add((int)(Math.random() * 100 + 1));
		
		for(Integer i : scores) {
			System.out.println(i + " : ");
		}
		System.out.println();
		
		// 메서드를 이용해서 가장 낮은 점수부터 상대 점수까지 get 해보기
		System.out.println(scores.first());
		System.out.println(scores.last());
		System.out.println("95점 아래 점수 : " + scores.lower(95));
		System.out.println("95점 위 점수 : " + scores.higher(95));
		System.out.println("95점 이거나 아래 점수 : " + scores.floor(95));
		System.out.println("95점 이거나 위 점수 : " + scores.ceiling(95));
		
		
		System.out.println(scores.descendingSet());
		scores.descendingSet();
		NavigableSet<Integer> navigableSet =  scores.descendingSet();
		
		for(Integer i : navigableSet) { // 내림차순
			System.out.println(i);
		}
		
		// tailset() : 80 <= 범위의 값 검색
		NavigableSet<Integer> rangeSet = scores.tailSet(80, true);
		for(Integer i : rangeSet) { // 
			System.out.println(i);
		}	
		
		// 범위검증 2.. subSet(범위1,포함여부2,범위2,포함여부)
		// 범위1 <= 값 < 범위2
		System.out.println("--------------------------");
		NavigableSet<Integer> rangeSet2 = scores.subSet(70, true, 90, true);
		for(Integer i : rangeSet2) {
			System.out.println(i);
		}
		
	}

}
