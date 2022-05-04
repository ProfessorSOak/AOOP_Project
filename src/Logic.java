import java.io.File;

public class Logic extends Sokoban {
    //private PictureComponent first = new PictureComponent();

    @Override
    public void UpPressed() {
        System.out.println("TestUP");
    }

    @Override
    public void DownPressed() {
        System.out.println("TestDOWN");
    }

    @Override
    public void LeftPressed(){
        System.out.println("TestLEFT");
    }

    @Override
    public void RightPressed(){
        System.out.println("TestRIGHT");
    }

    @Override
    public void ResetPressed(){
        System.out.println("TestRESET");
    }
}
