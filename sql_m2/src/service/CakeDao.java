// 2018. 8. 6(월) 이원상 CakeDao.java
package service;

import java.sql.*;
import java.util.*;

public class CakeDao {
	public CakeDao() {								// default 생성자 선언
		super();									// 조상클래스 생성자 호출, 사용자가 별도로 상속한 클래스가 없을 때는 최상위  object클래스를 상속함
	}												// 별도로 적지않아도 컴파일시 컴파일러에 의해 object클래스 상속, 조상클래스 생성자 호출됨.
	
	
	/* 메소드 설명
	 * 매개변수 : 없음
	 * 리턴값 : DB cake테이블 중 평균 이상의 가격을 가진 케이크의 이름,가격을 리스트로 리턴
	 * 메소드 용도 : 평균이상의 가격을 가진 케이크들을 조회할 때 사용
	 * Cake 클래스 프로퍼티 : String name, int price
	 */
	public List<Cake> selectCakeListOverAvg(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;		
		List<Cake> list = new ArrayList<Cake>();	// ArrayList<Cake>클래스를 통해 생성된 객체의 참조값을 List<Cake>(조상클래스)의 참조변수에 대입하여 사용(다형성)
		try {										// 조상클래스의 참조변수로 자손클래스의 인스턴스를 참조시 조상클래스에 정의된 멤버만 사용가능함
			Class.forName("com.mysql.jdbc.Driver");	
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_m2?useUnicode=true&characterEncoding=utf-8", "root", "java0000");
			preparedStatement = connection.prepareStatement("select name, price from tbl_cake where price >= (select avg(price) from tbl_cake)");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Cake cake = new Cake();
				cake.setName(resultSet.getString(1));
				cake.setPrice(resultSet.getInt(2));
				list.add(cake);				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return list;		
	}
}
