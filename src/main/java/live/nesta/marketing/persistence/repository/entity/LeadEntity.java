package live.nesta.marketing.persistence.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LEADS")
public class LeadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "NUMERIC(19,0)")
	private Long id;
	
	@Column(name="NAME", nullable=false, length=128)
	private String name;
	
	@Column(name="EMAIL", nullable=false, length=128)
	private String email;
	
	@Column(name="PHONE_NUMBER", nullable=false, length=16)
	private String phoneNumber;
	
	@Column(name="LOCATION", nullable=true, length=256)
	private String location;
	
	@Column(name="LEAD_SOURCE", nullable=true, length=32)
	@Enumerated(EnumType.STRING)
	private LeadSource source;
	
	@Column(name="CREATED_TIME", nullable=false, length=128)
	private LocalDateTime createdDate;
	
	@Column(name="MODIFIED_TIME", nullable=false, length=128)
	private LocalDateTime modifiedDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public LeadSource getSource() {
		return source;
	}
	public void setSource(LeadSource source) {
		this.source = source;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
