import java.util.Arrays;

public class _478 {
    double radius;
    double x_center;
    double y_center;

    public _478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        //产生一个随机数
        double x = (Math.random() * 2 - 1) * radius + x_center;
        double y = (Math.random() * 2 - 1) * radius + y_center;
        //重新产生
        while (Math.pow(x - x_center, 2) + Math.pow(y - y_center, 2) > radius * radius) {
            x = (Math.random() * 2 - 1) * radius + x_center;
            y = (Math.random() * 2 - 1) * radius + y_center;
        }
        //返回一个随机点
        return new double[]{x, y};
    }

    public static void main(String[] args) {
        _478 myCircle = new _478(3, 0, 0);
        double[] point = myCircle.randPoint();
        System.out.println(Arrays.toString(point));
    }

}
