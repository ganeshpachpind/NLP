/*
 * change path of file readFileString
 * 
 */

package opennlpdemo.test;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 *
 * @author 396460
 */

public class SentenceDetection
{
    public static void main(String args[])
    {
        sentencedemo();
    }
    /**
    * Read File and extratct string of data from file
    * @author-Ganesh Pachpind    *
    * @param path- complete path of text file to read (no absolute path)
    * @return String ,text of data from file
    * */
  public static String readFileString(String path) throws IOException
    {
        StringBuilder sb = null;
        try{
          BufferedReader br = new BufferedReader(new FileReader(path));
          sb=new StringBuilder();
          String line=br.readLine();
          while(line!=null)
          {
              sb.append(line);
              line=br.readLine();
          }
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        return new String(sb);
    }
  
  /**
   * Demo of OpenNlp Sentence detection
   * copy en-sent.bin model file in model folder or change path where this file belong
   * @return String array of sentences
   */
    public static String[] sentencedemo()
    {
        String sentences[] = null ;
        try
        {
          String paragraph = readFileString("d:\\data\\eng.txt");
          InputStream is = new FileInputStream(System.getProperty("user.dir")+"\\model\\en-sent.bin");
          SentenceModel model = new SentenceModel(is);
		  SentenceDetectorME sdetector = new SentenceDetectorME(model);
		  sentences= sdetector.sentDetect(paragraph);
          for(int i=0;i<sentences.length;i++)
          {
    	   System.out.println(sentences[i]);
          }
		  is.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
        return sentences;
    }

}
