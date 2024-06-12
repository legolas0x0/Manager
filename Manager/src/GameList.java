import java.util.Collections;
import java.util.List;

import javax.swing.AbstractListModel;

public class GameList {
    /**
	 * 
	 */
	
	protected List<Game>gameList;
 
    /**
	 * add game to the game list
	 * @param game Game object
	 */
	public GameList() {}
	public GameList(List<Game> gameList) {
		this.gameList = gameList;
	}
	public void addGame(Game game) {
		gameList.add(game);
	}
	/**

    * Attempt to remove the specified game from the game list. If successful, return true; otherwise, return false.
    * @param gameName A string representing the name of the game to be removed
    * @return True if the game was successfully removed from the game list, otherwise false.
    * @throws java.lang.IllegalArgumentException If the provided argument is incompatible with the expected pattern.
    */
	public boolean deleteGame(String gameName) {
		for (Game game: gameList) {
			if(game.getName().equals(gameName)) {
				gameList.remove(game);
				return true;
			}
		}
		return false;
}
 

 
    public int getSize() {
        return gameList.size();
    }
 
	
	public Game get(int index) {
		return gameList.get(index);
		
	}
	public void sort(int criterea) {
		quickSort(0, gameList.size(), criterea);
	}
	private void quickSort(int begin, int end, int criterea) {
	    if (begin < end) {
	        int partitionIndex = partition(begin, end, criterea);

	        quickSort(begin, partitionIndex-1, criterea);
	        quickSort(partitionIndex+1, end, criterea);
	    }
	}
	private int partition(int begin, int end, int criterea) {
	    Game pivot = gameList.get(end);
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (gameList.get(j).compare(pivot, criterea)) {
	            i++;

	            
	            Collections.swap(gameList, i, j);
	        }
	    }

	    Collections.swap(gameList, i + 1, end);

	    return i+1;
	}
	
    
}