import java.io.*;
import java.lang.*;

import java.util.HashMap;

public class mini2 {
	public static void main(String[] args) throws Exception {

		File file = new File("display.txt");
		int flength;
		HashMap<String,Integer> s1=new HashMap<String,Integer>();
		HashMap<String,Integer> s2=new HashMap<String,Integer>();
		double pl;
		int j, i = 0;
		int l = 0;
		double plag;
		String words[];
		String st, st1;
		int q = 0, p = 0;
		int a = 0, b = 0, count = 0;
		int space = 0;
	    FileWriter writer = new FileWriter("reportfolder.txt");  
	    BufferedWriter buffer = new BufferedWriter(writer);
		
		File f = new File("MainFiles");
		File f1[] = f.listFiles();
		System.out.println("files=" + f1.length);
		BufferedReader br = new BufferedReader(new FileReader(f1[0]));
		while ((st = br.readLine()) != null) 
		{
			st = st.replace("i ", "");
			st = st.replace("am ", "");
			st = st.replace("the ", "");
			st = st.replace("a ", "");
			st = st.replace("is ", "");
			st = st.replace("and ", "");
			st = st.replace(",", "");
			st = st.replace(".", "");
			st = st.replace("that ", "");
			st = st.replace("of ", "");
			st = st.replace("to ", "");
			st = st.replace("it's ", "");
			st = st.replace("also ", "");
			st = st.replace("by ", "");
			st = st.replace("are ", "");
			st = st.replace("but ", "");
			st = st.replace("or ", "");
			st = st.replace("in ", "");
			st = st.replace("as ", "");
			int start = 0;
			for (int z = 0; z < st.length(); z++) {
				if (st.charAt(z) != ' ') {
					if (start == 0) {
						start = 1;
						l++;
					}
				} else {
					if (start == 1) {
						start = 0;
					}
				}
			}
			words=st.split("\\s+");
			for(String w:words){
				w=w.toLowerCase();
				if(s1.containsKey(w)){
					s1.put(w, s1.get(w)+1);
				}
				else{
					s1.put(w, 1);
				}
			}
		}
		for (i = 1; i < f1.length; i++) {
			String fnm = f1[i].toString();
			int n = fnm.indexOf('.');
			String str = fnm.substring(n + 1, n + 4);
			if (str.equals("txt")) {
				System.out.println(f1[i]);
				BufferedReader br1 = new BufferedReader(new FileReader(f1[i]));
				while ((st1 = br1.readLine()) != null) 
				{
					st1 = st1.replace("i ", "");
					st1 = st1.replace("am ", "");
					st1 = st1.replace("the ", "");
					st1 = st1.replace("a ", "");
					st1 = st1.replace("is ", "");
					st1 = st1.replace("and ", "");
					st1 = st1.replace(",", "");
					st1 = st1.replace(".", "");
					st1 = st1.replace("that ", "");
					st1 = st1.replace("of ", "");
					st1 = st1.replace("to ", "");
					st1 = st1.replace("it's ", "");
					st1 = st1.replace("also ", "");
					st1 = st1.replace("by ", "");
					st1 = st1.replace("are ", "");
					st1 = st1.replace("but ", "");
					st1 = st1.replace("or ", "");
					st1 = st1.replace("in ", "");
					st1 = st1.replace("as ", "");
					words = st1.split("\\s+");
					for(String w:words){
						w=w.toLowerCase();
						if(s2.containsKey(w)){
							s2.put(w, s2.get(w)+1);
						}
						else{
							s2.put(w, 1);
						}
					}
				}
				for(String w:s1.keySet()){
					if(s2.containsKey(w)){
						count+=Math.min(s1.get(w), s2.get(w));
					}
				}
				System.out.println("common no. of words = " + count);
				pl = ((double) count / l);
				plag = (pl) * 100;
				plag = Math.round(plag * 100) / 100.00;
				System.out.println("% plagiarism is = " + plag);
				buffer.newLine();
				buffer.write(i+":"+" filename: "+f1[i]+" plagarism: "+plag);
				
				br1.close();			}
			System.out.println("*************");
			count = 0;
			
		}
		buffer.close();
	}
}