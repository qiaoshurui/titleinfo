package modle;

/**
 * 题目类型信息
 */

public class Type {
    private int id;
    private String name;
    private String info;
    public Type() {
        super();
    }
    public Type(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String toString(){
        return this.name;
    }
}
