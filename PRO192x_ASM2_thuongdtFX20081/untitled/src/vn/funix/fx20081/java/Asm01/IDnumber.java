package vn.funix.fx20081.java.Asm01;

import java.util.HashMap;
import java.util.Map;

public class IDnumber {

//danh sách các mã các tỉnh thành của Vệt Nam
    public static boolean ID(String key){
        Map<String, String> provinceCode = new HashMap<String, String>();
        provinceCode.put("001","Ha Noi");
        provinceCode.put("002", "Ha Giang");
        provinceCode.put("004", "Cao Bang");
        provinceCode.put("006", "Bac Can");
        provinceCode.put("008", "Tuyen Quang");
        provinceCode.put("010", "Lao Cai");
        provinceCode.put("011", "Dien Bien");
        provinceCode.put("012", "Lai Chau");
        provinceCode.put("014", "Son La");
        provinceCode.put("015", "Yen Bai");
        provinceCode.put("017", "Hoa Binh");
        provinceCode.put("019", "Thai Nguyen");
        provinceCode.put("020", "Lang Son");
        provinceCode.put("022", "Quang Ninh");
        provinceCode.put("024", "Bac Giang");
        provinceCode.put("025", "Phu Tho");
        provinceCode.put("026", "Vinh Phuc");
        provinceCode.put("027", "Bac Ninh");
        provinceCode.put("030", "Hai Duong");
        provinceCode.put("031", "Hai Phong");
        provinceCode.put("033", "Hung Yen");
        provinceCode.put("034", "Thai Binh");
        provinceCode.put("035", "Ha Nam");
        provinceCode.put("036", "Nam Dinh");
        provinceCode.put("037", "Ninh Binh");
        provinceCode.put("038", "Thanh Hoa");
        provinceCode.put("040", "Nghe An");
        provinceCode.put("042", "Ha Tinh");
        provinceCode.put("044", "Quang Binh");
        provinceCode.put("045", " Quang Tri");
        provinceCode.put("046", "Thua Thien Hue");
        provinceCode.put("048", "Da Nang");
        provinceCode.put("049", "Quang Nam");
        provinceCode.put("051", "Quang Ngai");
        provinceCode.put("052", "Binh Dinh");
        provinceCode.put("054", "Phu Yen");
        provinceCode.put("056", "Khanh Hoa");
        provinceCode.put("058", "Ninh Thuan");
        provinceCode.put("060", "Binh Thuan");
        provinceCode.put("062", "Kom Tum");
        provinceCode.put("064", "Gia Lai");
        provinceCode.put("066", "Dak Lak");
        provinceCode.put("067", "Dak Nong");
        provinceCode.put("068", "Lam Dong");
        provinceCode.put("070", "Binh Phuoc");
        provinceCode.put("072", "Tay Ninh");
        provinceCode.put("074", "Binh Duong");
        provinceCode.put("075", "Dong Nai");
        provinceCode.put("077", "Ba Ria-Vung Tau");
        provinceCode.put("079", "Ho Chi Minh");
        provinceCode.put("080", "Long An");
        provinceCode.put("082", "Tien Giang");
        provinceCode.put("083", "Ben Tre");
        provinceCode.put("084", "Tra Vinh");
        provinceCode.put("086", "Vinh Long");
        provinceCode.put("087", "Dong Thap");
        provinceCode.put("089", "An Giang");
        provinceCode.put("091", "Kien Giang");
        provinceCode.put("092", "Can Tho");
        provinceCode.put("093", "Hau Giang");
        provinceCode.put("094", "Soc Trang");
        provinceCode.put("095", "Bac Lieu");
        provinceCode.put("096", "Ca Mau");
        System.out.println("Noi sinh: " + provinceCode.get(key));
        return true;
    }

    public IDnumber() {

    }
}
