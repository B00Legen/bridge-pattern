public class Circle extends Shape {
	private int radius;
	public Circle(int id, int radius, Renderer renderer) {
		super(id, renderer);
		this.radius = radius;
	}
	public String execute() {
		return renderer.renderCircle(radius);
	}
	public int getSize() {
		return radius;
	}
}
