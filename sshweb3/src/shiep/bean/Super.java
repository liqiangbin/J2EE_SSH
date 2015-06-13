package shiep.bean;



/**
 * Super entity. @author MyEclipse Persistence Tools
 */

public class Super  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private String password;


    // Constructors

    /** default constructor */
    public Super() {
    }

	/** minimal constructor */
    public Super(Integer id) {
        this.id = id;
    }
    
    /** full constructor */
    public Super(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}