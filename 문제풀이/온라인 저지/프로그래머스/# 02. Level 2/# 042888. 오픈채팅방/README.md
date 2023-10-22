# 문제
- 플랫폼 : 프로그래머스
- 번호 : 042888
- 제목 : 오픈채팅방
- 난이도 : Level 2
- 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지를 문자열 배열 형태로 return
- 문제 : <a href="https://school.programmers.co.kr/learn/courses/30/lessons/42888" target="_blank">링크</a>

---

# 필요 지식
- 해시
- 구현

---

# 풀이
```kotlin
class Solution {
    fun solution(records: Array<String>): Array<String> {
        val userRepository = HashMap<String, User>()
        val events = ArrayList<Event>()
        var recordSplit: List<String>
        for (record in records) {
            recordSplit = record.split(" ")
            if (recordSplit[0] == "Enter") {
                if (userRepository.containsKey(recordSplit[1])) {
                    userRepository[recordSplit[1]]!!.changeName(recordSplit[2])
                } else {
                    userRepository[recordSplit[1]] = User(recordSplit[1], recordSplit[2])
                }
                events.add(Event(recordSplit[1], true))
            } else if (recordSplit[0] == "Leave") {
                events.add(Event(recordSplit[1], false))
            } else {
                userRepository[recordSplit[1]]!!.changeName(recordSplit[2])
            }
        }
        return events.map {
            if (it.isEnter) {
                "${userRepository[it.userId]!!.name}님이 들어왔습니다."
            } else {
                "${userRepository[it.userId]!!.name}님이 나갔습니다."
            }
        }.toTypedArray()
    }

}

class User (val id: String, var name: String) {

    fun changeName(newName: String) {
        if (newName != name) {
            name = newName;
        }
    }
}

class Event(val userId:String, val isEnter:Boolean)
```
- userRepository는 해시테이블이다. Key로 사용자의 식별자(id), Value로 사용자 객체를 저장한다.(잘 생각해보면 이름만 저장해도 되긴 했다.)
- 사용자가 들어오면
  - userRepository에 저장된 사용자 닉네임 정보를 갱신(미등록자는 해시테이블에 추가한다.)
  - events에 사용자 입장 내역을 추가(id, true)
- 사용자가 나가면
  - events에 사용자의 퇴장 내역을 추가(id, false)
- 사용자가 닉네임을 변경하면
  - userRepository에 저장된 사용자 닉네임 정보를 갱신
- 최종적으로 events 로그를 순서대로 읽어가면서 문자열로 변환하면 된다.
  - userId가 저장되어있으므로 이것을 userRepository에서 조회해서 사용자 최신 닉네임을 얻어온다.
  - isEnter 변수를 통해 입장/퇴장 여부를 확인한다.

---
