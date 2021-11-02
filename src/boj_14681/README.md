# boj_14681

난이도 : Bronze4  
BOJ(백준) 2단계 - if문

점수를 입력받아, 등급(F,D,C,B,A)을 출력

[[문제 확인하기]](https://www.acmicpc.net/problem/14681)

---
## Main
- Prompt 객체 호출, run() 메서드 실행
---
## Prompt

실제 실행될 내용을 정의한 클래스. run() 메서드를 호출하면 실행된다.

### void run()
- inputToPoint 메서드를 통해, 사용자로부터 x,y 좌표를 입력받고 point 객체를 반환받는다.
- point의 quadrant() 메서드를 호출하여, 사분면에 해당하는 문자 quadrant를 반환받는다.
- 사분면 문자를 출력한다.

### private Point inputToPoint()
- 사용자로부터 x,y 좌표 입력을 받아 Point 객체를 반환함
---
## Point
점을 정의한 클래스.
- 인스턴스 변수 : private int x, y (좌표)
- 생성자 : Point (int x, int y)
- char quadrant() : 점이 속한 사분면을 문자로 반환

---
# 기반 지식
- 조건문 (if문)
- 또는 ChoiceFormat
---
# 체크 포인트
- 점(Point)이라는 요소와 그 성질을 클래스를 통해 정의함
- 짜놓고 보니, 이걸 Prompt의 inputToPoint()를 Prompt에 정의하는게 맞을지, Point의 static 메서드로 정의하는게 맞았을지 긴가민가하다.