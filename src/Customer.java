import java.time.LocalDate;

public class Customer {
    private String Name;
    private int Frequency;
    //获取当前时间
    private LocalDate now = LocalDate.now();

    public Customer() {}

    public Customer(String name, int frequency, LocalDate now) {
        Name = name;
        Frequency = frequency;
        this.now = now;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getFrequency() {
        return Frequency;
    }

    public void setFrequency(int frequency) {
        Frequency = frequency;
    }

    public LocalDate getNow() {
        return now;
    }

    public void setNow(LocalDate now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Name：'" + Name + '\'' +
                ", Frequency：" + Frequency +
                ", now：" + now +
                '}';
    }
}