public abstract class Shape {
	private final int id;
	protected Renderer renderer;
	protected Shape(int id, Renderer renderer) {
		this.id = id;
		setImplementation(renderer);
	}
	public abstract String execute();
	public void setImplementation(Renderer renderer) {
		this.renderer = renderer;
	}
	public int getId() {
		return id;
	}
	public abstract int getSize();
}
