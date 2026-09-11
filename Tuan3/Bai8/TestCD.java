package Tuan3.Bai8;

import java.util.Scanner;

public class TestCD {
	public static void menu() {
        System.out.println("\n========= MENU QUAN LY CD =========");
        System.out.println("1. Nhap CD tu ban phim");
        System.out.println("2. Xoa CD theo ma");
        System.out.println("3. Cap nhat gia CD theo ma");
        System.out.println("4. In danh sach CD");
        System.out.println("5. Tinh tong thanh tien");
        System.out.println("0. Thoat");
        System.out.println("===================================");
        System.out.print("Chọn chức năng: ");
    }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhập số lượng CD tối đa có thể lưu: ");
		int n = Integer.parseInt(sc.nextLine());
		
		ListCD ds = new ListCD(n);
		
		int choice;
		do {
			menu();
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e){
				System.out.println("Lỗi nhập liệu! Vui lòng nhập lại.");
				choice=-1;
				continue;
			}
			
			switch(choice) {
				case 1:
					ds.nhapCD(sc);
					break;
				case 2:
					ds.xoaCD(sc);
					break;
				case 3:
					ds.capNhatGiaCD(sc);
					break;
				case 4:
					for(int i=1;i<5;i++) System.out.println();
					ds.inDanhSach();
					break;
				case 5:
					ds.tongThanhTien();
					break;
				case 0:
					System.out.println("Kết thúc chương trình!");
					break;
				default: System.out.println("Không hợp lệ");
			}
				
		}while(choice != 0);
		
		sc.close();
	}
}
