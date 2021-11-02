# boj_9498

난이도 : Bronze4  
BOJ(백준) 2단계 - if문

점수를 입력받아, 등급(F,D,C,B,A)을 출력

[[문제 확인하기]](https://www.acmicpc.net/problem/9498)

---
## Main
- Prompt 객체 호출, run() 메서드 실행
---
## Prompt

실제 실행될 내용을 정의한 클래스. run() 메서드를 호출하면 실행된다.

### void run()
- 사용자로부터 점수를 int타입으로 입력받음
- getGrade 메서드를 통하여, 점수에 해당하는 등급 문자열(F,D,C,B,A)을 반환받는다.
- 문자열을 출력한다.

### private int inputScore()
- 사용자로부터 점수를 입력받고 이를 int 타입 변수에 저장해 반환한다.

### private String getGrade(int score)
지정 점수를 통해 등급(F,D,C,B,A)을 반환받는다.
- 구현 방법 1 : if문을 통해 구현한다.
- 구현 방법 2 : ChoiceFormat을 통해 지정 score를 format에 맞게 형식화하여 반환한다.
---
# 기반 지식
- 조건문 (if문)
- 또는 ChoiceFormat

## ChoiceFormat
특정 범위에 속하는 값을 지정 문자열로 형식화

1. 생성자
   - ChoiceFormat(double[] limits, String[] formats)
     - limits : 범위 지정. 오름차순으로 정렬되어있어야함. 각 limits은 범위의 경계값. (포함)
     - formats : 범위에 따라 반환될 문자열 포맷
   - ChoiceFormat(String newPattern)
     - newPattern : 범위를 문자열로 지정함.  |를 통해 구분
       - \# : 이상
       - < : 초과
       - 예시 : "60<D|70<C|80<B|90<A"
2. 형식화
   - ChoiceFormat 객체.format(long number)
   - 입력된 long 값을 객체의 limits, formats에 따라 String으로 반환
---
# 체크 포인트
- if문의 내용이 한 줄이더라도, 괄호처리를 안 하는 것은 나쁜 습관이다.
- else, else if, switch case문은 가급적 쓰지 않도록하기
- 한 개의 메서드는 하나의 역할만!