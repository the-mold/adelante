public class MainProgramm {
	static String[] Split(String str, String flag) throws IllegalArgumentException {
		if (str.equals("") || flag.length() != 1) {
			throw new IllegalArgumentException("invalid argument");
		}

		//count instances
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (String.valueOf(str.charAt(i)).equals(flag)) {
				count++;
			}
		}

		if (count == 0) {
			return new String[]{str};
		}

		//create result array
		String[] res = new String[count + 1];

		count = 0;
		String segment = "";

		for (int i = 0; i < str.length(); i++) {
			if (!String.valueOf(str.charAt(i)).equals(flag)) {
				segment = segment.concat(String.valueOf(str.charAt(i)));
			} else {
				res[count] = segment;
				segment = "";
				count++;
			}
		}

		// add final segment
		res[count] = segment;

		return res;
	}

	static String arrToString(String[] arr) {
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			res = res.concat("[" + arr[i] + "]");
		}

		return res;
	}

	public static void main(String[] args) {		
		System.out.println("1==============================");
		String str = "1, 2, 3";
		String sep = ",";
		String[] got = Split(str, sep);
		System.out.println("got " + arrToString(got));
		System.out.println("exp " + arrToString(str.split(sep)));

		System.out.println("2==============================");
		String str2 = "make a sandwich";
		String sep2 = "a";
		String[] got2 = Split(str2, sep2);
		System.out.println("got " + arrToString(got2));
		System.out.println("exp " + arrToString(str2.split(sep2)));
	}
}
