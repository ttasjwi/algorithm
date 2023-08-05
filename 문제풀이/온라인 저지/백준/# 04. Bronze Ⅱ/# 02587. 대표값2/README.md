# 문제
- 플랫폼 : 백준
- 번호 : 02587
- 제목 : 대표값2
- 난이도 : Bronze 2
- 첫째 줄에는 평균을 출력하고, 둘째 줄에는 중앙값을 출력
- 문제 : <a href="https://www.acmicpc.net/problem/2587" target="_blank">링크</a>

---

# 필요 지식
- 정렬

---

# 풀이
```kotlin
fun main() {
    val check = IntArray(9)
    var sum = 0
    var num: Int
    for (i in 1..5) {
        num = readInt()
        sum += num
        check[num/10 - 1] += 1
    }
    var cnt = 0
    val sb = StringBuilder()
    sb.append(sum/5).append('\n')
    for (i in check.indices) {
        if (check[i] > 0) {
            cnt += check[i]
            if (cnt >= 3) {
                sb.append((i + 1) * 10).append('\n')
                break
            }
        }
    }
    print(sb)
}
```
- `check` : 등장 횟수 저장 배열 (여기서는 10,20,... 와 같이 10의 배수가 들어오므로 이에 맞게 9칸 인덱스만 가진 배열을 만듬)
- 작은 값부터 카운팅하여 중앙값을 찾아낸다.

---
