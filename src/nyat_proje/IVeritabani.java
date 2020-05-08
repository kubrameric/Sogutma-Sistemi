
package nyat_proje;

import java.sql.SQLException;

public interface IVeritabani {
    public boolean KullaniciDogrula(String kullaniciAdi,String sifre);
    public boolean KullaniciEkle(String kullaniciAdi,String Sifre); 
}
