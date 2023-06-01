package cntt.richard.QuanLyThuVienRB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cntt.richard.QuanLyThuVienRB.models.LoaiSach;
import cntt.richard.QuanLyThuVienRB.repository.LoaiSachRepository;

@Service
public class LoaiSachServiceImpl implements LoaiSachService{
	@Autowired LoaiSachRepository loaisachRepository;

	@Override
	public List<LoaiSach> getAllLoaiSach() {
		// TODO Auto-generated method stub
		List<LoaiSach> dsLS = loaisachRepository.findAll();
		return dsLS; 
	}

	@Override
	public boolean AddNewLoaiSach(LoaiSach LS) {
		loaisachRepository.saveAndFlush(LS);
		return false;
	}

	@Override
	public boolean DeleteLoaiSach(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

