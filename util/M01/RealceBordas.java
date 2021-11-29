package util.M01;

import util.Imagem;

// Realce de Bordas - Nao direcional
// Realce de Bordas - Direcional
// Realce de Bordas - Sobel
// Realce de Bordas - Prewitt
// Realce de Bordas - Roberts
// Realce de Bordas - Isotropico
// Realce de Bordas - Laplace

public class RealceBordas {
    // Kernel Realce de Bordas - não direcional - Laplace
    public static int kernelRB1[][] = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};
    public static int kernelRB2[][] = {{0,-1,0},{-1,4,-1},{0,-1,0}};
    public static int kernelRB3[][] = {{1,-2,1},{-2,3,-2},{1,-2,1}};

    // Kernel Realce de Bordas - Sobel
    public static int kernelRBS1[][] = {{-1,0,1},{-2,0,2},{-1,0,1}}; // Gx
    public static int kernelRBS2[][] = {{-1,-2,-1},{0,0,0},{1,2,1}}; // Gy

    // Kernel Realce de Bordas - Prewitt
    public static int kernelRBP1[][] = {{-1,-1,-1},{0,0,0},{1,1,1}}; // Gx
    public static int kernelRBP2[][] = {{-1,0,1},{-1,0,1},{-1,0,1}}; // Gy

    // Kernel Realce de Bordas - Roberts
    public static int kernelRBR1[][] = {{1,0},{0,-1}}; // Gx
    public static int kernelRBR2[][] = {{0,1},{-1,0}}; // Gy

    // Kernel Realce de Bordas - Isotropico
    public static int kernelRBI1[][] = {{-1,0,-1},{-(int)(Math.sqrt(2)),0,(int)(Math.sqrt(2))},{-1,0,1}}; // Gx
    public static int kernelRBI2[][] = {{-1,-(int)(Math.sqrt(2)),-1},{0,0,0},{1,(int)(Math.sqrt(2)),1}}; // Gy

    // Kernel Realce de Bordas - Laplace
    public static int kernelRBL1[][] = {{0,-1,0},{-1,4,-1},{0,-1,0}};
    public static int kernelRBL2[][] = {{-1,-1,-1},{-1,8,-1},{-1,-1,-1}};


    public static void realceBordasNDirecional (Imagem in) {
        Convolucao.filtroPassaAlta(in, RealceBordas.kernelRB1).mostrar("Passa Alta - kernal 01");
        Convolucao.filtroPassaAlta(in, RealceBordas.kernelRB2).mostrar("Passa Alta - kernal 02");
        Convolucao.filtroPassaAlta(in, RealceBordas.kernelRB3).mostrar("Passa Alta - kernal 03");
    }    

    public static Imagem realceBordasSobel (Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matOut[][][] = new int[nCanais][alt][larg];
        
        Imagem GxImg = Convolucao.filtroPassaAlta(in, kernelRBS1);
        Imagem GyImg = Convolucao.filtroPassaAlta(in, kernelRBS2);

        GxImg.mostrar("Realce de Borda Sobel - Gx");
        GyImg.mostrar("Realce de Borda Sobel - Gy");

        int Gx[][][] = GxImg.getMatriz();
        int Gy[][][] = GyImg.getMatriz();

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = (int)(Math.sqrt((Gx[c][y][x]*Gx[c][y][x]) + (Gy[c][y][x]*Gy[c][y][x])));
                }
            }
        }
        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }

    public static Imagem realceBordasPrewitt (Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matOut[][][] = new int[nCanais][alt][larg];
        
        Imagem GxImg = Convolucao.filtroPassaAlta(in, kernelRBP1);
        Imagem GyImg = Convolucao.filtroPassaAlta(in, kernelRBP2);

        GxImg.mostrar("Realce de Borda Prewitt - Gx");
        GyImg.mostrar("Realce de Borda Prewitt - Gy");

        int Gx[][][] = GxImg.getMatriz();
        int Gy[][][] = GyImg.getMatriz();

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = (int)(Math.sqrt((Gx[c][y][x]*Gx[c][y][x]) + (Gy[c][y][x]*Gy[c][y][x])));
                }
            }
        }
        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }

    public static Imagem realceBordasRoberts (Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matOut[][][] = new int[nCanais][alt][larg];
        
        Imagem GxImg = Convolucao.filtroPassaAlta(in, kernelRBR1);
        Imagem GyImg = Convolucao.filtroPassaAlta(in, kernelRBR2);

        GxImg.mostrar("Realce de Borda Roberts - Gx");
        GyImg.mostrar("Realce de Borda Roberts - Gy");

        int Gx[][][] = GxImg.getMatriz();
        int Gy[][][] = GyImg.getMatriz();

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = (int)(Math.sqrt((Gx[c][y][x]*Gx[c][y][x]) + (Gy[c][y][x]*Gy[c][y][x])));
                }
            }
        }
        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }

    public static Imagem realceBordasIsotropico (Imagem in) {
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matOut[][][] = new int[nCanais][alt][larg];
        
        Imagem GxImg = Convolucao.filtroPassaAlta(in, kernelRBI1);
        Imagem GyImg = Convolucao.filtroPassaAlta(in, kernelRBI2);

        GxImg.mostrar("Realce de Borda Isotrópico - Gx");
        GyImg.mostrar("Realce de Borda Isotrópico - Gy");

        int Gx[][][] = GxImg.getMatriz();
        int Gy[][][] = GyImg.getMatriz();

        for (int c = 0; c < nCanais; c++) {
            for (int y = 0; y < alt; y++) {
                for (int x = 0; x < larg; x++) {
                    matOut[c][y][x] = (int)(Math.sqrt((Gx[c][y][x]*Gx[c][y][x]) + (Gy[c][y][x]*Gy[c][y][x])));
                }
            }
        }

        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }
}
