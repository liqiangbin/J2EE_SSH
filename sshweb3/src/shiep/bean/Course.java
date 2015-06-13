package shiep.bean;



/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course  implements java.io.Serializable {


    // Fields    

     private String id;
     private String name;
     private String textbook;


    // Constructors

    /** default constructor */
    public Course() {
    }

	/** minimal constructor */
    public Course(String id) {
        this.id = id;
    }
    
    /** full constructor */
    public Course(String id, String name, String textbook) {
        this.id = id;
        this.name = name;
        this.textbook = textbook;
    }

   
    // Property accessors

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getTextbook() {
        return this.textbook;
    }
    
    public void setTextbook(String textbook) {
        this.textbook = textbook;
    }
   








}