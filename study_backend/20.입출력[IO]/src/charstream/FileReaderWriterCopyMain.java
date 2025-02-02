package charstream;

import java.io.FileReader;
import java.io.FileWriter;

public class FileReaderWriterCopyMain {

	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("데미안.txt");
		FileWriter fw = new FileWriter("데미안[복사].txt");
		
		int lineCount = 0;
		int charCount = 0;
		while (true) {
			int readChar = fr.read();
			if (readChar == -1) break;
			charCount++;
			if (readChar == '.') {
				fw.write(readChar);
				fw.write('\n');
			} else if (readChar == '-') {
				fw.write("page");
			} else if (readChar == '\n') {
				lineCount++;
			} else {
				fw.write(readChar);
			}
		}
		fw.flush();
		fw.close();
		fr.close();
		System.out.println("FileReaderWriterCopy[" + lineCount + "line copy]");
		System.out.println("FileReaderWriterCopy[" + charCount + "글자 copy]");
	}

}
