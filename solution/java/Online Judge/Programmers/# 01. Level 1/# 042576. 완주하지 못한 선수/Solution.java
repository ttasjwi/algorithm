import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<String, Integer> participantCounter = new HashMap<>();
    private final Map<String, Integer> completionCounter = new HashMap<>();

    public String solution(String[] participants, String[] completions) {
        participantCounting(participants);
        completionCounting(completions);
        return findDropOut();
    }

    private void participantCounting(String[] participants) {
        for (String participant : participants) {
            participantCounter.put(participant, participantCounter.getOrDefault(participant, 0) + 1);
        }
    }

    private void completionCounting(String[] completions) {
        for (String completion : completions) {
            completionCounter.put(completion, completionCounter.getOrDefault(completion, 0) + 1);
        }
    }

    private String findDropOut() {
        String answer = "";
        for (Map.Entry<String, Integer> entry : participantCounter.entrySet()) {
            String participant = entry.getKey();
            int count = entry.getValue();
            if (!completionCounter.containsKey(participant) || count != completionCounter.get(participant)) {
                answer = participant;
                break;
            }
        }
        return answer;
    }

}
