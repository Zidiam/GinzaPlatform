import java.awt.Graphics;
import java.awt.Point;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream; 
public class LevelReader
{ 
  private String t;
  private ArrayList<Point> solidBlockPoints = new ArrayList<Point>();;
  private ArrayList<ArrayList> allBlocks = new ArrayList<ArrayList>();
  private ArrayList<ArrayList> allSolidBlocks = new ArrayList<ArrayList>();
  private ArrayList<ArrayList> allNoneSolidBlocks = new ArrayList<ArrayList>();
  private ArrayList<ArrayList> playerText = new ArrayList<ArrayList>();
  private ArrayList<ArrayList> enemyText = new ArrayList<ArrayList>();
  
  private GinzaImages Images = new GinzaImages();
  
  private String filename;
  
  public LevelReader(String filename) {
	  this.filename = filename;
	  try {
			setupLevelReader(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
  public LevelReader() {}
  
  public LevelReader(int Level) {
	  this.filename = "Level" + Level;
	  try {
		setupLevelReader(filename);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void getBlocks(String fileN) {
	  try {
		setupLevelReader(fileN);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  public void setupLevelReader(String fileN) throws IOException{
	  allBlocks = new ArrayList<ArrayList>();
	  t = "";
	  File file = new File("src\\Levels\\" + fileN + ".txt"); 
	  
	  filename = fileN;
	  
	  BufferedReader br = new BufferedReader(new FileReader(file)); 
	  
	  String st;
	  
	  while ((st = br.readLine()) != null) 
	    t += st; 
	  
	  	String str = t;
		String[] splitStr = str.split("\\s+");
		ArrayList<String> temp = null;
		for(int i = 0; i < splitStr.length; i++) {
			
			String[] splitStr2 = splitStr[i].split(",");
			temp = new ArrayList<String>();
			for(int x = 0; x < splitStr2.length; x++) {
				temp.add(splitStr2[x]);
			}
			allBlocks.add(temp);
		}
  } 
  
  public void addToFile(String add){
	  try {
		  fileadd(add);
	  }catch (IOException e) {System.out.println("FILE couldnt be created");}
	  
  }
  
  public void removeFromFile(String remove){
	  try {
		  fileremove(remove);
	  }catch (IOException e) {System.out.println("FILE couldnt be created");}
	  
  }
  
  public void createFile(String fileName){
	  try {
		  creator(fileName);
	  }catch (IOException e) {System.out.println("FILE couldnt be created");}
	  
  }
  
  private void creator(String fileN) throws IOException{
	  File file = new File("src//Levels//" + fileN + ".txt");
	     /*If file gets created then the createNewFile() 
	      * method would return true or if the file is 
	      * already present it would return false
	      */
          boolean fvar = file.createNewFile();
	     if (fvar){
	          System.out.println("File has been created successfully");
	     }
	     else{
	          System.out.println("File already present at the specified location");
	     }
	     file = new File("src//Levels//" + fileN + ".txt");
		 FileWriter fr = new FileWriter(file, true);
		 fr.write("\n504,360,grassBlock ");
		 fr.close();
	 filename = fileN;
  }
  
  public void fileremove(String remove) throws IOException{
	  for(int i =0; i < allBlocks.size(); i++) {
		  String listString = String.join(",", allBlocks.get(i));
		  if(listString.contains(remove)) {
			  allBlocks.remove(i);
		  }
	  }
	  File file = new File("src//Levels//" + filename + ".txt");
	  file.delete();
	  
	  file = new File("src//Levels//" + filename + ".txt");
	  file.createNewFile();
	  FileOutputStream fileOutput = new FileOutputStream(file);

	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutput));
	   
	  FileWriter fr = new FileWriter(file, true);
	  
	  for(int i = 0; i < allBlocks.size(); i++) {
		  String listString = String.join(",", allBlocks.get(i));
		  fr.write("\n" + listString + " ");
	  }
	  fr.close();
	  
  }
  
  
  public void fileadd(String add) throws IOException{
	  File file = new File("src//Levels//" + filename + ".txt");
	  boolean inFile = false;
	  for(int i = 0; i < allBlocks.size(); i++) {
		  String test = Arrays.toString(allBlocks.get(i).toArray()).replace("[", "").replace("]", "").replace(" ", "") + " ";
		  if(test.equals(add))
			  inFile = true;
	  }
	  if(inFile == false) {
		  FileWriter fr = new FileWriter(file, true);
		  fr.write("\n" + add);
		  fr.close();
	  }
  }
  
  public ArrayList<Point> getSolidBlockPoints() {
	  this.getBlocks(filename);
	  for(int i = 0; i < allBlocks.size(); i++) {
		  for(int x = 0; x < Images.getSolidBlockNames().size(); x++) {
			  if(allBlocks.get(i).get(2).toString().equals(Images.getSolidBlockNames().get(x).toString())) {
				  solidBlockPoints.add(new Point(Integer.parseInt((String) allBlocks.get(i).get(0)), Integer.parseInt((String) allBlocks.get(i).get(1))));
			  }
		  }
	  }
	  return solidBlockPoints;
  }
  
  public ArrayList getSolidBlocks() {
	  this.getBlocks(filename);
	  for(int i = 0; i < allBlocks.size(); i++) {
		  for(int x = 0; x < Images.getSolidBlockNames().size(); x++) {
			  if(allBlocks.get(i).get(2).toString().equals(Images.getSolidBlockNames().get(x).toString())) {
				  allSolidBlocks.add(allBlocks.get(i));
			  }
		  }
	  }
	  return allSolidBlocks;
  }
  
  public ArrayList getNoneSolidBlocks() {
	  this.getBlocks(filename);
	  for(int i = 0; i < allBlocks.size(); i++) {
		  for(int x = 0; x < Images.getNoneSolidBlockNames().size(); x++) {
			  if(allBlocks.get(i).get(2).toString().equals(Images.getNoneSolidBlockNames().get(x).toString())) {
				  allNoneSolidBlocks.add(allBlocks.get(i));
			  }
		  }
	  }
	  return allNoneSolidBlocks;
  }
  
  public ArrayList getPlayerText() {
	  this.getBlocks(filename);
	  for(int i = 0; i < allBlocks.size(); i++) {
			  if(allBlocks.get(i).get(2).toString().equals("Player")) {
				  playerText.add(allBlocks.get(i));
			  }
	  }
	  return playerText;
  }
  
  public ArrayList getEnemyText() {
	  this.getBlocks(filename);
	  for(int i = 0; i < allBlocks.size(); i++) {
			  if(allBlocks.get(i).get(2).toString().equals("Enemy")) {
				  enemyText.add(allBlocks.get(i));
			  }
	  }
	  return enemyText;
  }
  
  public ArrayList getAllBlocks() {
	  this.getBlocks(filename);
	  return allBlocks;
  }
  
  
 
  
}