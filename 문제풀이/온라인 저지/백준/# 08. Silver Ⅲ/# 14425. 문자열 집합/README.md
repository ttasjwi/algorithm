# 문제
- 플랫폼 : 백준
- 번호 : 14425
- 제목 : 문자열 집합
- 난이도 : Silver 3
- M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력
- 문제 : <a href="https://www.acmicpc.net/problem/14425" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 집합

---

# 풀이
```python
fun main() {
    System.`in`.read(B,0,S)
    var n = i()
    var m = i()
    val s = HashSet<String>()
    while (n-->0) s.add(s())
    var c = 0
    while (m -->0) if (s() in s) c++
    print(c)
}

const val S=10020012
private val B=ByteArray(S)
private var p=0
fun i():Int{
    var v=0
    var c=B[p++]
    do v=v*10+c-48 while(B[p++].also{c=it}>47)
    return v
}
fun s():String{
    val f=p; var l=0
    while(B[p++]>64)l++
    return String(B,f,l)
}
```
- n개 라인을 읽고 set에 저장(해시 사용)
- 다음 m개 라인의 각 요소를 set에서 존재 여부를 확인 후, 존재하는 것에 대해서만 카운팅

---
