package spring.postgresql.Controller;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.postgresql.Entity.SanPham;
import spring.postgresql.service.SanPhamService;

@RestController
@RequestMapping("/sanpham")
public class SanPhamController {
    private final SanPhamService sanphamService;

    public SanPhamController(SanPhamService sanPhamService) {
        this.sanphamService = sanPhamService;
    }

    // @GetMapping
    // public List<SanPham> findAllSanPham() {
    // return sanphamService.findAllSanPham();
    // }
    @GetMapping
    public Page<SanPham> findAllSanPham(@RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());

        return sanphamService.findAllSanPham(paging);
    }

    @GetMapping("/{id}")
    public Optional<SanPham> findSanPhamById(@PathVariable("id") Long id) {
        return sanphamService.findById(id);
    }

    @PostMapping
    public SanPham saveSanPham(@RequestBody SanPham SanPham) {
        return sanphamService.saveSanPham(SanPham);
    }

    @PutMapping
    public SanPham updateSanPham(@RequestBody SanPham SanPham) {
        return sanphamService.updateSanPham(SanPham);
    }

    @DeleteMapping("/{id}")
    public void deleteSanPham(@PathVariable("id") Long id) {
        sanphamService.deleteSanPham(id);
    }

    // Using Request and Response with save and update SanPham

}
