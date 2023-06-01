package cntt.richard.QuanLyThuVienRB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cntt.richard.QuanLyThuVienRB.models.NhaXuatBan;
import cntt.richard.QuanLyThuVienRB.repository.NhaXuatBanRepository;

@Service
public class NhaXuatBanServiceImpl implements NhaXuatBanService{
	@Autowired NhaXuatBanRepository nhaxuatbanRepository;
	@Override
	public List<NhaXuatBan> getAllNhaXuatBan() {
		// TODO Auto-generated method stub
		List<NhaXuatBan> dsNXB = nhaxuatbanRepository.findAll();
		return dsNXB;
	}

	@Override
	public boolean AddNewLoaiNhaXuatBan(NhaXuatBan NXB) {
		nhaxuatbanRepository.saveAndFlush(NXB);
		return false;
	}

	@Override
	public boolean DeleteNhaXuatBan(int id) {
		nhaxuatbanRepository.deleteById(id);
		return false;
	}
	

}
