package Service;

import Entity.Urine;

import java.util.List;

public interface IUrineService {
    List<Urine> selectByCondition(Urine urine);

    void deleteRecord(String urineId);
}
