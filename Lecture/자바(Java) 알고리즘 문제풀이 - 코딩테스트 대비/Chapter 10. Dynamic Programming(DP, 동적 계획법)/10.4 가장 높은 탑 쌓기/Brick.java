public class Brick implements Comparable<Brick> {

    int area; // 밑면의 넓이
    int height; // 높이
    int weight; // 무게

    public Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    // 넓이를 기준으로 오름차순 정렬
    @Override
    public int compareTo(Brick other) {
        return this.area - other.area;
    }

}
