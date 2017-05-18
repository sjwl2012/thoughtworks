import java.util.ArrayList;


public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {

        String[] sourceStrArray = bowlingCode.split("\\|");
        ArrayList<Integer> v = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {

            if(sourceStrArray[i].length() == 1){
                int t = 10;
                v.add(t);
            }
            else if(sourceStrArray[i].length() == 2){
                int t = 0;
                //first
                if(sourceStrArray[i].charAt(0) == '-'){
                    v.add(0);
                }else{
                    t += sourceStrArray[i].charAt(0) - '0';
                    v.add(t);
                }
                //second
                if(sourceStrArray[i].charAt(1) == '/'){
                    t = 10 - t;
                }else if(sourceStrArray[i].charAt(1) == '-'){
                    t = 0;
                }else{
                    t = sourceStrArray[i].charAt(1) - '0';
                }
                v.add( t);
            }

        }
        //deal the more chance
        if(sourceStrArray.length == 12){
            String str = sourceStrArray[11];
            for(int i = 0; i < str.length(); i++){
                int t = 0;
                if(str.charAt(i) == 'X'){
                    t = 10;
                }else if(str.charAt(i) == '-'){
                    t  = 0;
                }else{
                    t = str.charAt(i) - '0';
                }
                v.add(t);
            }
        }

        int res = 0;
        int pos = 0;
        for(int i = 0; i < 10; i++){
            if(sourceStrArray[i].length() == 1){
                res += v.get(pos) + v.get(pos+1) + v.get(pos+2);
                pos++;
            }else {
                if (sourceStrArray[i].charAt(1) == '/') {
                    res += v.get(pos) + v.get(pos + 1) + v.get(pos + 2);
                } else {
                    res += v.get(pos) + v.get(pos + 1);
                }
                pos += 2;
            }
        }


        return res;
    }

}
