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
