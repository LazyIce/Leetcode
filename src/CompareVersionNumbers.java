public class CompareVersionNumbers {
    public class Solution {
        public int compareVersion(String version1, String version2) {
            //"1.0.0.0" == "1"
            int begin1 = 0, begin2 = 0, end1 = 0, end2 = 0;
            while(begin1 < version1.length() && begin2 < version2.length()){
                end1 = getDot(version1, begin1);
                end2 = getDot(version2, begin2);
                int a = Integer.parseInt(version1.substring(begin1, end1));
                int b = Integer.parseInt(version2.substring(begin2,end2));
                if(a < b){
                    return -1;
                }else if(a > b){
                    return 1;
                }else{
                    begin1 = end1 + 1;
                    begin2 = end2 + 1;
                }
            }
            if(begin1 >= version1.length() && begin2 >= version2.length()){
                return 0;
            }else if(begin1 >= version1.length()){
                while(begin2 < version2.length()){
                    end2 = getDot(version2, begin2);
                    int b = Integer.parseInt(version2.substring(begin2,end2));
                    if(b > 0) return -1;
                    else begin2 = end2 + 1;
                }
                return 0;
            }else{
                while(begin1 < version1.length()){
                    end1 = getDot(version1, begin1);
                    int a = Integer.parseInt(version1.substring(begin1,end1));
                    if(a > 0) return 1;
                    else begin1 = end1 + 1;
                }
                return 0;
            }

        }
        private int getDot(String version, int begin){
            while(begin < version.length()){
                if(version.charAt(begin) == '.'){
                    return begin;
                }else{
                    begin++;
                }
            }
            return version.length();
        }
    }
}
