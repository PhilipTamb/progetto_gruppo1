public class Prova{
    //Array domande e risposte
    static String[] domandeDiff1 = { "Calcola la somma: 10 + 5", "Calcola la moltiplicazione: 2 x 7 ", "Calcola la moltiplicazione: 3 x 3 ", "Calcola la somma: 28 + 5 ", "Calcola la moltiplicazione: 5 x 5 ", "Calcola la divisione: 18 : 9", "Calcola la somma: 24 + 14"};
    static float[]  risultatiDiff1 = {15, 14, 9, 33, 25, 2, -38};
    static String[] domandeDiff2 = { "Calcola la division: 27 : 3", "Calcola la moltiplicazione: 15 x 4 ","Calcola la moltiplicazione: 6 x 7", "Calcola la moltiplicazione: 25 x 5"};
    static float[]  risultatiDiff2 = {9, 60, 42, 125};
    static String[] domandeDiff3 = { "Calcola la somma: 237 + 1289 ", "Calcola la divisione: 372 : 60 ",  "Calcola lamoltiplicazione: 372 x 5 ","Calcola la somma: 1058 + 18 ","Calcola la somma: 1048 + 125" };
    static float[]  risultatiDiff3 = {1526, 6.2f ,1860, 1076, 1173};

    // Attributi di Prova
    static Integer difficoltà;
    static String domanda;
    static float risultato;
    static int corretto;
    static int errato;

    //Inizializza prova per difficoltà
    Prova(int stato){
        int randomIndex;
        switch(stato){
            
            case 1: //Prova difficoltà 1
                randomIndex = getRandomNumber(0, domandeDiff1.length);
                this.domanda = domandeDiff1[randomIndex];
                this.risultato = risultatiDiff1[randomIndex];
                this.difficoltà = 1;
                this.corretto = 2;
                this.errato = -1;
            break;

            case 2: //Prova difficoltà 2
                randomIndex = getRandomNumber(0, domandeDiff2.length);
                this.domanda = domandeDiff2[randomIndex];
                this.risultato = risultatiDiff2[randomIndex];
                this.difficoltà = 2;
                this.corretto = 3;
                this.errato = -2;
            break;

            case 3: //Prova difficoltà 3
                randomIndex = getRandomNumber(0, domandeDiff3.length);
                this.domanda = domandeDiff3[randomIndex];
                this.risultato = risultatiDiff3[randomIndex];
                this.difficoltà = 3;
                this.corretto = 5;
                this.errato = -3;
            break;
   
        }
    }

    //metodi getter
    static public int getCorretto(){
        return corretto;
    }

    static public int getErrato(){
        return errato;
    }

    static public Integer getDifficoltà(){
        return difficoltà;
    }

    static public String getDomande(){
        return domanda;
    }

    static public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    //Risultato risposta n
    static public int rispondi(float risposta){
        if(risposta ==  risultato ){
            return corretto;
        }else{
            return errato;
        }

    }



}