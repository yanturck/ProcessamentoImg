package util;

public class Processador {
    // img - imagem a ser quantizada
    // in - quatidade de níveis (por canal) da imagem original
    // out -  quantidade de níveis (por canal) da imagem resultante
    public static Imagem quantizar(Imagem img, int in, int out) {
        int cor, faixa = (in) / (out);
        int mat[][][] = img.getMatriz();
        int qntCanais = img.getNCanais(); //rgb ou gray
        int alt = img.getAltura();
        int larg = img.getLargura();

        for (int c = 0; c < qntCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    cor = (mat[c][y][x])/faixa;
                    mat[c][y][x] = (int) (cor * faixa);
                }
            }
        }
        return new Imagem(mat);
    }
}
