package javaFund.langex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class StringExam {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		/*
		 * 스트링 객체는 ""를 이용해서 생성시엔, 공유영역에 저장하고, 같은 값을 가진 문자열을 ""로 생성하게 되면
		 * 같은 객체의 ref 를 되돌려줍니다. 즉 같은 객체라는 뜻입니다.
		 * 
		 * 자바에서는 객체간의 비교시 == 의 의미는 같은 객체인지를 물어보는 겁니다.
		 * 즉 ref 가 같은지를 물어보는 것이지요
		 * 
		 */
		
		String a = "hello";
		String b = "hello";
		
		System.out.println(a == b);
		
		// 생성자를 이용한 문자열 객체 생성하기
		String c = new String("hello");
		System.out.println(a == c);
		
		String st = new String();
		
		byte[] bs = {49,50,51};
		// 위 배열의 값을 문자열로 생성함
		st = new String(bs);
		System.out.println(st);
		
		st = new String(bs,0,2,"EUC-KR");
		System.out.println(st);
		
		// 기본 문자셋 정보 얻어내기
		Charset cset = Charset.defaultCharset();
		System.out.println(cset.toString());
		
		char[] chArr = {'자','바','는','재','미'};
		String chstr = new String(chArr,3,2);
		System.out.println(chstr);
		
		System.out.println(chstr.contains("미"));
		
		// equals(String): 두 개의 문자열 값이 같으면 true 아니면 false 를 리턴
		System.out.println(c.equals(a)	);
		
		System.out.println(Arrays.toString("안녕 오늘은 뭐해?".getBytes()));
		
		bs = new byte[] {-20, -107, -120, -21, -123, -107, 32, -20, -104, -92, -21, -118, -104, -20, -99, -128, 32, -21, -83, -112, -19, -107, -76, 63};
		String bss = new String(bs);
		System.out.println(bss);
		
		// 여러분의 이메일을 변수에 담아서, @ 을 기준으로 id 분리해서 그걸 char 배열로 변환해서
		// 그것의 길이와 값을 출력해보세요
		String myMail = "seojunwon19@naver.com";
		int gol = myMail.indexOf("@");
		String myID = myMail.substring(0, gol);
		char[] charID = myID.toCharArray();
		System.out.print("아이디: " + Arrays.toString(charID));
//		System.out.print("아이디: ");
//		for(char cs : charID) {
//			System.out.print(cs);
//		}
		System.out.println(" 길이: " + charID.length);
		
		
		// charset 인터페이스에 문자셋을 리턴하도록 하는 메서드
		// 자바에서 지원하는 문자셋이 무엇인지를 출력하도록
		
//		Map<String, Charset> charsets = Charset.availableCharsets();
//        System.out.println("=== 자바에서 지원하는 문자셋 목록 ===");
//        for (String name : charsets.keySet()) {
//            System.out.println(name);
//        }
//        Charset.availableCharsets().forEach((t, u) -> System.out.println(t));

		StringBuilder sb = new StringBuilder("hello");
		System.out.println("내부 버퍼의 크기: " + sb.capacity());
		
		// 문자열을 끝에 추가하는 메서드 append()
//		sb = sb + "world";
		sb.append("world");
		System.out.println(sb);
		
		// 문자열 중간에 문자 넣기
		sb.insert(1, "h");
		System.out.println(sb);
		
		// 문자열 지우기
		sb.delete(0, 3);
		System.out.println(sb);
		
		// o 다음에 공백을 추가해서 llo world 가 되도록
//		int g = sb.indexOf("o");
//		sb.substring(0, g);
//		System.out.println(sb.insert(g+1, " "));
		
		sb.insert(sb.indexOf("w"), " ");
		System.out.println(sb);
		
		// sb 객체의 값을 String 객체로 생성해보세요
		String ssb = sb.toString();
//		String ssb = new String(sb);
		
		System.out.println(ssb);
		
		byte[] abc =  "abcde".getBytes();
		byte[] jkl =  "jklmn".getBytes();
		
		System.arraycopy(abc, 0, jkl, 0, abc.length);
		System.out.println(new String(jkl));
		
		System.out.println(new Date(System.currentTimeMillis()));
		
		// 자바프로그램을 강제 종료 시키는 메서드
//		System.exit(0);
		
		// 자바의 Wrapper 클래스
		// 자바에서 사용되는 모든 Ptype 을 클래스로 정의한 클래스
		// 이 클래스를 이용하면 Ptype 에 관련된 많은 정보를 손쉽게 사용할 수 있다
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		// compare
		System.out.println(Integer.compare(2, 1));
		
		// valueOf
		int i = 10;
		Integer.valueOf(i).byteValue();
		
		// parseInt
		System.out.println(Integer.parseInt("10"));
		
		String pass = "AasADF1dx"; //숫자 하나와 대문자가 포함되어야 한다라고 가정
		int digitCnt = 0, alphaCnt = 0;
		for(int ii = 0; ii < pass.length(); ii++) {
			// 문자를 하나씩 분리한다
			char ch = pass.charAt(ii);
			// 분리된 문자가 대문자인지 숫자인지 검증
			if(Character.isUpperCase(ch)) {
				alphaCnt++;
			}
			else if(Character.isDigit(ch)) {
				digitCnt++;
			}
			
		}
		
		
	}

}
