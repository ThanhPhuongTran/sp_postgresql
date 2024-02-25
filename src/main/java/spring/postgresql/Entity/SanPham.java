package spring.postgresql.Entity;

import java.sql.Date;
import jakarta.persistence.*;
@Entity
@Table(name= "SanPham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="TenSanPham")
	private String TenSanPham;
	@Column(name="NgayTao")
	private Date NgayTao;
	@Column(name="SoLuong")
	private int SoLuong;
	@Column(name="MoTa")
	private String moTa;
	@Column(name="Gia")
	private Long Gia;
	@Column(name="SanPhamTot")
	private int SanPhamTot;
	@Column(name="MaDanhMuc")
	private String maDanhMuc;

    public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public SanPham(int id, String tenSanPham, Date ngayTao, int soLuong, String moTa, Long gia, int sanPhamTot,
			String maDanhMuc) {
		this.id = id;
		TenSanPham = tenSanPham;
		NgayTao = ngayTao;
		SoLuong = soLuong;
		this.moTa = moTa;
		Gia = gia;
		SanPhamTot = sanPhamTot;
		this.maDanhMuc = maDanhMuc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenSanPham() {
		return TenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}

	public Date getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Long getGia() {
		return Gia;
	}

	public void setGia(Long gia) {
		Gia = gia;
	}

	public int getSanPhamTot() {
		return SanPhamTot;
	}

	public void setSanPhamTot(int sanPhamTot) {
		SanPhamTot = sanPhamTot;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	
	
	
}
