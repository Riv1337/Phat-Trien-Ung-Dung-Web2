package cntt.richard.QuanLyThuVienRB.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cntt.richard.QuanLyThuVienRB.models.TacGia;

@Service
public interface TacGiaService {
	List<TacGia> getAllTacGia();
	boolean AddNewTacGia(TacGia TG);
	boolean DeleteTacGia(int id);
	

}
