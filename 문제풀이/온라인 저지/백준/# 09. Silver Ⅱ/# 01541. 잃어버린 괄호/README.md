# 문제
- 플랫폼 : 백준
- 번호 : 01541
- 제목 : 잃어버린 괄호
- 난이도 : Silver 2
- 괄호를 적절히 쳐서 식의 값을 최소로 만드는 프로그램을 작성
- 문제 : <a href="https://www.acmicpc.net/problem/1541" target="_blank">링크</a>

---

# 필요 지식
- 그리디 알고리즘

---

# 풀이
```kotlin
fun main() {
    var answer = 0
    var sum = 0
    var v = 0
    var c: Byte
    var m = false
    while (true) {
        c = r()
        when {
            c <= 10 ->  {
                sum += v
                answer += if (m) -sum else sum
                break
            }
            c <= 43 -> {
                sum += v.also { v = 0 }
            }
            c <= 45 -> {
                sum += v.also { v = 0 }
                answer += if (m) -sum else sum
                m = true
                sum = 0
            }
            else -> {
                v = v * 10 + c - 48
            }
        }
    }
    print(answer)
}
```
- `-`를 만나고 다음 `-`를 만날 때까지 괄호로 묶어서 최대한 숫자들을 최대한 합해주면 합이 최소가 된다.
- 변수 설명
  - answer : 구하고자 하는 합
  - sum : 임시 저장 합
  - v : 숫자
  - m : 지금 누적시키는 sum이 음수인지, 양수인지에 대한 플래그
- 문자를 한 글자 한 글자 읽어나간다
  - `-`를 만나는 순간
    - v를 sum에 합산한다
    - 기존 sum들을 모두 answer에 더하거나 뺀다.(현재 m이 false이면 더하고, true이면 뺀다)
    - m을 true로 한다
    - sum을 0으로 초기화한다
  - `+`를 만나는 순간
    - v를 sum에 합산하고 v를 0으로 초기화한다
  - `\n`을 만나는 순간
    - sum에 v를 합산한다
    - 현재 m이 true이면 answer에서 sum을 빼고, false이면 answer에 sum을 더한다
    - 반복을 탈출한다
  - 그 외
    - 숫자를 읽어나간다
- 최종 answer를 출력한다