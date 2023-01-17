import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> map = new HashMap<>();

        for (String[] accounts : db) {
            map.put(accounts[0], accounts[1]);
        }

        String loginId = id_pw[0];
        String password = id_pw[1];

        if (!map.containsKey(loginId)) {
            return "fail";
        } else if (!map.get(loginId).equals(password)) {
            return "wrong pw";
        } else {
            return "login";
        }
    }
}
