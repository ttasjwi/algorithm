Prepare > Algorithms > Implementation > Number Line Jumps
## Number Line Jumps

---

Difficulty : Easy  
Problem : <a href="https://www.hackerrank.com/challenges/kangaroo/problem" target="_blank">link</a>

---

## 풀이
조건에서
t(t>0)초 경과했을 때 

- first kangroo의 위치는 x1 + v1 * t
- second kangroo의 위치는 x2 + v2 * t

라 할 수 있다.

이 두 위치가 같은 시점의 t값을 구하면 되는데, t에 대한 방정식 x1 + v1 * t = x2 + v2 * t 의 해는  
t = (x2 - x1) / (v1 - v2) 이다.

여기서 x2-x1은 양수이고 t>0 이므로, v1-v2 >0 이여야한다. 또 주어진 문제상황에서 t는 정수여야한다.

우선, v1과 v2의 값을 비교했을 때 v1<=v2 인 경우 "NO"를 반환하게 하고,  
double t 를 구한뒤, 이를 int로 변환한 값과 비교했을 때 같으면 "YES", 아니면 "NO"를 반환하게 했다.