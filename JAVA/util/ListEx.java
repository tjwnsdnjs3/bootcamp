package javaFund.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * ArrayList: 컬렉션의 대표적인 클래스, 같은 타입의 객체를 배열처럼 관리하는 자료구조임
 */
public class ListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList(); // Integer 객체만 요소로 관리하겠다는 의미 <제네릭>
		System.out.println(list.size());
		
		list.add(1); // Integer.valueOf(1) 내부적으로 호출
		System.out.println(list);
		
		//list.add("이");
		list.add(3);
		System.out.println(list);
		System.out.println(list.size());
		
		Integer ii = list.get(0);
		
		for(int i = 0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.add(0, 5);
		System.out.println(list);
		
		ArrayList list2 = new ArrayList<Integer>();
		list2.add(300);
		
		//리스트에 리스트 넣기
		list2.addAll(list);
		System.out.println(list2);
		
		System.out.println(list2.contains(3));
		
//		list2.clear();
		System.out.println(list2);
		
		// set()을 이용해서 1번 요소의 값을 2000으로 대체
		list2.set(1, 2000);
		System.out.println(list2);
		
		// Player 3명을 생성
		Player p1 = new Player();
		Player p2 = new Player();
		
		p1.setId("p1");
		p1.setPw("1234");
		p1.setName("페이커");
		p1.setLose((int)(Math.random()*10));
		p1.setWin((int)(Math.random()*10));
		p1.setDraw((int)(Math.random()*10));
			
		p2.setId("p2");
		p2.setPw("3456");
		p2.setName("오너");
		p2.setLose((int)(Math.random()*10));
		p2.setWin((int)(Math.random()*10));
		p2.setDraw((int)(Math.random()*10));
		
		
		List<Player> players = new ArrayList<Player>();
		players.add(p1);
		players.add(p2);
		new UseList().showUsers(players);
		
		List<Integer> li = new ArrayList<Integer>();
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		li.add((int)(Math.random()*10));
		
//		System.out.println(li);
		// Collections 라는 클래스의 메서드를 이용해서 정렬합니다.
//		Collections.sort(li, Collections.reverseOrder()); // Collections.reverseOrder() 내림차순 정렬
//		System.out.println(li);
		
		
		
		
		
		
		
	}

}
