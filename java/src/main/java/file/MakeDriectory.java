package file;

import java.io.File;

public class MakeDriectory {
	public static void main(String[] args) {

		// MY_TEST_DIR 이라는 하위 폴더 만들기

		File f = new File("MY_TEST_DIR");
		if (!f.mkdirs())
			System.err.println("디렉토리 생성 실패");

		// MY_TEST_DIR 이라는 하위 폴더 밑에
		// 333 이라는 하위 폴더 또 만들기
		// 즉, MY_TEST_DIR/333 이렇게 중첩된 폴더 한꺼번에 생성

		f = new File("MY_TEST_DIR/333");
		if (!f.mkdirs())
			System.err.println("디렉토리 생성 실패");

	}
}
