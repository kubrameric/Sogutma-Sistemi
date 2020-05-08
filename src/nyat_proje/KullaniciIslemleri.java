/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nyat_proje;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kubra
 */
public class KullaniciIslemleri implements IKullaniciIslemleri{
     private static KullaniciIslemleri instance;
    private KullaniciIslemleri()
    {
    }
    public static synchronized KullaniciIslemleri getInstance()
    {
        if(instance==null)
        {
            instance=new KullaniciIslemleri();
        }
        return instance;
    }
    @Override
    public void KullaniciEkle() {
        Scanner giris = new Scanner(System.in);
        System.out.println("Soğutucunuza Eklenecek üyenin;");
        System.out.println("Kullanıcı Adı:");
        String kullaniciAdi=giris.next();
        System.out.println("Şifre:");
        String sifre=giris.next();
        IVeritabani vt=Veritabani.getInstance();
        vt.KullaniciEkle(kullaniciAdi, sifre);
        
    }
}
