package cntt.richard.QuanLyThuVienRB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tacgia")
public class TacGia {
	@Id
	@Column(name="matacgia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ida;     
	@Column(name="tentacgia")
	private String namea;
	public int getIda() {
		return ida;
	}
	public void setIda(int ida) {
		this.ida = ida;
	}
	public String getNamea() {
		return namea;
	}
	public void setNamea(String namea) {
		this.namea = namea;
	}
	

	
}
