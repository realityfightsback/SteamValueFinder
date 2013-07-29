package impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class ValueFinder {

	static File theFile = new File("C:\\Users\\Standard\\Desktop\\Steam.txt");

	public static void main(String[] args) throws IOException {
		lineParserImpl();
		regexImpl();
	}

	private static void regexImpl() throws IOException {
		Pattern pattern = Pattern.compile("\\$[0-9]+\\.[0-9][0-9]");

		Matcher matcher = pattern.matcher(FileUtils.readFileToString(theFile));

		double sum = 0;
		while (matcher.find()) {
			// System.out.println("I found the text" + matcher.group() + "START"
			// + matcher.start() + "END" +matcher.end());
			String temp = matcher.group().substring(1);
			sum += Double.parseDouble(temp);

		}
		System.out.println(sum);

	}

	public static void lineParserImpl() throws IOException {
		List<String> lines = FileUtils.readLines(theFile);

		Double sum = new Double(0);
		for (String string : lines) {
			if (string.contains("$")) {
				int indexOfDollarSign = string.indexOf("$");
				int indexOfDecimalSign = string.indexOf(".", indexOfDollarSign);
				String dollarAmount = string.substring(indexOfDollarSign + 1,
						indexOfDecimalSign + 2);
				System.out.println(dollarAmount);
				sum += Double.parseDouble(dollarAmount);

			}
		}
		System.out.println(sum);

	}
}