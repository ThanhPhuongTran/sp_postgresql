package spring.postgresql.service;

import java.util.Optional;
import java.util.List;

import spring.postgresql.Entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SanPhamService {
		Page<SanPham> findAllSanPham(Pageable pageable);
		Optional<SanPham> findById(Long id);
		List<SanPham> getTheoDm(String id);
	 	SanPham saveSanPham(SanPham SanPham);
	 	SanPham updateSanPham(SanPham SanPham);
	    void deleteSanPham(Long id);
}
