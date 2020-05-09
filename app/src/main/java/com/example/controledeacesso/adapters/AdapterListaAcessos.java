package com.example.controledeacesso.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.controledeacesso.R;
import com.example.controledeacesso.model.ModelAcesso;

import java.util.List;

public class AdapterListaAcessos extends BaseAdapter {

    private Context context;
    private List<ModelAcesso> listaAcessos;

    public AdapterListaAcessos(Context context, List<ModelAcesso> listaAcessos) {
        this.context = context;
        this.listaAcessos = listaAcessos;
    }

    @Override
    public int getCount() {
        return this.listaAcessos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaAcessos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(this.context, R.layout.layout_acesso, null);

        TextView tvNome = (TextView) view.findViewById(R.id.tvNome);
       /* TextView tvCpf = (TextView) view.findViewById(R.id.tvCpf);
        TextView tvOrigem = (TextView) view.findViewById(R.id.tvOrigem);
        TextView tvDestino = (TextView) view.findViewById(R.id.tvDestino);
        TextView tvMorador = (TextView) view.findViewById(R.id.tvMorador);
        TextView tvDataHora = (TextView) view.findViewById(R.id.tvDataHora);*/

        tvNome.setText(listaAcessos.get(position).getNome());
      /*  tvCpf.setText(listaAcessos.get(position).getCpf());
        tvOrigem.setText(listaAcessos.get(position).getOrigem());
        tvDestino.setText(listaAcessos.get(position).getDestino());
        tvMorador.setText(listaAcessos.get(position).getMoradorSimNao());
        tvDataHora.setText(listaAcessos.get(position).getDataHora());*/

        return view;
    }
}
