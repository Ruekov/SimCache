package SimCache;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author guillem
 */
abstract class memoryCache {
    
    protected int memBlocks;
    protected int numberMises;
    ArrayList<Object> CacheBlocks = new ArrayList<Object>();
   
    public boolean setNumBlock(int numBlock){
    
        memBlocks = numBlock;
        return true;
    
    }
    
    public int getNumBlock() {
        
        return memBlocks;
        
        }
    
    public int getNumMisses(){
    
        return numberMises;
        
    }
    
    public void resetMises(){
        
        numberMises = 0;
    
    }
    
    abstract boolean missBlock(Object block);
    
    abstract boolean hitBlock(Object block);
    
    public boolean access(Object block){
        
        
        if (CacheBlocks.contains(block)==true) {
            
            return hitBlock(block);
            
        }else{
            
            numberMises++;
            return missBlock(block);
           
        }
     

    }
    
    
}