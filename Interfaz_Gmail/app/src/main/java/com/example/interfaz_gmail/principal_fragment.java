package com.example.interfaz_gmail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link principal_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class principal_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    public static Fragment newInstance(){
    return  new principal_fragment();
    }
    public principal_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment principal_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static principal_fragment newInstance(String param1, String param2) {
        principal_fragment fragment = new principal_fragment();
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
        Toast.makeText(this.getContext(),"Ha presionado opción Nuevo ",Toast.LENGTH_LONG).show();

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
    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

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
        private TextView mde;
        private TextView masunto;
        private TextView mdetalle;
        private TextView mfecha;
        private CircleImageView mciv;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public RecyclerViewHolder(LayoutInflater inflater, ViewGroup container){
            super(inflater.inflate(R.layout.lista_correos,container,false));
            mcardview=  itemView.findViewById(R.id.cardview);
            mde= itemView.findViewById(R.id.de);
            masunto=itemView.findViewById(R.id.asunto);
            mdetalle=itemView.findViewById(R.id.detalle);
            mfecha=itemView.findViewById(R.id.fecha);
             mciv= itemView.findViewById(R.id.icon);
        }
    }
}