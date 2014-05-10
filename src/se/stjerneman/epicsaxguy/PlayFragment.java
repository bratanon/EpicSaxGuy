package se.stjerneman.epicsaxguy;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class PlayFragment extends Fragment {

    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mp = MediaPlayer.create(getActivity(), R.raw.epic);

        final Button playButton = (Button) rootView.findViewById(R.id.playButton);

        playButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                if (mp.isPlaying()) {
                    mp.stop();
                    playButton.setText(getString(R.string.play));
                }
                else {
                    mp.start();
                    playButton.setText(getString(R.string.stop));
                }
            }
        });

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mp.isPlaying()) {
            mp.stop();
        }
    }

}
