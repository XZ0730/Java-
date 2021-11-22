import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class MyCatCafe implements CatCafe {
    private double Balance;//余额变量;
    Random r = new Random();//随机数种子;
    ArrayList<Cat> CatList = new ArrayList<>();//CatList集合;
    ArrayList<Customer> CustomerList = new ArrayList<>();//CustomerList集合;
    Customer nb = new Customer();//顾客对象;
    OrangeCat g = new OrangeCat();//橘猫对象,用于调用isFat的set和get,放在上面定义,不要直接用toString来输出isFat,否则一直为false;

    @Override//买猫方法重写
    public void BuyCat(ArrayList<Cat> CatList) throws InsufficientBalanceException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要购买的猫咪种类：");
        String catName = sc.nextLine();
        System.out.println("请输入猫咪年龄：");
        int catAge = sc.nextInt();
        System.out.println("请输入猫咪的性别：");
        String Sex = sc.next();//此处为输入int后继续输入string，因此不能用nextLine()而要转换为next(),或者将String输入放在int输入之前;

        if (Objects.equals(catName, "橘猫"))//equals()字符串比较;
        {
            System.out.println("是否买肥猫：");
            boolean isFat = sc.nextBoolean();
            g.setFat(isFat);//isFat变量通过封装，get()和set()来输出输入;

            Cat s = new OrangeCat(catName, catAge, Sex, 200);//Cat实例化（带参构造方法传输OrangeCat信息）;
            double money01 = getBalance();//接收店内余额然后购买，直接调用getBalance(),不用创建猫咖对象;
            money01 -= 200;
            if (money01 < 0)//余额不足异常抛出
            {
                throw new InsufficientBalanceException("余额不足");
            }
            setBalance(money01);//直接调用setBalance()方法，不用创建猫咖类对象调用;
            CatList.add(s);//添加猫咪至CatList集合
        } else if (Objects.equals(catName, "黑猫"))//equals()字符串比较;
        {
            Cat s1 = new BlackCat(catName, catAge, Sex, 350);//Cat实例化（带参构造方法传输BlackCat信息）;
            double money02 = getBalance();//直接调用getBalance(),不用创建猫咖对象;
            money02 -= 350;
            if (money02 < 0)//余额不足异常抛出;
            {
                throw new InsufficientBalanceException("余额不足");
            }
            setBalance(money02);//直接调用setBalance()方法，不用创建猫咖类对象调用;
            CatList.add(s1);//添加猫咪至CatList集合
        } else {
            System.out.println("没有售卖这种猫咪");
            return;
        }
        //给出购买成功提示
        System.out.println("购买猫咪成功");
    }


    @Override//招待顾客方法重写
    public void Entertain(ArrayList<Customer> CustomerList) throws CatNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----欢迎光临-----");
        System.out.println("请填写您的姓名：");
        String Name = sc.nextLine();
        System.out.println("请输入您想rua的次数：");
        int Frequency = sc.nextInt();
        if (CatList.size() == 0) {
            throw new CatNotFoundException("店内无猫可rua");

        }
        for (int i = 1; i <= Frequency; i++) {
            System.out.println("您第" + i + "次rua的猫咪是:");
            int kind = r.nextInt(CatList.size());//随机一个猫咪
            Cat kind01 = CatList.get(kind);//创立媒介对象，得到随机猫的信息
            System.out.println(kind01.toString());//输出猫咪toString;
            if (kind01.getCatName().equals("橘猫")) {//如果是橘猫则要额外输出判断是否为肥猫;媒介对象再调用猫名信息进一步匹配;
                System.out.println("是否为肥猫:" + g.isFat());
            }
        }
        nb.setNow(LocalDate.now());
        //创立CatCafe对象接收店内余额；
        double money = getBalance();
        money += (15 * Frequency);
        setBalance(money);
        //创建顾客对象，把键盘录入的数据赋值给顾客对象的成员变量
        nb = new Customer(Name, Frequency, LocalDate.now());
        //将顾客对象添加到集合中
        CustomerList.add(nb);
        //给出光临成功提示
        System.out.println("欢迎光临");
    }

    @Override
    public void Close() {


        if (CustomerList.size() == 0)
            System.out.println("今日无人光临");
        else {
            System.out.println("今日顾客名单:");
            System.out.println("顾客姓名\t\trua猫次数\t光临日期");
            for (Customer owner : CustomerList) {
                System.out.println(owner.getName() + "\t\t\t" + owner.getFrequency() + "\t\t\t" + owner.getNow());
            }
        }
        System.out.println("今日盈利：" + nb.getFrequency() * 15);
        System.out.println("今日歇业,啾咪~");
        System.exit(0); //JVM退出
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        this.Balance = balance;
    }
}
