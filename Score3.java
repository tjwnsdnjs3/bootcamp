package javaFund;

import javax.swing.JOptionPane;

public class Score3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] subjects = { "국어", "영어", "수학" };
		int studentCount = 3;
		int[][] scores = new int[studentCount][subjects.length];

		// 점수 입력
		for (int stu = 0; stu < studentCount; stu++) {
			for (int sub = 0; sub < subjects.length; sub++) {
				while (true) {
					String input = JOptionPane
							.showInputDialog((stu + 1) + "번 학생 " + subjects[sub] + " 점수를 입력하세요 (0~100):");
					int score = Integer.parseInt(input);
					if (score >= 0 && score <= 100) {
						scores[stu][sub] = score;
						break;
					} else {
						JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 다시 입력하세요.");
					}
				}
			}
		}

		for (int stu = 0; stu < studentCount; stu++) {
			int total = 0;
			for (int sub = 0; sub < subjects.length; sub++) {
				total += scores[stu][sub];
			}
			double avg = (double) total / subjects.length;

			char grade;
			switch ((int) avg / 10) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
			}

			System.out.printf("%d번 학생 - 총점: %d, 평균: %.2f, 학점: %c\n", stu + 1, total, avg, grade);
		}
	}

}
