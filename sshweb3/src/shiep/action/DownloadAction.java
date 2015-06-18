package shiep.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
public class DownloadAction extends ActionSupport{
	private String address;
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InputStream getDownloadFile(){
		File file=new File(address);

		
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(file);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fis;
	}
	
	public String execute() throws Exception{
		return super.execute();
	}
	
	

}
