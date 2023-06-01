package cntt.richard.QuanLyThuVienRB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cntt.richard.QuanLyThuVienRB.models.TacGia;

@Repository
public interface TacGiaRepository extends JpaRepository<TacGia,Integer>{

}
