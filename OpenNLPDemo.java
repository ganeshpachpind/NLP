/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package opennlpdemo.test;

import opennlp.tools.util.Span;

/**
 * Main class file for project 
 * @author 396460
 */
public class OpenNLPDemo
{
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) 
    {
       Config.createconfig();       
       String sentences[]=SentenceDemo.sentencedemo();
       for(String s:sentences)
       {
          String tokens[]= TokenizerDemo.gettokens(s);
          Span[] names=NameFinderDemo.findnames(tokens);
          NameFinderDemo.printnames(names,tokens);
       }     
    }
   
}

