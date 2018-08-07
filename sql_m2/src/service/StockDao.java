// 2018. 8. 7(화) 이원상 StockDao.java
package service;

import java.sql.*;
import java.util.*;

public class StockDao {
	public StockDao() {
		super();						// default 생성자 선언
	}									// 조상클래스 생성자 호출, 사용자가 별도로 상속한 클래스가 없을 때는 최상위  object클래스를 상속함
										// 별도로 적지않아도 컴파일시 컴파일러에 의해 object클래스 상속, 조상클래스 생성자 호출됨.
	
	/* 메소드 설명
	 * 매개변수 : 없음
	 * 리턴값 : DB Stock테이블 중 code를 그룹화한 결과 중 Stock테이블의 shipment의 평균값보다 적은 데이터 중에서 arrival열의 그룹 최저값이 서브쿼리 결과 작은데이터를 리스트한 결과
	 * DB테이블에 데이터가 추가(변경)될 경우 조회되는 값이 다수여서 List로 data type으로 리턴받음. 
	 * 메소드 용도 : 평균 출하량보다 적은 상품코드를 코드번호대로 그룹화 하여 코드별 최저 재고량이 평균 출하량보다 적은 데이터를 출력 
	 * Stock 클래스 프로퍼티 : int code, int arrival, int shipment
	 */
	public List<Stock> SelectStockListUnderAvg(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;		
		List<Stock> list = new ArrayList<Stock>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_m2?useUnicode=true&characterEncoding=utf-8", "root", "java0000");
			preparedStatement = connection.prepareStatement("select code, min(arrival) as arrival from tbl_stock group by code having min(arrival) < (select avg(shipment) from tbl_stock)");
			//group by는 내부정렬이 이루어지고 중복된 값을 배제한다, 위의 경우 code열을 기준으로 함으로 코드의 중복값이 하나로 그룹됨.
			//having은 group by에 부여하는 조건
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Stock stock = new Stock();
				stock.setCode(resultSet.getInt(1));
				stock.setArrival(resultSet.getInt(2));
				list.add(stock);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
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
		}
		return list;
	}
}		