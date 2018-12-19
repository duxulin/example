/**
 * @Program Triangle
 * @Description
 * @Author duxl
 * @Create 2018/12/13 13:19
 */
public class Triangle extends AbstractShape {


	public Triangle() {
		this.multipart = 3;
	}

	@Override
	void drow() {
		System.out.println("draw triangle");
	}

}
