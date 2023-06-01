package cntt.richard.QuanLyThuVienRB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cntt.richard.QuanLyThuVienRB.models.LoaiSach;

@Repository
public interface LoaiSachRepository extends JpaRepository<LoaiSach,Integer>{

}
