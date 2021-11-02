

# boj_2753

난이도 : Bronze4  
BOJ(백준) 2단계 - if문

연도를 입력받아 윤년, 평년 여부를 문자 '1', '0'으로 반환

[[문제 확인하기]](https://www.acmicpc.net/problem/2753)

---
## Main
- Prompt 객체 호출, run() 메서드 실행
---
## Prompt

실제 실행될 내용을 정의한 클래스. run() 메서드를 호출하면 실행된다.

### void run()
- 사용자로부터 연도를 int타입으로 입력받음
- getLeapYearCode 메서드를 통하여, 윤년이면 '1', 평년이면 '0' 문자를 반환받는다.
- 이 문자를 출력한다.

### private char getLeapYearCode(int year)
- isLeapYear 메서드를 통하여 지정년도가 윤년인지, 평년인지 여부를 판단
- 윤년이면 문자 '1', 평년이면 문자 '0'을 반환한다.

### private boolean isLeapYear(int year)
- 지정 연도가 윤년이면 true, 평년이면 false 를 반환
- 윤년의 조건
  1) 4의 배수이고 100의 배수 아니다.
  2) 400의 배수이다.
---
# 기반 지식
- 조건문 (if문)
---
# 체크 포인트
- if문의 내용이 한 줄이더라도, 괄호처리를 안 하는 것은 나쁜 습관이다.
- else, else if, switch case문은 가급적 쓰지 않도록하기
- 한 개의 메서드는 하나의 역할만!