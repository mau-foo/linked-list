package linked_list;

import java.util.Scanner;

public class Playlist {
	public static final String playlistMenu = " PLAYLIST MENU\n" +
											  "a - Add song\n" +
											  "d - Remove song\n" +
											  "c - Change position of song\n" +
											  "s - Output songs by specific artist\n" +
											  "t - Output total time of playlist (in seconds)\n" +
											  "o - Output full playlist\n" +
											  "q - Quit\n\n" +
											  "Choose an option:";
	public static String playlistTitle;
	
	public static void printMenu(String title, Scanner userInput) {
		char userSelection = 'o';
		String uniqueID;
		String songName;
		String artistName;
		
		String uniqueIDRemove;
		String findArtistName;
		
		int songLength;
		int totalTimeInSeconds = 0;
		int numberOfSongs;
		int currentPosition = 0;
		int newPosition = 0;
		int counter = 1;
		
		SongEntry firstSong = null;
		SongEntry currentSong = null;
		SongEntry lastSong = null;
		
		SongEntry swapSongOldPosition = null;
		SongEntry swapSongNewPosition = null;
		
		while (userSelection != 'q') {
			System.out.println(playlistTitle + playlistMenu);
			userSelection = userInput.next().charAt(0);
			counter = 1;
			numberOfSongs = 0;
			
			switch (userSelection) {
				case 'q':
					break;
				case 'o':
					System.out.println(playlistTitle + " - OUTPUT FULL PLAYLIST");
					if (firstSong == null) {
						System.out.println("Playlist is empty\n");
					} else {
						currentSong = firstSong;
						while (currentSong != null) {
							System.out.println(counter + ".");
							currentSong.printPlaylistSongs();
							currentSong = currentSong.getNext();
							counter++;
						}
					}
					break;
				case 'a':
					userInput.nextLine();
					System.out.println("ADD SONG");
					System.out.println("Enter song's unique ID:");
					uniqueID = userInput.nextLine();
					System.out.println("Enter song's name:");
					songName = userInput.nextLine();
					System.out.println("Enter artist's name:");
					artistName = userInput.nextLine();
					System.out.println("Enter song's length (in seconds):\n");
					songLength = Integer.parseInt(userInput.nextLine());		
					
					if (firstSong == null) {
						firstSong = new SongEntry(uniqueID, songName, artistName, songLength);
						lastSong = firstSong;
					} else {
						currentSong = new SongEntry(uniqueID, songName, artistName, songLength);
						lastSong.insertAfter(currentSong);
						lastSong = currentSong;
					}
					break;
				case 'd':
					userInput.nextLine();
					System.out.println("REMOVE SONG");
					System.out.println("Enter song's unique ID:");
					uniqueIDRemove = userInput.nextLine();
					if (firstSong != null) {
						currentSong = firstSong;
						while (currentSong != null) {
							if (currentSong.getID().equalsIgnoreCase(uniqueIDRemove)) {
								if (currentSong.getNext() == null) {
									System.out.println("\"" + currentSong.getSongName() + "\"" + " removed.\n");
									lastSong.setNext(null);
									break;
								} else {
									System.out.println("\"" + currentSong.getSongName() + "\"" + " removed.\n");
									lastSong.setNext(currentSong.getNext());
									currentSong = lastSong.getNext();
								}
							}
							lastSong = currentSong;
							currentSong = currentSong.getNext();
						}
					}
					break;
				  case 'c':
					  userInput.nextLine();
					  System.out.println("CHANGE POSITION OF SONG");
					  System.out.println("Enter song's current position:");
					  currentPosition = Integer.parseInt(userInput.nextLine());
					  System.out.println("Enter new position for song:");
					  newPosition = Integer.parseInt(userInput.nextLine());
					  
					  currentSong = firstSong;
					  while (currentSong != null) {
						  numberOfSongs++;
						  currentSong = currentSong.getNext();
					  }
					  
					  currentSong = firstSong;
					  swapSongOldPosition = firstSong;
					  swapSongNewPosition = firstSong;
					  int i = 1;
					  while (currentSong != null) {
						  if ((currentPosition - 1) == i) {
							  swapSongOldPosition = currentSong;
						  } else if ((newPosition - 1) == i) {
							  swapSongNewPosition = currentSong;
						  }
						  i++;
						  currentSong = currentSong.getNext();
					  }
					  
					  if (newPosition == 1) {
						  currentSong = swapSongOldPosition.getNext();
						  swapSongOldPosition.setNext(currentSong.getNext());
						  currentSong.setNext(firstSong);
						  firstSong = currentSong;
						  System.out.println("\"" + firstSong.getSongName() + "\"" + " moved to position " + newPosition + "\n");
					  } else if (newPosition == numberOfSongs) {
						  if (currentPosition == 1) {
							  currentSong = firstSong;
							  lastSong.setNext(currentSong);
							  firstSong = firstSong.getNext();
							  lastSong = currentSong;
							  currentSong.setNext(null);
							  System.out.println("\"" + lastSong.getSongName() + "\"" + " moved to position " + newPosition + "\n");
						  } else {
							  currentSong = swapSongOldPosition.getNext();
							  lastSong.setNext(currentSong);
							  swapSongOldPosition.setNext(swapSongOldPosition.getNext().getNext());
							  lastSong = currentSong;
							  currentSong.setNext(null);
							  System.out.println("\"" + lastSong.getSongName() + "\"" + " moved to position " + newPosition + "\n");
						  }
					  } else {
						  if (currentPosition == 1) {
							  firstSong = swapSongOldPosition.getNext();							 
							  swapSongOldPosition.setNext(swapSongNewPosition.getNext().getNext());
							  swapSongNewPosition.getNext().setNext(swapSongOldPosition);
							  System.out.println("\"" + swapSongOldPosition.getSongName() + "\"" + " moved to position " + newPosition + "\n");
						  } else if (currentPosition == numberOfSongs) {
							  currentSong = swapSongOldPosition.getNext();
							  currentSong.setNext(swapSongNewPosition.getNext());
							  swapSongNewPosition.setNext(currentSong);
							  lastSong = swapSongOldPosition;
							  lastSong.setNext(null);
							  System.out.println("\"" + currentSong.getSongName() + "\"" + " moved to position " + newPosition + "\n");
						  } else if (currentPosition < newPosition) {
							  currentSong = swapSongOldPosition.getNext();
							  swapSongOldPosition.setNext(currentSong.getNext());
							  currentSong.setNext(swapSongNewPosition.getNext().getNext());
							  swapSongNewPosition.getNext().setNext(currentSong);
							  System.out.println("\"" + currentSong.getSongName() + "\"" + " moved to position " + newPosition + "\n");
						  } else {
							  currentSong = swapSongOldPosition.getNext();
							  swapSongOldPosition.setNext(swapSongOldPosition.getNext().getNext());
							  currentSong.setNext(swapSongNewPosition.getNext());
							  swapSongNewPosition.setNext(currentSong);
							  System.out.println("\"" + currentSong.getSongName() + "\"" + " moved to position " + newPosition + "\n");
						  }
					  }
					  break;
				  case 's':
					  userInput.nextLine();
					  System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
					  System.out.println("Enter artist's name:");
					  findArtistName = userInput.nextLine();
					  currentSong = firstSong;
					  while (currentSong != null) {
						  if (currentSong.getArtistName().equalsIgnoreCase(findArtistName)) {
							  System.out.println(counter + ".");
							  currentSong.printPlaylistSongs();
						  }
						  currentSong = currentSong.getNext();
						  counter++;
					  }
					  break;
				  case 't':
					  currentSong = firstSong;
					  while (currentSong != null) {
						  totalTimeInSeconds += currentSong.getSongLength();
						  currentSong = currentSong.getNext();
					  }
					  System.out.println("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)");
					  System.out.println("Total time: " + totalTimeInSeconds + " seconds\n");
			}
		}
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("Enter playlist's title:\n");
		playlistTitle = userInput.nextLine();
		printMenu(playlistTitle, userInput);
		
		userInput.close();
	}
}