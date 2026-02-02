package javaFund.util;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		// stack 에 요소가 있는 지를 검증하도록 하는 메서드 활용
		while (!stack.isEmpty()) {
			// stack 이 공백이 아니라면
			// 데이터를 순차적으로 추출한다
			int data = stack.pop(); // peek 5~~
			System.out.println("Stack: "+data);
		}
		
		// Queue: 선입선출 맨처음 들어간 데이터가 먼저 빠져나오는 구조
		// 다형성을 이용해서 Queue 객체를 생성합니다.
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		
		while(!q.isEmpty()) { // 큐에 데이터가 존재한다면
			System.out.println("Queue: "+q.poll());
		}
	}

}
