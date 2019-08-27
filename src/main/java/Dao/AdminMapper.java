package Dao;

import Entity.Admin;

import java.util.List;



public interface AdminMapper {
    int getTotal();
    void addAdmin(Admin admin);
    void deleteAdmin(int id);
    void updateAdmin(Admin admin);
    Admin getAdmin(String id);
    List<Admin> list(int start, int count);
}
