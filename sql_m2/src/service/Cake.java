// 2018. 8. 6(월) 이원상 Cake.java
/*	DB생성문장
	CREATE TABLE `tbl_cake` (
	`name` VARCHAR(50) NULL DEFAULT NULL,
	`price` INT(10) NULL DEFAULT NULL
	)
 */
package service;

public class Cake {
	private String name;				// 케이크 이름
	private int price;					// 케이크 가격
	
	public Cake() {						// default 생성자 선언
		super();						// 조상클래스 생성자 호출, 사용자가 별도로 상속한 클래스가 없을 때는 최상위  object클래스를 상속함
	}									// 별도로 적지않아도 컴파일시 컴파일러에 의해 object클래스 상속, 조상클래스 생성자 호출됨.
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
