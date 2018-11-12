package lab8.tests.util;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import lab8.Polynomial;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class PolynomialTermUtils {
	public static Polynomial create(Supplier<Polynomial> supplier, Iterable<Term> terms) {
		Polynomial polynomial = supplier.get();
		for (Term term : terms) {
			polynomial = polynomial.addTerm(term.getCoefficient(), term.getDegree());
		}
		return polynomial;
	}

	public static List<Term> parseTerms(String text) {
		text = text.replaceAll("\\s+", "");
		text = text.replaceAll("-", "+-");

		String[] termTexts;
		if (text.contains("+")) {
			termTexts = text.split("\\+");
		} else {
			termTexts = new String[] { text };
		}

		List<Term> terms = new LinkedList<>();
		for (String termText : termTexts) {
			if (termText.length() > 0) {
				double coefficient;
				int degree;
				if (termText.contains("x^")) {
					String[] parts = termText.split("x\\^");
					if (parts[0].length() > 0) {
						if (parts[0].equals("-")) {
							coefficient = -1;
						} else {
							coefficient = Double.parseDouble(parts[0]);
						}
					} else {
						coefficient = 1.0;
					}
					degree = Integer.parseInt(parts[1]);
				} else if (termText.contains("x")) {
					String[] parts = termText.split("x");
					degree = 1;
					if (parts.length > 0) {
						if (parts[0].equals("-")) {
							coefficient = -1;
						} else {
							coefficient = Double.parseDouble(parts[0]);
						}
					} else {
						coefficient = 1.0;
					}
				} else {
					degree = 0;
					coefficient = Double.parseDouble(termText);
				}
				terms.add(new Term(coefficient, degree));
			}
		}
		return terms;
	}

	private static void appendDegree(StringBuilder sb, int degree) {
		if (degree > 0) {
			sb.append("x");
			if (degree > 1) {
				sb.append("^");
				sb.append(degree);
			}
		}
	}

	public static String addSpacesAroundSigns(String s) {
		if (s.length() > 0) {
			char c = s.charAt(0);
			s = s.substring(1);
			s = s.replaceAll("\\+", " + ");
			s = s.replaceAll("\\-", " - ");
			s = c + s;
		}
		return s;
	}

	public static String toString(Iterable<Term> terms) {
		StringBuilder sb = new StringBuilder();
		boolean isPositivePrefixIncluded = false;
		for (Term term : terms) {
			double coefficient = term.getCoefficient();
			if (coefficient >= 0.0) {
				if (isPositivePrefixIncluded) {
					sb.append("+");
				}
			}
			sb.append(coefficient);
			appendDegree(sb, term.getDegree());
			isPositivePrefixIncluded = true;
		}
		return addSpacesAroundSigns(sb.toString());
	}

	public static List<Term> toReversed(List<Term> terms) {
		List<Term> reversedTerms = new LinkedList<>(terms);
		Collections.reverse(reversedTerms);
		return reversedTerms;
	}

	public static List<Term> toReversed(String text) {
		return toReversed(parseTerms(text));
	}

	public static List<Term> toShuffled(List<Term> terms) {
		List<Term> shuffledTerms = new LinkedList<>(terms);
		Collections.shuffle(shuffledTerms);
		return shuffledTerms;
	}

	public static List<Term> toShuffled(String text) {
		return toShuffled(parseTerms(text));
	}
}
