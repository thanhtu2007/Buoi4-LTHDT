package Tuan3.Bai8;

public class CD {
	private String maCD;
	private String tuaCD;
	private String caSy;
	private int soBaiHat;
	private double giaThanh;
	public String getMaCD() {
		return maCD;
	}
	public void setMaCD(String maCD) throws Exception {
		if(!maCD.isEmpty())
			this.maCD = maCD;
		else 
			throw new Exception("Ma CD khong duoc rong!");
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) throws Exception {
		if(!tuaCD.isEmpty())
			this.tuaCD = tuaCD;
		else throw new Exception("Tua CD khong duoc rong!");
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) throws Exception {
		if(soBaiHat > 0)
			this.soBaiHat = soBaiHat;
		else throw new Exception("So bai hat phai > 0");
	}
	public double getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(double giaThanh) throws Exception {
		if(soBaiHat > 0)
			this.giaThanh = giaThanh;
		else throw new Exception("Gia thanh phai > 0");
	}
	
	public String getCaSy() {
		return caSy;
	}
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	public CD(String maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) throws Exception {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setCaSy(caSy);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}
	public CD(){
	}
	
	
	public static void tieuDe() {
        System.out.println("In danh sach CD");

        for (int i = 0; i < 67; i++) System.out.print("-");
        System.out.println();

        String s = String.format(
            "|%10s|%10s|%10s|%10s|%10s|%10s|",
            "Ma CD", "Tua CD", "Ca Sy",
            "So Bai", "Don Gia", "Thanh Tien");
        System.out.println(s);

        for (int i = 0; i < 67; i++) System.out.print("-");
        System.out.println();
    }
	
	@Override
	public String toString() {
		return String.format(
	            "|%10s|%10s|%10s|%10d|%10.2f|%10.2f|",
	            maCD, tuaCD, caSy, soBaiHat, giaThanh, giaThanh * soBaiHat);
	}
	
	public static void main(String[] args) {
		tieuDe();
		
	}
	
	
	
}
