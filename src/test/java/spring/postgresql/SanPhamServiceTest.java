package spring.postgresql;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import spring.postgresql.Entity.SanPham;
import spring.postgresql.repository.SanPhamRepository;
import spring.postgresql.service.impl.SanPhamServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SanPhamServiceTest {
  @Mock
    private SanPhamRepository sanPhamRepository;

    @InjectMocks
    private SanPhamServiceImpl sanPhamService;

    private SanPham testSanPham;

    @BeforeEach
    void setUp() {
        testSanPham = new SanPham();
        testSanPham.setId(1L);
        testSanPham.setTenSanPham("Test SanPham");
    }

    @Test
    void testFindAllSanPham() {
        // Arrange
        Page<SanPham> expectedPage = mock(Page.class);
        when(sanPhamRepository.findAll(any(Pageable.class))).thenReturn(expectedPage);

        // Act
        Page<SanPham> result = sanPhamService.findAllSanPham(mock(Pageable.class));

        // Assert
        assertEquals(expectedPage, result);
    }

    @Test
    void testFindById() {
        // Arrange
        when(sanPhamRepository.findById(1L)).thenReturn(Optional.of(testSanPham));

        // Act
        Optional<SanPham> result = sanPhamService.findById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(testSanPham, result.get());
    }

    @Test
    void testSaveSanPham() {
        // Arrange
        when(sanPhamRepository.save(testSanPham)).thenReturn(testSanPham);

        // Act
        SanPham result = sanPhamService.saveSanPham(testSanPham);

        // Assert
        assertEquals(testSanPham, result);
    }

    @Test
    void testUpdateSanPham() {
        // Arrange
        when(sanPhamRepository.save(testSanPham)).thenReturn(testSanPham);

        // Act
        SanPham result = sanPhamService.updateSanPham(testSanPham);

        // Assert
        assertEquals(testSanPham, result);
    }

    @Test
    void testDeleteSanPham() {
        // Arrange

        // Act
        sanPhamService.deleteSanPham(1L);

        // Assert
        verify(sanPhamRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetTheoDm() {
        // Arrange
        String maDanhMuc = "1";
        List<SanPham> expectedList = new ArrayList<>();
        expectedList.add(testSanPham);
        when(sanPhamRepository.findByMaDanhMuc(maDanhMuc)).thenReturn(expectedList);

        // Act
        List<SanPham> result = sanPhamService.getTheoDm(maDanhMuc);

        // Assert
        assertEquals(expectedList, result);
    }
}
