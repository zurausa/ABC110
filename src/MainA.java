import java.io.PrintWriter;

public class MainA {
	static FastScanner sc;
	static PrintWriter out;
	public static void main(String[] args){
		sc = new FastScanner();
		out = new PrintWriter(System.out);
		out.println(solve());
		out.flush();
	}

	static int solve(){
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int max = Math.max(A, Math.max(B, C));
		if(max == A) return A *10 + B +C;
		else if(max == B) return A + B*10 +C;
		else return C*10 + A + B;
	}
}

