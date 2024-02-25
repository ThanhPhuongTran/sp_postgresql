package spring.postgresql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

import spring.postgresql.Entity.SanPham;
import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long>{
    List<SanPham> findByMaDanhMuc(String maDanhMuc);

}
// public interface SanPhamRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {

// }