package Service;

import Entity.Sensor;

import java.util.List;



public interface SensorService {
	/**
     * 获取到 Sensor 的总数
     * @return
     */
    int getTotal();

    /**
     * 增加一条数据
     * @param Sensor
     */
    void addSensor(Sensor sensor);

    /**
     * 删除一条数据
     * @param id
     */
    void deleteSensor(int id);

    /**
     * 更新一条数据
     * @param Sensor
     */
    void updateSensor(Sensor sensor);

    /**
     * 找到一条数据
     * @param id
     * @return
     */
    Sensor getSensor(int id);

    /**
     * 列举出从 start 位置开始的 count 条数据
     * @param start
     * @param count
     * @return
     */
    List<Sensor> list(int id);
}
