package tmallssm.pojo;

public class Category {
    private Integer id;
    private String name;

    public void setName(String name) {
        this.name = name==null?null:name.trim();
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
