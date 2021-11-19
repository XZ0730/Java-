import java.util.Scanner;

public class Test {


    public static void main(String[] args) {
        MyCatCafe user = new MyCatCafe();
        user.setBalance(1000);
        Cat First = new BlackCat("黑猫",10,"公",350.0);
        user.CatList.add(First);
        while (true) {//此处while语句不能再未抛出异常情况下完成不知道怎么回事，明明下面我已经抛出，捕获且输出了异常;
        try{
            System.out.println("--------o(=•ェ•=)m咖--------");
            System.out.println("1 买猫猫");
            System.out.println("2 招待客户");
            System.out.println("3 歇业");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    user.BuyCat(user.CatList);//此处调用CatList要用对象调用且在接口CatCafe中也要有这个参数;
                    break;
                case "2":
                    user.Entertain(user.CustomerList);//此处调用CustomerList要用对象调用且在接口CatCafe中也要有这个参数;
                    break;
                case "3":
                    user.Close();
                    break;
            }

        }catch(InsufficientBalanceException | CatNotFoundException e){
            e.printStackTrace();
        }
    }
    }
}

