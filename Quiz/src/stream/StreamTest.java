package stream;

/**
 * @Author: nekotako
 * @Description: 参考以下程序,完成以下问题
 * @Date: 2023/11/1 19:02 星期三
 */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static List<Transaction> transactions = null;

    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
        // 1. 找出2011年发生的所有交易,并按交易额排序(从低到高)

        System.out.println("1. 找出2011年发生的所有交易,并按交易额排序(从低到高)");
        Stream<Transaction> stream = null;
        stream = transactions.stream();
        List<Transaction> list = stream.filter(x -> x.getYear() > 2011).collect(Collectors.toList());
        list.sort((a, b) -> a.getValue() - b.getValue());
        System.out.println(list);

        System.out.println("---------------------------------");
        // 2. 交易员都在哪些不同的城市工作过

        System.out.println("2. 交易员都在哪些不同的城市工作过");
        stream = transactions.stream();
        List<String> citys = stream.map(x -> x.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(citys);

        System.out.println("---------------------------------");
        // 3. 查找所有来自剑桥的交易员,并按姓名排序
        System.out.println("3. 查找所有来自剑桥的交易员,并按姓名排序");
        stream = transactions.stream();
        List<String> sorted = stream.map(x -> x.getTrader().getName()).sorted().distinct().collect(Collectors.toList());
        System.out.println(sorted);
        System.out.println("---------------------------------");
        // 4. 返回所有交易员的姓名字符串,按字母顺序排序
        System.out.println("4. 返回所有交易员的姓名字符串,按字母顺序排序");
        stream = transactions.stream();
        List<String> names = stream.map(x -> x.getTrader().getName()).distinct().sorted().collect(Collectors.toList());
        System.out.println(names);

        System.out.println("---------------------------------");
        // 5. 有没有交易员是在米兰工作的?
        System.out.println("5. 有没有交易员是在米兰工作的?");
        stream = transactions.stream();
        List<String> milan = stream.filter(x -> x.getTrader().getCity().equals("Milan")).map(x -> x.getTrader().getName()).distinct().collect(Collectors.toList());
        System.out.println(milan);
        System.out.println("---------------------------------");
        // 6. 打印生活在剑桥的交易员的所有交易额
        System.out.println("6. 打印生活在剑桥的交易员的所有交易额");
        stream = transactions.stream();
        stream.filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).forEach(System.out::println);
        System.out.println("---------------------------------");
        // 7. 所有交易中,最高的交易额是多少
        System.out.println("7. 所有交易中,最高的交易额是多少");
        stream = transactions.stream();
        Integer max = stream.map(Transaction::getValue).reduce(Integer::max).get();
        System.out.println(max);
        System.out.println("---------------------------------");
        // 8. 找到交易额最小的交易
        System.out.println("8. 所有交易中,最低的交易额是多少");
        stream = transactions.stream();
        Integer min = stream.map(Transaction::getValue).reduce(Integer::min).get();
        System.out.println(min);
    }
}

// 商人
class Trader {
    private String name;
    private String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" + "name='" + name + '\'' + ", city='" + city + '\''
                + '}';
    }
}

// 交易
class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" + "trader=" + trader + ", year=" + year
                + ", value=" + value + '}';
    }
}
