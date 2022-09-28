package com.example.planetas_fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class LeftFragment extends Fragment {

    private ListView lvPlanetas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {

        View view = inflater.inflate( R.layout.fragment_left, null );

        lvPlanetas = (ListView) view.findViewById( R.id.lvPlanetas );

        lvPlanetas.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long id) {

                tratarSelecao( position );

            }

        } );

        return view;
    }//fim do método onCreateView

    protected void tratarSelecao( int position ) {

        Configuration config = getResources().getConfiguration();

        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            androidx.fragment.app.FragmentManager fm = getFragmentManager();

            RightFragment fd = (RightFragment) fm.findFragmentById( R.id.fragmentRight );

            fd.setConteudo( position );

        } else {
            RightFragment fragDir = new RightFragment();

            Bundle args = new Bundle();
            args.putInt("pos", position);
            fragDir.setArguments(args);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(android.R.id.content, fragDir);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    } //fim do método tratarSelecao

} //fim da classe LeftFragment