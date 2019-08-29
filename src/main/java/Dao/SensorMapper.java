package Dao;

import Entity.Sensor;

import java.util.List;



public interface SensorMapper {

	int getTotal();
    void addSensor(Sensor sensor);
    void deleteSensor(int id);
    void updateSensor(Sensor sensor);
    Sensor getSensor(int id);
    List<Sensor> list(int id);
}
