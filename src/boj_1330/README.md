

# boj_1330

난이도 : Bronze4

BOJ(백준) 2단계 - if문



정수 두 개를 입력받고 입력값의 대소를 비교하여 비교 결과에 따라 부등호 출력
https://www.acmicpc.net/problem/1330

## Main
 - Prompt 객체 호출, run() 메서드 실행
## Prompt
 실제 실행될 내용을 정의한 클래스. run() 메서드를 통해 실행된다.
 
- 사용자로부터 문자열을 라인으로 입력받음
- 이를 StringToknize를 통해 int 타입 값들로 분리
- private String getComparison(int a, int b)을 통해 비교결과 문자열을 반환
- 결과를 출력