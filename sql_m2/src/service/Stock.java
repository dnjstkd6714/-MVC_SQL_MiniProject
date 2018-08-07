// 2018. 8. 7(화) 이원상 Stock.java
/*
 * CREATE TABLE `tbl_stock` (
	`code` INT(10) NULL,
	`arrival` INT(10) NULL,
	`shipment` INT(10) NULL
	)
 */
package service;

public class Stock {				// 재고품
	private int code;				// 코드넘버
	private int arrival;			// 입고
	private int shipment;			// 출하
	
	public Stock() {				// default 생성자 선언
		super();					// 조상클래스 생성자 호출, 사용자가 별도로 상속한 클래스가 없을 때는 최상위  object클래스를 상속함
	}								// 별도로 적지않아도 컴파일시 컴파일러에 의해 object클래스 상속, 조상클래스 생성자 호출됨.

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getArrival() {
		return this.arrival;
	}

	public void setArrival(int arrival) {
		this.arrival = arrival;
	}

	public int getShipment() {
		return this.shipment;
	}

	public void setShipment(int shipment) {
		this.shipment = shipment;
	}
			
}
