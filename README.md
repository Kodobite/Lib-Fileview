# Lib-Fileview

##### Dependency

````java
implementation 'com.github.Kodobite:Lib-Fileview:0.2'

````

##### Audio View Dialog

````java

     FileViewer.CustomAudioPlayerDialog dialog = new FileViewer.CustomAudioPlayerDialog(this);
            dialog.setTitle("Title");
            try {
                dialog.setDataSource("//your audio file source");
            } catch (IOException e) {
                e.printStackTrace();
            }
            dialog.setCancelable(false);
            dialog.show();
            
  ````
  
  ##### Audio view Activity
  
  ````xml

  <io.kodebite.fileviewer.audioView.CustomAudioPlayer
        android:id="@+id/audioPlayer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginTop="10dp"
        android:layout_marginEnd="10dp"
        android:layout_marginBottom="10dp" />

````

````java

 try {
      audioPlayer.setDataSource("//your audio file source");
      audioPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
````
            
            
