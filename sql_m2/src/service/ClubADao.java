// 2018. 8. 13(월) 이원상	ClubADao
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClubADao {							
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public ClubADao() {											// 생성자 내 DB연결
		try {		
			Class.forName("com.mysql.jdbc.Driver");				// ip주소, port넘버, db명, 사용자id/pw, 캐릭터 setting			
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_m2?useUnicode=true&characterEncoding=utf-8", "root", "java0000");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 메소드 용도 : 클럽A와 클럽B테이블 간의 이름과 성이 중복되는 데이터를 하나로 정리하여 두 테이블의 이름과 성을 조회함( 정렬기준은 왼쪽 테이블에 맞춤.)
	 * 매개변수 : 없음
	 * 리턴값 : 클럽a와 클럽b 테이블의 성과 이름(중복배제)을 List Data type으로 리턴.
	 * ClubA 프로퍼티 : String lname, String fname
	 */
	public List<ClubA> selectNameDoNotOverlap() {
		List<ClubA> nameList = new ArrayList<ClubA>();
		try {
			this.preparedStatement=this.connection.prepareStatement("select lname, fname from tbl_club_a union select sung, irum from tbl_club_b");
			this.resultSet=this.preparedStatement.executeQuery();
			while(this.resultSet.next()) {
				ClubA clubA = new ClubA();
				clubA.setLname(this.resultSet.getString(1));
				clubA.setFname(this.resultSet.getString(2));
				nameList.add(clubA);
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
		return nameList;
	}
}
