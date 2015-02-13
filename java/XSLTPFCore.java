import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class XSLTPFCore {
	private static void usage() {
		System.err.println("usage: java XSLTPFCore <-|input-xml> <input-xsl> <-|output>");
		System.exit(1);
	}

	private static boolean isStream(String file) {
		return file.equals("-");
	}

	public static void main(String args[]) throws Exception {
		if (args.length != 3) {
			usage();
		}

		try {
			StreamSource in = isStream(args[0]) ? new StreamSource(System.in)
			                                    : new StreamSource(new File(args[0]));
			StreamSource ss = new StreamSource(new File(args[1]));
			StreamResult out = isStream(args[2]) ? new StreamResult(System.out)
			                                     : new StreamResult(new File(args[2]));

			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer(ss);
			tf.transform(in, out);

			System.exit(0);
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			System.exit(1);
		}
	}
}
