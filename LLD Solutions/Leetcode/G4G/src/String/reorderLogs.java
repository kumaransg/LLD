package String;

import java.util.Arrays;

public class reorderLogs {

    public static String[] reorderLogFiles(String[] logs) {


        Arrays.sort(logs, (log1,log2)->{
            String[] splitLog1 = log1.split(" ",2);
            String[] splitLog2 = log2.split(" ",2);

            boolean isDigit1 = Character.isDigit(splitLog1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(splitLog2[1].charAt(0));

            if(!isDigit1 && !isDigit2){
                int cmp = splitLog1[1].compareTo(splitLog2[1]);
                if(cmp==0)
                    return cmp;
                return splitLog1[0].compareTo(splitLog2[0]);
            }
            return isDigit1?(isDigit2?0:1):-1;

        });
        return logs;

    }
        public static void main(String []args){
        String [] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        logs = reorderLogFiles(logs);
    }
}
