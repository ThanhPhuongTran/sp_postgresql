package spring.postgresql.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import spring.postgresql.Entity.DanhMuc;
import spring.postgresql.Entity.SanPham;
import spring.postgresql.service.SanPhamService;
import java.util.List;
import org.springframework.http.HttpMethod;

@RestController
@RequestMapping("/sanpham")
public class SanPhamController {
    private final SanPhamService sanphamService;
    @Autowired
	private RestTemplate restTemplate;
    public SanPhamController(SanPhamService sanPhamService) {
        this.sanphamService = sanPhamService;
    }

    @GetMapping("/theodm")
    public List<SanPham> findByMoTa(@RequestParam String id)
    {
        return sanphamService.getTheoDm(id);
    }
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
    String url = "http://danhmuc/api/dm/get/checkiddanhmuc";
        
        // Xây dựng URL với tham số từ @RequestParam
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("id", SanPham.getMaDanhMuc());
    System.err.println(builder.toUriString());
    int checkId = restTemplate.getForObject(builder.toUriString(), int.class);
  
    System.err.println("Ket Qua Check:");
    System.err.println(checkId);
    if (checkId==1)
    {
        return sanphamService.saveSanPham(SanPham);
    }
    else
    {
        throw new RuntimeException("MaDanhMuc không hợp lệ");
    }
    }
    @PutMapping
    public SanPham updateSanPham(@RequestBody SanPham SanPham) {
        return sanphamService.updateSanPham(SanPham);
    }

    @DeleteMapping("/{id}")
    public void deleteSanPham(@PathVariable("id") Long id) {
        sanphamService.deleteSanPham(id);
    }


}
