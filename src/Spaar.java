public class Spaar extends Hypotheek implements Product {

    public Spaar(String productNummer, String typeHyp, double hoofdsom, double rente, int looptijd) {
        super(typeHyp, hoofdsom, rente, looptijd);
        this.calculateHypotheek(productNummer, typeHyp, hoofdsom, rente, looptijd);
    }

    public void calculateHypotheek(String productNummer, String typeHyp, double hoofdsom, double rente, double looptijd) {
        double inleg;
        double spaardeel = 0;
        double factor = 0;
        double x = 1 + (rente / 100);

        String[][] table = new String[6][];
        table[0] = new String[]{"", "", "", "", ""};
        table[1] = new String[]{typeHyp + "hypotheek", "Nummer :" + productNummer, "", "", ""};
        table[2] = new String[]{"Hoofdsom € " + df.format(hoofdsom), "rente " + rente + "%", "looptijd " + (int) looptijd + " Jaar", "", ""};
        table[3] = new String[]{"", "", "", "", ""};
        table[4] = new String[]{"Jaar", "Inleg", "Gespaard", "Ontvangen Rente", "Rente hoofdsom"};
        table[5] = new String[]{"", "", "", "", ""};

        // String formatter
        for (String[] row : table) {
            System.out.format("%5s %15s %15s %20s %15s %n", (Object[]) row);
        }

        // create hypotheek calculator

        String[][] table_main = new String[(int) looptijd][];
        // Main table output Spaar Hypotheek calculation

        double interest = hoofdsom / 100 * rente;
        for (int i = 0; i < looptijd; i++) {
            factor += Math.pow(x, i);
        }

        for (int i = 0; i < looptijd; i++) {
            // Main table output lineaire Hypotheek calculation
            inleg = hoofdsom / factor;
            double spaardeelrente = (spaardeel / 100) * rente;
            spaardeel = spaardeel + inleg + spaardeelrente;
            // Main table output
            table_main[i] = new String[]{
                    String.valueOf(i + 1),
                    df.format(inleg),
                    df.format(spaardeel),
                    df.format(spaardeelrente),
                    df.format(interest)
            };
        }

        for (String[] row : table_main) {
            System.out.format("%5s %15s %15s %15s %15s %n", (Object[]) row);
        }
    }

}

