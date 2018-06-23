package ThirdLot.MinimumCopyPaste;

/**
 * Created by sjain on 9/19/17.
 */
public class MinimumCopyPaste {

    public int find(int remain, int current, int clipboard){
        if(remain==0)
            return 0;
        //two option: - either copy OR paste
        int copyAll = -1;
        int paste = -1;
        if(clipboard!=0 && remain>=clipboard){
            paste = find(remain-clipboard,current+clipboard,clipboard) + 1;
        }
        if(clipboard!=current && remain%current==0){
           copyAll  = find(remain,current,current) + 1;
        }
        if(copyAll!=-1 && paste !=-1) {
            return Math.min(copyAll, paste);
        }
        else if(copyAll==-1) {
            return paste;
        }
        else{
            return copyAll;
        }
    }

    public static void main(String[] args) {
        MinimumCopyPaste m = new MinimumCopyPaste();
        int n = 3;
        long startTime  = System.currentTimeMillis();
        System.out.println("Minimum Operations: " + m.find(n-1,1,0));
        long end  = System.currentTimeMillis();
        System.out.println("Recursion - Time taken: " + (end-startTime)+ " miliseconds");

    }
}
