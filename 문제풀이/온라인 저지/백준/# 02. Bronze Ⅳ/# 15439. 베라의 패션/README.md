# 문제
- 플랫폼 : 백준
- 번호 : 15439
- 제목 : 베라의 패션
- 난이도 : Bronze 4
- 상의와 하의가 서로 다른 색상인 조합의 가짓수를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/15439" target="_blank">링크</a>

---

# 필요 지식
- 수학

---

# 풀이
```python
fun main() {
    var v = 0
    var c = System.`in`.read()
    do v = v * 10 + (c - 48) while(System.`in`.read().also { c = it } > 47)
    print(v * (v-1))
}
```
- 단순히 경우의 수를 구하는 문제이다.
- 옷을 선택하는 가짓수는 n가지, 그 각각에 대하여 다른 색상의 옷을 선택하는 가짓수는 (n-1)
- 이 두 상황은 동시에 일어나므로 곱의 법칙에 의해 계산할 수 있다.

---
