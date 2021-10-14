package boj_2941;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_2941>>
	 *  크로아티아 알파벳의 갯수 구하기 (Pattern, Matcher 활용)
	 *  https://www.acmicpc.net/problem/2941
	 *  
	 *  예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
	 *  č -> c=
	 *  ć -> c-
	 *  dž -> dz=
	 *  đ  -> d-
	 *  lj -> lj
	 *  nj -> nj
	 *  š  -> s=
	 *  ž  -> z=
	 *  
	 *  예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.
	 *  단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
	 *  dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다.
	 *  lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
	 *  
	 *  (입력)
	 *   첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
	 *   단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
	 *  
	 *  (출력)
	 *   입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
	 * 
	 *   예제 입력1> ljes=njak
	 *   예제 출력1> 6
	 *  
	 *   예제 입력2> ddz=z=
	 *   예제 출력2> 3
	 *   
	 *   예제 입력3> nljj
	 *   예제 출력3> 3
	 *   
	 *   예제 입력4> c=c=
	 *   예제 출력4> 2
	 *   
	 *   예제 입력5> dz=ak
	 *   예제 출력5> 3
	 *  
	 * ===================================================
	 * 
	 * <필요지식>
	 * 
	 *  1. 정규식 (Regular Expression)
	 *  2. Escape-Sequence
	 *  3. Pattern
	 *  4. Escape-Sequence
	 *  
	 * ===================================================
	 * 
	 *  1. 정규식 (Regular Expression)
	 *   텍스트 데이터 중에서 원하는 조건(패턴, pattern)과 일치하는 문자열을 찾아내기 위해 사용하는 표현양식.
	 *   이 때 큰 따옴표 ""안에서 escape-Sequence '\'을 사용하려면 '\\'와 같이 두 번 사용해야한다.
	 *   
	 *   주요 정규식>
	 *    - .* : 모든 문자열 
	 *    
	 *    - c : c와 일치하는 문자열
	 *    - c. : c로 시작하는 모든 문자열
	 *    - c.* : c로 시작하는 모든 문자열 (기호 포함)
	 *    - c\. : c.과 일치하는 모든 문자열. '.'은 패턴 작성에 사용되므로, 문자로서 사용하려면 escape문자인 '\'을 사용해야함.

	 *    - c\d : c에 이어 숫자가 따라오는 두 자리 문자열
	 *    - c[0-9] : c에 이어 숫자가 따라오는 두 자리 문자열
	 *    
	 *    - c[a-z]* : c로 시작하고 뒤에 소문자 영어만 오는 문자열들
	 *    - c[a-z] : c로 시작하는 두자리 영단어(뒤에는 소문자만 허용)
	 *    - c[a-zA-Z] : c로 시작하는 두자리 영단어 (뒤에 오는 문자는 대소문자 구분 안 함)
	 *    
	 *    - c\w : c로 시작하고 숫자 또는 영어가 뒤에 따라오는 두자리 문자열
	 *    - c[a-zA-Z0-9] : c로 시작하고 뒤에 숫자 또는 영어가 뒤에 따라오는 두자리 문자열
	 *    
	 *    - c.*t : c로 시작하고 t로 끝나는 모든 문자열
	 *    - [b|c].* : b 또는 c로 시작하는 모든 문자열
	 *    
	 *    - ".*a.*" : a를 포함하는 모든 문자열. 여기서 '.*'는 0개 또는 그 이상의 문자를 포함해야함.
	 *    - ".*a.+" : a를 포함하는 모든 문자열. 여기서 '.+'는 1개 또는 그 이상의 문자를 포함해야함. 즉 마지막에 a로 끝나는 단어는 포함되지 않는다.
	 *    
	 *    - [b|c].{2} : b또는 c로 시작하는 세자리 문자열. {}안에 있는 숫자는 뒤에 오는 문자의 개수를 의미한다.
	 * 
	 * ===================================================
	 * 
	 *  2. Escape-Sequence
	 *   백슬래시( \ ) 뒤에 한 문자나 숫자 조합이 오는 문자 조합을 "이스케이프 시퀀스"라고 합니다.
	 *   줄 바꿈 문자, 작은따옴표, 또는 문자 상수의 다른 특정 문자를 나타내려면 이스케이프 시퀀스를 사용해야 합니다.
	 *   (https://docs.microsoft.com/ko-kr/cpp/c-language/escape-sequences?view=msvc-160)
	 *   
	 *    - \n : 개행(줄바꿈)
	 *    - \\ : 백슬래시 '\'
	 *    - \' : 홑따옴표
	 *    - \" : 쌍따옴표
	 *    - \t : 탭문자
	 *    - 그 외
	 * 
	 * ===================================================
	 * 
	 *  3. Pattern
	 *   패턴을 정의하는 클래스.
	 *   패턴으로 사용할 정규식을 정의하여 인스턴스를 생성할 수 있다.
	 *     
	 *   1) 생성
	 *     static Pattern compile(String regex)
	 *   	regex를 패턴으로 하는 Pattern 인스턴스 반환
	 *   
	 *     - 패턴을 그룹핑하기
	 *       괄호 '()'로 그룹을 나눌 수 있음.
	 *       Matcher에서 group (~)을 통하여 그룹단위로 반환받을 수 있음
	 *       
	 *       group(0), group() : 매칭된 문자열 전체를 나누어지지 않은 채 반환
	 *       group (int n) : 매칭된 문자열의 n번째 group을 반환함
	 *   
	 *   2) Matcher 반환
	 *     Matcher matcher(CharSequence input)
	 *     패턴(정규식)으로 비교할 문자열(input)을 매개변수로 하는 Matcher 인스턴스 반환
	 *     	 -> Matcher 객체는 패턴과, 문자열의 정보를 갖게 됨
	 *     (cf)
	 *      CharSequence는 인터페이스.
	 *      이를 구현한 클래스로는 String, CharBuffer, StringBuffer가 있다.
	 *      
	 * ========================================================================
	 * 
	 *  4. Matcher
	 *   패턴(정규식), 비교 데이터를 비교하는 역할
	 *  
	 *   1) 매칭 여부 반환하기
	 *    boolean matches()
	 *    비교 데이터가 패턴(정규식)에 부합하는지 확인하여 boolean 값으로 반환
	 *    
	 *   2) 부분 찾기
	 *    - boolean find()
	 *      소스 내에서 패턴과 일치하는 부분을 찾아내면 true를 반환 후 매칭된 부분으로 이동
	 *      find()를 한번 호출하고 다시 호출 시 패턴과 일치하는 부분의 다음부터 다시 패턴 매칭을 시작함.
	 *    
	 *    - start() : 매칭된 문자열이 시작하는 index를 반환
	 *    - end() : 매칭된 문자열이 끝나는 index를 반환
	 *    
	 *    - appendReplacement(StringBuffer sb, String replacement)
	 *     : 매칭된 문자를 replacement로 교체한 결과물을 매칭부분까지 sb에 저장
	 *    
	 *    - appendTail(StringBuffer sb)
	 *     : appendReplacement로 마지막으로 추가된 부분의 뒷부분을 전부 sb에 추가
	 *     
	 *    + StringBuffer의 append를 통해 문자열이 추가될 때 capacity를 초과할 경우 자동으로 capacity가 늘어난다.
	 *     
	 * ========================================================================  
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String source = br.readLine(); // 라인으로 문자를 읽어옴
		br.close();
		
		// 계산
		int croatiaAlphLength = getCroatiaAlphlength(source); // 크로아티아 알파벳의 갯수
		
		// 출력
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(croatiaAlphLength+"");
		bwr.flush();
		bwr.close();
	}

	private static int getCroatiaAlphlength(String source) {
		Pattern p = Pattern.compile("c=|c-|dz=|d-|lj|nj|s=|z="); // 패턴 지정
		Matcher m = p.matcher(source); // 매칭
		
		int croatiaAlphLength = source.length(); // 문자열의 전체 문자 갯수
		
		while(m.find()) {
			int length = m.end() - m.start(); // 패턴에 일치하는 문자열의 길이
			croatiaAlphLength -= length -1; // 패턴에 일치하는 경우, 하나의 문자로 취급하기 때문에 불필요한 길이만큼 제함  
		}
		return croatiaAlphLength;
	}

}
