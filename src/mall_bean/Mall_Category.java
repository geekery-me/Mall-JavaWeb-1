package mall_bean;

public class Mall_Category {
    private int cate_id;
    private String cate_name;
    private int cate_parent_id;

    @Override
    public String toString() {
        return "Mall_Category{" +
                "cate_id=" + cate_id +
                ", cate_name='" + cate_name + '\'' +
                ", cate_parent_id=" + cate_parent_id +
                '}';
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public int getCate_parent_id() {
        return cate_parent_id;
    }

    public void setCate_parent_id(int cate_parent_id) {
        this.cate_parent_id = cate_parent_id;
    }

    public Mall_Category(int cate_id, String cate_name, int cate_parent_id) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.cate_parent_id = cate_parent_id;
    }

    public Mall_Category() {
    }
}
