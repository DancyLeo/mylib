package algorithm.search;

public class KMP {
	public static int[] kmpTable(String pattern_str,int[] next) {
		int p_index,max_length;
		//char[] Tchar = pattern_str.toCharArray();
		char[] Pchar = pattern_str.toCharArray();
		next[0] = 0 ;
		
		for(p_index=0,max_length=0;p_index<Pchar.length;++p_index) {
			while(max_length>0&&Pchar[p_index]!=Pchar[max_length]) {
				max_length = next[max_length-1] ;
			}
			System.out.println("p_index = " + p_index); 
			if(Pchar[p_index]==Pchar[max_length]) {
				max_length++ ;
			}
			System.out.println("max_length=" + max_length);
			next[p_index] = max_length ;
		}
		for(int i=0;i<next.length;i++) {
			System.out.print("next=" + next.toString());
		}
		
		return next;
	}
	
	public static void kmp(String txt,String pattern_str,int[] next) {
		int t_index,p_index,max_length = 0;
		char[] Tchar = txt.toCharArray() ;
		char[] Pchar = pattern_str.toCharArray();
		int[] next1 = kmpTable(txt,next) ;
		System.out.print("next=" + next.toString());
		for( t_index=0,p_index=0 ;t_index<Tchar.length;++t_index) {
			while(max_length>0 && Tchar[t_index]!=Pchar[p_index]) {
				max_length = next1[max_length-1];
			}
		if(Tchar[t_index]==Pchar[p_index]) {
			max_length++ ;
		}
		if(max_length==Pchar.length) {
			//System.out.println("i=" + i);
			System.out.println("P.length=" + Pchar.length);
		}
		}
	}
	
	public static void main(String[] args) {
		String txt = "abcabdabcabdabcabd" ;
		String pattern = "abdabdabd" ;
		int[] next = new int[pattern.length()] ;
		kmpTable(pattern,next) ;
		
	}
		
}
