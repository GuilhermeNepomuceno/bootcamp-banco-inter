import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;
import java.util.stream.Collectors;

public class Abreviacao {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Palavra> palavras = new ArrayList<Palavra>();
        StringBuilder fraseOriginal = new StringBuilder();
        List<String> postAbreviado = new ArrayList<>();

        while (st.hasMoreTokens()) {
            String palavra = st.nextToken();
            fraseOriginal.append(palavra + " ");
            postAbreviado.add(palavra);
            if (palavra.length() > 2) {
                if (palavras.stream().anyMatch(objeto -> objeto.getPalavra().equals(palavra))) {
                    palavras.forEach(objeto -> {
                        if (objeto.getPalavra().equals(palavra))
                            objeto.calculaPeso();
                    });
                } else
                    palavras.add(new Palavra(palavra));
            }
        }

        List<Palavra> listaPalavrasAbreviadas = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            char letra = ch;
            palavras.stream().filter(objeto -> objeto.getAbreviacao() == letra)
                    .sorted((o1, o2) -> o2.getPeso() - o1.getPeso()).peek(objetoPalavra -> {
                        listaPalavrasAbreviadas.add(objetoPalavra);
                        Collections.replaceAll(postAbreviado, objetoPalavra.getPalavra(), objetoPalavra.getAbrePonto());
                    }).anyMatch(objeto -> objeto.getAbreviacao() == letra);
        }

        System.out.println(String.join(" ", postAbreviado));
        System.out.println(
                listaPalavrasAbreviadas.stream().collect(Collectors.summingInt(value -> value.getQtdPalavra())));
        listaPalavrasAbreviadas.stream()
                .forEach(objeto -> System.out.println(objeto.getAbrePonto() + " = " + objeto.getPalavra()));

    }
}

class Palavra {
    private String palavra;
    private Integer peso;
    private Integer qtdPalavra;
    private char abreviacao;
    private String abrePonto;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.abreviacao = palavra.charAt(0);
        this.abrePonto = abreviacao + ".";
        this.qtdPalavra = 0;
        this.peso = 0;
        calculaPeso();
    }

    public void calculaPeso() {
        peso += palavra.length() - 2;
        qtdPalavra += 1;
    }

    @Override
    public String toString() {
        return abrePonto + " " + palavra + " - " + peso + " qtd: " + qtdPalavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPseo() {
        this.peso += this.peso;
    }

    public Integer getQtdPalavra() {
        return qtdPalavra;
    }

    public void setQtdPalavra(Integer qtdPalavra) {
        this.qtdPalavra = qtdPalavra;
    }

    public char getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(char abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getAbrePonto() {
        return abrePonto;
    }

    public void setAbrePonto(String abrePonto) {
        this.abrePonto = abrePonto;
    }
}