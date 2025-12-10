public enum ZaverecneSpravy {
    NarazenieDoSteny("Narazil si do steny"),
    NarazenieDoHada("Narazil si do seba"),
    ZjedolSiVsetko("Gratulujem zjedol si vsetky jablka");

    private String text;

    ZaverecneSpravy(String obsah) {
        this.text = obsah;

    }

    public String getFinalnaSprava() {
        return this.text;
    }

}
