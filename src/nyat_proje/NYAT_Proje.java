
package nyat_proje;
import java.util.Scanner;
public class NYAT_Proje {
    public static void main(String[] args) throws InterruptedException {
        
        String kullaniciAdi;
        String sifre;
        System.out.println("Kullanici Adi:");
        Scanner giris = new Scanner(System.in);
        kullaniciAdi=giris.next();
        System.out.println("Sifre:");
        sifre=giris.next();
        IVeritabani dogrula;
        dogrula=Veritabani.getInstance();
        if(dogrula.KullaniciDogrula(kullaniciAdi, sifre)){
            System.out.println("Başaralı giris islemi.");
            IAkilliCihaz akilliCihaz=AkilliCihaz.getInstance();
            akilliCihaz.start("bekleme");
        }
        else
            System.out.println("Sifre veya kullanici adi hatali.");
        
    }
}
