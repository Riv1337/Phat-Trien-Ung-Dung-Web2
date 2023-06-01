package cntt.richard.QuanLyThuVienRB.services;
import java.util.List;

import org.springframework.stereotype.Service;
import cntt.richard.QuanLyThuVienRB.models.LoaiSach;

@Service
public interface LoaiSachService {
		List<LoaiSach> getAllLoaiSach();
		boolean AddNewLoaiSach(LoaiSach LS);
		boolean DeleteLoaiSach(int id);
}

