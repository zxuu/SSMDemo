package Service;

import Entity.Admin;

import java.util.List;



public interface AdminService {
	 /**
     * 获取到 Admin 的总数
     * @return
     */
    int getTotal();

    /**
     * 增加一条数据
     * @param Admin
     */
    void addAdmin(Admin admin);

    /**
     * 删除一条数据
     * @param id
     */
    void deleteAdmin(int id);

    /**
     * 更新一条数据
     * @param Admin
     */
    void updateAdmin(Admin admin);

    /**
     * 找到一条数据
     * @param id
     * @return
     */
    Admin getAdmin(String id);

    /**
     * 列举出从 start 位置开始的 count 条数据
     * @param start
     * @param count
     * @return
     */
    List<Admin> list(int start, int count);
    
    
}
