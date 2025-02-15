package logSection;

import java.util.ArrayList;

public class Log {
    ArrayList<String> log = new ArrayList<String>();
    public void appendLog(String event){
        log.add(event);
    }

    public void showLog(){
        for (String event : log) {
            System.out.println(event + "\n");
        }
    }

    public ArrayList<String> getLog(){
        return log;
    }
}
