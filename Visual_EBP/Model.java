import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 가중치 W[N].weights[i][j]. N번째 레이어의 노드 수 = i, N+1번째 레이어의 노드 수 = j
 */
public class Model {
	/**
	 * 가중치 행렬 [N][i][j]
	 */
	public double[][][] WeightMatrix;

	/**
	 * 입력층 노드 수
	 */
	public double[] inputNodes;

	/**
	 * 편향값
	 */
	public double bias;

	/**
	 * 가중치 행렬
	 * 
	 * @param N 가중치 행렬 인덱스
	 * @param i 현재 노드 수
	 * @param j 다음 노드 수
	 */
	public Model(int N, int i, int j) {
		this.WeightMatrix = new double[N][i][j];
	}

	public static double[][] LoadWeight(String fileName) {
		String filePath = "models/" + fileName;

		File file = new File(filePath);
		long fileSize = file.length();

		System.out.println("fileSize:" + fileSize);

		// double 배열 선언
		double[] data = new double[(int) fileSize];

		// BufferedInputStream을 사용하여 파일 읽기
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath))) {
			int bytesRead = 0;
			while (bytesRead < fileSize) {
				// 8바이트씩 읽어 double 값으로 변환
				byte[] bytes = new byte[8];
				int read = in.read(bytes);
				if (read == -1) {
					break;
				}
				bytesRead += read;
				data[(bytesRead - read) / 8] = Double.parseDouble(new String(bytes));
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		// 배열 내용 출력
		// for (double value : data) {
		// System.out.println(value);
		// }
		double[][] result = new double[1][1];
		return result;
	}
}
