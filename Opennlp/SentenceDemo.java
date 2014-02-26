/**
 * This Package Contain all Demo-codes for OpenNLP
 */

package DemoCode;
import java.io.BufferedReader;
import opennlpdemo.test.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

/**
 * @author Ganesh Pachpind
 */

public class SentenceDemo
{   
    
    public static void main(String args[])
    {
        String sentences[]=detectSentence("D:\\data\\ganesh.txt","D:\\data\\model\\");
        printsentence(sentences);
    }
  
  /**
   * Demo of OpenNlp Sentence detection
   * copy en-sent.bin model file in model folder or change path to folder where this file belong
   * @param filepath  -- text file path to detect sentences 
   * @param modeldir  -- directory which contain en.sent.bin model
   * @return String array of sentences
   */
    public static String[] detectSentence(String filepath,String modeldir)
    {
        String sentences[] = null ;
        try
        {          
          String paragraph = readFileString(filepath);
          InputStream is = new FileInputStream(modeldir+"en-sent.bin");
          SentenceModel model = new SentenceModel(is);
          SentenceDetectorME sdetector = new SentenceDetectorME(model);
          sentences= sdetector.sentDetect(paragraph);         
          is.close();          
        }
        catch(IOException ex)
        {
            System.out.println(ex.toString());
        }
        return sentences;
    }

    /**
     * Use if need to print sentences 
     * @param sentences --array of sentences 
     */
    public static void printsentence(String sentences[])
    {
        System.out.println("Number of Sentence Identified :"+sentences.length);
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
    /**
    * Read File and extratct string of data from file
    * @author-Ganesh Pachpind    *
    * @param path- complete path of text file to read (no absolute path)
    * @return String ,text of data from file
    * */

  public static String readFileString(String path) 
    {

        StringBuilder sb = null;
        BufferedReader br =null;
        try
        {
          br = new BufferedReader(new FileReader(path));
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
        finally
        {
            try{
            br.close();
            }catch(Exception e)
            {
                System.out.println("Exception closing file!!!"+e.toString());
            }
        }
         return new String(sb);
    }


}
