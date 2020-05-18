package com.cg.backgroundverification.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="document_details")
public class EmployeeDocumentDto
{ 
    private int empId;
    private String empName;
    @Id
    @GeneratedValue
    private int docId;
    private String docType;
    @Lob
    private byte[] docData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verfId")
    
	private VerificationDto verificationdto;
	
    public VerificationDto getVerificationdto() {
		return verificationdto;
	}
	public void setVerificationdto(VerificationDto verificationdto) {
		this.verificationdto = verificationdto;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public byte[] getDocData() {
		return docData;
	}
	public void setDocData(byte[] docData) {
		this.docData = docData;
	}
	public EmployeeDocumentDto(int empId, String empName, int docId, String docType, byte[] docData,
			VerificationDto verificationdto) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.docId = docId;
		this.docType = docType;
		this.docData = docData;
		this.verificationdto = verificationdto;
		}
	public EmployeeDocumentDto() {
		super();
	}
	
	
}












