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