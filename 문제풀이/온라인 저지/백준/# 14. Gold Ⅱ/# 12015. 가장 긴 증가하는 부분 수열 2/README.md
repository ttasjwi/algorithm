# 문제
- 플랫폼 : 백준
- 번호 : 12015
- 제목 : 가장 긴 증가하는 부분 수열 2
- 난이도 : Gold 2
- 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력
- 문제 : <a href="https://www.acmicpc.net/problem/12015" target="_blank">링크</a>

---

# 필요 지식
- 이분탐색
- LIS

---

# 풀이
```kotlin
fun main() {
    val n = i()
    var cur = i()
    var rt = 0
    val lis = IntArray(n)
    lis[0] = cur

    var l: Int
    var r: Int
    var mid: Int
    var tmp = 0
    loop@ for (i in 1 until n) {
        cur = i()
        when {
            lis[rt] == cur -> {
                continue
            }

            lis[rt] < cur -> {
                lis[++rt] = cur
            }

            else -> {
                l = 0
                r = rt
                while (l <= r) {
                    mid = (l + r) shr 1
                    if (lis[mid] == cur) {
                        continue@loop
                    } else if (lis[mid] > cur) {
                        tmp = mid
                        r = mid - 1
                    } else {
                        l = mid + 1
                    }
                }
                lis[tmp] = cur
            }
        }
    }
    print(++rt)
}
```
- lis의 첫번째 요소로 0번째 숫자를 둔다
- 숫자를 입력받는 족족 lis의 마지막 항과 현재 숫자를 비교하고 다음을 수행한다
  - 현재 숫자가 lis 마지막항과 같으면 아무 것도 하지 않는다
  - 현재 숫자가 lis 마지막항보다 크면 마지막항 뒤에 현재 숫자를 두고 rt를 증가시킨다
  - 현재 숫자가 lis 마지막 항보다 작으면 매개변수 탐색을 통해 삽입할 인덱스를 찾는다
    - l: 0
    - r: lis의 마지막 항 인덱스
    - 가능한 작은 인덱스쪽에 두도록 한다.
  - 찾은 인덱스에 현재 숫자를 삽입한다
- 이렇게 반복하고 마지막 rt값 +1 만큼이 lis의 최대 길이이다

---
