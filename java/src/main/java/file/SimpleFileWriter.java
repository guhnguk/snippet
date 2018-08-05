package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleFileWriter {

	public static void main(String[] args) {
		// new SimpleFileWriter().myFileWriter();
		new SimpleFileWriter().createNewFileWithDirectory();
	}

	private void createNewFileWithDirectory() {
		File directory = new File("data");
		if (!directory.mkdir()) {
			System.out.println("Directory failed.");
		}

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(directory.getName() + "/out.txt"));
			String text = "디렉터리 안에 들어갈 파일의 텍스트 ";
			
			bw.write(text);
			bw.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
			}
		}
	}

	public void myFileWriter() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("data/out.txt"));
			String s = "출력 파일에 저장될 이런 저런 문자열입니다.";

			out.write(s);
			out.newLine();

			out.write(s);
			out.newLine();

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 이어쓰기
	public void myFileWriter2() {
		String content = "파일쓰기 생성 내용";
		String fileName = "aaa.txt";
		File file = new File(fileName);

		if (fileName.length() == 0) {
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter buff_writer = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(buff_writer, true);
				pw.println(content);

				if (pw.checkError()) {
					System.out.println("print_writer error!!");
				}

				file.createNewFile();

				System.out.println("파일 생성 성공~ㅋ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { // 이어쓰기
			try {
				BufferedWriter buff_writer = new BufferedWriter(new FileWriter(file, true));
				PrintWriter pw = new PrintWriter(buff_writer, true);
				pw.println(content);

				if (pw.checkError()) {
					System.out.println("print_writer error!!");
				}
				System.out.println("이어쓰기 성공?!ㅋ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
