package cntt.richard.QuanLyThuVienRB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="nhaxuatban")
public class NhaXuatBan {
	@Id
	@Column(name="manxb")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;     
	@Column(name="tennxb")
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
