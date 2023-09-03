import java.util.ArrayList;
public class User {
  private String     userName;
  private boolean    online;

  private ArrayList<Song> songList;
  
  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList<Song>();
  }
  
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  public ArrayList<Song> getSongList() {return songList;}

  public void addSong(Song s){
    songList.add(s);
    s.setOwner(this);
  }

  public int totalSongTime(){
    int totalDuration =0;
    for(Song song: songList ){
      totalDuration += song.getDuration();
    }
    return totalDuration;
  }

  public String toString()  {
    String s = String.format("" + userName + ": %d songs (", getSongList().size());
    if (!online) s += "not ";
    return s + "online)";
  }

  public void register(MusicExchangeCenter m){
    m.registerUser(this);
  }

  public void logon(){
    online = true;
  }

  public void logoff(){
    online = false;
  }

  //3.Downloading Music
  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
    String t = "TITLE";
    String a = "ARTIST";
    String time = "TIME";
    String o = "ONWER";
    String space = "  ";

    ArrayList<String> allSongs = new ArrayList<String>();
    ArrayList<Song> songs = m.allAvailableSongs();
    String firstPart = "";
    String line = "";
    Song current = null;

    String heading = String.format("%-4s%-40s%-20s%-10s%-10s\n", space, t, a, time, o);
    allSongs.add(heading);

    for (int i=1; i<=songs.size(); i++){
      current=songs.get(i-1);
      String index = String.format("%2s. ",i);
      firstPart = String.format("%s",current.getTitle());
      line = String.format("%s%-40s%-20s%-10s%-10s",index, firstPart,current.getArtist(),secondsToMinutes(current),current.getOwner().getUserName());
      allSongs.add(line);
    }
    return allSongs;
  }


  public String secondsToMinutes(Song s){

    return String.format("%d:%02d", s.getMinutes(), s.getSeconds());
  }

  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
    String t = "TITLE";
    String a = "ARTIST";
    String time = "TIME";
    String o = "ONWER";
    String space = "  ";

    ArrayList<String> allSongs = new ArrayList<String>();
    ArrayList<Song> songs = m.availableSongsByArtist(artist);
    String firstPart = "";
    String line = "";
    Song current = null;

    String heading = String.format("%-3s%-26s%-11s%-12s%-10s\n", space, t, a, time, o);
    allSongs.add(heading);

    for (int i=1; i<songs.size(); i++){
      current=songs.get(i-1);
      firstPart = String.format("%d. %s",i, current.getTitle());
      line = String.format("%-30s%-10s%-10s%-10s",firstPart,current.getArtist(),secondsToMinutes(current),current.getOwner().getUserName());
      allSongs.add(line);
    }
    return allSongs;
  }

  public Song songWithTitle(String title){
    for(Song s: songList){
      if(s.getTitle().equals(title))
        return s;
    }
    return null;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
      Song temp = m.getSong(title,ownerName);
      if( temp != null) {
        songList.add(temp);
      }

  }


}
