package Service;



import Dao.SensorMapper;
import Entity.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SensorServiceImpl implements SensorService {
	  @Autowired
	  SensorMapper SensorDao;

	  @Override
	    public int getTotal() {
	        return SensorDao.getTotal();
	    }
	  @Override
	    public void addSensor(Sensor sensor) {
	        SensorDao.addSensor(sensor);
	    }
	  @Override
	    public void deleteSensor(int id) {
	        SensorDao.deleteSensor(id);
	    }
	  @Override
	    public void updateSensor(Sensor sensor) {
	        SensorDao.updateSensor(sensor);
	    }
	  @Override
	    public Sensor getSensor(int id) {
	        return SensorDao.getSensor(id);
	    }
	  @Override
	    public List<Sensor> list(int id) {
	        return SensorDao.list(id);
	    }


}
