package shiep.bean;
public class Customer  implements java.io.Serializable{
     
	private static final long serialVersionUID = -2262676388211730293L;
	private String customerId;
     private String name;
     private String phone;
    public Customer() {
    }
    public Customer(String customerId) {
        this.customerId = customerId;
    }
    public Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }
    public String getCustomerId() {
        return this.customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getName() {
       return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
   }

