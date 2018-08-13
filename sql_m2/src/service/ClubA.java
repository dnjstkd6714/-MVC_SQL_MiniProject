//2018. 8. 13(월) 이원상	ClubA
/*
 * CREATE TABLE `tbl_club_a` (
	`lname` VARCHAR(50) NULL DEFAULT NULL,
	`fname` VARCHAR(50) NULL DEFAULT NULL
)
 */
package service;

public class ClubA {
	private String lname;			// LastName(성)
	private String fname;			// firstName(이름)
	
	public ClubA() {				// dafault생성자 선언
		super();					// 조상클래스 생성자 호출
	}
	
	public String getLname() {
		return this.lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return this.fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
}
