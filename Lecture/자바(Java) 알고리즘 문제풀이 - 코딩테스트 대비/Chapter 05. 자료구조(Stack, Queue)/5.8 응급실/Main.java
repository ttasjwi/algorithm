import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 환자수
        int m = Integer.parseInt(st.nextToken()); // m번째 환자는 몇 번째로 진료 받는가?

        Person[] people = new Person[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int level = Integer.parseInt(st.nextToken());
            people[i] = new Person(i, level);
        }
        br.close();

        int answer = solution(people, n, m);
        System.out.print(answer);
    }

    private static int solution(Person[] people, int n, int m) {
        int answer = 0; // 진료를 본 사람의 수
        Queue<Person> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            q.offer(people[i]);
        }

        while(!q.isEmpty()) {
            Person current = q.poll();
            for (Person other : q) {
                if (current.level < other.level) {
                    // 나머지 사람들 중에 우선순위가 높은 사람이 있다면
                    q.offer(current);
                    current = null;
                    break;
                }
            }
            if (current != null) {
                answer ++;
                if (current.id == m) break;
            }
        }
        return answer;
    }

}

class Person {

    int id;
    int level;

    public Person (int id, int level) {
        this.id = id;
        this.level = level;
    }

}
