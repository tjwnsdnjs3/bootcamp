package javaFund.game;

//가위바위보 확장 게임입니다
//아래의 조건에 맞게 게임을 작성합니다.
//
//1. 클래스는 목적에 따라서 최소 5개 이상이 나오도록 설계하세요
//2. 게임 시작하면 로그인 하라고 합니다.
//3. 로그인은 ID 와 암호를 입력받아서 체크합니다.
//3. 로그인을 하면, 해당 ID 를 가진 사람의 마지막 로긴 시간이
//yyyy년 MM월 dd일 오전 몇시몇분 이었다라고 보여줍니다.
//
//위 내용 후 아래와 같은 선택사항을 둡니다.
//1.로그아웃
//2.게임시작
//3.내전적보기
//4.전체랭킹보기(승률별 오름/내림차순으로)
//5.비번 변경하기
//
//
//각 옵션에 맞게 다음 메뉴를 보여주고 다음으로 진행 시킵니다.
//
//게임 진행 방식은 기존과 같으며, 모든 게임은 로그 아웃시에 저장되어집니다.
//
//만약 처음 하는 사용자라면, 회원 가입 메뉴를 보여주고 회원가입을 시킵니다.
//
//ID 는 이메일 형식이어야 하고, 비번은 반드시 8~12 사이의 영대문자,숫자,특문
//하나가 포함 되어야 합니다.
//
//위 조건에 맞게 되어진 회원은 가입인사 시키고 위의 메뉴대로 갑니다,.
//
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

public class GameMain {
	public static void main(String[] args) {
		UserManager userMgr = new UserManager();
		GameManager gameMgr = new GameManager();
		User currentUser = null; // 현재 로그인한 사용자 정보 저장용
		System.out.println("프로그램을 시작합니다.");

		while (true) {
			// 1. 로그인 전 상태
			if (currentUser == null) {
				String menu = JOptionPane.showInputDialog("1.로그인 2.회원가입 0.종료");

				if (menu == null || "0".equals(menu))
					break;

				if ("1".equals(menu)) {
					// 로그인
					String id = JOptionPane.showInputDialog("ID(Email):");
					String pw = JOptionPane.showInputDialog("Password:");
					currentUser = userMgr.login(id, pw);

					if (currentUser != null) {
						JOptionPane.showMessageDialog(null, "로그인 성공\n마지막 접속: " + currentUser.getFormattedLoginTime());
						currentUser.setLastLoginTime(LocalDateTime.now()); // 접속 시간 업데이트
					} else {
						JOptionPane.showMessageDialog(null, "로그인 실패 아이디나 비번을 확인하세요.");
					}

				} else if ("2".equals(menu)) {
					// 회원가입
					String newId = JOptionPane.showInputDialog("가입할 ID(Email):");
					if (newId == null)
						continue;

					if (!ValidationUtil.isValidEmail(newId)) {
						JOptionPane.showMessageDialog(null, "이메일 형식에 맞게 입력해주세요.");
						continue;
					} else if (userMgr.isIdExists(newId)) {
						JOptionPane.showMessageDialog(null, "이미 존재하는 ID입니다.");
						continue;
					}

					String newPw = JOptionPane.showInputDialog("가입할 PW(8~12자, 대문자/숫자/특문 포함):");
					if (newPw == null)
						continue;

					if (!ValidationUtil.isValidPassword(newPw)) {
						JOptionPane.showMessageDialog(null, "비밀번호 규칙이 맞지 않습니다.");
						continue;
					}

					userMgr.addUser(new User(newId, newPw)); // 가입 인사와 함께 유저 추가
					JOptionPane.showMessageDialog(null, "회원가입을 환영합니다! 로그인 해주세요.");
				}

				// 2. 로그인 된 상태
			} else {
				String select = JOptionPane.showInputDialog("1.로그아웃 2.게임시작 3.전적보기 4.랭킹보기 5.비번변경");

				if (select == null)
					continue;

				switch (select) {
				case "1" -> {
					userMgr.save(); // 로그아웃 시 파일 저장 
					currentUser = null;
					JOptionPane.showMessageDialog(null, "안전하게 로그아웃 되었습니다.");
				}

				case "2" -> gameMgr.start(currentUser); // 게임 시작

				case "3" -> {
					// 전적 보기
					String msg = String.format("[%s님의 전적]\n총 %d판 | %d승 | %d무 | %d패\n현재 승률: %.2f%%",
							currentUser.getId(), 
							currentUser.getCnt(), 
							currentUser.getWinCnt(), 
							currentUser.getDrawCnt(), 
							currentUser.getLoseCnt(),
							currentUser.getWinRate()
					);
					JOptionPane.showMessageDialog(null, msg);
				}

				case "4" -> {
					// 랭킹 보기
					String opt = JOptionPane.showInputDialog("1. 승률 높은순 2. 승률 낮은순");
					if (opt == null)
						break;

					boolean lowToHigh = "2".equals(opt);
					List<User> ranking = userMgr.getRanking(lowToHigh);

					if (ranking.isEmpty()) {
						JOptionPane.showMessageDialog(null, "표시할 데이터가 없습니다.");
					} else {
						StringBuilder sb = new StringBuilder("=== 전체 랭킹 ===\n");
						sb.append(String.format("%-5s | %-20s | %-10s\n", "순위", "아이디", "승률"));
						for (int i = 0; i < ranking.size(); i++) {
							User u = ranking.get(i);
							sb.append(String.format("%2d위   | %-20s | %.2f%%\n", i + 1, u.getId(), u.getWinRate()));
						}
						JOptionPane.showMessageDialog(null, sb.toString());
					}
				}

				case "5" -> {
					// 비밀번호 변경
					String changePw = JOptionPane.showInputDialog("새 비밀번호를 입력하세요:");
					if (changePw != null && ValidationUtil.isValidPassword(changePw)) {
						currentUser.setPassword(changePw);
						userMgr.save(); // 파일 저장
						JOptionPane.showMessageDialog(null, "비밀번호가 변경되었습니다.");
					} else {
						JOptionPane.showMessageDialog(null, "규칙에 맞지 않는 비밀번호입니다.");
					}
				}

				default -> JOptionPane.showMessageDialog(null, "잘못된 선택입니다.");
				} 
			} 
		}

		System.out.println("프로그램을 종료합니다.");
		userMgr.printAllUsers();
	}
}