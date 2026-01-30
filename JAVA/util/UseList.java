package javaFund.util;

import java.util.Collections;
import java.util.List;

public class UseList {

	public void showUsers(List<Player> list) {
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		// list 내부에 있는 플레이어의 정보를 출력해보세요
		for (int i = 0; i < list.size(); i++) {
				Player player = list.get(i);
	            System.out.println("ID: " + player.getId());
	            System.out.println("PW: " + player.getPw());
	            System.out.println("Name: " + player.getName());
	            System.out.println("Win: " + player.getWin());
	            System.out.println("Lose: " + player.getLose());
	            System.out.println("Draw: " + player.getDraw());
	            System.out.printf("Rate: %.0f" ,player.getRate());
	            System.out.print("%\n");
        }

	}
}
