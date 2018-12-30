package MacLaptop.ThirdLot.MinimumCopyPaste;

import java.util.HashMap;

/**
 * Created by sjain on 9/20/17.
 */
public class MinimumCopyPasteDP {
    HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
    public int find(int remain, int current, int clipboard){
        int result = 0;
        if(remain==0)
            return 0;
        if(remain<clipboard)
            return 2000;
        if(map.containsKey(remain)){
            return map.get(remain);
        }
        System.out.println(remain);
        //two option: - either copy OR paste
        int copyAll = -1;
        int paste = -1;
        if(clipboard!=current){
            copyAll  = find(remain,current,current) + 1;
        }
        if(clipboard!=0){
            paste = find(remain-clipboard,current+clipboard,clipboard) + 1;
        }
        if(copyAll!=-1 && paste !=-1) {
            result =  Math.min(copyAll, paste);
        }
        else if(copyAll==-1) {
            result =  paste;
        }
        else{
            result = copyAll;
        }
        map.put(remain,result);
        return result;
    }

    public static void main(String[] args) {
        MinimumCopyPasteDP m = new MinimumCopyPasteDP();
        int n = 32;
        System.out.println("Minimum Operations: " + m.find(n-1,1,0));

    }
}
