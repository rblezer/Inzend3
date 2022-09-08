public class Lineair extends Hypotheek implements Product {

    public Lineair(double hoofdsom, double rente, int looptijd) {
        super(hoofdsom, rente, looptijd);
        calulateHypotheek(hoofdsom, rente, looptijd);
    }

    public void calulateHypotheek(double hoofdsom, double rente, double looptijd) {
        double hoofdsomBedrag = hoofdsom;

        // Table Header
        String[][] table = new String[5][];
        table[0] = new String[]{"", "", "", ""};
        table[1] = new String[]{"Lineaire hypotheek", "", "", ""};
        table[2] = new String[]{"Hoofdsom € " + df.format(hoofdsom), "rente " + rente + "%","","looptijd " + looptijd + " Jaar"};
        table[3] = new String[]{"", "", "", ""};
        table[4] = new String[]{"Jaar", "RestSom", "Aflossing", "Rente"};

        // String formatter
        for (String[] row : table) {
            System.out.format("%15s %15s %15s %15s %n", (Object[]) row);
        }

        String[][] table_main = new String[(int) looptijd][];
        for (int i = 0; i < looptijd; i++) {

            // Main table output lineaire Hypotheek calculation
            double renteBedrag = (hoofdsomBedrag / 100) * rente;
            double aflossingsBedrag = hoofdsom / looptijd;
            hoofdsomBedrag -= aflossingsBedrag;

            // Main table output
            table_main[i] = new String[]{
                    String.valueOf(i + 1),
                    df.format(hoofdsomBedrag),
                    df.format(aflossingsBedrag),
                    df.format(renteBedrag)
            };
        }

        // String formatter
        for (String[] row : table_main) {
            System.out.format("%15s %15s %15s %15s %n", (Object[]) row);
        }
    }

}

