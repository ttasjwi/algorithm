package boj_14681;

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 이 점이 속한 사분면을 문자로 반환
    char quadrant() {
        char quadrant = ' ';
        if (x>0 && y>0) quadrant = '1';
        if (x<0 && y>0) quadrant = '2';
        if (x<0 && y<0) quadrant = '3';
        if (x>0 && y<0) quadrant = '4';
        return quadrant;
    }
}