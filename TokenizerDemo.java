/*
 * Need TO Pass Sentences 
 */

package opennlpdemo.test;

import java.io.FileInputStream;
import java.io.InputStream;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

/**
 *
 * @author Ganesh Pachpind
 */
public class TokenizerDemo
{
    public static String[] gettokens(String sentence)
    {
       String token[]=null;
       try
       {
        InputStream is=new FileInputStream(Config.load().getProperty("modelpath")+"en-token.bin");
        TokenizerModel model=new TokenizerModel(is);
        Tokenizer tokenizer=new TokenizerME(model);
        token=tokenizer.tokenize(sentence);
       // printtokens(token);
        is.close();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
       return token;
    }
    
    /**
     * Use when need to print tokens 
     * @param token
     */
       public static void printtokens(String token[])
       {
         for(int i=0;i<token.length;i++)
        {
            System.out.println(token[i]);
        }
       }

}
