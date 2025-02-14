package logSection;

import java.util.ArrayList;

public class Log {
    private ArrayList<String> log = new ArrayList<String>();

    public Log(){
    }

    public void appendLog(String event){
        log.add(event);
    }

    public void showLog(){
        for (String event : log) {
            System.out.println(event);
        }
    }
    
}
