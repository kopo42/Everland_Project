
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportFileWrite {
	TypeClass t = new TypeClass();
	private FileWriter fw;
	private boolean isFileExist;
	
	public ReportFileWrite(String filename) {
		try {
			File file = new File(filename);
			if(file.exists() == true) {
				isFileExist = true;
			} else if(file.exists() == false){
				isFileExist = false;
			}
			fw = new FileWriter(filename, true);					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void headerWrite(String head) throws IOException {
		if(isFileExist == false) {
			fw.write(head);
		} else if(isFileExist == true){
			head = "";
		}
	}
	
	public void dataWrite(ReportOptions ro, String result) throws IOException {
		fw.write(result);
	}	
	
	public void TailWrite(ReportOptions ro, String tail) throws IOException {
		fw.write(tail);
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