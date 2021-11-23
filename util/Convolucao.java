package util;

// Equalizacao do Histograma
// Convolucao - Passa Alta
// Filtro da Mediana

public class Convolucao {
    // Kernel Filtro Passa Baixa
    public static int k2x2[][] = {{1,1},{1,1}};
    public static int k3x3[][] = {{1,1,1},{1,1,1},{1,1,1}};
    public static int k5x5[][] = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};

    // Kernel Filtro Passa Alta
    public static int kernelFPA1[][] = {{0,-1,0},{-1,5,-1},{0,-1,0}};
    public static int kernelFPA2[][] = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
    public static int kernelFPA3[][] = {{1,-2,1},{-2,5,-2},{1,-2,1}};
    public static int kernelFPA4[][] = {{3,-7,-7,3},{-7,13,13,-7},{-7,13,13,-7},{3,-7,-7,3}};

    public static Imagem filtroPassaBaixa(Imagem in, int[][]kernel) {
        int r = (kernel.length-1)/2;
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int soma, somaPeso = 0;
        
        for (int dy = 0; dy <= 2*r; dy++) {
            for (int dx = 0; dx <= 2*r; dx++) {
                somaPeso += kernel[r][r];
            }
        }

        for (int c = 0; c < nCanais; c++) {
            for (int y = r; y < alt-r; y++) {
                for (int x = r; x < larg-r; x++) {
                    soma = 0;
                    for (int dy = -r; dy <= +r; dy++) {
                        for (int dx = -r; dx <= +r; dx++) {
                            soma += matIn[c][y+dy][x+dx]*kernel[r+dy][r+dx];
                        }
                    }
                    matOut[c][y][x] = soma/somaPeso;
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem filtroMediana(Imagem in, int[][]kernel) {
        int r = (kernel.length-1)/2;
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int cout, mediana = (int)((kernel.length*kernel.length)/2);

        for (int c = 0; c < nCanais; c++) {
            for (int y = r; y < alt-r; y++) {
                for (int x = r; x < larg-r; x++) {
                    cout = 0;
                    for (int dy = -r; dy <= +r; dy++) {
                        for (int dx = -r; dx <= +r; dx++) {
                            cout++;
                            if (cout == mediana) matOut[c][y][x]= matIn[c][y+dy][x+dx];
                        }
                    }
                }
            }
        }
        return new Imagem(matOut);
    }

    public static Imagem filtroPassaAlta(Imagem in, int[][]kernel) {
        int r = (kernel.length-1)/2;
        int alt = in.getAltura();
        int larg = in.getLargura();
        int nCanais = in.getNCanais();
        int matIn[][][] = in.getMatriz();
        int matOut[][][] = new int[nCanais][alt][larg];
        int soma;

        for (int c = 0; c < nCanais; c++) {
            for (int y = r; y < alt-r; y++) {
                for (int x = r; x < larg-r; x++) {
                    soma = 0;
                    for (int dy = -r; dy <= +r; dy++) {
                        for (int dx = -r; dx <= +r; dx++) {
                            soma += matIn[c][y+dy][x+dx]*kernel[r+dy][r+dx];
                        }
                    }
                    matOut[c][y][x] = soma;
                }
            }
        }
        return Stretching.minMax(matOut);
        // return new Imagem(matOut);
    }
}
