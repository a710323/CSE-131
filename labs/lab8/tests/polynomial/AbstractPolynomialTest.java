package lab8.tests.polynomial;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.rules.TestRule;

import lab5.tests.utils.UnitTestUtils;
import lab8.Polynomial;
import lab8.tests.util.PolynomialTermUtils;
import lab8.tests.util.Term;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public abstract class AbstractPolynomialTest {
	@Rule
	public TestRule timeout = UnitTestUtils.createTimeoutRule();

	protected void checkTerms(String message, Polynomial polynomial, List<Term> terms) {
		int highestDegree = terms.size() > 0 ? terms.stream().max(Term::compareTo).get().getDegree() : 0;

		final double EPSILON = 0.0;

		for (int d = 0; d <= highestDegree; d++) {
			for (Term term : terms) {
				if (term.getDegree() == d) {
					StringBuilder sb = new StringBuilder();
					if (message != null) {
						sb.append(message);
						sb.append(".  ");
					}
					sb.append("degree: ");
					sb.append(d);
					sb.append(";");
					assertEquals(sb.toString(), term.getCoefficient(), polynomial.getCoefficientAtDegree(d), EPSILON);
				}
			}
		}

		for (int d = highestDegree + 1; d < highestDegree + 11; d++) {
			StringBuilder sb = new StringBuilder();
			if (message != null) {
				sb.append(message);
			}
			sb.append("(past highest) degree: ");
			sb.append(d);
			sb.append(";");
			assertEquals(sb.toString(), 0.0, polynomial.getCoefficientAtDegree(d), EPSILON);
		}
	}

	protected static double nextNonZeroCoefficient(Random random) {
		double coefficient = (random.nextInt(3_999) + 1) / 100.0;
		boolean isPositive = random.nextBoolean();
		return isPositive ? coefficient : -coefficient;
	}

	protected static String nextPolynomialText(Random random, double portionOfTermsIncluded, int highestDegree,
			BiConsumer<Double, Integer> consumer) {
		StringBuilder sb = new StringBuilder();
		boolean isPositivePrefixIncluded = false;
		for (int d = highestDegree; d >= 0; --d) {
			boolean isIncluded = random.nextDouble() < portionOfTermsIncluded;
			if (isIncluded) {
				double coefficient = nextNonZeroCoefficient(random);
				if (coefficient >= 0.0) {
					if (isPositivePrefixIncluded) {
						sb.append("+");
					}
				}
				sb.append(coefficient);
				appendDegree(sb, d);
				isPositivePrefixIncluded = true;
				if (consumer != null) {
					consumer.accept(coefficient, d);
				}
			}
		}
		return PolynomialTermUtils.addSpacesAroundSigns(sb.toString());
	}

	protected static String nextPolynomialText(Random random, double portionOfTermsIncluded, int highestDegree) {
		return nextPolynomialText(random, portionOfTermsIncluded, highestDegree, null);
	}

	protected static void appendDegree(StringBuilder sb, int degree) {
		if (degree > 0) {
			sb.append("x");
			if (degree > 1) {
				sb.append("^");
				sb.append(degree);
			}
		}
	}

	protected static List<String> generateInDescendingOrderPolynomialTextTestCases() {
		List<String> result = new LinkedList<>();

		result.add("1");
		result.add("x + 1");
		result.add("x^2 + x + 1");

		result.add("42");
		result.add("2x + 3");
		result.add("4x^2 + 5x + 6");

		result.add("-273.15");
		result.add("7x - 8");
		result.add("-9x^2 + 10x - 11");

		Random random = new Random();
		final int HIGHEST_DEGREE = 5;
		for (int i = 0; i < 8; ++i) {
			result.add(nextPolynomialText(random, 1.0, HIGHEST_DEGREE));
		}

		for (int i = 0; i < 16; ++i) {
			result.add(nextPolynomialText(random, 0.5, HIGHEST_DEGREE));
		}

		return result;
	}

	protected static List<Object[]> toParameters(List<String> polynomialTexts) {
		List<Object[]> result = new LinkedList<>();
		polynomialTexts.forEach(text -> result.add(new Object[] { text }));
		return result;
	}

	protected static <T> List<Object[]> toParametersWithReverseAndShuffle(List<String> polynomialTexts,
			Function<String, T> mapper, BiFunction<String, T, Object[]> toParamsFunction) {
		List<Object[]> result = new LinkedList<>();
		polynomialTexts.forEach(text -> result.add(toParamsFunction.apply("in-descending-order", mapper.apply(text))));

		polynomialTexts.forEach(text -> {
			List<Term> terms = PolynomialTermUtils.parseTerms(text);
			if (terms.size() > 0 && terms.get(0).getDegree() > 0) {
				List<Term> reversedTerms = PolynomialTermUtils.toReversed(text);
				result.add(
						toParamsFunction.apply("in-ascending-order", mapper.apply(PolynomialTermUtils.toString(reversedTerms))));
			}
		});

		polynomialTexts.forEach(text -> {
			List<Term> terms = PolynomialTermUtils.parseTerms(text);
			if (terms.size() > 0 && terms.get(0).getDegree() > 1) {
				List<Term> shuffledTerms = PolynomialTermUtils.toShuffled(text);
				result.add(
						toParamsFunction.apply("shuffled", mapper.apply(PolynomialTermUtils.toString(shuffledTerms))));
			}
		});
		return result;
	}

	protected static List<Object[]> toParametersWithReverseAndShuffle(List<String> polynomialTexts) {
		return toParametersWithReverseAndShuffle(polynomialTexts, s -> s,
				(message, text) -> new Object[] { message, text });
	}

	protected static List<Object[]> generateInDescendingOrderPolynomialTextTestCaseParameters() {
		return toParameters(generateInDescendingOrderPolynomialTextTestCases());
	}

	protected static List<Object[]> generatePolynomialTextTestCaseParametersWithReverseAndShuffle() {
		return toParametersWithReverseAndShuffle(generateInDescendingOrderPolynomialTextTestCases());
	}

	protected static <T> List<T> generateInDescendingOrderPolynomialTextTestCases(Function<String, T> mapper) {
		List<String> texts = generateInDescendingOrderPolynomialTextTestCases();
		return texts.stream().map(mapper).collect(Collectors.toList());
	}
}
