package com.example.planetas_fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class RightFragment extends Fragment {

    private int imagens_id[] = {
            R.drawable.mercurio,
            R.drawable.venus,
            R.drawable.terra,
            R.drawable.marte,
            R.drawable.jupiter,
            R.drawable.saturno,
            R.drawable.urano,
            R.drawable.netuno
    };

    private ImageView imPlanetas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {

        View view = inflater.inflate( R.layout.fragment_right, null );
        imPlanetas = (ImageView) view.findViewById(R.id.imPlaneta);
        imPlanetas.setScaleType(ImageView.ScaleType.FIT_XY);

        Configuration config = getResources().getConfiguration();
        if (config.orientation != Configuration.ORIENTATION_LANDSCAPE) {
            int position = getArguments().getInt("pos");
            imPlanetas.setImageResource(imagens_id[position]);
        }
        return view;
    }//fim do método onCreateView

    public void setConteudo( int pos ) {
        imPlanetas.setImageResource( imagens_id[ pos ] );
    }//fim do método setConteudo

}//fim da classe RightFragment
