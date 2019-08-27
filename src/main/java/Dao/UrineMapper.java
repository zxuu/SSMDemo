package Dao;

import Entity.Urine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrineMapper {
    List<Urine> selectByCondition(Urine urine);

    void deleteRecord(String urineId);

    void insertRecord(Urine urine);
}
