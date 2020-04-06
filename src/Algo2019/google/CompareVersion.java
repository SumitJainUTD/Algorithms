package Algo2019.google;

public class CompareVersion {

    public void compareVersions(String versionA, String versionB){
        System.out.println("Version A: " + versionA + " Version B: " + versionB);
        int result = compareVersionsUtil(versionA, versionB);
        if(result==10){
            System.out.println("Given versions are not valid");
        } else if(result==0){
            System.out.println("Given versions are same");
        } else if(result==1){
            System.out.println("Given version A latest than version B");
        } else if(result==-1){
            System.out.println("Given version B latest than version A");
        }
        System.out.println("--------------------------------------------------");
    }

    public int compareVersionsUtil(String versionA, String versionB){
        try {
            String[] versions_a = versionA.split("\\.");
            String[] versions_b = versionB.split("\\.");

            int i = 0;
            int j = 0;
            while (i < versions_a.length && j < versions_b.length) {
                int a = Integer.parseInt(versions_a[i]);
                int b = Integer.parseInt(versions_b[j]);

                if (a > b)
                    return 1;
                else if (b > a)
                    return -1;
                i++;
                j++;
            }

            //check if any versions remaining
            if (i < versions_a.length) {
                while (i < versions_a.length) {
                    int a = Integer.parseInt(versions_a[i]);
                    if (a > 0) {
                        return 1;
                    }
                    i++;
                }
            } else if (j < versions_b.length) {
                while (j < versions_b.length) {
                    int b = Integer.parseInt(versions_b[j]);
                    if (b > 0) {
                        return -1;
                    }
                    j++;
                }
            }
            return 0; //if here means versions are same
        } catch (Exception exp){
            return 10;
        }
    }

    public static void main(String[] args) {
        CompareVersion c = new CompareVersion();
        String versionA = "1.1.0";
        String versionB = "1.1.1";
        c.compareVersions(versionA, versionB);

        versionA = "1.2.1";
        versionB = "1.2.1";
        c.compareVersions(versionA, versionB);

        versionA = "2.2.0";
        versionB = "2.2";
        c.compareVersions(versionA, versionB);

        versionA = "2.2.0.0.1";
        versionB = "2.2.0";
        c.compareVersions(versionA, versionB);

        versionA = "2.2.0.0.1";
        versionB = "2.2.1";
        c.compareVersions(versionA, versionB);

        versionA = "a.b.c";
        versionB = "2.2.1";
        c.compareVersions(versionA, versionB);

        versionA = "1.  2.3";
        versionB = "2.2.1";
        c.compareVersions(versionA, versionB);
    }
}
