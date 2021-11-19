public class BlackCat extends Cat{
    public BlackCat(String catName, int catAge, String sex, double singlePrice) {
        super(catName, catAge, sex, singlePrice);
    }

    @Override
    public String toString() {
        return "猫类:" + CatName  +
                ", 年龄:" + CatAge +
                ", 性别:" + Sex +
                ", 单价:" + SinglePrice ;
    }
}
