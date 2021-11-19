public abstract class Cat {
    protected String CatName;
    protected int CatAge;
    protected String Sex;
    protected double SinglePrice;

    public Cat(){}
    public Cat(String catName, int catAge, String sex, double singlePrice) {
        CatName = catName;
        CatAge = catAge;
        Sex = sex;
        SinglePrice = singlePrice;
    }

    public String getCatName() {
        return CatName;
    }

    public void setCatName(String catName) {
        CatName = catName;
    }

    public int getCatAge() {
        return CatAge;
    }

    public void setCatAge(int catAge) {
        CatAge = catAge;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public double getSinglePrice() {
        return SinglePrice;
    }

    public void setSinglePrice(double singlePrice) {
        SinglePrice = singlePrice;
    }

    @Override
    public abstract String toString();
}
