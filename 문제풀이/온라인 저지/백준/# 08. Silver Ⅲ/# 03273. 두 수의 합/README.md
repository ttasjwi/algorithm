# 문제
- 플랫폼 : 백준
- 번호 : 03273
- 제목 : 두 수의 합
- 난이도 : Silver 3
- 자연수 x가 주어질 때 두 수의 합이 x가 되는 숫자 쌍의 갯수 구하기
- 문제 : <a href="https://www.acmicpc.net/problem/3273" target="_blank">링크</a>

---

# 필요 알고리즘
- 카운팅 정렬
- 투포인터
- 정렬

---

# 풀이
## 풀이1: 카운팅 정렬
```kotlin
fun main() {
    val n = i()
    val arr = IntArray(n)
    val check = BooleanArray(1_000_001)
    for (i in 0 until n) {
        arr[i] = i()
    }
    val x = i()
    var cnt = 0
    for (e in arr) {
        if (x-e in 1..1_000_000 && check[x-e]) {
            cnt ++
        } else {
            check[e] = true
        }
    }
    print(cnt)
}
```
- 배열에 수열을 저장한다
- 배열 요소를 하나씩 읽어가면서
  - 자신을 x에서 뺀 요소가 배열에 존재하면 cnt를 증가시킨다
  - 없으면 check 배열에 자신을 체크한다
- cnt를 출력한다.

## 풀이2: 정렬, 투포인터
```kotlin
fun main() {
    val n = i()
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = i()
    }
    val x = i()
    Arrays.sort(arr)
    var lt = 0
    var rt = n-1
    var sum: Int
    var cnt = 0
    while (lt < rt) {
        sum = arr[lt] + arr[rt]
        if (sum > x) {
            rt --
        } else if (sum < x) {
            lt ++
        } else {
            cnt ++
            lt ++
            rt --
        }
    }
    print(cnt)
}
```
- 배열에 수열을 저장하고 정렬한다.
- 두 포인터를 지정한다.
  - lt : 왼쪽 요소 인덱스(초깃값 0)
  - rt : 오른쪽 요소 인덱스 (초깃값 n-1)
- lt가 rt보다 앞서는 동안 다음을 반복한다.
  - sum : lt, rt에 위치한 요소의 합
  - sum이 x보다 크면 rt를 감소
  - sum이 x보다 작으면 lt를 증가
  - sum이 x와 같으면 cnt 증가후, lt 증가 rt 감소
- cnt 출력
