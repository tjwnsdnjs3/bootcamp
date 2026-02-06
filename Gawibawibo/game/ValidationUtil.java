package javaFund.game;

import java.util.regex.Pattern;

public class ValidationUtil {
	// 이메일 형식 체크, 비밀번호 복잡성 체크 등 유효성 검사 도구
	
	// 이메일 형식 정규표현식
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	// 비밀번호: 8~12자, 대문자, 숫자, 특수문자 포함
	private static final String PW_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,12}$";

	public static boolean isValidEmail(String email) {
		return Pattern.matches(EMAIL_REGEX, email);
	}

	public static boolean isValidPassword(String pw) {
		return Pattern.matches(PW_REGEX, pw);
	}
}