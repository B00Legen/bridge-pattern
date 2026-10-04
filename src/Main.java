public class Main {
	public static void main (String[] args) {
		if (args.length == 1 && args[0].equals("--demo")) {
			demo();
		}
	}
	public static void demo () {
		Renderer vector = new VectorRenderer();
		Renderer raster = new RasterRenderer();
		Renderer ascii = new AsciiRenderer();
		int tester = 0;
		
		{ // T1
			Shape circle = new Circle(1, 2, vector);
			String expected = "VECTOR circle radius=2";
			String result = circle.execute();
			
			boolean passed = result.equals(expected);
			if (passed) tester++;
			
			System.out.print("T1 " + 
							(passed ? "PASS" : "FAIL") +
							" | " + circle.getClass().getName() + " + " + vector.getClass().getName() +
							" | result=" + result);
			if (!passed) {
				System.out.print("    expected=" + expected);
			}
			System.out.println();
		}
		{ // T2
			Shape circle = new Circle(2, 2, raster);
			String expected = "RASTER circle radius=2";
			String result = circle.execute();
			
			boolean passed = result.equals(expected);
			if (passed) tester++;
			
			System.out.print("T2 " + 
							(passed ? "PASS" : "FAIL") +
							" | " + circle.getClass().getName() + " + " + raster.getClass().getName() +
							" | result=" + result);
			if (!passed) {
				System.out.print("    expected=" + expected);
			}
			System.out.println();
		}
		{ // T3
			Shape square = new Square(3, 3, vector);
			String expected = "VECTOR square side=3";
			String result = square.execute();
			
			boolean passed = result.equals(expected);
			if (passed) tester++;
			
			System.out.print("T3 " + 
							(passed ? "PASS" : "FAIL") +
							" | " + square.getClass().getName() + " + " + vector.getClass().getName() +
							" | result=" + result);
			if (!passed) {
				System.out.print("    expected=" + expected);
			}
			System.out.println();
		}
		{ // T4
			Shape square = new Square(4, 3, raster);
			String expected = "RASTER square side=3";
			String result = square.execute();
			
			boolean passed = result.equals(expected);
			if (passed) tester++;
			
			System.out.print("T4 " + 
							(passed ? "PASS" : "FAIL") +
							" | " + square.getClass().getName() + " + " + raster.getClass().getName() +
							" | result=" + result);
			if (!passed) {
				System.out.print("    expected=" + expected);
			}
			System.out.println();
		}
		{ // T5
			Shape circle = new Circle(5, 2, vector);
			Shape original = circle;
			int originalId = circle.getId();
			int originalSize = circle.getSize();
			String expected1 = "VECTOR circle radius=2";
			String expected2 = "RASTER circle radius=2";

			String before = circle.execute();

			circle.setImplementation(raster);

			String after = circle.execute();

			boolean sameObject = original == circle;
			boolean sameId = originalId == circle.getId();
			boolean sameSize = originalSize == circle.getSize();
			boolean stateUnchanged = sameSize && sameId;
			
			boolean passed = sameObject && stateUnchanged && before.equals(expected1) && after.equals(expected2);
			if (passed) tester++;

			System.out.print("T5 " +
							(passed ? "PASS" : "FAIL") +
							" | " + circle.getClass().getName() +
							" | " + vector.getClass().getName() +
							" -> " + raster.getClass().getName() +
							" | sameObject=" + sameObject +
							" | stateUnchanged=" + stateUnchanged);
			System.out.println("\tbefore=" + before +
							" | after=" + after);
			if (!passed) {
				System.out.print("    expected=" + expected1 + " and " + expected2);
			}
			System.out.println();
		}
		{ // T6
			Shape circle = new Circle(6, 2, ascii);
			String expected = "ASCII circle radius=2";
			String result = circle.execute();
			
			boolean passed = result.equals(expected);
			if (passed) tester++;
			
			System.out.print("T6 " + 
							(passed ? "PASS" : "FAIL") +
							" | " + circle.getClass().getName() + " + " + ascii.getClass().getName() +
							" | result=" + result);
			if (!passed) {
				System.out.print("    expected=" + expected);
			}
			System.out.println();
		}
		{ // T7
			Shape square = new Square(7, 3, ascii);
			String expected = "ASCII square side=3";
			String result = square.execute();
			
			boolean passed = result.equals(expected);
			if (passed) tester++;
			
			System.out.print("T7 " + 
							(passed ? "PASS" : "FAIL") +
							" | " + square.getClass().getName() + " + " + ascii.getClass().getName() +
							" | result=" + result);
			if (!passed) {
				System.out.print("    expected=" + expected);
			}
			System.out.println();
		}
		
		System.out.println("SUMMARY: " + tester + "/7 " +
						(tester == 7 ? "PASS" : "FAIL"));
	}
}
