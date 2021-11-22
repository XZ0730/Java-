public class OrangeCat extends Cat {


    private boolean isFat;

    public OrangeCat() {
    }

    public OrangeCat(String catName, int catAge, String sex, double singlePrice) {
        super(catName, catAge, sex, singlePrice);
    }

    public boolean isFat() {
        return isFat;
    }

    public void setFat(boolean fat) {
        isFat = fat;
    }

    @Override
    public String toString() {
        return "猫类：" + CatName +
                ", 年龄：" + CatAge +
                ", 性别：" + Sex +
                ", 单价：" + SinglePrice;
    }
}
