package cntt.richard.QuanLyThuVienRB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sach")
public class Sach {
	@Id
	@Column(name="masach")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	@Column(name="tensach")
	private String name;
	@ManyToOne
	@JoinColumn(name="mals")
	private LoaiSach loaisach;
	@ManyToOne
	@JoinColumn(name="matacgia")
	private TacGia tacgia;
	@ManyToOne
	@JoinColumn(name="manxb")
	private NhaXuatBan nhaxuatban;
	@Column(name="gia")
	private int price;
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
	public LoaiSach getLoaisach() {
		return loaisach;
	}
	public void setLoaisach(LoaiSach loaisach) {
		this.loaisach = loaisach;
	}
	public TacGia getTacgia() {
		return tacgia;
	}
	public void setTacgia(TacGia tacgia) {
		this.tacgia = tacgia;
	}
	public NhaXuatBan getNhaxuatban() {
		return nhaxuatban;
	}
	public void setNhaxuatban(NhaXuatBan nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	
}
