package javaFund.game;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class User implements Serializable{
	// 회원의 정보(ID, PW, 승/패, 마지막 로그인 시간)
	// 클래스 버전 관리용 ID (역직렬화 에러 방지)
    private static final long serialVersionUID = 1L;
    
	private String id;
	private String password;
	private LocalDateTime lastLoginTime;
	private int winCnt, loseCnt, drawCnt;

	public User(String id, String password) {
		this.id = id;
		this.password = password;
		this.winCnt = 0;
		this.drawCnt = 0;
		this.loseCnt = 0;
		this.lastLoginTime = LocalDateTime.now();
	}

	public double getWinRate() {
		int total = winCnt + loseCnt + drawCnt;
		if (total == 0)
			return 0.0;
		return ((double) winCnt / total) * 100;
	}
	public int getCnt() {
		return winCnt + loseCnt + drawCnt;
	}

	public String getFormattedLoginTime() {
		if (lastLoginTime == null)
			return "기록 없음";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분");
		return lastLoginTime.format(formatter);
	}
}
