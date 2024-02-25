package spring.postgresql.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DanhMuc {
    @JsonProperty("id")
    private String id;
    @JsonProperty("TenDanhMuc")
	private String TenDanhMuc;
    @JsonProperty("MoTa")
	private String MoTa;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTenDanhMuc() {
        return TenDanhMuc;
    }
    public void setTenDanhMuc(String tenDanhMuc) {
        TenDanhMuc = tenDanhMuc;
    }
    public String getMoTa() {
        return MoTa;
    }
    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

}
