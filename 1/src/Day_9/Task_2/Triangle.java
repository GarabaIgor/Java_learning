package Day_9.Task_2;

class Triangle extends Figure {
    private double firstSideLen;
    private double secondSideLen;
    private double thirdSideLen;

    public Triangle(double firstSideLen, double secondSideLen, double thirdSideLen, String color) {
        super(color);
        this.firstSideLen = firstSideLen;
        this.secondSideLen = secondSideLen;
        this.thirdSideLen = thirdSideLen;
    }

    public double getFirstSideLen() {
        return firstSideLen;
    }

    public void setFirstSideLen(double firstSideLen) {
        this.firstSideLen = firstSideLen;
    }

    public double getSecondSideLen() {
        return secondSideLen;
    }

    public void setSecondSideLen(double secondSideLen) {
        this.secondSideLen = secondSideLen;
    }

    public double getThirdSideLen() {
        return thirdSideLen;
    }

    public void setThirdSideLen(double thirdSideLen) {
        this.thirdSideLen = thirdSideLen;
    }

    @Override
    public double area() {
        double halfP = perimeter() / 2;
        return Math.sqrt(halfP * (halfP - firstSideLen) * (halfP - secondSideLen) * (halfP - thirdSideLen));
    }

    @Override
    public double perimeter() {
        return firstSideLen + secondSideLen + thirdSideLen;
    }
}
