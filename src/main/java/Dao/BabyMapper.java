package Dao;

import Entity.Baby;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyMapper {
    String getId(String name);
    int getMale();
    int getFemale();

    int getTotal();
    void addBaby(Baby baby);
    void deleteBaby(int id);
    void updateBaby(Baby baby);
    Baby getBaby(int id);
    List<Baby> list(int start, int count);
}
