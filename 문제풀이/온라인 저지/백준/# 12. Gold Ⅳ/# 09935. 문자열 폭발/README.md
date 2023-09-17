 # 문제
- 플랫폼 : 백준
- 번호 : 09935
- 제목 : 문자열 폭발
- 난이도 : Gold 4
- 모든 폭발이 끝난 후 남은 문자열을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/9935" target="_blank">링크</a>

---

# 필요 지식
- 스택

---

# 풀이
```kotlin
fun main() {
    val s = s()
    val x = s()
    val st = CharArray(s.length)
    var top = -1
    var p = -1
    for (i in s.indices) {
        st[++top] = s[i]

        if (st[top] != x[p+1]) {
            p = if (st[top] == x[0]) 0 else - 1
        } else {
            p ++
            if (p == x.length - 1) {
                top -= x.length
                p = -1
                if (top == -1) continue
                for (j in Math.max(0, top-x.length+1)..top) {
                    if (st[j] != x[p+1]) {
                        p = if (st[j] == x[0]) 0 else - 1
                    } else {
                        p ++
                    }
                }
            }
        }
    }
    if (top == -1) {
        print("FRULA")
    } else {
        for (i in 0..top) {
            sb.append(st[i])
        }
        print(sb)
    }
}
```
- 변수 설명
  - top : 스택의 최상단 문자 인덱스
  - p : 스택에 삽입된 문자열과 폭발문자열이 연속해서 몇 번 같았는지 체크하는 변수
- 스택의 다음 top에 문자를 삽입한뒤 폭발문자열의 다음 p 위치의 문자와 비교한다.
- 폭발문자열의 다음 p위치와 현재 top 문자가 같아지면 p 를 1 증가 시킨다.
  - 이때, p 값이 폭발문자열의 마지막 인덱스면 top을 폭발문자열 길이만큼 제한다. 그리고 top으로부터 x길이만큼 뺀 위치부터 문자를 비교하며 p를 갱신시킨다.
- 폭발문자열의 다음 p위치와 현재 top 문자가 다르면
  - 폭발문자열의 0번째 문자와 같으면 p를 0에 두고, 다르면 -1로 둔다.
---
