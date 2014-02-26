/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DemoCode;

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
    
    public static void main(String args[])
    {
        String filepath="D:\\data\\ganesh.txt";
        String modeldir="D:\\data\\model\\";
        String sentences[]=SentenceDemo.detectSentence(filepath,modeldir);
        for(String sent:sentences)
        {
            String tokens[]=gettokens(sent,modeldir);
            printtokens(tokens);
        }
    }
    /**
     * Method to generate tokens for given senetnce
     * @param sentence - pass single sentence 
     * @return array of tokens 
     */
    public static String[] gettokens(String sentence,String modeldir)
    {
       String token[]=null;
       try
       {
        InputStream is=new FileInputStream(modeldir+"en-token.bin");
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
     * @param token -- array of tokens
     */
       public static void printtokens(String token[])
       {
         for(int i=0;i<token.length;i++)
        {
            System.out.println(token[i]);
        }
       }

}
