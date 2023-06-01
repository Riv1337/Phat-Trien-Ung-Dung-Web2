package cntt.richard.QuanLyThuVienRB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cntt.richard.QuanLyThuVienRB.models.Sach;

@Repository
public interface SachRepository extends JpaRepository<Sach,Integer>{

}
