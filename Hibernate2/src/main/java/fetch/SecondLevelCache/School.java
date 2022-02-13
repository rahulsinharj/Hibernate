package fetch.SecondLevelCache;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "School_Details")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "school_id")
	private int scid;
	
	@Column(name = "school_name")
	private String name;
	
	@Column(name = "city_name")
	private String city;
	
	public School() {
		super();
	}
	public School(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	public int getShid() {
		return scid;
	}
	public void setShid(int scid) {
		this.scid = scid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "School [scid=" + scid + ", name=" + name + ", city=" + city + "]";
	}

	
}
