

public class Prova{
    static String[] domandeDiff1 = { "Calcola la somma: 10 + 5", "Calcola la moltiplicazione: 2 x 7 ", "Calcola la moltiplicazione: 3 x 3 "};
    static float[]  risultatiDiff1 = {15, 14, 9};
    static String[] domandeDiff2 = { "Calcola la division: 27 : 3", "Calcola la moltiplicazione: 15 x 4 ",  "Calcola la somma: 1058 + 18 "};
    static float[]  risultatiDiff2 = {9, 60, 1076};
    static String[] domandeDiff3 = { "Calcola la somma: 237 + 1289 ", "Calcola la divisione: 372 : 60 ",  "Calcola lamoltiplicazione: 372 x 5 "};
    static float[]  risultatiDiff3 = {1526f, 6.2f ,1860};


Integer difficoltà;
String domanda;
float risultato;
int corretto;
int errato;


    Prova(int stato){
        int randomIndex;
        switch(stato){
            
            case 1:
                randomIndex = getRandomNumber(0, domandeDiff1.length);
                this.domanda = domandeDiff1[randomIndex];
                this.risultato = risultatiDiff1[randomIndex];
                this.difficoltà = 1;
                this.corretto = 2;
                this.errato = -1;
            break;

            case 2:
                randomIndex = getRandomNumber(0, domandeDiff2.length);
                this.domanda = domandeDiff2[randomIndex];
                this.risultato = risultatiDiff2[randomIndex];
                this.difficoltà = 2;
                this.corretto = 3;
                this.errato = -2;
            break;

            case 3:
                randomIndex = getRandomNumber(0, domandeDiff3.length);
                this.domanda = domandeDiff3[randomIndex];
                this.risultato = risultatiDiff3[randomIndex];
                this.difficoltà = 3;
                this.corretto = 5;
                this.errato = -3;
            break;
   
        }
    }

    static public int getCorretto(){
        return this.corretto;
    }

    static public int getErrato(){
        return this.errato;
    }


    static public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    static public rispondi(float risposta){
        if(risposta ==  this.risultato ){
            return this.corretto;
        }else{
            return this.errato;
        }

    }



}