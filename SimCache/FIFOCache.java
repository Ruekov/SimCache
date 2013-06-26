package SimCache;

/**
 *
 * @author guillem
 */
public class FIFOCache extends memoryCache {
    
    public FIFOCache(){
        
        this(4);
        
    }
    
    public FIFOCache(int blocks){
        
        this.memBlocks= blocks;
        this.numberMises = 0;
        
    }
    
    @Override
    boolean hitBlock(Object block) {
        
        return true;
        
    }

    @Override
    boolean missBlock(Object block) {
               
        if (this.CacheBlocks.size()<this.getNumBlock()){
            
            this.CacheBlocks.add(block);
        
        }else{
            
            this.CacheBlocks.remove(0);
            this.CacheBlocks.add(block);
        
        }
        
        this.numberMises++;
        return false;
    }

  
}
