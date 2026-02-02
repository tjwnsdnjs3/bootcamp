package javaFund.util;

import java.util.ArrayList;
import java.util.List;

class Board {
    private String title;
    private String content;

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

class BoardDao {
    public List<Board> getBoardList() {
        List<Board> list = new ArrayList<Board>();
        list.add(new Board("제목1", "내용1"));
        list.add(new Board("제목2", "내용2"));
        list.add(new Board("제목3", "내용3"));
        return list;
    }
}

class ListExam {
    public void doSome() {
        BoardDao dao = new BoardDao();
        List<Board> list = dao.getBoardList();
        for (Board b : list) {
            System.out.println(b.getTitle() + " = " + b.getContent());
        }
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        ListExam le = new ListExam();
        le.doSome();
    }
}