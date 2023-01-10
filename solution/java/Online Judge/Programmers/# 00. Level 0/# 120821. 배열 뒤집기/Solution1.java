public class Solution1 {
    public int[] solution(int[] num_list) {
        int lt = 0;
        int rt = num_list.length -1;
        int tmp;
        while (lt < rt) {
            tmp = num_list[lt];
            num_list[lt] = num_list[rt];
            num_list[rt] = tmp;

            lt ++;
            rt --;
        }
        return num_list;
    }
}
