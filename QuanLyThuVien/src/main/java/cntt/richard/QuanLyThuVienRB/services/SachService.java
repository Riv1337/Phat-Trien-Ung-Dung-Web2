package cntt.richard.QuanLyThuVienRB.services;

import java.util.List;

import org.springframework.stereotype.Service;
import cntt.richard.QuanLyThuVienRB.models.Sach;

@Service
public interface SachService {
	List<Sach> getAllSach();
	boolean AddNewSach(Sach S);
	boolean DeleteSach(int id);
}
