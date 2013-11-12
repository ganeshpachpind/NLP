/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package opennlpdemo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Ganesh Pachpind
 */
public class Config
{
    public static void createconfig()
    {
        try{
        Properties prop=new Properties();
        prop.setProperty("readfile","d:\\data\\eng.txt");
        prop.setProperty("modelpath",System.getProperty("user.dir")+"\\model\\");
        prop.store(new FileOutputStream("config.properties"), null);
        }
        catch (IOException ex)
        {
          System.out.println("File Loading error"+ex.toString());

        }
    }
  public static Properties load() throws FileNotFoundException, IOException
  {
    Properties prop=new Properties();
    prop.load(new FileInputStream("config.properties"));
    return prop;
   }

}
