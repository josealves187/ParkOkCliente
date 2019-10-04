package br.com.crosoften.parkokcliente.view.fragmenst;



import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.crosoften.parkokcliente.R;
import br.com.crosoften.parkokcliente.commom.Historic;
import br.com.crosoften.parkokcliente.view.adapters.HistoricAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoricFragment extends Fragment {

    private RecyclerView rvHistoric;

    public HistoricFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_historic, container, false);
        getActivity().setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        rvHistoric = view.findViewById(R.id.rv_historic);
        List<Historic> historics = new ArrayList<>();
        historics.add(new Historic(1, new Date(), new Date(), 1,10,1,1,1));
        historics.add(new Historic(1, new Date(), new Date(), 1,10,2,2,2));
        historics.add(new Historic(1, new Date(), new Date(), 1,17,3,3,1));
        historics.add(new Historic(1, new Date(), new Date(), 58,70,1,4,2));
        historics.add(new Historic(1, new Date(), new Date(), 7,55,2,5,1));
        historics.add(new Historic(1, new Date(), new Date(), 3,14,3,6,2));

        rvHistoric.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHistoric.setAdapter(new HistoricAdapter(historics, getContext()));
        return view;
    }



}
