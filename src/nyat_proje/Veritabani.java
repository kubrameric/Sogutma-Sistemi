
package nyat_proje;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Veritabani implements IVeritabani{
    private static Veritabani instance;
    private Veritabani()
    {
    }
    public static synchronized Veritabani getInstance()
    {
        if(instance==null)
        {
            instance=new Veritabani();
        }
        return instance;
    }

    private int kullaniciSayisi=1;
    @Override
    public boolean KullaniciDogrula(String kullaniciAdi,String sifre)
    {
        try{
            Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NYAT", "postgres", "123456");
            /*if(conn!=null)
                System.out.println("Veritabanına başarılı bir şekilde bağlandı.");
            else
                System.out.println("Veritabanına bağlanılamadı.");
            */
            String sql="SELECT \"kullaniciAdi\" , \"sifre\" FROM \"Kullanicilar\"";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                String kullaniciAdi_v=rs.getString("kullaniciAdi");
                String sifre_v=rs.getString("sifre");
                if(kullaniciAdi.equals(kullaniciAdi_v)&&sifre.equals(sifre_v))//girilen degerlerle veritabanından dogrulama yapar
                {
                    IObserver kullanici=Kullanici.getInstance(kullaniciAdi);
                    ISubject yonetici=Publisher.getInstance();
                    yonetici.attach(kullanici);
                    return true;
                }
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    @Override
    public boolean KullaniciEkle(String kullaniciAdi,String Sifre)
    {
        try{
        Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NYAT", "postgres", "123456");
        String sql_="SELECT \"akilliCihaz\"  FROM \"Kullanicilar\"";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql_);
        int akilliCihaz;
        int sayi=KullaniciSayisiBul();
        rs.next();
        akilliCihaz=rs.getInt("akilliCihaz");
        String sql= "Insert Into \"Kullanicilar\" (\"kullaniciNo\" ,\"kullaniciAdi\" , \"sifre\" , \"akilliCihaz\") VALUES(?,?,?,?)";
                PreparedStatement preparedStatement=conn.prepareStatement(sql);
                preparedStatement.setInt(1,sayi);
                preparedStatement.setString(2, kullaniciAdi);
                preparedStatement.setString(3, Sifre);
                preparedStatement.setInt(4,akilliCihaz);
                 preparedStatement.executeUpdate();
                conn.close();
        
        
        System.out.println(kullaniciAdi+" isimli kullanici basariyla eklendi");
        } catch (SQLException ex) {
            Logger.getLogger(Veritabani.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public int KullaniciSayisiBul() throws SQLException
    {
        Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NYAT", "postgres", "123456");
        String sql_="SELECT \"akilliCihaz\"  FROM \"Kullanicilar\"";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql_);
        while(rs.next())
        {
            kullaniciSayisi++;
        }
        return kullaniciSayisi;
    
    }
}
