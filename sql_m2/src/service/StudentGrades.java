// 2018. 8. 8(수) 이원상	StudentGrades.java
package service;

//클래스 명명 : 특정인의 학점,점수를 나타냄으로 학생이라 특정하고 지음.
public class StudentGrades {
	private NameList nameList;		// 포함관계
	private Grades grades;			// 포함관계
	
	public StudentGrades() {		// default 생성자
		super();					// 조상클래스 생성자 호출
	}

	public NameList getNameList() {
		return this.nameList;
	}

	public void setNameList(NameList nameList) {
		this.nameList = nameList;
	}

	public Grades getGrades() {
		return this.grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
	}
}
