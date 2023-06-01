package cntt.richard.QuanLyThuVienRB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cntt.richard.QuanLyThuVienRB.models.TacGia;
import cntt.richard.QuanLyThuVienRB.repository.TacGiaRepository;

@Service
public class TacGiaServiceImpl implements TacGiaService{
	@Autowired TacGiaRepository tacgiaRepository;
	@Override
	public List<TacGia> getAllTacGia() {
		List<TacGia> dsTG = tacgiaRepository.findAll();
		return dsTG;
	}

	@Override
	public boolean AddNewTacGia(TacGia TG) {
		tacgiaRepository.saveAndFlush(TG);
		return false;
	}

	@Override
	public boolean DeleteTacGia(int id) {
		tacgiaRepository.deleteById(id);
		return false;
	}

}
