public class Utente {
    private String nomeUtente;
    private String password;
    private Integer punteggio;
    private Integer difficolta;

    public Utente(String nomeUtente, String password, Integer punteggio, Integer difficolta) {
        this.nomeUtente = nomeUtente;
        this.password = password;
        this.punteggio = punteggio;
        this.difficolta = difficolta;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public Integer getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(Integer difficolta) {
        this.difficolta = difficolta;
    }
}
