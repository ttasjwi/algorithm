# Programmers 77486 : 다단계 칫솔 판매

- 난이도 : Level 3
- 다단계 사원들의 수익금 구하기
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/77486)

---

## 풀이

### Member : 사원
```java

class Member {

    private String name;
    private Member parent;
    private int money = 0;
    private final ArrayList<Member> children = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public void initParent(Member parent) {
        if (parent == null) {
            return;
        }
        this.parent = parent; // 양방향 참조 등록
        parent.children.add(this);
    }

    public void earnMoney(int money) {
        int parentMoney = money / 10;
        if (parentMoney == 0) { // 부모에게 갈 돈이 0원이면 그냥 자기가 다 가진다.
            this.money += money;
            return;
        }
        this.money += money - parentMoney; // 내가 실제 수령할 금액
        if (parent == null) {
            return; // 부모가 null -> center에 해당하는 민호는 고려하지 않는다.
        }
        parent.earnMoney(parentMoney); // 부모에게 남은 금액을 전달하고, 부모가 알아서 처리한다.
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
}

```
1. Member의 속성
   - member는 이름이 있다
   - member는 부모를 한 명 가지고, 여러명의 자식을 가질 수 있다.
   - member의 부모가 null인 경우, null은 민호로 간주한다.

2. Member의 행동
   - earnMoney(money)
     - 10%에 해당하는 금액을 부모에게 전달해야한다. 근데 10%의 금액이 0이면 그냥 자기가 다 가진다.
     - 부모가 null이면, null은 민호로 간주하고, 민호가 자신이 번 돈을 처리하는건 생각하지 않는다.
     - 90%는 자신이 갖고, 10%의 금액을 처리하는 것은 부모에게 위임한다.


### Solution
```java

public class Solution {

    public static final int PRICE_OF_BRUSHES = 100; // 칫솔의 가격

    // LinkedHashMap은 저장 순서를 유지함이 보장된다. (파이썬 딕셔너리도 3.x 기준으로 순서가 유지될 듯...)
    // key를 이름으로 하여, 이름을 통한 접근의 시간 복잡도는 O(1)이 된다.
    public final LinkedHashMap<String, Member> members = new LinkedHashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (String name : enroll) {
            members.put(name, new Member(name));
        }

        int index = 0; // index 순서대로 접근해도, members의 저장순서가 보장된다.
        for (Member member : members.values()) {
            member.initParent(members.get(referral[index])); // referral의 name에 해당하는 부모를 members에서 찾아 등록한다.
            index ++;
        }

        for (int i=0; i< seller.length; i++) {
            members.get(seller[i]).earnMoney(amount[i] * PRICE_OF_BRUSHES); // seller가 amount만큼 팔아 돈을 번다.
        }
        return members.values()
                .stream().mapToInt(Member::getMoney)
                .toArray();
    }

}
```
- 컬렉션에서 회원에 접근해야하는데, 이름으로 접근할 때 배열 구조의 자료구조에 저장할 경우, 매번 이름이 맞는 회원을 찾을 때 시간이 오래 걸릴 수밖에 없다.
- 해시테이블 형태의 자료구조에 저장함으로서, 시간 복잡도를 `O(1)`로 한다.
- 편의를 위해 저장순서를 유지할 수 있도록 `LinkedHashMap`을 사용한다. 이것은 저장순서를 유지함이 보장된다.
- 회원을 저장하고, 부모를 등록한다.
- seller 배열을 순회하면서 각각이 돈을 벌게 한다.
- 최종적으로 각각이 가진 금액을 순서대로 배열에 담아 반환한다.

---
