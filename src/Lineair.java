public class Lineair extends Hypotheek implements Product {

    public Lineair(String productNummer, String typeHyp, double hoofdsom, double rente, int looptijd) {
        super(typeHyp, hoofdsom, rente, looptijd);
        this.calculateHypotheek(productNummer, typeHyp, hoofdsom, rente, looptijd);
    }

    public void calculateHypotheek(String productNummer, String typeHyp, double hoofdsom, double rente, double looptijd) {
        double restSom = hoofdsom;
        double totaal = 0;

        Display d = new Display();
        d.tableHeader(productNummer, typeHyp, hoofdsom, rente, looptijd);

        // create hypotheek calculator
        String[][] table_main = new String[(int) looptijd][];
        for (int i = 0; i < looptijd; i++) {

            // Main table output lineaire Hypotheek calculation
            double renteBedrag = (restSom / 100) * rente;
            double aflossingsBedrag = hoofdsom / looptijd;
            restSom -= aflossingsBedrag;
            totaal += (renteBedrag + aflossingsBedrag);
            // Main table output
            table_main[i] = new String[]{
                    String.valueOf(i + 1),
                    df.format(restSom),
                    df.format(aflossingsBedrag),
                    df.format(renteBedrag)
            };
        }

        // Display summary
        Display f = new Display();
        f.tableFooter(table_main);
    }

}

