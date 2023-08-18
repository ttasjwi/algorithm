# 문제
- 플랫폼 : 백준
- 번호 : 02346
- 제목 : 풍선 터뜨리기
- 난이도 : Silver 3
- 터진 풍선의 번호를 차례로 나열
- 문제 : <a href="https://www.acmicpc.net/problem/2346" target="_blank">링크</a>

---

# 필요 지식
- 연결 리스트

---

# 풀이
```kotlin
fun main() {
    val n = i()
    val l = LinkedList<IntArray>()
    for (i in 1..n) {
        l.add(intArrayOf(i, i()))
    }
    val sb = StringBuilder()
    var idx = 0
    var item = l.removeAt(idx)
    sb.append(item[0]).append(' ')

    while (!l.isEmpty()) {
        if (item[1] > 0) idx--
        idx = (idx + item[1] + l.size)%l.size
        while (idx < 0) idx += l.size
        item = l.removeAt(idx)
        sb.append(item[0]).append(' ')
    }
    print(sb)
}
```
- 연결리스트에 배열을 삽입한다. (0번 인덱스 : 풍선 번호, 1번 인덱스 : 변위)
- idx : 삭제할 인덱스
- item : 삭제된 요소
- 요소를 꺼내고(item에 할당), 0번 인덱스 값을 sb에 append 한다.
- 리스트가 빌 때까지 반복한다.
  - idx 계산
    - 1번 인덱스 값(변위)이 양수이면 인덱스를 1 감소시킨 상태에서 다음 인덱스로 이동해야한다.
    - idx가 음수가 됐을 때 0 이상이 될 때까지 리스트 크기만큼 계속 더 해 메꾼다
  - idx 위치의 요소를 거내고 0번 인덱스 값을 sb에 append한다.