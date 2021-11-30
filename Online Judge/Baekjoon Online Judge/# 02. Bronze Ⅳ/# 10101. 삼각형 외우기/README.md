# \[BOJ 10101\] 삼각형 외우기

난이도 : Bronze4

각 3개를 입력받아, 그 삼각형이 어떤 삼각형인지 출력하기  
문제 : <a href="https://www.acmicpc.net/problem/10101" target="_blank"> [링크]</a>
---  

## Main.java : 백준 제출 답안

- 소스 코드 : <a href="src/Main.java" target="_blank">gitHub</a>
- BufferedReader로 세 각을 int로 입력받는다. (`a`, `b`, `c`)
- `a`,`b`,`c`의 합을 구하고, 그 합이 180인지 아닌지 판단하여 String `result`에 다음 문자열을 할당한다.
  - 합이 180이 아니면 : `"Error"`
  - 합이 180이면
    - 세 각의 크기가 같다(모두 60) : `"Equilateral"`
    - 세 각 중 적어도 두 각의 크기가 같다(이등변 삼각형) : `"Isosceles"`
    - 위의 두 경우가 아닌 경우, 즉 같은 각이 없다. : `"Scalene"`
- `result`를 출력한다.

---

## Review
- if, else if, else로 적극적으로 분기쳐서 처리함
- 구현문제에서는 if, else if, else는 가독성을 죽이고 유지보수에 최악이지만, 알고리즘에선 그런거 다 필요없음.

---