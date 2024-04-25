package chapter03;

public class SongTest {
    public static void main(String[] args) {
        Song song01 = new Song("아이유", "좋은날", "Real",
                "이민수", 2010, 3);

//        song.setArtist("아이유");
//        song.setTitle("좋은날");
//        song.setAlbum("Real");
//        song.setComposer("이민수");
//        song.setYear(2010);
//        song.setTrack(3);

        song01.show();

        Song song02 = new Song("Ditto", "New Jeans");
        song02.show();
    }
}
