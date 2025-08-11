import java.util.ArrayList;
import java.util.List;

enum State{READY, RUNNING, STOPPED};

public class SplitSecondStopwatch {
	State  current_state;
	String current_time;
	
	List<String> times;
	
	SplitSecondStopwatch() {
		current_state = State.READY;
		current_time  = "00:00:00";
		
		times = new ArrayList<String>();
	}
	
    public void start() {
        if (current_state == State.READY || current_state == State.STOPPED)
        	current_state = State.RUNNING;
        else if (current_state == State.RUNNING)
        	throw new IllegalStateException("cannot start an already running stopwatch");
    }

    public void stop() {
        if (current_state == State.RUNNING)
        	{current_state = State.STOPPED; return;}
        
        throw new IllegalStateException("cannot stop a stopwatch that is not running");
    }

    public void reset() {
        if (current_state == State.STOPPED) {
        	times.clear();
        	current_time = "00:00:00";
        	current_state = State.READY;
        	return;
        }
        
        throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
    }

    public void lap() {
    	if (current_state == State.RUNNING) {
    		times.add(current_time);
        
        	current_time = "00:00:00";
        	return;
    	}
    	
    	throw new IllegalStateException("cannot lap a stopwatch that is not running");
    }

    public String state() {
        switch(current_state) {
        case READY   : return "ready";
        case RUNNING : return "running";
        case STOPPED : return "stopped";
        }
        
        return "unknown";
    }

    public String currentLap() {
        return current_time;
    }

    public String total() {
        String res = "00:00:00";
        
        res = add(res, current_time);
        
        for (String time : times)
        	res = add(res, time);
        
        return res;
    }

    public List<String> previousLaps() {
        return times;
    }

    public void advanceTime(String timeString) {
    	if (current_state == State.RUNNING) {
    		current_time = add (current_time, timeString);
    	}
    }
    
    private String add(String a, String b) {
    	String[] a_ = a.split(":");
    	String[] b_ = b.split(":");
    	
    	String res = "";
    	int h = 0;
    	int m = 0;
    	int s = 0;
    	
    	boolean carry = false;
    	
    	s = parse_int(a_[2]) + parse_int(b_[2]);
    	
    	if (s >= 60) {
    		carry = true;
    		s -= 60;
    	}
    	
    	res = Integer.toString(s);
    	
    	if (s < 10)res = "0" + res;
    	
    	res = ":" + res;
    	
    	m = parse_int(a_[1]) + parse_int(b_[1]);
    	
    	if (carry) { 
    		m++;
    		carry = false;
    	}
    	
    	if (m >= 60) {
    		carry = true;
    		m -= 60;
    	}
    	
    	res = Integer.toString(m) + res;
    	
    	if (m < 10) res = "0" + res;
    	
    	res = ":" + res;
    	
    	h = parse_int(a_[0]) + parse_int(b_[0]);
    	
    	if (carry) {
    		h++;
    		carry = false;
    	}
    	
    	res = Integer.toString(h) + res;
    	
    	if (h < 10) res = "0" + res;
    	
    	return res;
    }
    
    private int parse_int(String num) {
    	if (num.startsWith("0"))
    		num = num.substring(1);
    	
    	return Integer.parseInt(num);
    }
}