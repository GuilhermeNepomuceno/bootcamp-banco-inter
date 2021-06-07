import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validadora {
	public final static int MAX = 200;

	public static void main(String[] args) throws IOException, NullPointerException {
		var bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boolean oneLowerCase, oneUpperCase, oneDigit, anyPunctuationBlank;
		int senhaLength;
		String senha, regex;
		Matcher matcher;

		regex = "[(?=\\p{Punct}\\p{Blank})]+"; // regex seleciona no minimo 1 ponto ou " "

		Pattern pattern = Pattern.compile(regex);

		do {
			senha = bufferedReader.readLine();
			if (senha == null)
				break;
			matcher = pattern.matcher(senha);
			anyPunctuationBlank = matcher.find();

			if (!anyPunctuationBlank) {
				oneUpperCase = senha.chars().anyMatch(Character::isUpperCase);
				oneLowerCase = senha.chars().anyMatch(Character::isLowerCase);
				oneDigit = senha.chars().anyMatch(Character::isDigit);
				senhaLength = senha.length();
				if (!oneUpperCase || !oneLowerCase || !oneDigit || senhaLength < 6 || senhaLength > 32) {
					System.out.println("Senha invalida.");
				} else {
					System.out.println("Senha valida.");
				}
			} else {
				System.out.println("Senha invalida.");
			}
		} while (true);
	}
}
