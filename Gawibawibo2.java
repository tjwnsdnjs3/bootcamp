package javaFund;

import javax.swing.JOptionPane;

class Game {
    private int win = 0;
    private int lose = 0;
    private int draw = 0;
    private int cnt = 0;

    public void start() {
        while (true) {
            int userChoice = user();
            int comChoice = com();
            fight(userChoice, comChoice);

            if (!more()) { 
                showResult();
                break;
            }
        }
    }

    public int user() {
        while (true) {
            String input = JOptionPane.showInputDialog("게임을 시작함 (1:보자기 2:바위 3:가위)");
            if ("1".equals(input) || "보".equals(input)) {
                System.out.println("사용자: 보자기");
                return 1;
            } else if ("2".equals(input) || "바위".equals(input)) {
                System.out.println("사용자: 바위");
                return 2;
            } else if ("3".equals(input) || "가위".equals(input)) {
                System.out.println("사용자: 가위");
                return 3;
            } else {
                System.out.println("제대로 된 값을 입력하세요.");
            }
        }
    }

    public int com() {
        int random = (int)(Math.random() * 3) + 1;
        if(random == 1) {
			System.out.println("컴퓨터: 보자기");
		}
		else if(random == 2) {
			System.out.println("컴퓨터: 바위");
		}
		else {
			System.out.println("컴퓨터: 가위");
		}
        return random;
    }

    public void fight(int go, int random) {
        if (go == random) {
            System.out.println("무승부");
            draw++;
        } else if ((go == 1 && random == 2) || (go == 2 && random == 3) || (go == 3 && random == 1)) {
            System.out.println("승리");
            win++;
        } else {
            System.out.println("패배");
            lose++;
        }
        cnt++;
    }

    public boolean more() {
        String output = JOptionPane.showInputDialog("게임을 계속 하시겠습니까?(y:계속 다른키:종료)");
        return "y".equalsIgnoreCase(output);
    }

    public void showResult() {
        double winRate = (double)win/cnt;
        System.out.printf("총: %d, win: %d, lose: %d, draw: %d, 승률: %.2f", cnt, win, lose, draw, winRate);
    }
}

public class Gawibawibo2 {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}