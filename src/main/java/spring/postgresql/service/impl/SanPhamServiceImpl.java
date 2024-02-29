package spring.postgresql.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import java.text.ParseException;

import spring.postgresql.Entity.SanPham;
import spring.postgresql.repository.SanPhamRepository;
import spring.postgresql.service.SanPhamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class SanPhamServiceImpl implements SanPhamService {
	private final SanPhamRepository sanphamRepository;
	public SanPhamServiceImpl (SanPhamRepository sanphamRepository)
	{
		this.sanphamRepository=sanphamRepository;
	}
	@Override
	public Page<SanPham> findAllSanPham(Pageable pageable) {
		// TODO Auto-generated method stub
		return sanphamRepository.findAll(pageable);
	}


	@Override
	public Optional<SanPham> findById(Long id) {
		// TODO Auto-generated method stub
		return sanphamRepository.findById(id);
	}

	@Override
	public SanPham saveSanPham(SanPham sanPham) throws IllegalArgumentException {
        // Kiểm tra id và maDanhMuc không được trống
        if (sanPham.getId() == null || sanPham.getMaDanhMuc() == null || sanPham.getMaDanhMuc().isEmpty()) {
            throw new IllegalArgumentException("Id và mã danh mục không được trống.");
        }

        // Kiểm tra ngày tạo đúng định dạng
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(sanPham.getNgayTao().toString());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Ngày tạo không đúng định dạng.");
        }

        // Kiểm tra tên sản phẩm không quá 10 ký tự
        if (sanPham.getTenSanPham().length() > 10) {
            throw new IllegalArgumentException("Tên sản phẩm không được quá 10 ký tự.");
        }

        // Lưu sản phẩm nếu các điều kiện đều đúng
        return sanphamRepository.save(sanPham);
    }

	@Override
	public SanPham updateSanPham(SanPham SanPham) {
		// TODO Auto-generated method stub
		return sanphamRepository.save(SanPham);
	}

	@Override
	public void deleteSanPham(Long id) {
		// TODO Auto-generated method stub
		sanphamRepository.deleteById(id);
	}
	@Override
	public List<SanPham> getTheoDm(String id)
	{
		return sanphamRepository.findByMaDanhMuc(id);
	}
}
