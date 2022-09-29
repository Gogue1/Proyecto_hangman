import java.util.Scanner;


public class Inicio {
    public static void main(String[] args) throws InterruptedException {
        String Word = "jorge";
        String lowbar = new String(new char[Word.length()]).replace("\0", "_");
        int option = 0, count = 0;
        boolean fullWord = false;

        // Thread.sleep(1000);

        while (option == 3 || !fullWord){
            Scanner sc = new Scanner(System.in);

            // System.out.print("\033[H\033[2J");
            // System.out.flush();
            System.out.print("PALABRA");
            System.out.println("     Tienes " + count + " fallos");
            System.out.println(lowbar);
            option = Menu(option);
            switch (option) {
                case 1:
                    System.out.print("Introduce la letra: ");
                    String resolve = sc.nextLine();
                    letter(Word,lowbar,resolve,count,fullWord);
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
        }

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
    public static void letter(String Word, String lowbar,String resolve, int count,boolean fullWord) {

        String newlowbar = "";

        for (int i = 0; i < Word.length(); i++) {
            if(Word.charAt(i) == resolve.charAt(0)){
                newlowbar += resolve.charAt(0);
            }else if(lowbar.charAt(i) != '_'){
                newlowbar += Word.charAt(i);
            }else{
                newlowbar += "_";
            }
        }

        if (lowbar.equals(newlowbar)) {
            count++;
        }else{
            lowbar = newlowbar;
        }

        if(newlowbar.equals(Word)){
            ;
        }
    }
}
