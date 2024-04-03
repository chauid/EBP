public class Utils {
	public Utils() {
	}

	public static double ReLU(double x) {
		return x >= 0 ? x : 0;
	}

	public static double Sigmoid(double x) {
		return 1 / (1 + Math.exp(x));
	}

}
