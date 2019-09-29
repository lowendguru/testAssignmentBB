package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class RandomValueGenerator {

	public static String getRandomSentence(int numberOfWords) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < numberOfWords; i++) {
			if (i > 0) {
				buffer.append(" ");
			}
			buffer.append(getRandomText(4 + (int) (Math.random() * 6)));
		}
		return buffer.toString();
	}

	public static String getRandomText(int stringLength) {

		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int character = (int) (Math.random() * text.length());
			buffer.append(text.charAt(character));
		}

		return buffer.toString();
	}

	public static String getRandomEmail() {
		StringBuilder buffer = new StringBuilder();

		buffer.append(getRandomText(getRandomInt(4, 20)));
		buffer.append("@");
		buffer.append(getRandomText(getRandomInt(4, 20)));
		buffer.append(".");
		buffer.append(getRandomText(3));

		return buffer.toString();
	}

	public static int getRandomInt(int min, int max) {

		Random random = new Random();
		int randomNum = random.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static String getRandomDate() {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String str_date1 = "2010-01-01";
		String str_date2 = "2017-12-31";
		Long value1 = cal.getTimeInMillis();

		try {
			cal.setTime(formatter.parse(str_date1));
			cal.setTime(formatter.parse(str_date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long value2 = cal.getTimeInMillis();

		long value3 = (long) (value1 + Math.random() * (value2 - value1));
		cal.setTimeInMillis(value3);
		return formatter.format(cal.getTime());

	}

}
