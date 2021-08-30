package mall_user_servlet;

import mall_bean.Mall_User;

import java.util.ArrayList;

public interface UserDao {
    /**
     * 添加用户
     */
    public  int adduser(Mall_User user);


    /**
     * 删除用户
     */
    public int deleteusers(Object... objects);

    /**
     * 修改用户数据
     */
    public int updateuser(Object... objects);

    /**
     * 查询用户
     * @return 结果集
     */
    public ArrayList<Mall_User> queryAll(int cpage, int count, String keyword);
}
