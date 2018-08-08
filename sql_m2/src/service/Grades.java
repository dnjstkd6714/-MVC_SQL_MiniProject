// 2018. 8. 8(수) 이원상	Grades.java
package service;
/*
 * CREATE TABLE `tbl_grades` (
	`no` INT(11) NULL DEFAULT NULL,
	`history` INT(11) NULL DEFAULT NULL,
	`science` INT(11) NULL DEFAULT NULL
)
 */
								// 성적,학점 table
public class Grades {			// 멤버변수 캡슐화
	private int no;				// 학생번호
	private int history;		// 역사
	private int science;		// 과학
	
	public Grades() {			// default 생성자
		super();				// 조상클래스 obj 생성자 호출
	}

	public int getNo() {
		return this.no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getHistory() {
		return this.history;
	}

	public void setHistory(int history) {
		this.history = history;
	}

	public int getScience() {
		return this.science;
	}

	public void setScience(int science) {
		this.science = science;
	}
}
