package everland;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWriteClass {
	TypeClass t = new TypeClass();
	private FileWriter fw;
	private boolean isFileExist;
	
	public FileWriteClass() {
		try {
			File file = new File(Options.filename);
			if(file.exists() == true) {
				isFileExist = true;
			} else if(file.exists() == false){
				isFileExist = false;
			}
			fw = new FileWriter(Options.filename, true);					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void headerWrite() throws IOException {
		String head = "";
		if(isFileExist == false) {
			head = "날짜," + "권종," + "연령구분," + "발매수," + "결제금액," + "우대사항"+"\n";
			fw.write(head);
		} else if(isFileExist == true){
			head = "";
		}
	}
	
	public void dataWrite(TypeClass t) throws IOException {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		
		String result = sdf.format(c.getTime()) + "," + t.timestr + "," + t.agestr + "," 
								+ t.amnt + "," + t.subtotal + "," + t.discntstr + "\n";
		fw.write(result);
		System.out.println();
	}	
	
	public void fileClose() {
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}