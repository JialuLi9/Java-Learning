import java.util.*;

public class MusicExchangeCenter{
    private ArrayList<User> user;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;


    public MusicExchangeCenter (){

        user = new ArrayList<User>();
        royalties =new HashMap<String, Float>();
        downloadedSongs = new ArrayList<Song>();

    }

    public ArrayList<User> onlineUsers(){
        ArrayList<User> userOnline;
        userOnline = new ArrayList<User>();
        for (User u: user)
            if (u.isOnline())
                userOnline.add(u);
        return userOnline;
    }

    public ArrayList<Song> allAvailableSongs(){
        ArrayList<Song> availableSongs;
        availableSongs = new ArrayList<Song>();
        for (User u: user) {
            if (u.isOnline()) {
                availableSongs.addAll(u.getSongList());
            }
        }
        return availableSongs;
    }

    public String toString(){
        return String.format("Music Exchange Center (%d users online, %d songs available)", onlineUsers().size(), allAvailableSongs().size());
    }

    public User userWithName(String s){
        for(User u: user)
            if(u.getUserName().equals(s))
                return u;
        return null;
    }

    public void registerUser(User x){
        String name = "";
        for(User u: user)
            name = x.getUserName();
            if(userWithName(name) == null){
                user.add(x);
            }
    }

    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> availSongsByArtist = new ArrayList<Song>();
        for(Song s: allAvailableSongs())
            if(s.getArtist().equals(artist))
                availSongsByArtist.add(s);
        return  availSongsByArtist;
    }

    public Song getSong(String title, String ownerName){
        User temp = userWithName(ownerName);
        Song isSong = temp.songWithTitle(title);

        if( temp != null && isSong != null && temp.isOnline()){
            downloadedSongs.add(isSong);
            for(Song s: downloadedSongs){
                if (!royalties.containsKey(s.getArtist())){
                    royalties.put(s.getArtist(),0.0f);
                }
                else{
                    float v = royalties.get(s.getArtist())+0.25f;
                    royalties.replace(s.getArtist(),v);
                }
            }

            return isSong;
        }
        return null;
    }



    public void displayRoyalties(){
        String a = "Amount";
        String b = "Artist";
        String heading = String.format("%s%8s\n", a,b);
        heading += "---------------";
        System.out.println(heading);
        for (Map.Entry<String, Float> entry: royalties.entrySet()){
            String money = String.format("$%1.2f", entry.getValue());
            String body = String.format("%-8s%s", money, entry.getKey());
            System.out.println(body);

        }
    }


    public TreeSet<Song> uniqueDownloads(){
        TreeSet<Song> songList = new TreeSet<Song>(downloadedSongs);
        return songList;
    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public ArrayList<Pair<Integer,Song>> songsByPopularity(){

        TreeSet<Song> songList = uniqueDownloads();
        ArrayList<Song> temp = getDownloadedSongs();
        ArrayList<Pair<Integer,Song>> result = new ArrayList<Pair<Integer, Song>>();
        for (Song s: songList){
            int counter = 0;
            for (int j = 0; j<temp.size(); j++){
                if(temp.get(j).getTitle().equals(s.getTitle())){
                    counter ++;
                }
            }
            result.add(new Pair<Integer, Song> (counter, s));
        }

        Collections.sort(result, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                return p2.getKey()- p1.getKey();
            }
        });

        return result;
    }



}
