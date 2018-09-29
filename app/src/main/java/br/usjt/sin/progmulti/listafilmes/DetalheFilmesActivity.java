package br.usjt.sin.progmulti.listafilmes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.usjt.sin.progmulti.servicedesk.R;

public class DetalheFilmesActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filmes);
        TextView nome = (TextView)findViewById(R.id.chamado_selecionado);
        Intent intent = getIntent();
        nome.setText(intent.getStringExtra(ListarFilmesActivity.DESCRICAO));
    }
}