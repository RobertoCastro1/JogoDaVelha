import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Campo[][] velha = new Campo[3][3];
        Boolean game = true;
        char simboloAtual = 'X';
        String vitoria  = "";
        Scanner sc = new Scanner(System.in);

        iniciarJogo(velha);
        while(game) {
            desenhaJogo(velha);
            vitoria = verificaVitoria(velha);
            if (!vitoria.equals("")) {
                System.out.printf("Jogador %s venceu!", vitoria);
                break;
            }

            try {
                if(verificarJogada(velha, Jogar(sc, simboloAtual), simboloAtual)) {
                    if (simboloAtual == 'X') {
                        simboloAtual = 'O';
                    }
                    else {
                        simboloAtual = 'X';
                    }
                }
            }
            catch (Exception e) {
                System.out.printf("Erro");
            }
        }
        System.out.println("O jogo acabou");
    }

    public static void desenhaJogo(Campo[][] v) {
        limparTela();
        System.out.println("    0   1   2");
        System.out.printf("0   %c | %c | %c %n", v[0][0].getSimbolo(), v[0][1].getSimbolo(), v[0][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("1   %c | %c | %c %n", v[1][0].getSimbolo(), v[1][1].getSimbolo(), v[1][2].getSimbolo());
        System.out.println("   ------------");
        System.out.printf("2   %c | %c | %c %n", v[2][0].getSimbolo(), v[2][1].getSimbolo(), v[2][2].getSimbolo());
    }

    public static String verificaVitoria(Campo[][] v) {
        for (int l = 0 ; l <3 ; l++) {
            
                if (v[l][0].getSimbolo() == 'X' && v[l][1].getSimbolo() == 'X' && v[l][2].getSimbolo() == 'X') {
                    return "X";
                }
                if (v[l][0].getSimbolo() == 'O' && v[l][1].getSimbolo() == 'O' && v[l][2].getSimbolo() == 'O') {
                    return "O";
                }
            
        }

        for (int l = 0 ; l <3 ; l++) {
            
            if (v[0][l].getSimbolo() == 'X' && v[1][l].getSimbolo() == 'X' && v[2][l].getSimbolo() == 'X') {
                return "X";
            }
            if (v[0][l].getSimbolo() == 'O' && v[1][l].getSimbolo() == 'O' && v[2][l].getSimbolo() == 'O') {
                return "O";
            }
        
        }

        if (v[1][1].getSimbolo() == 'X') {
            if (v[0][0].getSimbolo() == 'X' && v[2][2].getSimbolo() == 'X') {
                return "X";
            }
            if (v[2][0].getSimbolo() == 'X' && v[0][2].getSimbolo() == 'X') {
                return "X";
            }
        }
        
        if (v[1][1].getSimbolo() == 'O') {
            if (v[0][0].getSimbolo() == 'O' && v[2][2].getSimbolo() == 'O') {
                return "O";
            }
            if (v[2][0].getSimbolo() == 'O' && v[0][2].getSimbolo() == 'O') {
                return "O";
            }
        }
        
        return "";
    }

    public static Boolean verificarJogada(Campo[][] v, int p[], char simboloAtual) {
        if (v[p[0]][p[1]].getSimbolo() == ' ') {
            v[p[0]][p[1]].setSimbolo(simboloAtual);
            return true;
        }
        else {
            return false;
        }
    }

    public static int[] Jogar(Scanner sc, char sa) {
        int p[] = new int[2];
        System.out.printf("%s %c%n", "Quem joga: ", sa);
        System.out.print("Informe a linha: ");
        p[0] = sc.nextInt();
        System.out.print("Informe a coluna: ");
        p[1] = sc.nextInt();
        return p;
    }
    
    public static void limparTela() {
        for(int count=0; count<200; count++) {
            System.out.println("");
        }
    }
    
    public static void iniciarJogo(Campo[][] v) {
        for (int i = 0 ; i <3 ; i++) {
            for (int c = 0 ; c <3 ; c++) {
                v[i][c] = new Campo();
            }
        }
    }
}
