public class Square extends Shape {
	private int side;
	public Square(int id, int side, Renderer renderer) {
		super(id, renderer);
		this.side = side;
	}
	public String execute() {
		return renderer.renderSquare(side);
	}
	public int getSize() {
		return side;
	}
}
