package pojos4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "dac_adr1")
public class Address {

	private Long addrId;
	private String city,country;
	private long version;

	public Address() {
		System.out.println("in adr constr");
	}

	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	public Long getAddrId() {
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", city=" + city + ", country="
				+ country + ", version=" + version + "]";
	}
	
	


}