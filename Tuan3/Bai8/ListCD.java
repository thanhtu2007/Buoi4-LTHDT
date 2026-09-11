package Tuan3.Bai8;

import java.util.Scanner;

public class ListCD {
	private CD[] cdr;
	private int count;
	
	/**
     * Constructor: Tạo mảng ban đầu có sức chứa là n
     * @param n Số phần tử tối đa có thể thêm.
     */
	public ListCD(int n) {
		this.cdr = new CD[n];
		this.count = 0;
	}

	public int getCount() {
		return count;
	}
	

	// ============ MỞ RỘNG MẢNG ============
	/***
	 * Tăng kích thước mảng lên gấp đôi nếu mảng đã đầy.
	 */
	public void tangKT() {
        if (cdr.length == count) {                  
            CD[] tam = new CD[cdr.length * 2];     
            System.arraycopy(cdr, 0, tam, 0, count); 
            cdr = tam;                              
        }
    }
	
	// ============ THÊM CD ============
    /**
     * Thêm 1 CD vào danh sách.
     * Kiểm tra mã có bị trùng không trước khi thêm.
     * @param crom Đối tượng CD cần thêm
     * @return true nếu thêm thành công, ngược lại false
     */
	public boolean themCD(CD crom) {
        for (int i = 0; i < count; i++) {
            if (cdr[i].getMaCD().equalsIgnoreCase(crom.getMaCD())) {
                return false; 
            }
        }
        tangKT();
        cdr[count] = crom;
        count++;
        return true;
    }
	
	
	// ============ Xóa CD ============
    /**
     * Xóa CD theo mã.
     * Dồn các phần tử phía sau lên sau khi xóa.
     * @param maXoa mã CD cần xóa
     * @return true nếu tìm thấy và xóa thành công, ngược lại false
     */
	public boolean xoa(String maXoa) {
        for (int i = 0; i < count; i++) {
            if (cdr[i].getMaCD().equalsIgnoreCase(maXoa)) {
                for (int j = i; j < count - 1; j++) {
                    cdr[j] = cdr[j + 1];
                }
                cdr[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
	
	// ============ CẬP NHẬT GIÁ ============
	/***
	 * Cập nhật giá mới cho CD theo mã
	 * @param maCD Ma CD cần cập nhật
	 * @param gia 	Giá mới cho CD 
	 * @return true nếu tìm thấy và cập nhất, ngược lại false
	 * @throws Exception
	 */
	public boolean capNhatCD(String maCD, double gia) throws Exception {
        for (int i = 0; i < count; i++) {
            if (cdr[i].getMaCD().equalsIgnoreCase(maCD)) {
                cdr[i].setGiaThanh(gia);
                return true;
            }
        }
        return false;
    }
	
	// ============ IN DANH SÁCH ============
    /**
     * In tiêu đề và toàn bộ danh sách CD
     */
    public void inDanhSach() {
        CD.tieuDe();
        for (int i = 0; i < count; i++) {
            System.out.println(cdr[i]);
        }
    }
    
    
 // ============ TỔNG THÀNH TIỀN ============
    /**
     * Tính tổng tiền của tất cả các CD
     * Thành tiền 1 CD = giaThanh * soBaiHat
     * @return tổng tiền
     */
    public float tongThanhTien() {
        float tong = 0;
        for (int i = 0; i < count; i++) {
            tong += cdr[i].getGiaThanh() * cdr[i].getSoBaiHat();
        }
        return tong;
    }
    
    // ============ NHẬP CD (nhập từ bàn phím) ============
    public void nhapCD(Scanner sc) {
        try {
            System.out.print("Nhap ma CD: ");
            String maCD = sc.nextLine();

            System.out.print("Nhap tua CD: ");
            String tuaCD = sc.nextLine();

            System.out.print("Nhap ten ca sy: ");
            String caSy = sc.nextLine();

            System.out.print("Nhap so bai hat: ");
            int soBaiHat = Integer.parseInt(sc.nextLine());

            System.out.print("Nhap don gia: ");
            double giaThanh = Double.parseDouble(sc.nextLine());

            CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
            if (themCD(cd)) {
                System.out.println("=> Them CD thanh cong!");
            } else {
                System.out.println("=> Ma CD da ton tai, them that bai!");
            }
        } catch (Exception e) {
            System.out.println("=> Loi nhap lieu: " + e.getMessage());
        }
    }
    
    // ============ Xóa CD (nhập từ bàn phím) ============
    public void xoaCD(Scanner sc) {
        System.out.print("Nhap ma CD can xoa: ");
        String maXoa = sc.nextLine();
        if (xoa(maXoa)) {
            System.out.println("=> Xoa thanh cong!");
        } else {
            System.out.println("=> Khong tim thay ma CD: " + maXoa);
        }
    }
    
    // ============ CẬP NHẬT GIÁ (nhập từ bàn phím) ============
    public void capNhatGiaCD(Scanner sc) throws Exception {
        System.out.print("Nhap ma CD can cap nhat: ");
        String maCD = sc.nextLine();
        try {
            System.out.print("Nhap gia moi: ");
            double gia = Double.parseDouble(sc.nextLine());
            if (capNhatCD(maCD, gia)) {
                System.out.println("=> Cap nhat thanh cong!");
            } else {
                System.out.println("=> Khong tim thay ma CD: " + maCD);
            }
        } catch (NumberFormatException e) {
            System.out.println("=> Gia khong hop le!");
        }
    }
    
    
}
