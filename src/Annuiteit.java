public class Annuiteit extends Hypotheek implements Product {

    public Annuiteit(String productNummer, String typeHyp, double hoofdsom, double rente, int looptijd) {
        super(typeHyp, hoofdsom, rente, looptijd);
        this.calculateHypotheek(productNummer, typeHyp, hoofdsom, rente, looptijd);
    }


    public void calculateHypotheek(String productNummer, String typeHyp, double hoofdsom, double rente, double looptijd) {

        // Table Header
        Display d = new Display();
        d.tableHeader(productNummer, typeHyp, hoofdsom, rente, looptijd);

        String[][] table_main = new String[(int) looptijd][];
        double restSom = hoofdsom;
        double rentevoet = rente / 100;
        double annuiteit = rentevoet / (1.0 - (Math.pow(1.0 + rentevoet, -looptijd))) * hoofdsom;
        double totaal = 0.0;

        // annuiteit formula
        for (int i = 0; i < looptijd; i++) {
            double renteresult = restSom * rentevoet;
            double aflossing = annuiteit - renteresult;
            restSom -= aflossing;
            totaal += (annuiteit);
            // Main table output
            table_main[i] = new String[]{
                    String.valueOf(i + 1),
                    df.format(restSom),
                    df.format(aflossing),
                    df.format(renteresult)
            };
        }

        Display f = new Display();
        f.tableFooter(table_main);
    }
}



