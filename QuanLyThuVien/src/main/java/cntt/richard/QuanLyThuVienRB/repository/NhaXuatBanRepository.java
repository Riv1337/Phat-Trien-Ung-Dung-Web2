package cntt.richard.QuanLyThuVienRB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cntt.richard.QuanLyThuVienRB.models.NhaXuatBan;

@Repository
public interface NhaXuatBanRepository extends JpaRepository<NhaXuatBan,Integer>{

}
