package javaFund.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/*
 * HashMap 에 ID(String) 와 점수(Integer) 가 저장되어 있음
 * 실행 결과와 같이 평균 점수, 최고점수, 최고 점수의 ID를 출력하도록 코드 완성하시오
 */

public class HashMapQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("blue", 96);
		map.put("white", 82);
		map.put("red", 82);
		
		String name = null; // 최고점수 아이디
		int maxScore = 0; // 최고점수
		int totalScore = 0; // 점수 합계
		
//		Set<String> keyset = map.keySet();
//		Iterator<String> keyIter = keyset.iterator();
//		while(keyIter.hasNext()) {
//			String k = keyIter.next();
//			Integer v = map.get(k);
//			System.out.println(k + " : " + v);
//			totalScore += v;
//			if(v > maxScore) {
//				maxScore = v;
//				name = k;
//			}
//		}
//		
		Set<Entry<String,Integer>> entrySet = map.entrySet();
		Iterator<Entry<String,Integer>> entryIt = entrySet.iterator();

		while(entryIt.hasNext()) {
			Entry<String,Integer> entry = entryIt.next();
			String k = entry.getKey();
			Integer v = entry.getValue();
			System.out.println("k " + k + " : " + "v " + v);
			totalScore += v;
			if(v > maxScore) {
				maxScore = v;
				name = k;
			}
		}
		
		double avg = totalScore/map.size();
		System.out.println("------------------------");
		System.out.println("평균점수: " + avg);
		System.out.println("최고점수: " + maxScore);
		System.out.println("최고점수를 받은 ID: " + name);
		// 결과
		/*
		 * 평균점수 : ?
		 * 최고점수 : ?
		 * 최고점수를 받은 ID: ?
		 */
	}

}
