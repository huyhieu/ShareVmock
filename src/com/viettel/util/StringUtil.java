package com.viettel.util;

import java.nio.charset.Charset;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

/**
 * @author hieunq5
 * 
 */
public class StringUtil {

	static final String AB = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ123456789!@#$%^&*";

	public static final int stringLength = 50;
	public static final int DEFAULT_PASSWORD_LENGHT = 8;

	public static final String stringFormat = "UTF-8";
	// Tieng Viet
	private static final char[] marked = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
		'A', 'A', 'A', 'A', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'i', 'i', 'i', 'i', 'i', 'I', 'I', 'I', 'I', 'I', 'o',
		'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'u', 'u', 'u', 'u',
		'u', 'u', 'u', 'u', 'u', 'u', 'u', 'U', 'U', 'U', 'U', 'U', 'y', 'y', 'y', 'y', 'y', 'Y', 'Y', 'Y', 'Y', 'Y', 'd', 'D', 'U', 'U', 'U', 'U', 'U', 'U'};
	private static final char[] notmarked = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A',
			'A', 'A', 'A', 'A', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'i', 'i', 'i', 'i', 'i', 'I', 'I', 'I', 'I', 'I', 'o',
			'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'u', 'u', 'u', 'u',
			'u', 'u', 'u', 'u', 'u', 'u', 'u', 'U', 'U', 'U', 'U', 'U', 'y', 'y', 'y', 'y', 'y', 'Y', 'Y', 'Y', 'Y', 'Y', 'd', 'D', 'U', 'U', 'U', 'U', 'U', 'U'};

	/**
	 * 
	 * Kiem tra xem mot CharSequence co null hay do dai la 0
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 
	 * Kiem tra xem mot chuoi String co null hay do dai la 0
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	/**
	 * 
	 * Trim whitespace o dau va cuoi cua chuoi String
	 */
	public static String trimWhitespace(String str) {
		if (!hasLength(str)) {
			return str;
		}
		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 
	 * Chuyen tieng viet co dau (unicode) thanh tieng anh (eng)
	 */
	public static String convertUnicodeToEngString(String unicodeString) {
		if (!hasLength(unicodeString)) {
			return "";
		}
		unicodeString = trimWhitespace(unicodeString);

		for (int i = 0; i < marked.length; i++) {
			unicodeString = unicodeString.replace(marked[i], notmarked[i]);
		}
		return unicodeString;
	}

	public static String getRandomTokenString()
	{
		String token = "";
		token = RandomStringUtils.randomAlphabetic(stringLength);
		return token;
	}

	public static String getRandomString(int length) {
		String token = "";
		token = RandomStringUtils.randomAlphabetic(length);
		return token;
	}

	public static byte[] stringToByte(String input) {
		byte[] output = input.getBytes(Charset.forName(stringFormat));
		return output;
	}

	public static byte[] stringToByte(String input, String stringFormat) {
		byte[] output = input.getBytes(Charset.forName(stringFormat));
		return output;
	}

	public static String byteToString(byte[] input) {
		String output = "";
		try {
			output = new String(input, "UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return output;
	}

	public static Random rnd = new Random();

	public static String randomString(int len)
	{
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
}
