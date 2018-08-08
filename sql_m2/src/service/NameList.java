// 2018. 8. 8(수) 이원상	NameList.java
package service;
/*
 * CREATE TABLE `tbl_namelist` (
	`no` INT(11) NULL DEFAULT NULL,
	`name` VARCHAR(10) NULL DEFAULT NULL
)
 */
public class NameList {			// 멤버변수 캡슐화
	private int no;				// 학생번호
	private String name;		// 학생이름
	
	public NameList() {			// default 생성자
		super();				// 조상클래스 obj 생성자 호출
	}

	public int getNo() {
		return this.no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
