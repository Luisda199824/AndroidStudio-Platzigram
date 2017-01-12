package com.luisda.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisda.platzigram.R;
import com.luisda.platzigram.adapter.PictureAdapterReciclerView;
import com.luisda.platzigram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureProfileRecicler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterReciclerView pictureAdapterReciclerView = new PictureAdapterReciclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterReciclerView);

        return view;
    }

    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();
        String url_JuanValdez = "https://external.feoh1-1.fna.fbcdn.net/safe_image.php?d=AQCVDTzy0IFLpG0O&w=526&h=394&url=https%3A%2F%2Fscontent.feoh1-1.fna.fbcdn.net%2Fv%2Ft1.0-0%2Fp526x296%2F15873108_10157971041745697_2416284077698491249_n.jpg%3Foh%3D74c3ab6afacc15b57a081f198438bf3f%26oe%3D5917D64C&cfs=1&upscale=1&_nc_hash=AQAIFKDSb3PN45og";
        String url_Oma = "https://scontent.feoh1-1.fna.fbcdn.net/v/t1.0-9/15940455_1202484229859075_1204263236352795132_n.jpg?oh=0fac688aca8dbefabf3eb93976768310&oe=58E0FD0E";
        String url_Cineco = "https://scontent.feoh1-1.fna.fbcdn.net/v/t1.0-0/s261x260/15665424_1567806063233060_4258138226711821418_n.png?oh=380e76722fff1921c1fe8bef796f5d8a&oe=591DFA4F";

        pictures.add(new Picture(url_JuanValdez, "Juan Valdéz Café", "1 días", "200 Me gusta"));
        pictures.add(new Picture(url_Oma, "Oma Café Restaurante", "2 días", "199 Me gusta"));
        pictures.add(new Picture(url_Cineco, "Cine Colombia", "3 días", "45 Me gusta"));

        return pictures;
    }

    public void showToolbar(String title, Boolean upButton, View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
