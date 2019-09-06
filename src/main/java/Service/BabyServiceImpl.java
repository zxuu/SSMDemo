package Service;

import java.util.List;


import Dao.BabyMapper;
import Entity.Baby;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class BabyServiceImpl implements BabyService {
	  @Autowired
	  BabyMapper babyDao;

	@Override
	public String getId(String name) {
		return babyDao.getId(name);
	}
	@Override
	public int getMale() {
		return babyDao.getMale();
	}
	@Override
	public int getFemale() {
		return babyDao.getFemale();
	}

	@Override
	    public int getTotal() {
	        return babyDao.getTotal();
	    }
	  @Override
	    public void addBaby(Baby baby) {
	        babyDao.addBaby(baby);
	    }
	  @Override
	    public void deleteBaby(int id) {
	        babyDao.deleteBaby(id);
	    }
	  @Override
	    public void updateBaby(Baby baby) {
	        babyDao.updateBaby(baby);
	    }
	  @Override
	    public Baby getBaby(int id) {
	        return babyDao.getBaby(id);
	    }
	  @Override
	    public List<Baby> list(int start, int count) {
	        return babyDao.list(start, count);
	    }

	@Override
	public List<Baby> selectBabys(Baby baby) {
		return babyDao.selectBabys(baby);
	}


}
