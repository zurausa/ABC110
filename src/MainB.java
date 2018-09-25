    import java.io.PrintWriter;

    public class MainB {
    	static FastScanner sc;
    	static PrintWriter out;
    	public static void main(String[] args){
    		sc = new FastScanner();
    		out = new PrintWriter(System.out);
    		out.println(solve());
    		out.flush();
    	}

    	static String solve(){
    		int N = sc.nextInt();
    		int M = sc.nextInt();
    		int X = sc.nextInt();
    		int Y = sc.nextInt();
    		int max = X;
    		int min = Y;
    		for(int i=0;i<N;i++){
    			max = Math.max(max, sc.nextInt());
    		}
    		for(int i=0;i<M;i++){
    			min = Math.min(min, sc.nextInt());
    		}
    		if(max >= min) return "War";
    		else return "No War";
    	}
    }
