public class Runner {
    public static void main(String[] args) {

        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer1(new HumanPlayer('O', board, "Pretty"));
        game.setPlayer2(new HumanPlayer('X', board, "Lil Thomas"));
        game.playGame();

    }
}
