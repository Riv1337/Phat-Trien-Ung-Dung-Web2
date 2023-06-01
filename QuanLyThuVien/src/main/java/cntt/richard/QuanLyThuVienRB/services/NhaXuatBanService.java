package cntt.richard.QuanLyThuVienRB.services;
import java.util.List;

import org.springframework.stereotype.Service;
import cntt.richard.QuanLyThuVienRB.models.NhaXuatBan;

@Service
public interface NhaXuatBanService {
		List<NhaXuatBan> getAllNhaXuatBan();
		boolean AddNewLoaiNhaXuatBan(NhaXuatBan NXB);
		boolean DeleteNhaXuatBan(int id);
}
