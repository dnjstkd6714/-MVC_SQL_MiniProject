// 2018. 8. 8(수) 이원상	StudentGradesDao
package service;

import java.sql.*;
import java.util.*;
import service.StudentGrades;

// 클래스 명명 : 특정인의 학점,점수를 나타냄으로 학생이라 특정하고 지음.
public class StudentGradesDao {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private StudentGrades studentGrades = null;
	private NameList nameList = null;
	private Grades grades = null;
	
	public StudentGradesDao() {									// 생성자 내 DB연결
		try {		
			Class.forName("com.mysql.jdbc.Driver");				// ip주소, port넘버, db명, 사용자id/pw, 캐릭터 setting			
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_m2?useUnicode=true&characterEncoding=utf-8", "root", "java0000");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 메소드 용도 : 점수가 기록되어있는 학생의 이름과 번호 과목 점수를 조회(단, 학생의 테이블, 점수의 테이블 중 넘버가 일치하는 경우만 조회되며 일치하지 않는 경우는 조회되지 않음.)
	 * 매개변수 : 없음
	 * 리턴값 : 점수가 DB내 저장되어 있는 학생의 이름,넘버,과목점수를 리스트 data type으로 리턴
	 */
	public List<StudentGrades> selectStudentGradeList(){
		List<StudentGrades> studentGradeList = new ArrayList<StudentGrades>();		// List클래스는 인스턴스 생성자 호출에 접근을 제한함. 
																					// 따라 자바 다형성을 통해 자식클래스 인스턴스를 조상클래스 참조변수로 참조
		try {
			this.preparedStatement = this.connection.prepareStatement("select n.`no`,n.name,g.history,g.science from tbl_namelist n inner join tbl_grades g on n.`no` = g.`no`");
			this.resultSet = this.preparedStatement.executeQuery();
			while(resultSet.next()) {
				this.nameList = new NameList();
				this.grades = new Grades();
				this.studentGrades = new StudentGrades();
				this.nameList.setNo(this.resultSet.getInt(1));
				this.nameList.setName(this.resultSet.getString(2));
				this.grades.setNo(this.resultSet.getInt(1));
				this.grades.setHistory(this.resultSet.getInt(3));
				this.grades.setScience(this.resultSet.getInt(4));	
				this.studentGrades.setNameList(this.nameList);
				this.studentGrades.setGrades(this.grades);
				studentGradeList.add(this.studentGrades);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(this.resultSet != null) {
				try {
					this.resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(this.preparedStatement != null) {
				try {
					this.preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(this.connection != null) {
				try {
					this.connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentGradeList;															
	}
}
