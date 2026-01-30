package javaFund;

import javax.swing.JOptionPane;

public class Gawibawibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String d = "1";
		
//		if(d == input) { // 같은 객체니?
//			System.out.println("same");
//		}
//		if(d.equals(input)) { // 사용자값은 equals
//			System.out.println("same");
//		}
		/*
		 * 사용자는 가위, 바위, 보 대신 1,2,3을 값으로 낼 수 있음
		 * 그럼 프로그램은 이 값을 분석해서 랜덤한 컴퓨터의 값을(Math.random())
		 * 으로 게임을 진행시키고, 결과를 다음처럼 출력시키게
		 * 컴: 가위, 사용자: 보
		 * 컴 승리!
		 * 
		 * 위처럼 결과를 출력 후 게임을 다시 할건지를 물어보게
		 * ex)게임을 계속 하시겠습니까? 이때 사용자는 y or n를 입력하게 되고
		 * 이에 따라서 게임이 계속되거나 종료
		 * 
		 * 단 게임이 끝날 때 총전적, 승, 패, 무 승률(소수점 2자리까지)을
		 * 출력시키고 게임 종료
		 * 
		 */
		String b,m,j;
		int go = 0;
		int win=0, lose=0, draw=0, cnt=0;
		
		while(true) {
			String input = JOptionPane.showInputDialog("게임을 시작함(1:보자기 2:바위 3:가위)");
//			b = "1";
//			m = "2";
//			j = "3";
			try {
				go = Integer.parseInt(input);
				if(go == 1) System.out.println("사용자: 보자기");
			    else if(go == 2) System.out.println("사용자: 바위");
			    else if(go == 3) System.out.println("사용자: 가위");
			    else go = 4;
			} catch (Exception e) {
				// TODO: handle exception
				switch (input) {
				case "보자기":
					go = 1;
					System.out.println("사용자: 보자기");
					break;
				case "바위":
					go = 2;
					System.out.println("사용자: 바위");
					break;
				case "가위":
					go = 3;
					System.out.println("사용자: 가위");
					break;
				default :
					go = 4;
 				}
			}
			if(go == 4) {
				System.out.println("제대로된 값을 입력하세요.");	
				continue;
			}
//			if("1".equals(input) || "보".equals(input)) {
//				go = 1;
//				System.out.println("사용자: 보자기");
//			}
//			else if("2".equals(input) || "바위".equals(input)) {
//				go = 2;
//				System.out.println("사용자: 바위");
//			}
//			else if("3".equals(input) || "가위".equals(input)) {
//				go = 3;
//				System.out.println("사용자: 가위");
//			}
//			else {
//				System.out.println("제대로된 값을 입력하세요.");
//				continue;
//			}
			int random = (int)(Math.random()*3)+1;
			if(random == 1) {
				System.out.println("컴퓨터: 보자기");
			}
			else if(random == 2) {
				System.out.println("컴퓨터: 바위");
			}
			else {
				System.out.println("컴퓨터: 가위");
			}
			
			
			if (go == random) {
			    System.out.println("무");
			    draw++;
			} else if ((go == 1 && random == 2) || (go == 2 && random == 3) || (go == 3 && random == 1)) {   
			    System.out.println("승");
			    win++;
			} else {
			    System.out.println("패");
			    lose++;
			}
			cnt++;
			
			String output = JOptionPane.showInputDialog("게임을 계속 하시겠습니까?(y:계속 다른키:종료)");
			String out = "y";
			if(out.equals(output)) {
				continue;
			}else {
				break;
			}
		}
		double winRate = (double)win/cnt;
		System.out.printf("win: %d, lose: %d, draw: %d, 승률: %.2f", win, lose, draw, winRate);		
	}

}
