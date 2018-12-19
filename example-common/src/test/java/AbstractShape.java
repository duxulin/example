/**
 * @Program AbstractShape
 * @Description
 * @Author duxl
 * @Create 2018/12/13 13:17
 */
public abstract class AbstractShape {

	protected int multipart;

	public AbstractShape() {
	}

	public AbstractShape(int multipart) {
		this.multipart = multipart;

	}

	abstract void drow();

	void eraser() {
		System.out.println("eraser.....");
	}

	public int getMultipart() {
		return multipart;
	}

	public void setMultipart(int multipart) {
		this.multipart = multipart;
	}
}
