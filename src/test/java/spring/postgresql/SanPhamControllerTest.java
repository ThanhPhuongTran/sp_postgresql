package spring.postgresql;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import spring.postgresql.Controller.SanPhamController;
import spring.postgresql.Entity.SanPham;
import spring.postgresql.service.SanPhamService;

@WebMvcTest(SanPhamController.class)
@ExtendWith(MockitoExtension.class)
public class SanPhamControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SanPhamService sanPhamService;

    @Test
    public void testFindAllSanPham() throws Exception {
        List<SanPham> sanPhamList = Arrays.asList(new SanPham(), new SanPham());
        PageRequest pageRequest = PageRequest.of(0, 10);
        when(sanPhamService.findAllSanPham(pageRequest)).thenReturn(new PageImpl<>(sanPhamList));

        mockMvc.perform(get("/sanpham")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(sanPhamList.size()));
    }

    @Test
    public void testFindSanPhamById() throws Exception {
        Long id = 1L;
        SanPham sanPham = new SanPham();
        sanPham.setId(id);
        when(sanPhamService.findById(id)).thenReturn(Optional.of(sanPham));

        mockMvc.perform(get("/sanpham/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    public void testSaveSanPham_ValidMaDanhMuc() throws Exception {
        SanPham sanPham = new SanPham();
        sanPham.setMaDanhMuc("valid_ma_danh_muc");
        when(sanPhamService.saveSanPham(sanPham)).thenReturn(sanPham);

        mockMvc.perform(post("/sanpham")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"maDanhMuc\": \"valid_ma_danh_muc\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSaveSanPham_InvalidMaDanhMuc() throws Exception {
        SanPham sanPham = new SanPham();
        sanPham.setMaDanhMuc("invalid_ma_danh_muc");
        when(sanPhamService.saveSanPham(sanPham)).thenThrow(new RuntimeException("MaDanhMuc không hợp lệ"));

        mockMvc.perform(post("/sanpham")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"maDanhMuc\": \"invalid_ma_danh_muc\"}"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    public void testUpdateSanPham() throws Exception {
        SanPham sanPham = new SanPham();
        sanPham.setId(1L);
        when(sanPhamService.updateSanPham(sanPham)).thenReturn(sanPham);

        mockMvc.perform(put("/sanpham")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteSanPham() throws Exception {
        Long id = 1L;
        mockMvc.perform(delete("/sanpham/{id}", id))
                .andExpect(status().isOk());

        verify(sanPhamService, times(1)).deleteSanPham(id);
    }
}
