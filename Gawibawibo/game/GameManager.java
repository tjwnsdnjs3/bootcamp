package javaFund.game;

import javax.swing.JOptionPane;

public class GameManager {
    public void start(User user) {
        int win = 0, lose = 0, draw = 0, cnt = 0;

        while (true) {
            String input = JOptionPane.showInputDialog("1:보자기 2:바위 3:가위 (또는 직접 입력)");
            if (input == null) break;

            // 1. 사용자 입력 처리 
            int userChoice;
            try {
                userChoice = Integer.parseInt(input);
                if (userChoice < 1 || userChoice > 3) userChoice = 4;
            } catch (Exception e) {
                userChoice = switch (input) {
                    case "보자기" -> 1;
                    case "바위" -> 2;
                    case "가위" -> 3;
                    default -> 4;
                };
            }

            if (userChoice == 4) {
                JOptionPane.showMessageDialog(null, "제대로 된 값을 입력하세요.");
                continue;
            }

            // 2. 컴퓨터 랜덤 선택
            int comChoice = (int) (Math.random() * 3) + 1;

            // 3. 입력 출력
            String uName = switch (userChoice) { case 1 -> "보자기"; case 2 -> "바위"; default -> "가위"; };
            String cName = switch (comChoice) { case 1 -> "보자기"; case 2 -> "바위"; default -> "가위"; };
            
            System.out.println("사용자: " + uName);
            System.out.println("컴퓨터: " + cName);

            // 4. 승패무 판정
            if (userChoice == comChoice) {
                System.out.println("무승부");
                draw++;
                user.setDrawCnt(user.getDrawCnt() + 1);
            } else if ((userChoice == 1 && comChoice == 2) || (userChoice == 2 && comChoice == 3)
                    || (userChoice == 3 && comChoice == 1)) {
                System.out.println("승리");
                win++;
                user.setWinCnt(user.getWinCnt() + 1);
            } else {
                System.out.println("패배");
                lose++;
                user.setLoseCnt(user.getLoseCnt() + 1);
            }
            cnt++;

            String output = JOptionPane.showInputDialog("게임을 계속 하시겠습니까?(y:계속 / 그외:종료)");
            if (!"y".equalsIgnoreCase(output)) break;
        }

        // 결과 출력
        double winRate = (cnt == 0) ? 0 : (double) win / cnt * 100;
        System.out.printf("\n[이번 게임 결과] 승: %d, 패: %d, 무: %d, 승률: %.2f%%\n", win, lose, draw, winRate);
        System.out.println("[누적 전적] " + user.getWinCnt() + "승 " + user.getLoseCnt() + "패 " + user.getDrawCnt() + "무");
    }
}