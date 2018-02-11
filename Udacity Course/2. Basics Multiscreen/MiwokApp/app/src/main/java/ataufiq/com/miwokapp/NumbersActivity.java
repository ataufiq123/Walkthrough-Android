package ataufiq.com.miwokapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = (new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("lutti","one",R.drawable.number_one,
                R.raw.number_one));
        words.add(new Word("otiiko","two",R.drawable.number_two,
                R.raw.number_two));
        words.add(new Word("tolookosu","three",R.drawable.number_three,
                R.raw.number_three));
        words.add(new Word("oyyisa","four",R.drawable.number_four,
                R.raw.number_four));
        words.add(new Word("massokka","five",R.drawable.number_five,
                R.raw.number_five));
        words.add(new Word("temmokka","six",R.drawable.number_six,
                R.raw.number_six));
        words.add(new Word("kenekaku","seven",R.drawable.number_seven,
                R.raw.number_seven));
        words.add(new Word("kawinta","eight",R.drawable.number_eight,
                R.raw.number_eight));
        words.add(new Word("wo’e","nine",R.drawable.number_nine,
                R.raw.number_nine));
        words.add(new Word("na’aacha","ten",R.drawable.number_ten,
                R.raw.number_ten));

        WordAdapter itemsAdapter=
                new WordAdapter(this,words,R.color.category_numbers);

        ListView listView = findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word =words.get(position);
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }


    private void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();

            mMediaPlayer = null;
        }
    }
}
