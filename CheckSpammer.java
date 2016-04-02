import java.net.*;

public class CheckSpammer {

	public static final String BHSERVICE = "sbl.spamhaus.org";

	public static void main(String[] args) throws UnknownHostException {

		for (String arg: args) {
			if (isKnownSpammer(arg)) {
				System.out.println(arg + " is a known spammer.");
			}
			else {
				System.out.println(arg + " doesn't appear to be a spammer.");
			}
		}
	}

	private static boolean isKnownSpammer(String arg) {
		try {
			InetAddress address = InetAddress.getByName(arg);
			byte[] quad = address.getAddress();
			String query = BHSERVICE;
			for (byte octet : quad) {
				int unsignedByte = octet < 0 ? octet + 256 : octet;
				query = unsignedByte + "." + query;
			}
			InetAddress.getByName(query);
			return true;
		} catch (UnknownHostException e) {
			return false;
		}
	}

}
