import java.util.ArrayList;
import java.util.LinkedHashMap;

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
