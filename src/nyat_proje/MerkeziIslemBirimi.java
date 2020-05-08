
package nyat_proje;

public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    private static MerkeziIslemBirimi instance;
    private final ISubject yonetici;
    private MerkeziIslemBirimi(ISubject yonetici)
    {
        this.yonetici=yonetici;
    }
    public static synchronized MerkeziIslemBirimi getInstance(ISubject yonetici)
    {
        if(instance==null)
        {
            instance=new MerkeziIslemBirimi(yonetici);
        }
        return instance;
    }
   // ISicaklikAlgilayici algilayici;
    @Override
    public void SicaklikGoruntule(){
        ISicaklikAlgilayici algilayici;
        algilayici=SicaklikAlgilayici.getInstance();
        int sicaklik=algilayici.sicaklikDegeriAl();
        System.out.println("**********************");
        System.out.println("Ölçülen sıcaklık değeri: "+sicaklik);
        if(sicaklik>30)
           yonetici.notify("Sıcaklık değeri çok yüksek. Soğutucuyu açmanız önerilir. ");
        if(sicaklik<15)
           yonetici.notify("Sıcaklık değeri çok düşük. Soğutucuyu kapamanız önerilir. ");
       
    }

    @Override
    public void SogutucuKapa() {
        IEyleyici eyleyici=Eyleyici.getInstance();
        eyleyici.sogutucuKapa();
    }

    @Override
    public void SogutucuAc() {
        IEyleyici eyleyici=Eyleyici.getInstance();
        eyleyici.sogutucuAc();
    }
    
    
}
