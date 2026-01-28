package javaFund;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Score2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] subjects = {
    		  {"국어", ""},
    		  {"영어", ""},
    		  {"수학", ""}
		};
		int[] scores = new int[subjects.length];


		for (int i = 0; i < subjects.length; i++) {
			while (true) {
				String input = JOptionPane.showInputDialog(
						subjects[i][0] + " 점수를 입력하세요 (0~100):");
				int score = Integer.parseInt(input);
				if (score >= 0 && score <= 100) {
					subjects[i][1] = input; 
					scores[i] = score;     
					break;
				} else {
                  JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
				}
			}
		}
      
		int total = 0;
		for (int s : scores) {
          total += s;
		}
	      double avg = (double) total / scores.length;
	
	      char grade;
	      switch((int)avg/10) {
	          case 10: 
	          case 9:  
	              grade = 'A';
	              break;
	          case 8:  
	              grade = 'B';
	              break;
	          default:
	              grade = 'F';
	      }
	      System.out.printf("총점: %d, 평균: %.2f, 학점: %c\n", total, avg, grade);
	}

}
