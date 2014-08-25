package zservers.zlib.utilities;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class Utilities {

	private Utilities() {}

	public static String joinString(CharSequence[] array, String delimiter) {

        if(array == null || delimiter == null) return "";

        if (array.length == 0) return "";
        if (array.length == 1) return array[0].toString();
        StringBuilder sb = new StringBuilder();

        int i;
        for(i = 0; i < array.length - 1; i++) {

        	sb.append(array[i].toString());
        	sb.append(delimiter);
        }
        return sb.toString() + array[i];
	}

	public static String repeatChar(CharSequence seq, int count) {

        if(seq == null) throw new IllegalArgumentException("sequence mustn't be null");

		StringBuilder sb = new StringBuilder(count);
		for(int i = 0; i < count; i++) sb.append(seq);

		return sb.toString();
	}

	public static List<Character> arrayAsList(char[] a) {

        if(a == null) return null;

        List<Character> list = new ArrayList<Character>();
	    for (char c : a) {
	        list.add(c);
	    }

	    return list;
	}

	public static List<Integer> arrayAsList(int[] a) {

        if(a == null) return null;

        List<Integer> list = new ArrayList<Integer>();
	    for (int i : a) {
	        list.add(i);
	    }

	    return list;
	}

	public static List<Boolean> arrayAsList(boolean[] a) {

        if(a == null) return null;

        List<Boolean> list = new ArrayList<Boolean>();
	    for (boolean b : a) {
	        list.add(b);
	    }

	    return list;
	}

	public static List<Double> arrayAsList(double[] a) {

        if(a == null) return null;

        List<Double> list = new ArrayList<Double>();
	    for (double d : a) {
	        list.add(d);
	    }

	    return list;
	}

	public static String md5(String hash) {

        if(hash == null) return null;

		try {

			byte[] messageBytes = hash.getBytes("UTF-8");
			return DatatypeConverter.printHexBinary(md5Bytes(messageBytes));
		} catch (UnsupportedEncodingException e) { //never happens...

			return null;
		}
	}

	public static byte[] md5Bytes(byte[] hash) {

        if(hash == null) return null;

		try {

			return MessageDigest.getInstance("MD5").digest(hash);
		} catch (NoSuchAlgorithmException e) { //never happens...

			return null;
		}
	}

    public static String substringBetween(String string, char character, int startIndex) {

        int i = string.indexOf(character, startIndex);
        int i2 = string.indexOf(character, i + 1);

        return string.substring(i + 1, i2);
    }
}
