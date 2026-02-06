package javaFund.game;

import java.io.*;
import java.util.*;

public class UserManager {
    private List<User> userList = new ArrayList<>(); // 리스트 초기화
    private final String PATH = "C:\\java_game\\user_data.dat";

    public UserManager() {
        load(); // 시작할 때 불러오기
    }

    // 1. 로그인
    public User login(String id, String pw) {
        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            if (u.getId().equals(id) && u.getPassword().equals(pw)) {
                return u; // 찾으면 그 유저를 리턴
            }
        }
        return null; // 없으면 null 값 리턴
    }

    // 2. 가입
    public void addUser(User user) {
        userList.add(user);
        save();
    }

    // 3. 아이디 중복체크
    public boolean isIdExists(String id) {
        for (User u : userList) {
            if (u.getId().equals(id)) return true;
        }
        return false;
    }

    // 4. 파일 쓰기 (저장하기)
    public void save() {
        try {
            // 폴더가 없으면 만드는 과정
            File folder = new File("C:\\java_game");
            if (!folder.exists()) folder.mkdir();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH));
            oos.writeObject(userList);
            oos.close();
        } catch (Exception e) {
            System.out.println("저장 실패: " + e.getMessage());
        }
    }

    // 5. 파일 읽기 (불러오기)
    public void load() {
        File file = new File(PATH);
        if (!file.exists()) return; // 파일 없으면 그냥 종료

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH));
            userList = (List<User>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("불러오기 실패");
        }
    }

    // 6. 랭킹 정렬(오름차순, 내림차순)
    public List<User> getRanking(boolean lowToHigh) {
        List<User> copyList = new ArrayList<>(userList);
        copyList.sort((u1, u2) -> {
            if (lowToHigh) return Double.compare(u1.getWinRate(), u2.getWinRate());
            else return Double.compare(u2.getWinRate(), u1.getWinRate());
        });
        return copyList;
    }
    // 저장된 모든 유저의 정보를 콘솔 출력
    public void printAllUsers() {
        System.out.println("\n======================================= [현재 파일 내 데이터 확인] =======================================");
        if (userList.isEmpty()) {
            System.out.println("저장된 유저가 없습니다.");
        } else {
            for (User u : userList) {
                System.out.printf("ID: %-15s | PW: %-10s | 전적: %d승 %d무 %d패 | 마지막 접속: %s\n",
                    u.getId(), 
                    u.getPassword(), 
                    u.getWinCnt(), 
                    u.getDrawCnt(), 
                    u.getLoseCnt(),
                    u.getFormattedLoginTime());
            }
        }
        System.out.println("=====================================================================================================\n");
    }
}