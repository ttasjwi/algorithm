# 문제
- 플랫폼 : 백준
- 번호 : 11653
- 제목 : 소인수분해
- 난이도 : Bronze 1
- 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/11653" target="_blank">링크</a>

---

# 필요 지식
- 소수

---

# 풀이
## 풀이1 : 소수 전부 구하기 -> 반복해서 나누기
```kotlin
fun main() {
    var n = readInt()
    if (n == 1) {
        return
    }
    val check = BooleanArray(n + 1)
    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (!check[i]) {
            for (j in 2 * i..n step (i)) {
                check[j] = true
            }
        }
    }
    val sb = StringBuilder()
    for (i in 2..n) {
        if (check[i]) continue
        while (n % i == 0) {
            sb.append(i).append('\n')
            n /= i
        }
        if (n == 1) {
            break
        }
    }
    print(sb)
}
```
- n 이하의 소수를 전부 구하고(에라토스 테네스의 체 적용) 2부터 n까지 존재하는 소수를 순서대로 작은 것부터 나눌 수 있는 만큼 나누는 방식이다


## 풀이2:
```kotlin
fun main() {
    var n = readInt();
    val sb = StringBuilder()

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        while (n % i == 0) {
            sb.append(i).append('\n')
            n /= i
        }
    }
    if (n != 1) {
        sb.append(n)
    }
    print(sb)
}
```
- 2부터 루트 n까지, 각 숫자 순서대로 나눌 수 있는 만큼 계속 나누는 방식이다.
  - 모든 자연수는 루트 n 이하의 약수들로 나눠질 수 있기 때문에 루트 n까지 나누는 것이다.
- 2부터 반복하다보면, 앞에서 소수로 나눠지기 때문에 합성수로 나눠질 일이 없다
- 이렇게 진행한 후 마지막에 소수가 하나 남을 가능성이 있는데, 그 값도 마저 출력해주면 된다.
