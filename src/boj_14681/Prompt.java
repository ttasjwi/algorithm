package boj_14681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Prompt {

    // 실행내용
    void run() {
        Point point = inputToPoint();
        char quadrant = point.quadrant();
        System.out.println(quadrant);
    }

    // 사용자로부터 입력을 받아 Point 객체를 반환함
    private Point inputToPoint() {
        int x = 0;
        int y = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            x = Integer.parseInt(br.readLine());
            y = Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Point point = new Point(x,y);
        return point;
    }

}