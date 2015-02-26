import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class XSLTPFCore {
	private enum XSLInputType {
		STRING, FILE, INVALID,
	}

	private static void usage() {
		System.err.println("usage: java XSLTPFCore <-|input-xml> <-e string-xsl|-t input-xsl> <-|output>");
		System.exit(1);
	}

	private static XSLInputType xslInputType(String opt) {
		if (opt.equals("-e")) {
			return XSLInputType.STRING;
		} else if (opt.equals("-t")) {
			return XSLInputType.FILE;
		} else {
			return XSLInputType.INVALID;
		}
	}

	private static boolean isStream(String file) {
		return file.equals("-");
	}

	public static void main(String args[]) throws Exception {
		if (args.length != 4) {
			usage();
		}

		XSLInputType inputType = xslInputType(args[1]);
		if (inputType == XSLInputType.INVALID) {
			usage();
		}

		try {
			StreamSource in = isStream(args[0]) ? new StreamSource(System.in)
			                                    : new StreamSource(new File(args[0]));
			StreamSource ss = (inputType == XSLInputType.STRING) ? new StreamSource(new StringReader(args[2]))
			                                                     : new StreamSource(new File(args[2]));
			StreamResult out = isStream(args[3]) ? new StreamResult(System.out)
			                                     : new StreamResult(new File(args[3]));

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
