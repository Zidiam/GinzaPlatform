import java.awt.Point;
import java.util.ArrayList;

public class testing {
	public static void main(String [] args) {
		ArrayList<ArrayList> test = new ArrayList<ArrayList>();
		String str = "x,y,grassBlock 2x,2y,grassBlock";
		String[] splitStr = str.split("\\s+");
		ArrayList<String> temp = null;
		for(int i = 0; i < splitStr.length; i++) {
			
			String[] splitStr2 = splitStr[i].split(",");
			temp = new ArrayList<String>();
			for(int x = 0; x < splitStr2.length; x++) {
				temp.add(splitStr2[x]);
			}
			test.add(temp);
		}
		
		for(int i = 0; i < test.size(); i++) {
			if(test.get(i).get(2).equals("grassBlock")) {
				System.out.println(test.get(i).get(0));
			}
		}
	}
}
