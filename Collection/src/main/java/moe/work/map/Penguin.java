package moe.work.map;

/**
 * @Author: nekotako
 * @Description: TODO
 * @Date: 2023/8/31 19:25 星期四
 */

public class Penguin {
    private String name;
    private String alias;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Penguin(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }
}

