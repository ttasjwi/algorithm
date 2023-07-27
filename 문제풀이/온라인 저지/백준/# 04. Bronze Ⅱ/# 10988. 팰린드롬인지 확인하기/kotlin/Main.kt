fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val word = br.readLine()
    var lt = 0
    var rt = word.length - 1
    var answer = "1"
    while (lt < rt) {
        if (word[lt] != word[rt]) {
            answer = "0"
            break
        }
        lt += 1
        rt -= 1
    }
    bw.write(answer)
    bw.flush()
}
