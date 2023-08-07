# 문제
- 플랫폼 : 백준
- 번호 : 10814
- 제목 : 나이순 정렬
- 난이도 : Silver 5
- 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력
- 문제 : <a href="https://www.acmicpc.net/problem/10814" target="_blank">링크</a>

---

# 필요 지식
- 정렬 API
- 카운팅 정렬

---

# 풀이

## 풀이1 : 정렬(느림)
```kotlin
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val members = arrayOfNulls<Member>(n)

    for (i in members.indices) {
        st = StringTokenizer(br.readLine())
        members[i] = Member(i, st.nextToken().toInt(), st.nextToken())
    }
    members.sort()
    val sb = StringBuilder()
    for (member in members) {
        sb.append(member!!.age).append(' ').append(member!!.name).append('\n')
    }
    print(sb)
}

data class Member(
    val id: Int,
    val age: Int,
    val name: String
) : Comparable<Member> {

    override fun compareTo(other: Member): Int {
        return if (age == other.age) {
            id - other.id
        } else {
            age - other.age
        }
    }
}
```
- Member 객체 생성 후 정렬

## 풀이2: 카운팅 정렬(빠름)
```kotlin
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var n = st.nextToken().toInt()
    val counter = arrayOfNulls<StringBuilder>(201)

    var age: Int
    var name: String
    while (n -- > 0) {
        st = StringTokenizer(br.readLine())
        age = st.nextToken().toInt()
        name = st.nextToken()
        counter[age] = counter[age] ?: StringBuilder()
        counter[age]!!.append(age).append(' ').append(name).append('\n')
    }

    val sb = StringBuilder()
    for (s in counter) {
        if (s !== null) {
            sb.append(s)
        }
    }
    print(sb)
}
```
- 카운터에 StringBuilder를 두고 같은 나이가 입력될때마다 append

---
