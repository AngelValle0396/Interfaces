package com.example.winzip;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link principal#newInstance} factory method to
 * create an instance of this fragment.
 */
public class principal extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public principal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment principal.
     */
    // TODO: Rename and change types and number of parameters
    public static principal newInstance(String param1, String param2) {
        principal fragment = new principal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_principal,container,false);
        RecyclerView recyclerView=view.findViewById(R.id.reyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());
        // Inflate the layout for this fragment
        return view;
    }
    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater= LayoutInflater.from(getActivity());

            return new RecyclerViewHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }
    private class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private CardView mcardview;
        private TextView mfolder;
        private TextView mdetalle;
        private CircleImageView mciv;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.lista_carpetas,container,false));
            mcardview=  itemView.findViewById(R.id.cardview);
            mfolder= itemView.findViewById(R.id.folder);
            mdetalle=itemView.findViewById(R.id.detalle);
            mciv= itemView.findViewById(R.id.icon);
        }
    }
}