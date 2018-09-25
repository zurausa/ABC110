	import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;

	public class MainC {
		static FastScanner sc;
		static PrintWriter out;
		public static void main(String[] args){
			sc = new FastScanner();
			out = new PrintWriter(System.out);
			out.println(solve());
			out.flush();
		}

		static String solve(){
			char[] S = sc.next().toCharArray();
			char[] T = sc.next().toCharArray();
			int[] repS = new int[26];
			int[] repT = new int[26];
			Arrays.fill(repS, -1);
			Arrays.fill(repT, -1);
			for(int i=0;i<S.length;i++){
				int tmpS = S[i]- 'a';
				int tmpT = T[i]- 'a';
				if(repS[tmpS]==-1 && repT[tmpT]==-1){
					repS[tmpS] = tmpT;
					repT[tmpT] = tmpS;
				}else if(tmpS == repT[tmpT] && tmpT == repS[tmpS]) continue;
				else return "No";
			}
			return "Yes";
		}
	}

	class FastScanner {
		private final InputStream in = System.in;
		private final byte[] buffer = new byte[1024];
		private int ptr = 0;
		private int buflen = 0;
		private boolean hasNextByte() {
			if (ptr < buflen) {
				return true;
			}else{
				ptr = 0;
				try {
					buflen = in.read(buffer);
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (buflen <= 0) {
					return false;
				}
			}
			return true;
		}
		private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
		private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
		public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
		public String next() {
			if (!hasNext()) throw new NoSuchElementException();
			StringBuilder sb = new StringBuilder();
			int b = readByte();
			while(isPrintableChar(b)) {
				sb.appendCodePoint(b);
				b = readByte();
			}
			return sb.toString();
		}
		public long nextLong() {
			if (!hasNext()) throw new NoSuchElementException();
			long n = 0;
			boolean minus = false;
			int b = readByte();
			if (b == '-') {
				minus = true;
				b = readByte();
			}
			if (b < '0' || '9' < b) {
				throw new NumberFormatException();
			}
			while(true){
				if ('0' <= b && b <= '9') {
					n *= 10;
					n += b - '0';
				}else if(b == -1 || !isPrintableChar(b)){
					return minus ? -n : n;
				}else{
					throw new NumberFormatException();
				}
				b = readByte();
			}
		}
		public int nextInt() {
			long nl = nextLong();
			if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
			return (int) nl;
		}
		public double nextDouble() { return Double.parseDouble(next());}
	}