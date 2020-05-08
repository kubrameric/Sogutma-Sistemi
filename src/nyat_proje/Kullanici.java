
package nyat_proje;

public class Kullanici implements IObserver{
    private static Kullanici instance;
    private String kullaniciAdi;
    private Kullanici(String kullaniciAdi)
    {
        this.kullaniciAdi=kullaniciAdi;
    }
    public static synchronized Kullanici getInstance(String kullaniciAdi)
    {
        if(instance==null)
        {
            instance=new Kullanici(kullaniciAdi);
        }
        
        return instance;
    }
    @Override
    public void update(String mesaj) {
        System.out.println(kullaniciAdi+ " kullanıcısına gelen duyuru:  " + mesaj );

    }
    
}
