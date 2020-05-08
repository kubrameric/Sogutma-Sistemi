/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nyat_proje;

import java.util.Random;

/**
 *
 * @author kubra
 */
public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    private static SicaklikAlgilayici instance;
    private SicaklikAlgilayici()
    {
    }
    public static synchronized SicaklikAlgilayici getInstance()
    {
        if(instance==null)
        {
            instance=new SicaklikAlgilayici();
        }
        return instance;
    }
    @Override
    public int sicaklikDegeriAl()
    {
            Random sıcaklık=new Random();
           return sıcaklık.nextInt(50);
    }
}
