package com.OX.app;

/**
 * Interface check if any condition to stop a game appears. ( tie or win).
 */
@SuppressWarnings("unused")
public interface GameChecker {
    boolean check(Board board, Move lastMove, Integer inLineToWin);
}
