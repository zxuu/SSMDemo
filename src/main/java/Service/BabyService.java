package Service;

import Entity.Baby;

import java.util.List;



public interface BabyService {

    String getId(String name);
    int getMale();
    int getFemale();

    /**
     * 获取到 Baby 的总数
     * @return
     */
    int getTotal();

    /**
     * 增加一条数据
     */
    void addBaby(Baby baby);

    /**
     * 删除一条数据
     * @param id
     */
    void deleteBaby(int id);

    /**
     * 更新一条数据
     */
    void updateBaby(Baby baby);

    /**
     * 找到一条数据
     * @param id
     * @return
     */
    Baby getBaby(int id);

    /**
     * 列举出从 start 位置开始的 count 条数据
     * @param start
     * @param count
     * @return
     */
    List<Baby> list(int start, int count);

    List<Baby> selectBabys(Baby baby);
}
