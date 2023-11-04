public class WordleGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                GraficoWordle wordle = new GraficoWordle();
                wordle.setVisible(true);
                ;
            }
        });
    }
}
