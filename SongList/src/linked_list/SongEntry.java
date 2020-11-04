package linked_list;

public class SongEntry {
	private String uniqueID;
	private String songName;
	private String artistName;
	private int    songLength;
	private SongEntry nextNode;
	
	
	public SongEntry() {
		uniqueID = "none";
		songName = "none";
		artistName = "none";
		songLength = 0;
		nextNode = null;
	}
	
	public SongEntry(String uniqueID, String songName, String artistName, int songLength) {
		this.uniqueID = uniqueID;
		this.songName = songName;
		this.artistName = artistName;
		this.songLength = songLength;
		this.nextNode = null;
	}
		
	public String getID() {
		return uniqueID;
	}
	
	public String getSongName() {
		return songName;
	}
	
	public String getArtistName() {
		return artistName;
	}
	
	public int getSongLength() {
		return songLength;
	}
	
	public SongEntry getNext() {
		return nextNode;
	}
	
	public void setNext(SongEntry nextNode) {
		this.nextNode = nextNode;
	}
	
	public void insertAfter(SongEntry currNode) {
		SongEntry tmpNext;
		
		tmpNext = this.nextNode;
		this.nextNode = currNode;
		currNode.nextNode = tmpNext; 
	}
		
	public void printPlaylistSongs() {
		System.out.printf("Unique ID: %s\nSong Name: %s\nArtist Name: %s\nSong Length (in seconds): %s\n\n", uniqueID, songName, artistName, songLength);
	}
}
