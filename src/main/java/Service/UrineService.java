package Service;

import Dao.UrineMapper;
import Entity.Urine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrineService implements IUrineService{
    @Autowired
    private UrineMapper urineMapper;

    @Override
    public List<Urine> selectByCondition(Urine urine) {

        return urineMapper.selectByCondition(urine);
    }

    @Override
    public void deleteRecord(String urineId) {
        urineMapper.deleteRecord(urineId);
    }

    @Override
    public void insertRecord(Urine urine) {
        urineMapper.insertRecord(urine);
    }
}
