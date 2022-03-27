package LCS;

public class all_substring {
	public static void main(String[] args) {
		String str="abc";
		substring("",str);
	}

    // recursive approach
	private static void substring(String p, String np) {
		if(np.isEmpty()) {
			System.out.print(p+" ");
			return;
		}
		substring(p+np.charAt(0),np.substring(1));
		substring(p,np.substring(1));
		
	}

}
