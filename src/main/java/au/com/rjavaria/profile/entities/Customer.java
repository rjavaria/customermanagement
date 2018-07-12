package au.com.rjavaria.profile.entities;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Customer
 */
@Validated
public class Customer   {

   @JsonProperty("accountid")
   private String accountid = null;
  
   @JsonProperty("firstname")
   private String firstname = null;
  
   @JsonProperty("lastname")
   private String lastname = null;
  
   @JsonProperty("title")
   private String title = null;
  
   @JsonProperty("dob")
   private String dob = null;
  
   @JsonProperty("email")
   private String email = null;
  
   @JsonProperty("homeaddress")
   private Address homeaddress = null;
  
   @JsonProperty("officeaddress")
   private Address officeaddress = null;
   
   public Customer() {
	   super();
   }
  
   
   public static class Builder {
	   private final String accountid;
	   private String firstname;
	   private String lastname;
	   private String title;
	   private String dob;
	   private String email;
	   private Address homeaddress;
	   private Address officeaddress;
	   
	   public Builder(String accountid) {
	     this.accountid = accountid;
	   }
  
	   public Builder firstname(String firstname) {
		    this.firstname = firstname;
		    return this;
	   }

       public Builder lastname(String lastname) {
	       this.lastname = lastname;
	       return this;
	   }
  
  
	   public Builder title(String title) {
	       this.title = title;
	       return this;
	   }
	  
	   public Builder dob(String dob) {
		    this.dob = dob;
		    return this;
	   }
	  
	   public Builder email(String email) {
		   this.email = email;
		   return this;
	   }
	  
	   public Builder homeaddress(Address homeaddress) {
		   this.homeaddress = homeaddress;
		   return this;
	   }
  
	  public Builder officeaddress(Address officeaddress) {
	       this.officeaddress = officeaddress;
	       return this;
	  }
	  
	  public Customer build() {
      	return new Customer(this);
      }
   }
  
   	 private Customer(Builder builder) {
		  accountid = builder.accountid;
		  firstname = builder.firstname;
		  lastname = builder.lastname;
		  title = builder.title;
		  dob = builder.dob;
		  email = builder.email;
		  homeaddress = builder.homeaddress;
		  officeaddress = builder.officeaddress;
	  }
  
  /**
   * Get accountid
   * @return accountid
  **/
  @ApiModelProperty(example = "rjavaria", value = "")
  public String getAccountid() {
    return accountid;
  }

  public void setAccountid(String accountid) {
    this.accountid = accountid;
  }
  
  /**
   * Get firstname
   * @return firstname
  **/
  @ApiModelProperty(example = "Rajesh", value = "")
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   * Get lastname
   * @return lastname
  **/
  @ApiModelProperty(example = "Javaria", value = "")
  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(example = "Mr.", value = "")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  /**
   * Get dob
   * @return dob
  **/
  @ApiModelProperty(example = "01/01/1985", value = "")
  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(example = "rajesh.javaria@gmail.com", value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Get homeaddress
   * @return homeaddress
  **/
  @ApiModelProperty(value = "")
  @Valid
  public Address getHomeaddress() {
    return homeaddress;
  }

  public void setHomeaddress(Address homeaddress) {
    this.homeaddress = homeaddress;
  }

  /**
   * Get officeaddress
   * @return officeaddress
  **/
 
  @ApiModelProperty(value = "")
  @Valid
  public Address getOfficeaddress() {
    return officeaddress;
  }

  public void setOfficeaddress(Address officeaddress) {
    this.officeaddress = officeaddress;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.accountid, customer.accountid) &&
        Objects.equals(this.firstname, customer.firstname) &&
        Objects.equals(this.lastname, customer.lastname) &&
        Objects.equals(this.title, customer.title) &&
        Objects.equals(this.dob, customer.dob) &&
        Objects.equals(this.email, customer.email) &&
        Objects.equals(this.homeaddress, customer.homeaddress) &&
        Objects.equals(this.officeaddress, customer.officeaddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountid, firstname, lastname, title, dob, email, homeaddress, officeaddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    accountid: ").append(toIndentedString(accountid)).append("\n");
    sb.append("    firstname: ").append(toIndentedString(firstname)).append("\n");
    sb.append("    lastname: ").append(toIndentedString(lastname)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    homeaddress: ").append(toIndentedString(homeaddress)).append("\n");
    sb.append("    officeaddress: ").append(toIndentedString(officeaddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}