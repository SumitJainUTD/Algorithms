package MacLaptop.ThirdLot.MinimumCopyPaste;

/**
 * Created by sjain on 9/19/17.
 */
public class MinimumCopyPaste {

    public int find(int remain, int current, int clipboard){
        if(remain==0)
            return 0;
        if(remain<clipboard)
            return 2000;
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
        int n = 12;
        System.out.println("Minimum Operations: " + m.find(n-1,1,0));

    }
}
