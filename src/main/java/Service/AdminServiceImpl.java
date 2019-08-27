package Service;

import java.util.List;

import Dao.AdminMapper;
import Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AdminServiceImpl implements AdminService {

	  @Autowired
	  AdminMapper adminDao;

	  @Override
	    public int getTotal() {
	        return adminDao.getTotal();
	    }
	  @Override
	    public void addAdmin(Admin admin) {
		  adminDao.addAdmin(admin);
	    }
	  @Override
	    public void deleteAdmin(int id) {
		  adminDao.deleteAdmin(id);
	    }
	  @Override
	    public void updateAdmin(Admin admin) {
		  adminDao.updateAdmin(admin);
	    }
	  @Override
	    public Admin getAdmin(String id) {
	        return adminDao.getAdmin(id);
	    }
	  @Override
	    public List<Admin> list(int start, int count) {
	        return adminDao.list(start, count);
	    }


}
