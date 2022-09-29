import java.util.Scanner;


public class Inicio {
    public static void main(String[] args) throws InterruptedException {
        String Word = "jorge";
        String newWord;
        String lowbar = new String(new char[Word.length()]).replace("\0", " _ ");
        int option = 0;
        boolean fullWord = false;

        // Thread.sleep(1000);

        do {
            Scanner sc = new Scanner(System.in);

            // System.out.print("\033[H\033[2J");
            // System.out.flush();
            System.out.println("PALABRA");
            System.out.println(lowbar);
            option = Menu(option);
            switch (option) {
                case 1:
                    System.out.print("Introduce la letra: ");
                    String guess = sc.next();
                    letter(Word,guess,lowbar);
                    break;
                case 2:
                    if (wordInput(Word)) {
                        fullWord = true;
                    } else {
                        fullWord = false;
                        System.out.println("La palabra introducida no es correcta.");
                    }
                    break;
                case 3:
                    break;
                case 4:
                    fullWord = true;
                    break;
                default:
                    System.out.println("Ese numero es incorrecto. \n Vuelve a introducirlo");

                    break;
            }
        } while (option == 3 || !fullWord);

        if (option != 4) {
            System.out.println("HAS GANADO");
        } else {
            System.out.println("Mas suerte la proxima vez");
        }

    }

    //initialice the Game Menu
    public static int Menu(int option) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1 - [ Introducir una letra ]");
        System.out.println("2 - [ Introducir una palabra ]");
        System.out.println("3 - [ Detalles ]");
        System.out.println("4 - [ Salir ]");

        option = sc.nextInt();
        return option;
    }

    //Test if the introduced word is the same
    public static Boolean wordInput(String Word) {
        Scanner wd = new Scanner(System.in);

        System.out.print("Input the word: ");
        String clasic = wd.nextLine();

        return clasic.equals(Word);
    }

    //Show " _ " letter by letter

    //Introduce a letter
    public static void letter(String Word, String guess, String lowbar) {

        String newlowbar = "";

        for (int i = 0; i < Word.length(); i++) {
            if(Word.charAt(i) == guess.charAt(0)){
                newlowbar += guess.charAt(0);
            }else if(lowbar.charAt(i) != '_'){
                newlowbar += Word.charAt(i);
            }else{
                newlowbar += "_";
            }
        }
    }
}
