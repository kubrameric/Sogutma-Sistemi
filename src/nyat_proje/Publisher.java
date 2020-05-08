
package nyat_proje;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{
    private static Publisher instance;
    private Publisher()
    {
    }
    public static synchronized Publisher getInstance()
    {
        if(instance==null)
        {
            instance=new Publisher();
        }
        return instance;
    }

    private List<IObserver> subscribers=new ArrayList<IObserver>();
    @Override
    public void attach(IObserver o) {
        subscribers.add(o);
    }

    @Override
    public void detach(IObserver o) {
       subscribers.remove(o);
    }

    @Override
    public void notify(String mesaj) {
         for(IObserver subscriber: subscribers) {
                subscriber.update(mesaj);
            }
    }
    
}
