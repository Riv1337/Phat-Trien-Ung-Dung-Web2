package cntt.richard.QuanLyThuVienRB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cntt.richard.QuanLyThuVienRB.models.Sach;
import cntt.richard.QuanLyThuVienRB.repository.SachRepository;

@Service
public class SachServiceImpl implements SachService{
	@Autowired SachRepository sachRepository;
	
	@Override
	public List<Sach> getAllSach() {
		
		List<Sach> dsS= sachRepository.findAll();
		return dsS;
	}

	@Override
	public boolean AddNewSach(Sach S) {
		sachRepository.saveAndFlush(S);
		return false;
	}

	@Override
	public boolean DeleteSach(int id) {
		sachRepository.deleteById(id);
		return false;
	}

	

}
