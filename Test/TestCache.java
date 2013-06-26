package Test;


/**
 *
 * @author guillem
 */
import SimCache.LRUCache;
import SimCache.MRUCache;
import java.util.ArrayList;
import java.util.List;

public class TestCache {
    
    public static void main(String args[ ]){
        
        TestLRU4();
        TestLRU7();
        
        TestFIFO4();
        TestFIFO7();
        
        TestMRU4();
        TestMRU7();
        TestMRU16();
        
        TestPLRU4();
        TestPLRU8();
        TestPLRU16();
        
    }
    

    
    public static boolean TestLRU4 (){
        
        System.out.println("Testing LRU 4");
     
        // LRU 4
        boolean[] miss = {false, false, false, true, false, false, false, true} ;
        char[] words = {'A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.LRUCache Test = new SimCache.LRUCache(4);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
    
    public static boolean TestLRU7 (){
            
        
        System.out.println("Testing LRU 7");
     
        boolean[] miss = {false, false, false, true, true, true, false, false, false, false, true, false, false, true, false} ;
        char[] words = {'A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G','F', 'H', 'A', 'B', 'C'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.LRUCache Test = new SimCache.LRUCache(7);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
        
    public static boolean TestFIFO4 (){
        
            
        
        System.out.println("Testing FIFO 4");
     
        // FIFO 4  
        boolean[] miss = {false, false, false, true, false, false, true, false};
        char[] words = {'A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.FIFOCache Test = new SimCache.FIFOCache(4);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
        
        
    public static boolean TestFIFO7 (){
        
        System.out.println("Testing FIFO 7");
        
        // FIFO 7  
        boolean[] miss = {false, false, false, true, true, true, false, false,false, false, true, false, false, false, false, true};
        char[] words = {'A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G','F', 'H', 'A', 'B', 'C', 'F'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.FIFOCache Test = new SimCache.FIFOCache(7);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
    
    public static boolean TestMRU4 (){
     
        
        System.out.println("Testing MRU 4");
     
        boolean[] miss = {false, false, false, true, false, false, true, false};
        char[] words = {'A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.MRUCache Test = new SimCache.MRUCache(4);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
    
    
    public static boolean TestMRU7 (){
     
        
        System.out.println("Testing MRU 7");
     
        boolean[] miss = {false, false, false, true, true, true, false, false, 
             false, false, true, false, false, false, false, true};
        char[] words = {'A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G',
            'F', 'H', 'A', 'B', 'C', 'F'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.MRUCache Test = new SimCache.MRUCache(7);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }


    public static boolean TestPLRU4 (){
          
     
        System.out.println("Testing PLRU 4");
     
        boolean[] miss = {false, false, false, true, false, false, true, true} ;
        char[] words = {'A', 'B', 'C', 'A', 'D', 'E', 'B', 'A'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.PLRUCache Test = new SimCache.PLRUCache(4);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }

 
 public static boolean TestPLRU16 (){
          
     
        System.out.println("Testing PLRU 16");
     
        boolean[] miss = {false, false, false, true, false, false, true, true, 
             false, true, false, true, true, false, false, true, true, 
             false, false, false, false, false, false, false, false, false, 
             true, true, true, false, true, false} ;
        char[] words = {'A', 'B', 'C', 'A', 'D', 'E', 'B', 'A', 'F', 'A', 'G','A', 
            'B', 'H', 'I', 'A', 'C', 'J', 'K', 'L', 'M', 'N', 'O','P', 'X', 'Y', 
            'A', 'B', 'C', 'D', 'E', 'F'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.PLRUCache Test = new SimCache.PLRUCache(16);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
 
 public static boolean TestPLRU8 (){
          
     
        System.out.println("Testing PLRU 8");
     
        boolean[] miss = {false, false, false, true, true, true, false, false, 
             false, false, true, false, true, true, true, true} ;
        char[] words = {'A', 'B', 'C', 'A', 'C', 'B', 'D', 'E', 'F', 'G',
            'F', 'H', 'A', 'B', 'C', 'F'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.PLRUCache Test = new SimCache.PLRUCache(8);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
    public static boolean TestMRU16 (){
     
        
        System.out.println("Testing MRU 16");
     
        boolean[] miss = {false, false, false, true, false, false, true, true, 
             false, true, false, true, true, false, false, true, true, 
             false, false, false, false, false, false, false, false, false, 
             true, false, false, false, false, false};
        char[] words = {'A', 'B', 'C', 'A', 'D', 'E', 'B', 'A', 'F', 'A', 'G', 
             'A', 'B', 'H', 'I', 'A', 'C', 'J', 'K', 'L', 'M', 'N', 'O',
             'P', 'X', 'Y', 'C', 'A', 'B', 'D', 'E', 'F'};
        
        boolean[] result = new boolean[miss.length];
        SimCache.MRUCache Test = new SimCache.MRUCache(16);
        
        for(int i=0;words.length>i;i++){
            
            result[i] = Test.access(words[i]);
            
            if (result[i]!=miss[i]){
                System.out.println("... ERROR");
                System.out.println("Position: " + i);
                System.out.println("Expected answer: " + miss[i]);
                System.out.println("Actual answer: " + result[i]);
                break;
            }  

            
        }
        System.out.println("... ok.");
                
        return true;
    }
 
}

