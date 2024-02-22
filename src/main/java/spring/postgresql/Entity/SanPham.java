package spring.postgresql.Entity;

import java.sql.Date;
import jakarta.persistence.*;
@Entity
@Table(name= "SanPham")
public class SanPham {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="TenSanPham")
	private String TenSanPham;
	@Column(name="NgayTao")
	private Date NgayTao;
	@Column(name="SoLuong")
	private int SoLuong;
	@Column(name="MoTa")
	private String MoTa;
	@Column(name="Gia")
	private Long Gia;
	@Column(name="SanPhamTot")
	private int SanPhamTot;

    public SanPham() {
		// TODO Auto-generated constructor stub
	}

	public SanPham(Long id, String tenSanPham, Date ngayTao, int soLuong, String moTa, Long gia, int sanPhamTot) {
		this.id=id;
		this.TenSanPham = tenSanPham;
		this.NgayTao = ngayTao;
		this.SoLuong = soLuong;
		this.MoTa = moTa;
		this.Gia = gia;
		this.SanPhamTot = sanPhamTot;
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
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
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
}
