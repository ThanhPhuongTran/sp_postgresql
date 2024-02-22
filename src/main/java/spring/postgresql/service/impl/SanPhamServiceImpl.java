package spring.postgresql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
	public SanPham saveSanPham(SanPham SanPham) {
		// TODO Auto-generated method stub
		return sanphamRepository.save(SanPham);
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

}
