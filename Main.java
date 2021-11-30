
import util.M01.Convolucao;
import util.M01.EqHistograma;
import util.Imagem;
import util.M01.MudancaSCores;
import util.M01.OperacoesAritmeticas;
import util.M01.OperacoesLogicas;
import util.M01.RealceBordas;
import util.M01.Stretching;
import util.M02.MoforlogiaBin;

public class Main {

    static String IMAGEM_A = "imagens/a.png";
    static String IMAGEM_B = "imagens/b.png";
    static String IMAGEM_LENNA = "imagens/lenna.png";
    static String IMAGEM_OLHO = "imagens/olho.png";
    static String IMAGEM_CINZA1 = "imagens/cinza1.png";
    static String IMAGEM_CINZA2 = "imagens/cinza2.png";
    static String IMAGEM_MASSA = "imagens/massa.jpg";
    static String IMAGEM_MACACO = "imagens/macaco.jpg";
    static String IMAGEM_PAISAGEM = "imagens/paisagem.jpeg";

    public static void main(String args[]) {
        // operacoesAritmeticas();
        // equalizacaoHistograma();
        // convolucao();
        // stretching();
        // operacoesLogicas();
        // mudancaCores();
        testeMoforlogiaBin();
    }

    private static void operacoesAritmeticas() {
        Imagem imgA = new Imagem(Main.IMAGEM_A);
        Imagem imgB = new Imagem(Main.IMAGEM_B);
        Imagem test[] = {imgA, imgB};
        OperacoesAritmeticas.adicao(imgA, imgB).mostrar("Adição de A e B");
        OperacoesAritmeticas.subtracao(imgA, imgB).mostrar("Subtração de A e B");
        OperacoesAritmeticas.media(test).mostrar("Média de A e B");
        imgA.mostrar("Imagem A");
        imgB.mostrar("Imagem B");
    }

    private static void equalizacaoHistograma() {
        Imagem imgA = new Imagem(Main.IMAGEM_PAISAGEM);
        imgA.mostrar("Imagem A");
        EqHistograma.equalizacaoHistograma(imgA).mostrar("Imagem Equalizada");
    }

    private static void convolucao() {
        media();
        passaAlta();
        mediana();
        realceBorda();
    }

    private static void stretching() {
        Imagem imgA = new Imagem(Main.IMAGEM_MASSA);
        imgA.mostrar("Imagem A");
        Stretching.linear(imgA, 1, 2, true).mostrar("Linear");
        Stretching.raizQuadrada(imgA, 2, true).mostrar("Raiz Quadrada");
        Stretching.quadrado(imgA, 2, true).mostrar("Quadrada");
        Stretching.logaritmica(imgA, 2, true).mostrar("Logaritmica");
        Stretching.exponencial(imgA, 1, 2, true).mostrar("Exponencial");
        Stretching.negativo(imgA, 1, 2, true).mostrar("Negativo");
        Stretching.minMax(imgA.getMatriz()).mostrar("MinMax");
    }

    private static void operacoesLogicas() {
        Imagem imgA = new Imagem(Main.IMAGEM_A);
        Imagem imgB = new Imagem(Main.IMAGEM_B);
        OperacoesLogicas.not(imgB).mostrar("Not B");
        OperacoesLogicas.or(imgA, imgB).mostrar("A or B");
        OperacoesLogicas.and(imgA, imgB).mostrar("A and B");
        OperacoesLogicas.xor(imgA, imgB).mostrar("A xor B");
        OperacoesLogicas.sub(imgA, imgB).mostrar("A sub B");
        imgA.mostrar("Imagem A");
        imgB.mostrar("Imagem B");
    }

    private static void mudancaCores() {
        Imagem imgA = new Imagem(Main.IMAGEM_MACACO);
        MudancaSCores.rgbCMY(imgA).mostrar("Imagem - CMY ");
        MudancaSCores.rgbHSI(imgA).mostrar("Imagem - HSI");
        MudancaSCores.rgbYUV(imgA).mostrar("Imagem - YUV");
        imgA.mostrar("Imagem - RGB");
    }

    private static void media() {
        Imagem imgA = new Imagem(Main.IMAGEM_OLHO);
        imgA.mostrar("Imagem A");
        Convolucao.filtroPassaBaixa(imgA, Convolucao.k2x2).mostrar("Passa Baixa - k2x2");
        Convolucao.filtroPassaBaixa(imgA, Convolucao.k3x3).mostrar("Passa Baixa - k3x3");
        Convolucao.filtroPassaBaixa(imgA, Convolucao.k5x5).mostrar("Passa Baixa - k5x5");
    }

    private static void passaAlta() {
        Imagem imgA = new Imagem(Main.IMAGEM_OLHO);
        imgA.mostrar("Imagem A");
        Convolucao.filtroPassaAlta(imgA, Convolucao.kernelFPA1).mostrar("Passa Alta - kernal 01");
        Convolucao.filtroPassaAlta(imgA, Convolucao.kernelFPA2).mostrar("Passa Alta - kernal 02");
        Convolucao.filtroPassaAlta(imgA, Convolucao.kernelFPA3).mostrar("Passa Alta - kernal 03");
        Convolucao.filtroPassaAlta(imgA, Convolucao.kernelFPA4).mostrar("Passa Alta - kernal 04");
    }

    private static void mediana() {
        Imagem imgA = new Imagem(Main.IMAGEM_OLHO);
        imgA.mostrar("Imagem A");
        Convolucao.filtroMediana(imgA, Convolucao.k3x3).mostrar("Filtro Mediana - k3x3");
        Convolucao.filtroMediana(imgA, Convolucao.k5x5).mostrar("Filtro Mediana - k5x5");
    }

    private static void realceBorda() {
        Imagem imgA = new Imagem(Main.IMAGEM_OLHO);
        imgA.mostrar("Imagem A");
        RealceBordas.realceBordasSobel(imgA).mostrar("Realce de Borda Sobel - G");
        RealceBordas.realceBordasPrewitt(imgA).mostrar("Realce de Borda Prewitt - G");
        RealceBordas.realceBordasRoberts(imgA).mostrar("Realce de Borda Roberts - G");
        RealceBordas.realceBordasIsotropico(imgA).mostrar("Realce de Borda Isotrópico - G");
        RealceBordas.realceBordasNDirecional(imgA); // Realce de bordas - Laplace
    }

    private static void testeMoforlogiaBin () {
        Imagem imgB = new Imagem(Main.IMAGEM_B);
        imgB.mostrar("Imagem B");
        MoforlogiaBin mb = new MoforlogiaBin();
        int [][]ee = {{255, 255, 255},{255, 255, 255},{255, 255, 255}};
        mb.erosao(imgB, ee).mostrar("Erosão");
        mb.dilatacao(imgB, ee).mostrar("Dilatação");
        mb.bordaInterna(imgB, ee).mostrar("Borda Interna");
        mb.bordaExterna(imgB, ee).mostrar("Borda Externa");
        mb.abertura(imgB, ee).mostrar("Abertura");
        mb.fechamento(imgB, ee).mostrar("Fechamento");
        mb.esqueleto(imgB, ee, 2).mostrar("Esqueleto");
    }
}
