
package nyat_proje;

import java.sql.*;
import java.util.Scanner;

public class AkilliCihaz implements IAkilliCihaz{
    private static AkilliCihaz instance;
    
    private String durumSogutucu="Kapali";
    private String durumAkilliCihaz;
    private AkilliCihaz()
    {
    }
    public static synchronized AkilliCihaz getInstance()
    {
        if(instance==null)
        {
            instance=new AkilliCihaz();
        }
        return instance;
    }
    @Override
    public void durumAtaSogutucu(String durum)
    {
        this.durumAkilliCihaz=durum;
    }
    @Override
    public void durumAtaAkilliCihaz(String durum)
    {
        this.durumAkilliCihaz=durum;
    }
    @Override
    public void start(String durum) 
    {
        ISubject yonetici=Publisher.getInstance();
        IMerkeziIslemBirimi islem;
        islem=MerkeziIslemBirimi.getInstance(yonetici);
        durumAtaAkilliCihaz(durum);
          int secim;
        do{
            System.out.println("**********");
            System.out.println("Ana Menü");
            System.out.println("1-Sıcaklık Görüntüle");
            System.out.println("2-Soğutucu Aç");
            System.out.println("3-Soğutucu Kapa");
            System.out.println("4-Kullanıcı Ekle");
            System.out.println("5-Çıkış");
            Scanner giris = new Scanner(System.in);
            secim=giris.nextInt();
            switch (secim) {
		case 1:
                        islem.SicaklikGoruntule();
                    break;
		case 2:
                        if(durumSogutucu.equals("Kapali")){
                            islem.SogutucuAc();
                            durumSogutucu="Acik";
                        }
                        else
                            System.out.println("Soğutucu zaten açık konumda.");
                    break;
		case 3:
                        if(durumSogutucu.equals("Acik")){
                            islem.SogutucuKapa();
                            durumSogutucu="Kapali";
                        }
                        else
                            System.out.println("Soğutucu zaten kapalı konumda.");
                    break;

		case 4:
                        IKullaniciIslemleri ekle=KullaniciIslemleri.getInstance();
                        ekle.KullaniciEkle();
                    break;
                case 5:
                        System.out.println("Çıkış yapılıyor...");
                        System.exit(0);
                    break;
		default:
                    System.out.println("1-4 arasında bir sayı girmelisiniz");
		}
	}while(secim!=4);
            
    }
    
    
}
