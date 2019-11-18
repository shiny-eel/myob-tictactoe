package tic.game;


import tic.io.IO;

public class Manager {
    protected IO _io;
    Player _p1;
    Player _p2;
    Player _currentPlayer;
    public void begin(IO io) {
        _io = io;
    }

    public Player nextPlayer(){
        if (_currentPlayer.equals(_p1)) {
            _currentPlayer = _p2;
            return _currentPlayer;
        } else {

            _currentPlayer = _p1;
            return _currentPlayer;
        }
    }

    public IO getIO() {
        return _io;
    }

    public void displayGame() {

    }

}
