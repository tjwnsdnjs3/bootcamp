package javaFund;

import javax.swing.JOptionPane;

public class Score {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Score.java 파일을 생성 아래와 같은 결과를 도출하는 로직을 작성
		 * 학생의 성적을 국영수로 입력받아서 총점, 평균, 학점(ABCF)를 출력하는 프로그램
		 * 프로그램이 시작되면 각 과목을 입력 받도록 하는데 입력된 점수는 반드시 0 ~ 100점 사이
		 * 만약 이 범위를 벗어나면 해당 과목 다시 입력 받도록 다른 과목으로 넘어가면 X
		 * 
		 * 올바른 값이 모두 입력되면 위 결과를 출력
		 * 모든 점수는 배열로 관리 총점도
		 * 학점은 90점 이상은 A 80 이상 B 나머진 F switch case로 작성
		 * 
		 */
		//---------------------------------------------------------------------------------
		//첫번째 방법
		String skor="", seng="", smat="";
		int ikor=0, ieng=0, imat=0;
		while(true) {
			skor = JOptionPane.showInputDialog("국어점수를 입력하세요(0~100):");
			ikor = Integer.parseInt(skor);
			if(ikor < 0 || ikor > 100) {
		JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}else {
				break;
			}
		}
		while(true) {
			seng = JOptionPane.showInputDialog("영어점수를 입력하세요(0~100):");
			ieng = Integer.parseInt(seng);
			if(ieng < 0 || ieng > 100) {
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}else {
				break;
			}
		}
		while(true) {
			smat = JOptionPane.showInputDialog("수학점수를 입력하세요(0~100):");
			imat = Integer.parseInt(smat);
			if(imat < 0 || imat > 100) {
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}else {
				break;
			}
		}
		int subject[] = new int[3];
		subject[0] = ikor;
		subject[1] = ieng;
		subject[2] = imat;
		
        int total = 0;
        for(int i=0; i<subject.length; i++) {
            total += subject[i];
        }
        double avg = (double)total / subject.length;
		//---------------------------------------------------------------------------------
		//두번째 방법
//        String[] subjects = {"국어", "영어", "수학"};
//        int[] scores = new int[subjects.length];
//
//
//        for (int i = 0; i < subjects.length; i++) {
//            while (true) {
//                String input = JOptionPane.showInputDialog(
//                    subjects[i] + " 점수를 입력하세요 (0~100):"
//                );
//                int score = Integer.parseInt(input);
//                if (score >= 0 && score <= 100) {
//                    scores[i] = score;
//                    break;
//                } else {
//                    JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
//                }
//            }
//        }
//        int total = 0;
//        for (int s : scores) {
//            total += s;
//        }
//        double avg = (double) total / scores.length;
        //---------------------------------------------------------------------------------
        char grade;
        switch((int)avg/10) {
            case 10: 
            case 9:  
                grade = 'A';
                break;
            case 8:  
                grade = 'B';
                break;
            default: // 나머지
                grade = 'F';
        }
        System.out.printf("총점: %d, 평균: %.2f, 학점: %c\n", total, avg, grade);
		
	}
}
