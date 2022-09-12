public class Display extends Hypotheek implements Product {

    // printout table header
    public void tableHeader(String productNummer, String typeHyp, Double hoofdsom, double rente, double looptijd) {
        String[][] table = new String[5][];
        table[0] = new String[]{"", "", "", ""};
        table[1] = new String[]{typeHyp + "hypotheek", "Nummer: " + productNummer, "", ""};
        table[2] = new String[]{"Hoofdsom € " + df.format(hoofdsom), "rente " + rente + "%", "looptijd " + (int) looptijd + " Jaar", ""};
        table[3] = new String[]{"", "", "", ""};
        table[4] = new String[]{"Jaar", "RestSom", "Aflossing", "Rente"};

        // String formatter
        for (String[] row : table) {
            System.out.format("%5s %15s %15s %15s %n", (Object[]) row);
        }
    }

    // printout table footer (optional)
    public void tableFooter(String[][] table_main) {
        // String formatter
        for (String[] row : table_main) {
            System.out.format("%5s %15s %15s %15s %n", (Object[]) row);
        }

    }
}
