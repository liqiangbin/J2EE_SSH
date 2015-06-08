package shiep.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class FileUploadAction extends ActionSupport
{
   //ע�⣬file������ָǰ��jsp�ϴ��������ļ����������ļ��ϴ������������ʱ�ļ���������ļ�
    private File file;
    
    //�ύ������file������
    private String fileFileName;
    
    //�ύ������file��MIME����
    private String fileContentType;

   

    public File getFile()
    {
        return file;
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public String getFileFileName()
    {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName)
    {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType()
    {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType)
    {
        this.fileContentType = fileContentType;
    }
    
    @Override
    public String execute() throws Exception
    {
    	String path = ServletActionContext.getServletContext().getRealPath("/upload");
    	saveFile(path);
    	List<String> filenames=listFiles(path);
    	Map request=(Map) ActionContext.getContext().get("request");
        request.put("filenames", filenames); 
        return "success";
    }
    private List<String> listFiles(String path) throws Exception{
    	List<String> filenames=new ArrayList<String>();
		File fileDir = new File(path);

		if (fileDir.isDirectory()) {
			File files[] = fileDir.listFiles();
			for (int i = 0; i < files.length; i++) {
				File currFile = files[i];
				if (currFile.isFile()) {
					filenames.add(currFile.getName());
				}
			}
		}
		return filenames;
    }
    private void saveFile(String root)  throws Exception{
        InputStream is = new FileInputStream(file);
        OutputStream os = new FileOutputStream(new File(root, fileFileName));
        byte[] buffer = new byte[1500];
        int length = 0;
        while(-1 != (length = is.read(buffer, 0, buffer.length)))
        {
            os.write(buffer);
        }
        
        os.close();
        is.close();
    }
}