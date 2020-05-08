
package nyat_proje;

public class Eyleyici implements IEyleyici{
    private static Eyleyici instance;
    private Eyleyici()
    {
    }
    public static synchronized Eyleyici getInstance()
    {
        if(instance==null)
        {
            instance=new Eyleyici();
        }
        return instance;
    }
    @Override
    public void sogutucuAc()
    {
        IAkilliCihaz cihaz=AkilliCihaz.getInstance();
        cihaz.durumAtaSogutucu("Kapali");
        System.out.println("Sogutucu açıldı.");
    }
    
    @Override
    public void sogutucuKapa()
    {
        IAkilliCihaz cihaz=AkilliCihaz.getInstance();
        cihaz.durumAtaSogutucu("Acik");
        System.out.println("Sogutucu kapatıldı.");
    }
}
